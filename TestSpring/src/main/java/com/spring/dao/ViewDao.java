package com.spring.dao;

import java.util.List;

import com.spring.dto.TempDTO;

public interface ViewDao {
	
	public TempDTO test(TempDTO dto);
	public List<TempDTO> list(TempDTO dto); // list 페이지 select문 sql실행(승인, 미승인 구분하여 출력)
	public List<TempDTO> listall(TempDTO dto); // list 페이지 select문 sql실행(리스트 전체 출력)
	public TempDTO add(TempDTO dto) ; // new 페이지 데이터 insert문 실행
	public TempDTO findone(TempDTO dto); // detail 페이지 select문(1개) sql 실행
	public TempDTO edit(TempDTO dto); // detail 페이지 update문(title, content 수정) sql 실행
	public TempDTO accept(TempDTO dto); // detail 페이지 update문(accept 수정) sql 실행
}
