package com.jyty.entity;

/**
 * @author Administrator
 *类名称：返回数据
 */
public class ResponseData {
	private int status;
	private String message;
	private boolean succeed;
	private Object data;
	
	public ResponseData success(Object data) {
		this.status = 1;
		this.message = "ok";
		this.succeed = true;
		this.data = data;
		return this;
	}
	public ResponseData failure(String msg) {
		this.status = 0;
		this.message = msg;
		this.succeed = false;
		return this;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSucceed() {
		return succeed;
	}
	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
