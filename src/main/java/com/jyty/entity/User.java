package com.jyty.entity;

import java.util.Date;

import javax.sound.midi.MidiDevice.Info;

public class User {
	//�û�id
	private int id;	
	//�û��˻�
	private String username;	
	//����
	private String password; 
	//����
	private String name;	
	//����
	private String email; 
	//qq
	private String qq;
	//weixin
	private String weixin;
	//blog
	private String blog;
	//github
	private String github;
	//���
	private String summary;
	//����ʱ��
	private Date create_time;
	//����ʱ��
	private Date update_time;
	// ��ַ
	private String address;
	// ���˼���
	private String info;
	// ����
	private String progress;
	// �����뷢չ
	private String dream;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getDream() {
		return dream;
	}
	public void setDream(String dream) {
		this.dream = dream;
	}
	
}
