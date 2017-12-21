package com.blog.entity.member;

public class Member implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2622395741632948914L;
	private Integer id;
	private String  username;
	private String  password;
	
	
	
	public Member(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	
}
