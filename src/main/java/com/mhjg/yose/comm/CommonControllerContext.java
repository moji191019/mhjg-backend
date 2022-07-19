package com.mhjg.yose.comm;

public class CommonControllerContext {
	
	private static ThreadLocal<CommonControllerContext> storage = new ThreadLocal<>();
	
	private CommonCoreData coreData;
	
	private CommonUserData userData;
	
	public static CommonControllerContext getStorage() {
		return storage.get();
	}
	
	public static void setStorage(CommonControllerContext context) {
		storage.set(context);
	}
	
	public static void clear() {
		if(storage != null) {
			storage.remove();
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
