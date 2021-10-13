package com.developer.forum.board_qna.impl;

import com.developer.forum.board_qna.model.BoardQnAVO;

public interface BoardQnAService {

	void insert(BoardQnAVO vo);

	void delete(BoardQnAVO vo);

	void update(BoardQnAVO vo);

	BoardQnAVO select(BoardQnAVO vo);

}