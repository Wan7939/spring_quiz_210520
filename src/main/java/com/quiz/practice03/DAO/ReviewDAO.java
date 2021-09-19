package com.quiz.practice03.DAO;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.practice03.model.Review;

@Repository
public interface ReviewDAO {
	public Review selectReview(@Param("id") int id); // 특정 id에 해당하는 row가져오기
	
}
