package com.developer.forum.board_free.impl;

import java.util.List;

import com.developer.forum.board_free.model.BoardFreeVO;

public interface BoardFreeService {

	void insert(BoardFreeVO vo);

	void delete(BoardFreeVO vo);

	void update(BoardFreeVO vo);

	BoardFreeVO select(BoardFreeVO vo);

	void countUp(BoardFreeVO vo);
	
	List<BoardFreeVO> selectArticleList();
	
	public List<BoardFreeVO> pageNationArticleList(int page);
	
	public int totalPage();
}