package com.mhjg.yose.comm.dao;

import org.springframework.stereotype.Repository;

import com.mhjg.yose.comm.MariadbDaoSession;
import com.mhjg.yose.comm.vo.CommonVo;

@Repository
public class CommonDao extends MariadbDaoSession {
	
	public int insertCommon(CommonVo commonVo) throws Exception {
		return insert("com.mhjg.yose.comm.insertCommon", commonVo);
	}
	
}
