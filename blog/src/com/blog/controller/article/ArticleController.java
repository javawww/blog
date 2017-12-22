package com.blog.controller.article;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.controller.BaseController;
/**
 * 文章管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController extends BaseController{

	@RequestMapping(value = "",method = RequestMethod.GET)
	public String article(HttpServletRequest request) {
		
		return "article/article";
	}
	
}
