package com.mhjg.yose.comm;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptPropertyEncryptor {
	
	public static final String PASSWORD = "yose";
	public static final String ALGORITHM = "PBEWithMD5AndDES";
	public static final String KEY_OBTENTION_ITERATIONS = "1000";
	public static final String POOL_SIZE = "1";
	public static final String SALT_GENERATOR_CLASSNAME = "org.jasypt.salt.RandomSaltGenerator";
	public static final String STRING_OUTPUT_TYPE = "BASE64";
	
	public static void main(String[] args) {
		String username = "kim";
		String password = "lA3@KwQ4LF";
		
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
		SimpleStringPBEConfig config = new SimpleStringPBEConfig(); 
		
		config.setPassword(PASSWORD); 
		config.setAlgorithm(ALGORITHM); 
		config.setKeyObtentionIterations(KEY_OBTENTION_ITERATIONS); 
		config.setPoolSize(POOL_SIZE); 
		config.setSaltGeneratorClassName(SALT_GENERATOR_CLASSNAME); 
		config.setStringOutputType(STRING_OUTPUT_TYPE);
		
		encryptor.setConfig(config); 
		
		StringBuilder sb = new StringBuilder();
		sb.append("spring.yose.datasource.username=ENC(");
		sb.append(encryptor.encrypt(username));
		sb.append(")\n");
		sb.append("spring.yose.datasource.password=ENC(");
		sb.append(encryptor.encrypt(password));
		sb.append(")");
		
		System.out.println(sb.toString());
	}
	
}
