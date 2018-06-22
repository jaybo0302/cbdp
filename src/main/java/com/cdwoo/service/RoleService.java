package com.cdwoo.service;

import java.util.List;
import java.util.Map;

import com.cdwoo.common.CDPage;
import com.cdwoo.common.CDParam;
import com.cdwoo.entity.Role;

public interface RoleService {

	CDPage queryRoleByPage(CDParam param);

	void addRole(Role role);

	Role getRoleById(String id);

	void editRole(Role role);

	List<Map<String, Object>> getRole();
}
