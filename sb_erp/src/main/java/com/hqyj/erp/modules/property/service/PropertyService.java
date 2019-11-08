package com.hqyj.erp.modules.property.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.property.entity.Apply;
import com.hqyj.erp.modules.property.entity.GrantProperty;
import com.hqyj.erp.modules.property.entity.Property;

public interface PropertyService {

	Result addProperty(Property property);
	
	PageInfo<GrantProperty> getGrantProperties(SearchVo searchVo);
	
	Result insertOrUpdateApply(Apply apply);
	
	PageInfo<Apply> getApplies(SearchVo searchVo);
	
	Apply getApplyById(int applyId);
	
	Result deleteApply(int applyId);
	
	Result updateApplyFlow(Apply apply);
}
