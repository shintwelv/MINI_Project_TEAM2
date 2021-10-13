package com.developer.forum.article.impl;

import java.util.List;

import com.developer.forum.article.model.ArticleVO;

public interface ArticleService {

	void insert(ArticleVO vo);

	void delete(ArticleVO vo);

	void update(ArticleVO vo);

	ArticleVO select(ArticleVO vo);

	void countUp(ArticleVO vo);
	
	List<ArticleVO> selectArticleList();
	
	public List<ArticleVO> pageNationArticleList(int page);
	
	public int totalPage();
}