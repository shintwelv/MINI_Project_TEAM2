package com.developer.forum.board_qna.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.board_qna.dao.BoardQnADAO;
import com.developer.forum.board_qna.model.BoardQnAVO;

@Service("BoardQnAService")
public class BoardQnAServiceImpl implements BoardQnAService {
	
	@Autowired
	private BoardQnADAO dao;
	
	@Override
	public void insert(BoardQnAVO vo) {
		dao.insert(vo);
	}
	
	@Override
	public void delete(BoardQnAVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public void update(BoardQnAVO vo) {
		dao.update(vo);
	}
	
	@Override
	public BoardQnAVO select(BoardQnAVO vo) {
		BoardQnAVO user = dao.select(vo);
		return user;
	}
}
