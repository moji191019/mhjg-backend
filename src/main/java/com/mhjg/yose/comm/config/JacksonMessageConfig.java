package com.mhjg.yose.comm.config;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.mhjg.yose.comm.CommonControllerContextHolder;
import com.mhjg.yose.comm.CommonCoreData;

@Configuration
public class JacksonMessageConfig extends MappingJackson2HttpMessageConverter {
	
	public static final String CORE_DATA = "coreData";
	public static final String USER_DATA = "userData";
	public static final String MHJG_DATA = "mhjgData";
	
	@Override
	protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		
		Map<String, Object> outputMap = new HashMap<>();
		
		CommonCoreData coreData = CommonControllerContextHolder.getHolder().getCoreData();
		coreData.setResult("0");
		
		outputMap.put(CORE_DATA, coreData);
		outputMap.put(MHJG_DATA, object);
		
		super.writeInternal(outputMap, type, outputMessage);
	}
	
}
