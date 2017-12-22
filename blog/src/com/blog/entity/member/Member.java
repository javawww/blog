package com.blog.entity.member;

/**
 * QQ群:327947585
 * 你看到或是没有看到、我都在这里、坚定不移！！！
 * 你来或是不来、我都在这里、无怨无悔！！！
 * @author Administrator
 *
 */
public class Member implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2622395741632948914L;
	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 昵称、笔名
	 */
	private String nickname;
	/**
	 * 用户名
	 */
	private String  username;
	/**
	 * 密码
	 */
	private String  password;
	/**
	 * 推荐人
	 */
	private Integer pid;
	
	public Member(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	
	public Member(Integer id, String nickname, String username, String password, Integer pid) {
		this.id = id;
		this.nickname = nickname;
		this.username = username;
		this.password = password;
		this.pid = pid;
	}


	public Member() {
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	
}
