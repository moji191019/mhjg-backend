package com.mhjg.yose.comm;

public class CommonControllerContextHolder {
	
	private static ThreadLocal<CommonControllerContextHolder> holder = new ThreadLocal<>();
	
	private CommonCoreData coreData;
	
	private CommonUserData userData;
	
	public static CommonControllerContextHolder getHolder() {
		return holder.get();
	}
	
	public static void setHolder(CommonControllerContextHolder context) {
		holder.set(context);
	}
	
	public static void clear() {
		if(holder != null) {
			holder.remove();
		}
	}
	
	public CommonCoreData getCoreData() {
		return coreData;
	}
	
	public void setCoreData(CommonCoreData coreData) {
		this.coreData = coreData;
	}
	
	public CommonUserData getUserData() {
		return userData;
	}
	
	public void setUserData(CommonUserData userData) {
		this.userData = userData;
	}
	
}
