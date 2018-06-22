/**
 * 
 */
package com.cdwoo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdwoo.common.CDResult;
import com.cdwoo.entity.Role;
import com.cdwoo.service.ResourceService;
import com.cdwoo.service.RoleService;

/**
 * @author cd
 *
 */
@Controller
@RequestMapping("common")
public class CommonController {
	@Autowired 
	private ResourceService resourceService;
	@Autowired
	private RoleService roleService;
	@RequestMapping("index")
	public String index(HttpServletRequest req) {
		Role r = this.roleService.getRoleById("0");
		String rIds = r.getrIds().substring(0, r.getrIds().length() - 1);
		List<Map<String, Object>> list = this.resourceService.getResourcesByRole(rIds);
		req.getSession().setAttribute("rs", list);
		return "jsp/index";
	}
}
