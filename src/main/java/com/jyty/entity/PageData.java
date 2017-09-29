package com.jyty.entity;

import java.util.List;

/**
 * @author Administrator
 *分页类
 */
public class PageData {
	//每页显示数量
	private Integer pageSize;
	//当前页码
	private Integer pageNum;
	//总条数
	private Long totalCount;
	//总页数
	private Integer totalPage;
	//内容列表
	private List<Object> dataList;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<Object> getDataList() {
		return dataList;
	}
	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}
	
	
}
