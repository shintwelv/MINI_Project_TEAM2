package com.developer.forum.board_qna.impl;

import java.util.List;

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
//		BoardQnAVO article = dao.select(vo);
		BoardQnAVO article = dao.select();
		return article;
	}
	
	public void countUp(BoardQnAVO vo) {
		dao.countUp(vo);
	}
	
	public List<BoardQnAVO> selectArticleList() {
		List<BoardQnAVO> articleList = null;
		articleList = dao.selectArticleList();
		return articleList;
	}
	
	public List<BoardQnAVO> pageNationArticleList(int page) {
		List<BoardQnAVO> articleList = null;
		articleList = dao.pageNationArticle(page);
		return articleList;
	}
	
	public int totalPage() {
		int totalArticleCount = dao.totalArticleCount();
		int totalPage = (totalArticleCount - (totalArticleCount%10))/10;
		if (totalArticleCount%10 != 0) {
			totalPage++;
		}
		return totalPage;
	}
}
