package com.mhjg.yose.comm.dao;

import org.springframework.stereotype.Repository;

import com.mhjg.yose.comm.vo.CommonVo;
import com.mhjg.yose.db.session.MariadbDaoSession;

@Repository
public class CommonDao extends MariadbDaoSession {
	
	public int insertCommon(CommonVo commonVo) throws Exception {
		return insert("com.mhjg.yose.comm.insertCommon", commonVo);
	}
	
	public CommonVo selectOneCommon(CommonVo commonVo)throws Exception {
		return (CommonVo) selectOne("com.mhjg.yose.comm.selectOneCommon", commonVo);
	}
	
}
