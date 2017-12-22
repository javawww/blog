package com.blog.entity.article;

import java.util.Date;

/**
 * QQ群:327947585
 * 你看到或是没有看到、我都在这里、坚定不移！！！
 * 你来或是不来、我都在这里、无怨无悔！！！
 * @author Administrator
 *
 */
public class Article implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2538524384488923419L;

	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 分类ID
	 */
	private Integer typeId;
	/**
	 * 分类路径
	 */
	private String typePath;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 创建人id
	 */
	private Integer createId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypePath() {
		return typePath;
	}
	public void setTypePath(String typePath) {
		this.typePath = typePath;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getCreateId() {
		return createId;
	}
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
