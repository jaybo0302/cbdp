package com.cdwoo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdwoo.common.CDPage;
import com.cdwoo.common.CDParam;
import com.cdwoo.dao.RoleDao;
import com.cdwoo.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Override
	public CDPage queryRoleByPage(CDParam param) {
		CDPage page = new CDPage();
		page.setCount(param.getPageSize());
		page.setCurrentPage(param.getPageNo());
		page.setTotalCount(roleDao.queryRoleCount(param));
		List<Object> result= roleDao.queryRoleByPage(param);
		page.setData(result);
		return page;
	}
	@Override
	public void addRole(Role role) {
		this.roleDao.addRole(role);
	}
	@Override
	public Role getRoleById(String id) {
		return this.roleDao.getRoleById(id);
	}
	@Override
	public void editRole(Role role) {
		this.roleDao.editRole(role);
	}
	@Override
	public List<Map<String, Object>> getRole() {
		return this.roleDao.getRole();
	}
	@Override
	public long getCurrentRoleCount(String id) {
		
		return this.roleDao.getCurrentRoleCount(id);
	}
	@Override
	public void deleteRole(String id) {
		this.roleDao.deleteRole(id);
	}
}
