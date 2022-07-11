package com.mhjg.yose.comm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
