package com.developer.forum.board_tip.impl;

import com.developer.forum.board_tip.model.BoardTipVO;

public interface BoardTipService {

	void insert(BoardTipVO vo);

	void delete(BoardTipVO vo);

	void update(BoardTipVO vo);

	BoardTipVO select(BoardTipVO vo);

}