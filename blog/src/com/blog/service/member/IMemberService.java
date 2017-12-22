package com.blog.service.member;

import java.util.List;
import java.util.Map;

import com.blog.entity.member.Member;

public interface IMemberService {

	/**根据ID获取唯一*/
	public Member getById(Integer id);
	
	/**根据条件获取列表 分页*/
	public List<Member> getMembers(Map<String, String> queryMap, Integer start, Integer size);
    
    /**根据条件获取数量 分页*/
    public Integer getMembersCount(Map<String, String> queryMap);
    
     /**保存*/
	public Integer insert(Member member);
	
	 /**更新*/
	public Integer update(Member member);
	
	/**删除*/
	public Integer delById(Integer id);

	/**根据用户名查询*/
	public Member getByUsername(String username);

	/**根据对象查询*/
	public List<Member> getByProperties(Map<String, String> queryMap);
}
