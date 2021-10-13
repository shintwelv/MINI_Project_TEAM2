package com.developer.forum.article.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.article.dao.ArticleDAO;
import com.developer.forum.article.model.ArticleVO;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDAO dao;
	
	@Override
	public void insert(ArticleVO vo) {
		dao.insert(vo);
	}
	
	@Override
	public void delete(ArticleVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public void update(ArticleVO vo) {
		dao.update(vo);
	}
	
	@Override
	public ArticleVO select(ArticleVO vo) {
		ArticleVO article = dao.select();
//		ArticleVO article = dao.select(vo);
		return article;
	}
}
