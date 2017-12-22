package com.blog.dao.article;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.blog.entity.article.Article;

@Repository
public interface ArticleDao {

	/**根据ID获取唯一*/
	Article getById(Integer id);
	
	/**根据条件获取列表 分页*/
	List<Article> getArticles(@Param("queryMap") Map<String, String> queryMap,
                            @Param("start") Integer start, @Param("size") Integer size);
    
    /**根据条件获取数量 分页*/
    Integer getArticlesCount(@Param("queryMap") Map<String, String> queryMap);
    
     /**保存*/
	Integer insert(Article article);
	
	 /**更新*/
	Integer update(Article article);
	
	/**删除*/
	Integer delById(Integer id);

	/**根据对象查询*/
	List<Article> getByProperties(@Param("queryMap") Map<String, String> queryMap);
}
