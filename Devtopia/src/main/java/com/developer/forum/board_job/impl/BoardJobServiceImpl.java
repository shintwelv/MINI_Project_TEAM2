package com.developer.forum.board_job.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.board_job.dao.BoardJobDAO;
import com.developer.forum.board_job.model.BoardJobVO;

@Service("BoardJobService")
public class BoardJobServiceImpl implements BoardJobService {
	
	@Autowired
	private BoardJobDAO dao;
	
	@Override
	public void insert(BoardJobVO vo) {
		dao.insert(vo);
	}
	
	@Override
	public void delete(BoardJobVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public void update(BoardJobVO vo) {
		dao.update(vo);
	}
	
	@Override
	public BoardJobVO select(BoardJobVO vo) {
		BoardJobVO user = dao.select(vo);
		return user;
	}
}
