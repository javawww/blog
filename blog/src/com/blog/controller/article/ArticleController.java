package com.blog.controller.article;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.blog.controller.BaseController;
import com.blog.core.ResultCode;
import com.blog.entity.article.Article;
import com.blog.entity.member.Member;
import com.blog.entity.type.Type;
import com.blog.service.article.IArticleService;
import com.blog.service.type.ITypeService;
import com.blog.vo.State;
import com.blog.vo.TreeModel;
/**
 * 文章管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController extends BaseController{

	
	@Resource
	private ITypeService typeService;
	
	@Resource
	private IArticleService  articleService;
	
	/**
	 * 默认
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String article(HttpServletRequest request,Map<String, Object> dataMap) {
		
		return "article/article";
	}
	
	/**
	 * 动态生成树	
	 * @param treemodels
	 * @param pTypes
	 * @return
	 */
	private List<TreeModel> generateTree(List<TreeModel> treemodels, List<Type> pTypes) {
		for (Type type : pTypes) {
			TreeModel treeModel = new TreeModel();
			treeModel.setText(type.getName());
			treeModel.setId(type.getId());
			treeModel.setState(new State(true, false));
			Map<String, Object> queryMap = new HashMap<String, Object>();
			queryMap.put("pid",type.getId());
			List<Type> types = typeService.getByProperties(queryMap);
			if(types.size() > 0) {
				List<TreeModel> treemodels2 = new ArrayList<TreeModel>();
				treeModel.setNodes(generateTree(treemodels2, types));
			}
			treemodels.add(treeModel);
		}
		return treemodels;
	}
	
	/**
	 * 添加文章
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "add-article.html",method = RequestMethod.GET)
	public String addArticle(HttpServletRequest request,Map<String, Object> dataMap) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("pid", "0");
		List<Type> pTypes = typeService.getByProperties(queryMap);//系统根节点
		dataMap.put("pTypes", pTypes);
		//~~~~~~~~~~~~~~~~~~~~~~~~~~
		List<TreeModel> treemodels = new ArrayList<TreeModel>();
		treemodels = generateTree(treemodels,pTypes);
		dataMap.put("treemodels", JSON.toJSONString(treemodels));
		
		return "article/add-article";
	}
	
	/**
	 * 提交
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "create",method = RequestMethod.POST)
	public ResultCode create(HttpServletRequest request,Map<String, Object> dataMap,Article article) {
		//当前用户
		Member member = (Member) request.getSession().getAttribute("member");
		
		article.setAuthor(member.getNickname());
		article.setCreateId(member.getId());
		article.setCreateTime(new Date());
		
		Integer flag = articleService.insert(article);
		if(flag == 0) {
			return ResultCode.newErrorCode("插入失败");
		}
		return ResultCode.newRightCode("插入成功");
	}
}
