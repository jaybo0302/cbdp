/**
 * 
 */
package com.cdwoo.entity;

import com.cdwoo.common.CDParam;

/**
 * @author cd
 *
 */
public class TransformerParam extends CDParam {
	private String name;
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
