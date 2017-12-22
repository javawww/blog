package com.blog.service.impl.article;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blog.dao.article.ArticleDao;
import com.blog.entity.article.Article;
import com.blog.service.article.IArticleService;

@Service(value = "articleService")
public class ArticleServiceImpl implements IArticleService {
	
	@Resource
	private ArticleDao articleDao;

	@Override
	public Article getById(Integer id) {
		return articleDao.getById(id);
	}

	@Override
	public List<Article> getArticles(Map<String, String> queryMap, Integer start, Integer size) {
		return articleDao.getArticles(queryMap, start, size);
	}

	@Override
	public Integer getArticlesCount(Map<String, String> queryMap) {
		return articleDao.getArticlesCount(queryMap);
	}

	@Override
	public Integer insert(Article article) {
		return articleDao.insert(article);
	}

	@Override
	public Integer update(Article article) {
		return articleDao.update(article);
	}

	@Override
	public Integer delById(Integer id) {
		return articleDao.delById(id);
	}

	@Override
	public List<Article> getByProperties(Map<String, String> queryMap) {
		return articleDao.getByProperties(queryMap);
	}

}
