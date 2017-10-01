package com.jyty.entity;

import java.util.Date;

/**
 * 分类基础类
 * @author Administrator
 *
 */
public class BaseType {
	
	// 分类id
	Integer type_id;
	// 分类名称
	String type_name;
	// 父级id
	String pid;
	// 创建时间
	Date create_time;
	// 修改时间
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
