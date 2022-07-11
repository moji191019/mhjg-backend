package com.mhjg.yose.comm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhjg.yose.comm.service.CommService;

@RestController
public class CommController {
	
	@Autowired
	private CommService commService;
	
	@GetMapping(value = {"/test"}, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Map<String, Object> test(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("remoteAddr", request.getRemoteAddr());
		map.put("remoteHost", request.getRemoteHost());
		return map;
	}
	
}
