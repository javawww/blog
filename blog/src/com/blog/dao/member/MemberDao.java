package com.blog.dao.member;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.blog.entity.member.Member;

@Repository
public interface MemberDao {
 
 	/**根据ID获取唯一*/
	Member getById(Integer id);
	
	/**根据条件获取列表 分页*/
	List<Member> getMembers(@Param("queryMap") Map<String, String> queryMap,
                            @Param("start") Integer start, @Param("size") Integer size);
    
    /**根据条件获取数量 分页*/
    Integer getMembersCount(@Param("queryMap") Map<String, String> queryMap);
    
     /**保存*/
	Integer insert(Member member);
	
	 /**更新*/
	Integer update(Member member);
	
	/**删除*/
	Integer delById(Integer id);

	/**根据用户名查询*/
	Member getByUsername(String username);

	/**根据对象查询*/
	List<Member> getByProperties(@Param("queryMap") Map<String, String> queryMap);
	
}
