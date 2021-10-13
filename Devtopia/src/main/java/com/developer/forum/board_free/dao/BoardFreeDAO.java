package com.developer.forum.board_free.dao;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.developer.forum.board_free.model.BoardFreeVO;

@Repository
public class BoardFreeDAO {
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
	
	public void insert(BoardFreeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("BoardFree.insert",vo);
		session.commit();
	}
	
	public void update(BoardFreeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("BoardFree.update", vo);
		session.commit();
	}
	
	public void delete(BoardFreeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("BoardFree.delete", vo);
		session.commit();
	}
	
	public BoardFreeVO select(BoardFreeVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		BoardFreeVO BoardFree = session.selectOne("BoardFree.select", vo);
		return BoardFree;
	}
}
