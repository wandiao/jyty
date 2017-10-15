package com.jyty.entity;

import java.util.Date;

public class Article {
	// id
	private int id;
	// 标题
	private String title;
	// 分类id
	private String type_id;
	// 分类名称
	private String type_name;
	// 内容
	private String body;
	// 参考地址
	private String refer_url;
	// 点赞数
	private Integer favorite_num;
	// 阅读数
	private Integer read_num;
	// 创建时间
	private Date create_time;
	// 	更新时间
	private Date update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getRefer_url() {
		return refer_url;
	}
	public void setRefer_url(String refer_url) {
		this.refer_url = refer_url;
	}
	public Integer getFavorite_num() {
		return favorite_num;
	}
	public void setFavorite_num(Integer favorite_num) {
		this.favorite_num = favorite_num;
	}
	public Integer getRead_num() {
		return read_num;
	}
	public void setRead_num(Integer read_num) {
		this.read_num = read_num;
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
