/**
 * 
 */
package com.cdwoo.service;

import com.cdwoo.entity.Resource;

/**
 * @author cd
 *
 */
public interface ResourceService {

	Object getResources();

	Resource getResourceById(String id);

	void editResource(Resource r);

	void addResource(Resource r);

	boolean checkHaveChild(String id);

	void deleteResource(String id);

}
