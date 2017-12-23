package com.blog.service.impl.type;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.type.TypeDao;
import com.blog.entity.type.Type;
import com.blog.service.type.ITypeService;

@Service(value = "typeService")
public class TypeServiceImpl implements ITypeService {

	@Resource
	private TypeDao typeDao;
	
	@Override
	public Type getById(Integer id) {
		return typeDao.getById(id);
	}

	@Override
	public List<Type> getTypes(Map<String, String> queryMap, Integer start, Integer size) {
		return typeDao.getTypes(queryMap, start, size);
	}

	@Override
	public Integer getTypesCount(Map<String, String> queryMap) {
		return typeDao.getTypesCount(queryMap);
	}

	@Override
	public Integer insert(Type Type) {
		return typeDao.insert(Type);
	}

	@Override
	public Integer update(Type Type) {
		return typeDao.update(Type);
	}

	@Override
	public Integer delById(Integer id) {
		return typeDao.delById(id);
	}

	@Override
	public List<Type> getByProperties(Map<String, Object> queryMap) {
		return typeDao.getByProperties(queryMap);
	}

	@Override
	public List<Type> getAllTypes() {
		return typeDao.getAllTypes();
	}

}
