package com.cdwoo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cdwoo.entity.Resource;

public interface ResourceDao {

	List<Map<String, Object>> getResources();

	Resource getResourceById(@Param("id") String id);

	void editResource(Resource r);

	void addResource(Resource r);

	void deleteResource(@Param("id") String id);

	long checkHaveChild(@Param("id") String id);

	List<Map<String, Object>> getResourcesByRole(@Param("rIds")String rIds);

}
