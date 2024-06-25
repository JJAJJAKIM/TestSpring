package com.spring.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private SqlSession session;

	@GetMapping("/testAPI")
	public int test() {
		return session.selectOne("sql.test");
	}
	
}
