package com.developer.forum.article.dao;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.developer.forum.article.model.ArticleVO;

@Repository
public class ArticleDAO {
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
	
	public void insert(ArticleVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("user.insert",vo);
		session.commit();
	}
	
	public void update(ArticleVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("user.update", vo);
		session.commit();
	}
	
	public void delete(ArticleVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("user.delete", vo);
		session.commit();
	}
	
	public ArticleVO select(ArticleVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		ArticleVO user = session.selectOne("user.select", vo);
		return user;
	}
}
