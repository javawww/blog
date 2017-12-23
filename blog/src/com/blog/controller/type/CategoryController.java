package com.blog.controller.type;

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
import com.blog.entity.type.Type;
import com.blog.service.type.ITypeService;
import com.blog.vo.State;
import com.blog.vo.TreeModel;

/**
 * 栏目分类
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "category")
public class CategoryController extends BaseController{
	
	@Resource
	private ITypeService typeService;
	
	/**
	 * 默认页面
	 * @param request
	 * @param dataMap
	 * @return
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String category(HttpServletRequest request,Map<String, Object> dataMap) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("pid", "0");
		List<Type> pTypes = typeService.getByProperties(queryMap);//系统根节点
		dataMap.put("pTypes", pTypes);
		//~~~~~~~~~~~~~~~~~~~~~~~~~~
		List<TreeModel> treemodels = new ArrayList<TreeModel>();
		treemodels = generateTree(treemodels,pTypes);
		dataMap.put("treemodels", JSON.toJSONString(treemodels));
		return "type/category";
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
	 * 提交
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "create",method = RequestMethod.POST)
	@ResponseBody
	public ResultCode create(HttpServletRequest request,Type type) {
		type.setCreateTime(new Date());
		
		Integer flag = typeService.insert(type);
		if(flag==1) {
			return ResultCode.newRightCode("提交成功");
		}
		if(flag==0) {
			return ResultCode.newErrorCode("提交失败");
		}
		return null;
	}
	
	@RequestMapping(value = "getByPid",method = RequestMethod.GET)
	@ResponseBody
	public ResultCode getByPid(HttpServletRequest request,Integer id) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("pid",id);
		List<Type> types = typeService.getByProperties(queryMap);
		return ResultCode.newRightCode(types);
	}
	
	
}
