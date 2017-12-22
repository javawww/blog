package com.blog.controller.type;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blog.controller.BaseController;

/**
 * 栏目分类
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "category")
public class CategoryController extends BaseController{
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String category(HttpServletRequest request) {
		
		return "type/category";
	}

}
