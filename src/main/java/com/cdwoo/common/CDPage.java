/**
 * 
 */
package com.cdwoo.common;

import java.util.List;

/**
 * @author cd
 *
 */
public class CDPage {
	private long totalCount;
	private long currentPage;
	private long count;
	private List<Object> data;
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
}
