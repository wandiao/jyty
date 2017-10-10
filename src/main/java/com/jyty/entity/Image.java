package com.jyty.entity;

import java.util.Date;

public class Image {
	// 图片id
	private Integer id;
	// 图片名称
	private String name;
	// 分类id
	private String type_id;
	// 分类名称
	private String type_name;
	// 图片地址
	private String pic_url;
	// 项目名称
	private String project_name;
	// 项目地址
	private String project_url;
	// 图片简介
	private String summary;
	// 阅读数
	private Integer read_num;
	// 点赞数
	private Integer favorite_num;
	// 完成时间
	private Date complete_time;
	// 创建时间
	private Date create_time;
	// 修改时间
	private Date update_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getPic_url() {
		return pic_url;
	}
	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_url() {
		return project_url;
	}
	public void setProject_url(String project_url) {
		this.project_url = project_url;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getRead_num() {
		return read_num;
	}
	public void setRead_num(Integer read_num) {
		this.read_num = read_num;
	}
	public Integer getFavorite_num() {
		return favorite_num;
	}
	public void setFavorite_num(Integer favorite_num) {
		this.favorite_num = favorite_num;
	}
	public Date getComplete_time() {
		return complete_time;
	}
	public void setComplete_time(Date complete_time) {
		this.complete_time = complete_time;
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
