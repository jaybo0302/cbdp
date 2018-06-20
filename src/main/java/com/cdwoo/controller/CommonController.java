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
import com.cdwoo.service.ResourceService;

/**
 * @author cd
 *
 */
@Controller
@RequestMapping("common")
public class CommonController {
	@Autowired 
	private ResourceService resourceService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest req) {
		String rIds = "1,8,10,9,11,12,13,14,15,16,17";
		List<Map<String, Object>> list = this.resourceService.getResourcesByRole(rIds);
		req.getSession().setAttribute("rs", list);
		return "jsp/index";
	}
}
