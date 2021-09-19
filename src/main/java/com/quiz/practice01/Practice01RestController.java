package com.quiz.practice01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/practice01/ex01")
@RestController  // @Controller + @ResponseBody
public class Practice01RestController {
	
	// 요청 URL : http://localhost/practice01/ex01/3
	@RequestMapping("/3")
	public String pringString() {
		return "@RestController를 사용해 String를 리턴해보자";
	}

	// 요청 URL : http://localhost/practice01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap(){
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		
		return map;   // map을 리턴 하니까 json!!
	}
	
	// 요청 URL : http://localhost/practice01/ex01/5
		@RequestMapping("/5")
		public Data printData() {
			Data data = new Data();
			data.setId(1);
			data.setName("박경완");
			return data;
		
			
		}
		
		// 요청 URL : http://localhost/practice01/ex01/6
				@RequestMapping("/6")
				public ResponseEntity<Data> entity(){
					Data data = new Data();
					data.setId(1);
					data.setName("박경완");
					
					return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
					
				}
	
}
