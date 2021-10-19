package com.developer.forum.board_tip.impl;

import java.util.List;

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
		BoardTipVO article = dao.select(vo);
		return article;
	}
	
	public void countUp(BoardTipVO vo) {
		dao.countUp(vo);
	}
	
	public List<BoardTipVO> selectArticleList() {
		List<BoardTipVO> articleList = null;
		articleList = dao.selectArticleList();
		return articleList;
	}
	
	public List<BoardTipVO> pageNationArticleList(int page) {
		List<BoardTipVO> articleList = null;
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
	
	public List<BoardTipVO> selectTopFive() {
		List<BoardTipVO> topFiveList = null;
		topFiveList = dao.selectTopFive();
		return topFiveList;
	}
}
