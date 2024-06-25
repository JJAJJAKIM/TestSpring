package com.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.dto.TempDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ViewDaoImp implements ViewDao {
	
	private final SqlSession session;
	
	public TempDTO test(TempDTO dto) {
		return session.selectOne("sql.findOne", dto);
	}
	
	public List<TempDTO> list(TempDTO dto) { // list 페이지 select문 sql실행(accept 구분하여 출력)
		List<TempDTO> list = session.selectList("sql.findaccept", dto);
		return list;
	}
	public List<TempDTO> listall(TempDTO dto) { // list 페이지 select문 sql실행(리스트 전체 출력)
		List<TempDTO> list = session.selectList("sql.findAll", dto);
		return list;
	}
	public TempDTO add(TempDTO dto) { // new 페이지 데이터 insert문 실행
		session.insert("sql.save",dto);
		return dto;
	}
	public TempDTO findone(TempDTO dto){ // detail 페이지 select문(1개) sql 실행
		return session.selectOne("sql.findOne", dto);
	}
	public TempDTO edit(TempDTO dto) { // detail 페이지 update문(title, content 수정) sql 실행
		session.update("sql.edit", dto);
		return dto;
	}
	public TempDTO accept(TempDTO dto) { // detail 페이지 update문(accept 수정) sql 실행
		session.update("sql.accept", dto);
		return dto;
	}

}
