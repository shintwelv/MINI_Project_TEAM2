package com.developer.forum.board_free.impl;

import com.developer.forum.board_free.model.BoardFreeVO;

public interface BoardFreeService {

	void insert(BoardFreeVO vo);

	void delete(BoardFreeVO vo);

	void update(BoardFreeVO vo);

	BoardFreeVO select(BoardFreeVO vo);

}