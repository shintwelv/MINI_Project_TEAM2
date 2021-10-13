package com.developer.forum.article.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.article.dao.ArticleDAO;
import com.developer.forum.article.model.ArticleVO;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	private ArticleDAO dao;
	
	public void insert(ArticleVO vo) {
		dao.insert(vo);
	}
	
	public void delete(ArticleVO vo) {
		dao.delete(vo);
	}
	
	public void update(ArticleVO vo) {
		dao.update(vo);
	}
	
	public ArticleVO select(ArticleVO vo) {
		ArticleVO article = dao.select();
//		ArticleVO article = dao.select(vo);
		return article;
	}
	
	public void countUp(ArticleVO vo) {
		dao.countUp(vo);
	}
	
	public List<ArticleVO> selectArticleList() {
		List<ArticleVO> articleList = null;
		articleList = dao.selectArticleList();
		return articleList;
	}
	
	public List<ArticleVO> pageNationArticleList(int page) {
		List<ArticleVO> articleList = null;
		articleList = dao.pageNationArticle(page);
		return articleList;
	}
}
