package com.jyty.entity;

import java.util.Date;

/**
 * ���������
 * @author Administrator
 *
 */
public class BaseType {
	
	// ����id
	Integer type_id;
	// ��������
	String type_name;
	// ����id
	String pid;
	// ����ʱ��
	Date create_time;
	// �޸�ʱ��
	Date update_time;
	public Integer getType_id() {
		return type_id;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
}
