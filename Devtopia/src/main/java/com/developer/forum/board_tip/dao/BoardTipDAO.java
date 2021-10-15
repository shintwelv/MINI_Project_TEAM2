
package com.developer.forum.board_tip.dao;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.developer.forum.board_tip.model.BoardTipVO;

@Repository
public class BoardTipDAO {
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
	
	public void insert(BoardTipVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("BoardTip.insert",vo);
		session.commit();
	}
	
	public void update(BoardTipVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardTip.update", vo);
		session.commit();
	}
	
	public void delete(BoardTipVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("BoardTip.delete", vo);
		session.commit();
	}
	
//	public BoardTipVO select(BoardTipVO vo) {
//		sqlMapper = getInstance();
//		SqlSession session = sqlMapper.openSession();
//		BoardTipVO BoardTip = session.selectOne("BoardTip.select", vo);
//		return BoardTip;
//	}
	public BoardTipVO select() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		BoardTipVO BoardTip = session.selectOne("BoardTip.select");
		return BoardTip;
	}
	
	public void countUp(BoardTipVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardTip.ArticleCountUp", vo);
		session.commit();
	}
	
	public List<BoardTipVO> selectArticleList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardTipVO> articleList = null;
		articleList = session.selectList("BoardTip.getArticleList");
		return articleList;
	}
	
	public int totalArticleCount() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		int totalArticleCount = session.selectOne("BoardTip.totalArticleCount");
		return totalArticleCount;
	}
	
	public List<BoardTipVO> pageNationArticle(int page) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<BoardTipVO> articleList = session.selectList("BoardTip.pageNation", (page-1)*10);
		return articleList;
	}
}
