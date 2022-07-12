package com.mhjg.yose.comm;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CommonDefaultDaoSupportor extends SqlSessionDaoSupport {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	protected int insert(String statement) {
		return super.getSqlSession().insert(statement);
	}
	
	protected int insert(String statement, Object parameter) {
		return super.getSqlSession().insert(statement, parameter);
	}
	
	protected int update(String statement) {
		return super.getSqlSession().update(statement);
	}
	
	protected int update(String statement, Object parameter) {
		return super.getSqlSession().update(statement, parameter);
	}
	
	protected int delete(String statement) {
		return super.getSqlSession().delete(statement);
	}
	
	protected int delete(String statement, Object parameter) {
		return super.getSqlSession().delete(statement, parameter);
	}
	
	protected Object selectOne(String statement) {
		return super.getSqlSession().selectOne(statement);
	}
	
	protected Object selectOne(String statement, Object parameter) {
		return super.getSqlSession().selectOne(statement, parameter);
	}
	
	protected List<Object> selectList(String statement) {
		return super.getSqlSession().selectList(statement);
	}
	
	protected List<Object> selectList(String statement, Object parameter) {
		return super.getSqlSession().selectList(statement, parameter);
	}
	
}
