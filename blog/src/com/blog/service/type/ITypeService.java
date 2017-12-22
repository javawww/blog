package com.blog.service.type;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.type.Type;

public interface ITypeService {

	/**根据ID获取唯一*/
	Type getById(Integer id);
	
	/**根据条件获取列表 分页*/
	List<Type> getTypes(@Param("queryMap") Map<String, String> queryMap,
                            @Param("start") Integer start, @Param("size") Integer size);
    
    /**根据条件获取数量 分页*/
    Integer getTypesCount(@Param("queryMap") Map<String, String> queryMap);
    
     /**保存*/
	Integer insert(Type Type);
	
	 /**更新*/
	Integer update(Type Type);
	
	/**删除*/
	Integer delById(Integer id);

	/**根据对象查询*/
	List<Type> getByProperties(@Param("queryMap") Map<String, String> queryMap);
}
