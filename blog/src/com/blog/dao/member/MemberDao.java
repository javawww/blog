package com.blog.dao.member;


import org.springframework.stereotype.Repository;

import com.blog.entity.member.Member;

@Repository
public interface MemberDao {

	public Member getById(Integer id);
	
}
