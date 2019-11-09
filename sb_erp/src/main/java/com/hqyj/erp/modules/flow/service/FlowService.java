package com.hqyj.erp.modules.flow.service;

import com.github.pagehelper.PageInfo;
import com.hqyj.erp.modules.common.vo.Result;
import com.hqyj.erp.modules.common.vo.SearchVo;
import com.hqyj.erp.modules.flow.entity.Apply;

public interface FlowService {

	Result insertOrUpdateApply(Apply apply);
	
	PageInfo<Apply> getApplies(SearchVo searchVo);
	
	Apply getApplyById(int applyId);
	
	Result deleteApply(int applyId);
	
	Result updateApplyFlow(Apply apply);
}
