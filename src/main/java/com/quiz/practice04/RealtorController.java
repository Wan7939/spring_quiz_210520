package com.quiz.practice04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

@RequestMapping("/practice04")
@Controller
public class RealtorController {
	
	@Autowired
	private RealtorBO realtorBO;
	
	// 요청 URL: http://localhost/practice04/quiz01/1
	@GetMapping("/quiz01/1")
	public String addRealtorView() {
		return "practice04/addRealtor";
	}
	
	// 요청 URL: http://localhost/practice04/quiz01/add_realtor
	@PostMapping("/quiz01/add_realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		
		/// insert DB
		realtorBO.addRealtor(realtor);
		
		/// select DB
		realtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("result", realtor);
		model.addAttribute("subject", "매물 정보");
		
		return "practice04/afterAddRealtor";
	}
}
