package com.jyty.entity;

import java.util.Date;

/**
 * @author Administrator
 *类名称：项目
 */
public class Project{
	 //文章id
	private Integer id;
	//文章标题
	private String title; 
	//分类id
	private String type_id;
	//分类名称
	private String type_name;
	//链接地址
	private String url;
	//职位
	private String position;
	//公司
	private String company;
	//文章内容
	private String summary;
	//点赞数
	private Integer favorite_num;
	//阅读数
	private Integer read_num;
	//创建时间
	private Date create_time;
	//更新时间
	private Date update_time;
	//项目开始时间
	private Date project_start_time;
	//项目结束时间
	private Date project_end_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getFavorite_num() {
		return favorite_num;
	}
	public void setFavorite_num(Integer favorite_num) {
		this.favorite_num = favorite_num;
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
	public Integer getRead_num() {
		return read_num;
	}
	public void setRead_num(Integer read_num) {
		this.read_num = read_num;
	}
	public Date getProject_start_time() {
		return project_start_time;
	}
	public void setProject_start_time(Date project_start_time) {
		this.project_start_time = project_start_time;
	}
	public Date getProject_end_time() {
		return project_end_time;
	}
	public void setProject_end_time(Date project_end_time) {
		this.project_end_time = project_end_time;
	}	
}
