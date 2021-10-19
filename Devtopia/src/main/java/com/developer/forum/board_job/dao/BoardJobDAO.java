package com.developer.forum.board_job.dao;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.developer.forum.board_job.model.BoardJobVO;

@Repository
public class BoardJobDAO {
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
	
	public void insert(BoardJobVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("BoardJob.insert",vo);
		session.commit();
	}
	
	public void update(BoardJobVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardJob.update", vo);
		session.commit();
	}
	
	public void delete(BoardJobVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("BoardJob.delete", vo);
		session.commit();
	}
	
	public BoardJobVO select(BoardJobVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		BoardJobVO BoardJob = session.selectOne("BoardJob.select", vo);
		return BoardJob;
	}
	
	public void countUp(BoardJobVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardJob.ArticleCountUp", vo);
		session.commit();
	}
	
	public List<BoardJobVO> selectArticleList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardJobVO> articleList = null;
		articleList = session.selectList("BoardJob.getArticleList");
		return articleList;
	}
	
	public int totalArticleCount() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int totalArticleCount = session.selectOne("BoardJob.totalArticleCount");
		return totalArticleCount;
	}
	
	public List<BoardJobVO> pageNationArticle(int page) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardJobVO> articleList = session.selectList("BoardJob.pageNation", (page-1)*10);
		return articleList;
	}
	
	public List<BoardJobVO> selectTopFive() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardJobVO> topFiveList = session.selectList("BoardJob.selectViewTop5");
		return topFiveList;
		
	}
}
