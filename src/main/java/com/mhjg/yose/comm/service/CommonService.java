package com.mhjg.yose.comm.service;

import com.mhjg.yose.comm.vo.CommonVo;

public interface CommonService {
	
	public int insertCommon(CommonVo commonVo) throws Exception;
	
	public CommonVo selectOneCommon(CommonVo commonVo) throws Exception;
	
}
