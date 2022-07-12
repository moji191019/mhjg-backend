package com.mhjg.yose.db.session;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mhjg.yose.comm.CommonDefaultDaoSupportor;

public class MariadbDaoSession extends CommonDefaultDaoSupportor {

	@Override
	@Autowired
	@Qualifier("yoseSqlSessionFactory")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
}
