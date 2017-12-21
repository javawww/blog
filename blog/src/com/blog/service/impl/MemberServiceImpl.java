package com.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.member.MemberDao;
import com.blog.entity.member.Member;
import com.blog.service.member.IMemberService;

@Service(value = "memberService")
public class MemberServiceImpl implements IMemberService {

	@Resource
	private MemberDao memberDao;
	
	@Override
	public Member getById(Integer id) {
		Member m = memberDao.getById(id);
		return m;
	}

}
