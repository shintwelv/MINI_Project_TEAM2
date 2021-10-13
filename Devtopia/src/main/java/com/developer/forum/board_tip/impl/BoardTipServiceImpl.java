package com.developer.forum.board_tip.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.board_tip.dao.BoardTipDAO;
import com.developer.forum.board_tip.model.BoardTipVO;

@Service("BoardTipService")
public class BoardTipServiceImpl implements BoardTipService {
	
	@Autowired
	private BoardTipDAO dao;
	
	@Override
	public void insert(BoardTipVO vo) {
		dao.insert(vo);
	}
	
	@Override
	public void delete(BoardTipVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public void update(BoardTipVO vo) {
		dao.update(vo);
	}
	
	@Override
	public BoardTipVO select(BoardTipVO vo) {
		BoardTipVO user = dao.select(vo);
		return user;
	}
}
