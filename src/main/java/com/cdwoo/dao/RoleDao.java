package com.cdwoo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cdwoo.common.CDParam;
import com.cdwoo.entity.Role;

public interface RoleDao {
	long queryRoleCount(CDParam param);
	List<Object> queryRoleByPage(CDParam param);
	void addRole(Role role);
	Role getRoleById(@Param("id")String id);
	void editRole(Role role);
	List<Map<String, Object>> getRole();
	long getCurrentRoleCount(@Param("id")String id);
	void deleteRole(@Param("id")String id);
}
