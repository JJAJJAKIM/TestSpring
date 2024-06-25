package com.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring.dao.ViewDao;
import com.spring.dto.TempDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ViewServiceImp implements ViewService {

	private final ViewDao viewDao;

	
	public void list(Model model, HttpServletRequest req) { // list 페이지 화면 출력(accept 구분)
			
		if("true".equals(req.getParameter("accept"))){				// 승인된 데이터만 출력
			TempDTO dto = TempDTO.builder()	
					.accept(true)
					.build();
			model.addAttribute("list", viewDao.list(dto));	
		} else if ("false".equals(req.getParameter("accept"))) {	// 미승인된 데이터만 출력
			TempDTO dto = TempDTO.builder()	
					.accept(false)
					.build();
			model.addAttribute("list", viewDao.list(dto));
		} else {													// 전부 다 출력
			TempDTO dto = TempDTO.builder()
					.no(1)
					.build();
			model.addAttribute("list", viewDao.listall(dto));
		}
	}
	
	public TempDTO add(TempDTO dto) { // new 페이지 생성 기능
		return viewDao.add(dto);
	}
	
	public boolean findone(Model model, TempDTO dto) { // detail 페이지 출력
		try {
			model.addAttribute("list", viewDao.findone(dto));
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public TempDTO edit(TempDTO dto) { // 수정 기능
		try {
			return viewDao.edit(dto);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	public TempDTO accept(TempDTO dto) { // 승인, 미승인 기능
		try {
			return viewDao.accept(dto);	
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
