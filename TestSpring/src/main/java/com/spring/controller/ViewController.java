package com.spring.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.spring.dto.TempDTO;
import com.spring.service.ViewService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewController {
	
	private final ViewService viewService;
	
	
	/********************             list 페이지 화면  처리              **********************/
	@GetMapping("/list")
	public String listpage(Model model, HttpServletRequest req) {
		viewService.list(model, req);
		return "list";
	}
	/***************************************************************************************/
	
	/**********************             new페이지 화면 처리             ************************/
	@GetMapping("/new")
	public String newpage() {
		return "new";
	}
	/***************************************************************************************/
	
	/*************             new페이지에서 생성버튼 클릭시 insert 처리              ***************/
	@PostMapping("/insert")
	public String insertpage(@ModelAttribute TempDTO dto) throws IOException {
		
		dto = viewService.add(dto);
		if(dto != null ) {
			return "redirect:/detail?no="+dto.getNo();
		}else {
			return "redirect:/new";
		}
	}
	/***************************************************************************************/
	
	/********************             detail페이지 화면  처리              **********************/
	@GetMapping("/detail")
	public String detailpage(Model model, @ModelAttribute TempDTO dto) {
		if(viewService.findone(model, dto)){
			return "detail";			
		} else {
			return "redirect:/list";
		}
	}
	/***************************************************************************************/
	
	/*******************             detail페이지에서 수정 처리              *********************/
	@PostMapping("/edit")
	public String edit(@ModelAttribute TempDTO dto) throws IOException{
		dto = viewService.edit(dto);
		if(dto != null) {
			return "redirect:/detail?no="+dto.getNo();
		}else {
			return "redirect:/new";
		}
	}
	/***************************************************************************************/
	
	/********************             detail페이지에서 승인 처리             * *******************/
	@GetMapping("/accept")
	public String accept(@ModelAttribute TempDTO dto) throws IOException{										
		dto = viewService.accept(dto);									
		if(dto != null) {												
			return "redirect:/list";
		}else {
			return "redirect:/detail?no="+dto.getNo();
		}
	}
	/**************************************************************************************/
	
}
