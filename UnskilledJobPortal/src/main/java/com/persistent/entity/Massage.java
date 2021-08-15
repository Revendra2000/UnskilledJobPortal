package com.persistent.entity;

public class Massage {
	private String content;
	private String type;
	public Massage() {
		super();
	}
	public Massage(String content, String type) {
		super();
		this.content = content;
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	@Override
	public String toString() {
		return "Massage [content=" + content + ", type=" + type + "]";
	}
	
	
}
