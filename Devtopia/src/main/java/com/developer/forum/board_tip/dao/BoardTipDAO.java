
package com.developer.forum.board_tip.dao;


import java.io.IOException;
import java.io.Reader;

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
			String resource = "mybatis-config.xml";
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
	
	public BoardTipVO select(BoardTipVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		BoardTipVO BoardTip = session.selectOne("BoardTip.select", vo);
		return BoardTip;
	}
}
