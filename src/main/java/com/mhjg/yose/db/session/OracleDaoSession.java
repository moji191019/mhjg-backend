package com.mhjg.yose.db.session;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mhjg.yose.comm.DefaultDaoSupportor;

public class OracleDaoSession extends DefaultDaoSupportor {

	@Override
	@Autowired
	@Qualifier("oracleSqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
}
