package com.quiz.practice03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.practice03.BO.ReviewBO;
import com.quiz.practice03.model.Review;

@RestController
public class ReviewController {

	@Autowired
	private ReviewBO reviewBO;
	// 요청 URL : http://localhost/practice03/ex01
	
	@RequestMapping("/practice03/ex01")
	public Review ex01(
			@RequestParam(value="id", defaultValue="1") int id 
			){
		System.out.println("### id:" + id);
		return reviewBO.getReview(id);
		
	}
	
	
}
