package com.developer.forum.board_news.impl;

import com.developer.forum.board_news.model.BoardNewsVO;

public interface BoardNewsService {

	void insert(BoardNewsVO vo);

	void delete(BoardNewsVO vo);

	void update(BoardNewsVO vo);

	BoardNewsVO select(BoardNewsVO vo);

}