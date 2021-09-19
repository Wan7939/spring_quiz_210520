package com.quiz.practice01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice02Controller {
	
	// 요청 URL : http://localhost/practice01/ex02/1
	@RequestMapping("/practice01/ex02/1")
	public String view() {
		// ResponseBody가 아닌 상태로 String를 리턴하면
		// ViewResolver에 의해, 리턴된 String 이름의 view를 찾고 view화면이 구성된다
		return"practice01/ex02";
	}
	
}
