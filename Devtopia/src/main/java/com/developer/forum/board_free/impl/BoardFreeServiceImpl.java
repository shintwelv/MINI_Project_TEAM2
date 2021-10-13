package com.developer.forum.board_free.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.board_free.dao.BoardFreeDAO;
import com.developer.forum.board_free.model.BoardFreeVO;

@Service("BoardFreeService")
public class BoardFreeServiceImpl implements BoardFreeService {
	
	@Autowired
	private BoardFreeDAO dao;
	
	@Override
	public void insert(BoardFreeVO vo) {
		dao.insert(vo);
	}
	
	@Override
	public void delete(BoardFreeVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public void update(BoardFreeVO vo) {
		dao.update(vo);
	}
	
	@Override
	public BoardFreeVO select(BoardFreeVO vo) {
		BoardFreeVO user = dao.select(vo);
		return user;
	}
}
