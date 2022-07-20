package com.mhjg.yose.comm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.mhjg.yose.comm.CommonControllerContextHolder;
import com.mhjg.yose.comm.CommonCoreData;

public class CommonContextInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("CommonContextInterceptor preHandle executed...");
		
		CommonControllerContextHolder context = new CommonControllerContextHolder();
		CommonCoreData coreData = new CommonCoreData();
		context.setCoreData(coreData);
		
		CommonControllerContextHolder.setHolder(context);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("CommonContextInterceptor postHandle executed...");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
}
