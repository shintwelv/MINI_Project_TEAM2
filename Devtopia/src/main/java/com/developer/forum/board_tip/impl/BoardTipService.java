package com.developer.forum.board_tip.impl;

import java.util.List;

import com.developer.forum.board_tip.model.BoardTipVO;

public interface BoardTipService {

	void insert(BoardTipVO vo);

	void delete(BoardTipVO vo);

	void update(BoardTipVO vo);

	BoardTipVO select(BoardTipVO vo);

	void countUp(BoardTipVO vo);
	
	List<BoardTipVO> selectArticleList();
	
	public List<BoardTipVO> pageNationArticleList(int page);
	
	public int totalPage();

	public List<BoardTipVO> selectTopFive();
}