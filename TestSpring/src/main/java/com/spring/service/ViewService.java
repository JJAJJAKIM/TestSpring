package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.dto.TempDTO;

public interface ViewService {
	
	public void list(Model model, HttpServletRequest req); // list 페이지 화면 출력 (전체, 승인, 미승인 구분하여 출력)
	public TempDTO add(TempDTO dto); // new 페이지 생성 기능
	public boolean findone(Model model,TempDTO dto); // detail 페이지 출력
	public TempDTO edit(TempDTO dto); // 수정 기능
	public TempDTO accept(TempDTO dto); // 승인, 미승인 기능
	
	
}
