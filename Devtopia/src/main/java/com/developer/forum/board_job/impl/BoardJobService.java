package com.developer.forum.board_job.impl;

import java.util.List;

import com.developer.forum.board_job.model.BoardJobVO;

public interface BoardJobService {

	void insert(BoardJobVO vo);

	void delete(BoardJobVO vo);

	void update(BoardJobVO vo);

	BoardJobVO select(BoardJobVO vo);

	void countUp(BoardJobVO vo);
	
	List<BoardJobVO> selectArticleList();
	
	public List<BoardJobVO> pageNationArticleList(int page);
	
	public int totalPage();
	
	public List<BoardJobVO> selectTopFive();
}