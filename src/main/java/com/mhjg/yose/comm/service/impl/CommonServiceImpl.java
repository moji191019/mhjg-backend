package com.mhjg.yose.comm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhjg.yose.comm.dao.CommonDao;
import com.mhjg.yose.comm.service.CommonService;
import com.mhjg.yose.comm.vo.CommonVo;

@Service
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private CommonDao commonDao;
	
	@Override
	public int insertCommon(CommonVo commonVo) throws Exception {
		return commonDao.insertCommon(commonVo);
	}

	@Override
	public CommonVo selectOneCommon(CommonVo commonVo) throws Exception {
		return commonDao.selectOneCommon(commonVo);
	}

}
