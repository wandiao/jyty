package com.jyty.entity;

import java.util.Date;

/**
 * @author Administrator
 *�����ƣ���Ŀ
 */
public class Project{
	 //����id
	private Integer id;
	//���±���
	private String title; 
	//����id
	private String type_id;
	//��������
	private String type_name;
	//���ӵ�ַ
	private String url;
	//ְλ
	private String position;
	//��˾
	private String company;
	//��������
	private String summary;
	//������
	private Integer favorite_num;
	//�Ķ���
	private Integer read_num;
	//����ʱ��
	private Date create_time;
	//����ʱ��
	private Date update_time;
	//��Ŀ��ʼʱ��
	private Date project_start_time;
	//��Ŀ����ʱ��
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
