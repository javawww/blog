package com.blog.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.controller.BaseController;
import com.blog.core.ResultCode;
import com.blog.entity.member.Member;
import com.blog.service.member.IMemberService;

@Controller
@RequestMapping(value = "member")
public class LoginController extends BaseController{
	
	/***注入业务service层*/
	@Resource
	private IMemberService							memberService;
	
	/**
	 * 登陆页面
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = "login",method = {RequestMethod.GET })
	public String login(HttpServletRequest request, Map<String, Object> dataMap) {
		return "member/login";
	}

	/**
	 * 登陆校验
	 * @param request
	 * @param member
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "dologin",method = {RequestMethod.POST})
	@ResponseBody
	public ResultCode doLogin(HttpServletRequest request,Member member){
		if(member==null) {
			return ResultCode.newErrorCode("用户对象不存在");
		}
		
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("username",member.getUsername());
		queryMap.put("password",member.getPassword());
		List<Member> member_query = memberService.getByProperties(queryMap);
		if(member_query==null || member_query.size()==0) {
			return ResultCode.newErrorCode("登陆失败");
		}
		request.getSession().setAttribute("member", member_query.get(0));
		
		return ResultCode.newRightCode("登陆成功");
	}
	
	/**
	 * 注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("member");
		return "redirect:/";
	}
}
