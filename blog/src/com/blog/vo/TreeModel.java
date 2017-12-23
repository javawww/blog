package com.blog.vo;

import java.util.List;

/**
 * 推荐图  TREE 数据图   无限遍历  递归调用
 * @author Administrator
 *
 */
public class TreeModel {
	
	private  java.lang.String  				text;//文字描述
	private  java.lang.String 				memNum;// 用户编号
	private  java.lang.Integer      		id;//主键  唯一标识
	private  List<TreeModel>			nodes;//儿子元素
	private  TreeModel 				parent;//父节点
	private  State 							state;//关联状态  是否展开  是否选中
	private int 							level;//深度
	
	
	public java.lang.String getText() {
		return text;
	}
	public void setText(java.lang.String text) {
		this.text = text;
	}
	public java.lang.String getMemNum() {
		return memNum;
	}
	public void setMemNum(java.lang.String memNum) {
		this.memNum = memNum;
	}
	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public List<TreeModel> getNodes() {
		return nodes;
	}
	public void setNodes(List<TreeModel> nodes) {
		this.nodes = nodes;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public TreeModel getParent() {
		return parent;
	}
	public void setParent(TreeModel parent) {
		this.parent = parent;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}


}
