package com.jyty.entity;

import java.util.List;

/**
 * @author Administrator
 *��ҳ��
 */
public class PageData {
	//ÿҳ��ʾ����
	private Integer pageSize;
	//��ǰҳ��
	private Integer pageNum;
	//������
	private Long totalCount;
	//��ҳ��
	private Integer totalPage;
	//�����б�
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
