package com.cdwoo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdwoo.common.CDPage;
import com.cdwoo.common.CDParam;
import com.cdwoo.common.CDResult;
import com.cdwoo.entity.Role;
import com.cdwoo.service.RoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@ResponseBody
	@RequestMapping("queryRoleByPage")
	public CDPage queryRoleByPage(CDParam param) {
		return this.roleService.queryRoleByPage(param);
	}
	
	@ResponseBody
	@RequestMapping("addRole")
	public CDResult addRole(Role role) {
		try {
			this.roleService.addRole(role);
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("添加失败");
		}
		return CDResult.success();
	}
	
	@RequestMapping("getEditPage")
	public String getEditPage(@RequestParam("id") String id, HttpServletRequest req) {
		Role r = this.roleService.getRoleById(id);
		req.getSession().setAttribute("r", r);
		return "jsp/role_edit";
	}
	
	@ResponseBody
	@RequestMapping("editRole")
	public CDResult editRole(Role role) {
		try {
			this.roleService.editRole(role);
			return CDResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("修改失败");
		}
	}
	
	@ResponseBody
	@RequestMapping("getRole")
	public CDResult getRole() {
		try {
			List<Map<String, Object>> result = this.roleService.getRole();
			return CDResult.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return CDResult.fail("获取角色失败");
		}
	}
	
	@ResponseBody
	@RequestMapping("deleteRole")
	public CDResult deleteRole(@RequestParam("id")String id) {
		try {
			//首先查看是否有用户属于该角色
			long total = this.roleService.getCurrentRoleCount(id);
			if (total > 0) {
				return CDResult.fail("有用户是该角色，无法删除");
			} else {
				this.roleService.deleteRole(id);
				return CDResult.success();
			}
		} catch (Exception e) {
			return CDResult.fail("删除失败");
		}
	}
}
