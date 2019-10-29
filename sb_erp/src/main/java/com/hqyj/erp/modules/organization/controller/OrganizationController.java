package com.hqyj.erp.modules.organization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrganizationController {

	@RequestMapping("/organization/organizationPage")
	public String OrganizationPage (ModelMap modelMap) {
		modelMap.addAttribute("template", "organization/organizationStructure");
		return "indexSimple";
	}
}
