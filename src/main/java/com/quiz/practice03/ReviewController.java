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
	// 요청 URL : http://localhost/practice03/ex02
	@RequestMapping("/practice03/ex02")
	public String ex02() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("오겹2인세트");
		review.setUserName("박경완");
		review.setPoint(2.5);
		review.setReview("둘이 먹기에는 좀 적네요");
		
		int row = reviewBO.insertReview(review);
		return "success row count:" + row;
	}
	
	// 요청 URL : http://localhost/practice03/ex03
		@RequestMapping("/practice03/ex03")
		public String ex03(
				@RequestParam(value = "id") int id,
				@RequestParam(value = "review") String review) {
			
			int row = reviewBO.updateReviewById(id, review);
			return "변경 완료 : " + row ;
		}
	
}
