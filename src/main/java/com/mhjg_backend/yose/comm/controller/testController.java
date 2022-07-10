package com.mhjg_backend.yose.comm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
