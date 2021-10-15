package com.spring.user.dao;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import com.spring.user.model.UserVO;

@Repository
public class UserDao {

	private static SqlSessionFactory sqlMapper;
	
	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			String resource = "mybatis-config.xml";
			try {
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	
	
	public void insert(UserVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.insert("User.insertUser", vo);
		session.commit();
	}
	public void update(UserVO vo) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.update("User.udpateUser", vo);
		session.commit();
	}
	public void delete() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		session.delete("User.deleteUser");
		session.commit();
	}
	
	
}
