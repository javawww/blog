package com.blog.controller.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.controller.BaseController;
import com.blog.core.ResultCode;
import com.blog.entity.member.Member;

@Controller
@RequestMapping(value = "member")
public class LoginController extends BaseController{
	
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
	@RequestMapping(value = "dologin",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public ResultCode doLogin(HttpServletRequest request,@PathVariable(required = false) Member member){
		String msg = "success";
		if(member==null) {
			msg = "error";
			return ResultCode.newErrorCode(msg);
		}
		
		return ResultCode.newRightCode(msg);
	}
	
	
}
