package com.quiz.practice04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.practice04.bo.NewStudentBO;
import com.quiz.practice04.model.NewStudent;

@RequestMapping("/practice04")
@Controller

public class NewStudentController {
	
	@Autowired
	private NewStudentBO newStudentBO;
	
	// 요청 URL: http://localhost/practice04/ex02/1
	@GetMapping("/ex02/1")
	public String addStudentView() {
		return "practice04/addStudent";
		
	}
	// 요청 URL: http://localhost/practice04/ex02/add_student
	@PostMapping("/ex02/add_student")
	public String addStudent(
			@ModelAttribute NewStudent newStudent, // name 태그 값과 일치하는 필드에 값이 들어간다.
			Model model) {
		// insert DB
		
		newStudentBO.addNewStudent(newStudent);
		
		// select DB
		newStudent = newStudentBO.getNewStudentById(newStudent.getId());
		model.addAttribute("result", newStudent);
		model.addAttribute("subject", "학생 정보");
		
		return "practice04/afterAddStudent"; // 추가된 학생 정보를 나타내는 jsp
	}
		
		
}
