package com.quiz.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Quiz05Controller {
	//weatherHistory
	@RequestMapping("/1")
	public String quiz05() {
		
		return "lesson05/quiz05";
	}

}
