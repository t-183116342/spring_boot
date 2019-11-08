package com.hqyj.erp.modules.property.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.erp.exception.ErpException;
import com.hqyj.erp.modules.account.entity.User;
import com.hqyj.erp.modules.account.service.AccountService;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.constant.ApplyStatus;
import com.hqyj.erp.modules.property.constant.ApplyType;
import com.hqyj.erp.modules.property.dao.PropertyDao;
import com.hqyj.erp.modules.property.entity.Apply;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;
import com.hqyj.erp.modules.property.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private AccountService accountService;
	
	@Override
	public Result addProperty(Property property) {
		Property existProperty = propertyDao.getPropertyByAttribute(property);
		property.initProperty(existProperty);
		
		return null;
	}
	
	@Override
	public PageInfo<GrantProperty> getGrantProperties(SearchVo searchVo) {
		try {
			SearchVo.initSearchVo(searchVo);
			PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
			
			List<GrantProperty> grantProperties = 
					Optional.ofNullable(propertyDao.getGrantProperties(searchVo))
					.orElse(Collections.emptyList());
			return new PageInfo<>(grantProperties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}

	@Override
	public Result insertOrUpdateApply(Apply apply) {
		try {
			User user = accountService.getUserById(apply.getApplyUserId());
			apply.setApplyDate(new Date());
			apply.setApplyUserName(user.getUserName());
			apply.setApplyStatus(ApplyStatus.APPLY.getDesc());
			apply.setApproveUserId(0);
			
			if (apply.getApplyId() > 0) {
				Apply existApply = propertyDao.getApplyById(apply.getApplyId());
				existApply.setApplyType(apply.getApplyType());
				existApply.setPropertyModel(apply.getPropertyModel());
				existApply.setPropertyName(apply.getPropertyName());
				existApply.setPropertyNum(apply.getPropertyNum());
				existApply.setPropertyType(apply.getPropertyType());
				existApply.setUnitPrice(apply.getUnitPrice() == null ? 0.0 : apply.getUnitPrice());
				existApply.setTotalPrice(apply.getUnitPrice() * apply.getPropertyNum());
				propertyDao.updateApply(existApply);
			} else {
				apply.setUnitPrice(apply.getUnitPrice() == null ? 0.0 : apply.getUnitPrice());
				apply.setTotalPrice(apply.getUnitPrice() * apply.getPropertyNum());
				propertyDao.insertApply(apply);
			}
			
			return new Result(200, "Apply success.");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "Apply failed.");
		}
	}

	@Override
	public PageInfo<Apply> getApplies(SearchVo searchVo) {
		try {
			SearchVo.initSearchVo(searchVo);
			PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
			
			List<Apply> applies = 
					Optional.ofNullable(propertyDao.getApplies(searchVo))
					.orElse(Collections.emptyList());
			return new PageInfo<>(applies);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new PageInfo<>();
	}

	@Override
	public Apply getApplyById(int applyId) {
		return propertyDao.getApplyById(applyId);
	}

	@Override
	public Result deleteApply(int applyId) {
		try {
			propertyDao.deleteApply(applyId);
			return new Result(200, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(500, "操作失败");
		}
	}

	@Override
	@Transactional
	public Result updateApplyFlow(Apply apply) {
		Apply existApply = propertyDao.getApplyById(apply.getApplyId());
		User user = accountService.getUserById(apply.getApproveUserId());
		existApply.setApproveUserId(user.getUserId());
		existApply.setApproveDate(new Date());
		existApply.setApplyStatus(apply.getApplyStatus());
		existApply.setApproveDesc(apply.getApproveDesc());
		
		propertyDao.updateApply(existApply);
		updateProperyByFlow(existApply);
		updateGrantPropertyByFlow(existApply);
		
		return new Result(200, "操作成功。");
	}
	
	public void updateProperyByFlow(Apply apply) {
		if (apply.getApplyStatus().equals(ApplyStatus.APPROVE.getDesc())) {
			Property property = Property.initProperty(apply);
			if (apply.getApplyType().equals(ApplyType.GRANT.getDesc())) {
				Property existProperty = propertyDao.getPropertyByAttribute(property);
				if (existProperty == null || existProperty.getPropertyNum() < apply.getPropertyNum()) {
					throw new ErpException(500, "库存数量不足。");
				} else {
					existProperty.setPropertyNum(
							existProperty.getPropertyNum() - apply.getPropertyNum());
					existProperty.setUnitPrice(apply.getUnitPrice());
					existProperty.setTotalPrice(
							existProperty.getUnitPrice() * existProperty.getPropertyNum());
					propertyDao.updateProperty(existProperty);
				}
			} else if (apply.getApplyType().equals(ApplyType.PURCHASE.getDesc())) {
				Property existProperty = propertyDao.getPropertyByAttribute(property);
				if (existProperty == null) {
					propertyDao.insertProperty(property);
				} else {
					existProperty.setPropertyNum(
							existProperty.getPropertyNum() + apply.getPropertyNum());
					existProperty.setUnitPrice(apply.getUnitPrice());
					existProperty.setTotalPrice(
							existProperty.getUnitPrice() * existProperty.getPropertyNum());
					propertyDao.updateProperty(existProperty);
				}
			}
		}
	}
	
	public void updateGrantPropertyByFlow(Apply apply) {
		GrantProperty grantProperty = GrantProperty.init(apply);
		GrantProperty existGrantProperty = 
				propertyDao.getGrantPropertyByAttribute(grantProperty);
		if (apply.getApplyStatus().equals(ApplyStatus.APPROVE.getDesc())) {
			if (apply.getApplyType().equals(ApplyType.GRANT.getDesc())) {
				if (existGrantProperty == null) {
					grantProperty.setUserId(apply.getApplyUserId());
					propertyDao.insertGrantProperty(grantProperty);
				} else {
					existGrantProperty.setPropertyNum(
							existGrantProperty.getPropertyNum() + apply.getPropertyNum());
					existGrantProperty.setUnitPrice(apply.getUnitPrice());
					existGrantProperty.setTotalPrice(
							existGrantProperty.getPropertyNum() * existGrantProperty.getUnitPrice());
					propertyDao.updateGrantProperty(existGrantProperty);
				}
			} else if (apply.getApplyType().equals(ApplyType.SCRAP.getDesc())) {
				if (existGrantProperty == null || 
						(existGrantProperty.getPropertyNum() < apply.getPropertyNum())) {
					throw new ErpException(500, "该用户在用数量不足。");
				} else {
					existGrantProperty.setPropertyNum(
							existGrantProperty.getPropertyNum() - apply.getPropertyNum());
					if (existGrantProperty.getPropertyNum() <= 0) {
						propertyDao.deleteGrantProperty(existGrantProperty.getGrantPropertyId());
					} else {
						propertyDao.updateGrantProperty(existGrantProperty);
					}
				}
			}
		}
	}
	
}
