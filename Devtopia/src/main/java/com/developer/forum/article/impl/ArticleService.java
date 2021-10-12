package com.developer.forum.article.impl;

import com.developer.forum.article.model.ArticleVO;

public interface ArticleService {

	void insert(ArticleVO vo);

	void delete(ArticleVO vo);

	void update(ArticleVO vo);

	ArticleVO select(ArticleVO vo);

}