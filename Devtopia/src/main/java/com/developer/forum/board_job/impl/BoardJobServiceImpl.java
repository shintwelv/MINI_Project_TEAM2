package com.developer.forum.board_job.impl;

import java.util.List;

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
		BoardJobVO article = dao.select(vo);
		return article;
	}
	
	public void countUp(BoardJobVO vo) {
		dao.countUp(vo);
	}
	
	public List<BoardJobVO> selectArticleList() {
		List<BoardJobVO> articleList = null;
		articleList = dao.selectArticleList();
		return articleList;
	}
	
	public List<BoardJobVO> pageNationArticleList(int page) {
		List<BoardJobVO> articleList = null;
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
	
	public List<BoardJobVO> selectTopFive() {
		List<BoardJobVO> topFiveList = null;
		topFiveList = dao.selectTopFive();
		return topFiveList;
	}
}
