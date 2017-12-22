package com.blog.controller.index;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.blog.entity.member.Member;
import com.blog.service.member.IMemberService;

@Controller
public class IndexController {

	@Resource
	private IMemberService memberService;
	
	@RequestMapping(value = "")
	public String defaultIndex() {
		return "index/index";
	}
	
	@RequestMapping(value = "index")
	public String index() {
		return "index/index";
	}
	
	@RequestMapping(value = "testjson")
	@ResponseBody
	public Member testjson() {
		Member member = new Member(1, "张三", "123456");
		return member;
	}
	
	@RequestMapping(value = "getmember")
	@ResponseBody
	public Member getMember(Integer id ) {
		Member m = memberService.getById(id);
		
		return m;
	}
}
