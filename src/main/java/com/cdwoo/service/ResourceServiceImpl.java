package com.cdwoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdwoo.dao.ResourceDao;
import com.cdwoo.entity.Resource;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	@Override
	public Object getResources() {
		return resourceDao.getResources();
	}
	@Override
	public Resource getResourceById(String id) {
		return resourceDao.getResourceById(id);
	}
	@Override
	public void editResource(Resource r) {
		resourceDao.editResource(r);
	}
	@Override
	public void addResource(Resource r) {
		resourceDao.addResource(r);
	}
	@Override
	public boolean checkHaveChild(String id) {
		long count = 0;
		count = resourceDao.checkHaveChild(id);
		return (count > 0);
	}
	@Override
	public void deleteResource(String id) {
		resourceDao.deleteResource(id);
	}

}
