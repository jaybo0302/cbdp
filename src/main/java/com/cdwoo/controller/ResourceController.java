/**
 * 
 */
package com.cdwoo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdwoo.common.CDResult;
import com.cdwoo.entity.Resource;
import com.cdwoo.service.ResourceService;

/**
 * @author cd
 *
 */
@Controller
@RequestMapping("resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	@ResponseBody
	@RequestMapping("getResources")
	public Object getResources() {
		
        return resourceService.getResources();
	}
	
	@RequestMapping("getEditPage")
	public String getEditPage(@RequestParam("id") String id, HttpServletRequest req) {
		Resource r =  resourceService.getResourceById(id);
		req.getSession().setAttribute("r", r);
		return "jsp/resource_edit";
	}
	
	@ResponseBody
	@RequestMapping("editResource")
	public CDResult editResource(Resource r) {
		try {
			resourceService.editResource(r);
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("修改失败");
		}
		return CDResult.success();
	}
	
	@ResponseBody
	@RequestMapping("addResource")
	public CDResult addResource(Resource r) {
		try {
			resourceService.addResource(r);
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("修改失败");
		}
		return CDResult.success();
	}
	
	@ResponseBody
	@RequestMapping("deleteResource")
	public CDResult deleteResource(@RequestParam("id") String id) {
		try {
			//首先判断是否有子节点，如果有，返回错误
			if (!resourceService.checkHaveChild(id)) {
				//执行删除操作
				resourceService.deleteResource(id);
				return CDResult.success();
			} else {
				return CDResult.fail("不能删除拥有子节点的资源");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("删除失败");
		}
	}
}
