package com.mhjg.yose.comm;

public class CommonControllerContextHolder {
	
	private static ThreadLocal<CommonControllerContextHolder> storage = new ThreadLocal<>();
	
	private CommonCoreData coreData;
	
	private CommonUserData userData;
	
	public static CommonControllerContextHolder getStorage() {
		return storage.get();
	}
	
	public static void setStorage(CommonControllerContextHolder context) {
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
