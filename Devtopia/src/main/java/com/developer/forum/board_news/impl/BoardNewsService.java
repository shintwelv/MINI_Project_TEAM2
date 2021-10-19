package com.developer.forum.board_news.impl;

import java.util.List;

import com.developer.forum.board_news.model.BoardNewsVO;

public interface BoardNewsService {

	void insert(BoardNewsVO vo);

	void delete(BoardNewsVO vo);

	void update(BoardNewsVO vo);

	BoardNewsVO select(BoardNewsVO vo);

	void countUp(BoardNewsVO vo);
	
	List<BoardNewsVO> selectArticleList();
	
	public List<BoardNewsVO> pageNationArticleList(int page);
	
	public int totalPage();

	public List<BoardNewsVO> selectTopFive();
}