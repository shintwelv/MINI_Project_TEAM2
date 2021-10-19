package com.developer.forum.board_qna.dao;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.developer.forum.board_qna.model.BoardQnAVO;

@Repository
public class BoardQnADAO {
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
	
	public void insert(BoardQnAVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("BoardQnA.insert",vo);
		session.commit();
	}
	
	public void update(BoardQnAVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardQnA.update", vo);
		session.commit();
	}
	
	public void delete(BoardQnAVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("BoardQnA.delete", vo);
		session.commit();
	}
	
	public BoardQnAVO select(BoardQnAVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		BoardQnAVO BoardQnA = session.selectOne("BoardQnA.select", vo);
		return BoardQnA;
	}
	
	public void countUp(BoardQnAVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardQnA.ArticleCountUp", vo);
		session.commit();
	}
	
	public List<BoardQnAVO> selectArticleList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardQnAVO> articleList = null;
		articleList = session.selectList("BoardQnA.getArticleList");
		return articleList;
	}
	
	public int totalArticleCount() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int totalArticleCount = session.selectOne("BoardQnA.totalArticleCount");
		return totalArticleCount;
	}
	
	public List<BoardQnAVO> pageNationArticle(int page) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardQnAVO> articleList = session.selectList("BoardQnA.pageNation", (page-1)*10);
		return articleList;
	}
	
	public List<BoardQnAVO> selectTopFive() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
	List<BoardQnAVO> topFiveList = session.selectList("BoardQnA.selectViewTop5");
		return topFiveList;
		
	}
}
