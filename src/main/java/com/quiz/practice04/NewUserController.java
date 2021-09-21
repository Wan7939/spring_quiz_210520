package com.quiz.practice04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.practice04.bo.NewUserBO;

@RequestMapping("/practice04")
@Controller

public class NewUserController {
	
	@Autowired
	
	private NewUserBO newUserBO;
	
	// 요청 URL: http://localhost/practice04/ex01/1
	@RequestMapping(method = RequestMethod.GET, path = "/ex01/1")
	public String addUserView() {
		return "practice04/addUser";   // addUser.jsp를 보여주기 위한 로직 view 경로
	}
	
	// 요청 URL: http://localhost/practice04/ex01/add_user
	@PostMapping("/ex01/add_user")
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam(value = "introduce", required=false) String introduce,
			@RequestParam("email") String email	) {
			
			// DB insert 화이팅!
			newUserBO.addUser(name, yyyymmdd, introduce, email);
		
		return "practice04/afterAddUser"; // 결과 jsp
			
	}
}
