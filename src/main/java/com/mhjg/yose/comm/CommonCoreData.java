package com.mhjg.yose.comm;

public class CommonCoreData {
	
	private String result;
	
	private String core;
	
	private String message;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CommonCoreData [result=" + result + ", core=" + core + ", message=" + message + "]";
	}
	
}
