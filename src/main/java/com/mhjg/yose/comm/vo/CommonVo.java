package com.mhjg.yose.comm.vo;

import com.mhjg.yose.comm.CommonDefaultVo;

public class CommonVo extends CommonDefaultVo {
	
	private String username;
	
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "CommonVo [username=" + username + ", password=" + password + "]";
	}
	
}
