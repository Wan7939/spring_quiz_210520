package com.quiz.practice03.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.practice03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(@Param("id") int id); // 특정 id에 해당하는 row가져오기
	
	
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			@Param("storeId") int storeId, 
			@Param("menu") String menu, 
			@Param("userName") String userName, 
			@Param("point") double point, 
			@Param("review") String review);  // 여러 파라미터들을 row로 추가
	
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
}
