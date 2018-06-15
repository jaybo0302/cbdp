/**
 * 
 */
package com.cdwoo.common;

/**
 * @author cd
 *
 */
public final class CDResult {
	private boolean isSuccess;
	private String message;
	private Object data;
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	private CDResult() {}
	 
	public static CDResult success(Object data) {
		CDResult cdResult = new CDResult();
		cdResult.setData(data);
		cdResult.setSuccess(true);
		cdResult.setMessage("success");
		return cdResult;
	}
	
	public static CDResult fail(String message) {
		CDResult cdResult = new CDResult();
		cdResult.setSuccess(false);
		cdResult.setMessage(message);
		return cdResult;
	}
	
	public static CDResult success() {
		CDResult cdResult = new CDResult();
		cdResult.setSuccess(true);
		cdResult.setMessage("success");
		return cdResult;
	}
}
