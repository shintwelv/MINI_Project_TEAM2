package com.developer.forum.board_news.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.forum.board_news.dao.BoardNewsDAO;
import com.developer.forum.board_news.model.BoardNewsVO;

@Service("BoardNewsService")
public class BoardNewsServiceImpl implements BoardNewsService {
	
	@Autowired
	private BoardNewsDAO dao;
	
	@Override
	public void insert(BoardNewsVO vo) {
		dao.insert(vo);
	}
	
	@Override
	public void delete(BoardNewsVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public void update(BoardNewsVO vo) {
		dao.update(vo);
	}
	
	@Override
	public BoardNewsVO select(BoardNewsVO vo) {
//		BoardNewsVO article = dao.select(vo);
		BoardNewsVO article = dao.select();
		return article;
	}
	
	public void countUp(BoardNewsVO vo) {
		dao.countUp(vo);
	}
	
	public List<BoardNewsVO> selectArticleList() {
		List<BoardNewsVO> articleList = null;
		articleList = dao.selectArticleList();
		return articleList;
	}
	
	public List<BoardNewsVO> pageNationArticleList(int page) {
		List<BoardNewsVO> articleList = null;
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
