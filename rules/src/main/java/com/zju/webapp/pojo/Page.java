package com.zju.webapp.pojo;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class Page {

	static private int DEFAULT_PAGE_SIZE = 15;

	/**
	 * 每页的记录数
	 */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/**
	 * 当前页第一条数据在List中的位置,从0开始
	 */
	private int start;

	/**
	 * 当前页中存放的记录
	 */
	private List results;

	/**
	 * 总记录数
	 */
	private int totalCount;

	/**
	 * 构造方法，只构造空页
	 */
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
	}

	/**
	 * 默认构造方法
	 * 
	 * @param start 		本页数据在数据库中的起始位置
	 * @param totalSize  	数据库中总记录条数
	 * @param pageSize  	本页容量
	 * @param results  		本页包含的数据
	 */
	public Page(int start, int totalSize, int pageSize, List results) {
		this.start = start;
		this.totalCount = totalSize;
		this.pageSize = pageSize;
		this.results = results;
	}

	/**
	 * 取数据库中包含的总记录数
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 取总页数
	 */
	public int getTotalPageCount() {
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else
			return totalCount / pageSize + 1;
	}

	/**
	 * 取每页数据容量
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 当前页记录
	 */
	public List getResults() {
		return results;
	}

	/**
	 * 取当前页码,页码从1开始
	 */
	public int getCurrentPageNo() {
		return start / pageSize + 1;
	}

	/**
	 * 是否有下一页
	 */
	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount() - 1;
	}

	/**
	 * 是否有上一页
	 */
	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	/**
	 * 获取任一页第一条数据的位置，每页条数使用默认值
	 */
	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	/**
	 * 获取任一页第一条数据的位置,startIndex从0开始
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 设置总记录数
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 设置记录
	 * 
	 * @param results
	 */
	public void setResults(List results) {
		this.results = results;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
