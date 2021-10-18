package com.developer.forum.board_news.dao;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.developer.forum.board_news.model.BoardNewsVO;

@Repository
public class BoardNewsDAO {
private static SqlSessionFactory sqlMapper;
	
	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			String resource = "mybatis/mybatis-config.xml";
			Reader reader;
			try {
				reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public void insert(BoardNewsVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("BoardNews.insert",vo);
		session.commit();
	}
	
	public void update(BoardNewsVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardNews.update", vo);
		session.commit();
	}
	
	public void delete(BoardNewsVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("BoardNews.delete", vo);
		session.commit();
	}
	
//	public BoardNewsVO select(BoardNewsVO vo) {
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		BoardNewsVO BoardNews = session.selectOne("BoardNews.select", vo);
//		return BoardNews;
//	}
	public BoardNewsVO select() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		BoardNewsVO BoardNews = session.selectOne("BoardNews.select");
		return BoardNews;
	}
	
	public void countUp(BoardNewsVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardNews.ArticleCountUp", vo);
		session.commit();
	}
	
	public List<BoardNewsVO> selectArticleList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardNewsVO> articleList = null;
		articleList = session.selectList("BoardNews.getArticleList");
		return articleList;
	}
	
	public int totalArticleCount() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int totalArticleCount = session.selectOne("BoardNews.totalArticleCount");
		return totalArticleCount;
	}
	
	public List<BoardNewsVO> pageNationArticle(int page) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardNewsVO> articleList = session.selectList("BoardNews.pageNation", (page-1)*10);
		return articleList;
	}
	
	public List<BoardNewsVO> selectTopFive() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardNewsVO> topFiveList = session.selectList("BoardNews.selectViewTop5");
		return topFiveList;
		
	}
}
