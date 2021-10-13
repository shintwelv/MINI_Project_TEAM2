package com.developer.forum.board_job.impl;

import com.developer.forum.board_job.model.BoardJobVO;

public interface BoardJobService {

	void insert(BoardJobVO vo);

	void delete(BoardJobVO vo);

	void update(BoardJobVO vo);

	BoardJobVO select(BoardJobVO vo);

}