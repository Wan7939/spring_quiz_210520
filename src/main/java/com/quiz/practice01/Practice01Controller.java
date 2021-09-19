package com.quiz.practice01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/practice01/ex01")  
@Controller

public class Practice01Controller {
	
	// 요청 URL : http://localhost/practice01/ex01/1
	@ResponseBody // 리턴되는 값을 HTML Response로 보낸다
	@RequestMapping("/1")
	public String pringString() {
		String text = "이 문자열을 <br> respons body로 <br> 보내보자";
		return text;
	}
	
	// 요청 URL : http://localhost/practice01/ex01/2
	
	@RequestMapping("/2")
	public @ResponseBody Map<String, Object> printMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 54);
		map.put("orange", 4324);
		map.put("lemon", 56);
		
		// map을 리턴하면 json으로 나타난다. web stater에 jackson 이라는 라이브러리가 포함 되어있기 때문
		
		return map;
	}
}




