/**
 * 
 */
package com.cdwoo.entity;

/**
 * @author cd
 *
 */
public class Role {
	private String role;
	private String roleName;
	private String description;
	private int id;
	private String rIds;
	
	public String getrIds() {
		return rIds;
	}
	public void setrIds(String rIds) {
		this.rIds = rIds;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
