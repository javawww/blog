package com.blog.entity.type;

import java.util.Date;
import java.util.List;

/**
 * QQ群:327947585
 * 你看到或是没有看到、我都在这里、坚定不移！！！
 * 你来或是不来、我都在这里、无怨无悔！！！
 * @author Administrator
 *
 */
public class Type implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4457780246954372998L;
	
	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 父ID
	 */
	private Integer pid;
	
	/**
	 * 父路径
	 */
	private String ppath;
	
	/**
	 *名称 
	 */
	private String name;
	
	/**
	 *排序 
	 */
	private Integer sort;
	
	//------------------------------------------
	private List<Type> childs;//子节点
	
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPpath() {
		return ppath;
	}

	public void setPpath(String ppath) {
		this.ppath = ppath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<Type> getChilds() {
		return childs;
	}

	public void setChilds(List<Type> childs) {
		this.childs = childs;
	}
	
	

}
