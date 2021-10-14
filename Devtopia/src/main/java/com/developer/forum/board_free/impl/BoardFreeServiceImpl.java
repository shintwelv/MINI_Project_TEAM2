package com.developer.forum.board_free.impl;

import java.util.List;

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
//		BoardFreeVO article = dao.select(vo);
		BoardFreeVO article = dao.select();
		return article;
	}
	
	public void countUp(BoardFreeVO vo) {
		dao.countUp(vo);
	}
	
	public List<BoardFreeVO> selectArticleList() {
		List<BoardFreeVO> articleList = null;
		articleList = dao.selectArticleList();
		return articleList;
	}
	
	public List<BoardFreeVO> pageNationArticleList(int page) {
		List<BoardFreeVO> articleList = null;
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
