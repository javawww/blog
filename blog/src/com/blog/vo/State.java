package com.blog.vo;
/**
 * 推荐图  TREE所需
 * @author Administrator
 *
 */
public class State {

	private boolean 					expanded;//是否展开
	private boolean 					selected;//是否展开
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public State(boolean expanded, boolean selected) {
		this.expanded = expanded;
		this.selected = selected;
	}
	
	
	
	
}
