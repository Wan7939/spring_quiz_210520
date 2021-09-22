package com.quiz.practice04.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.model.Realtor;

@Repository
public interface Realtor2DAO {
	
	public void insertRealtor(Realtor realtor);
	
	public Realtor selectRealtorById(int id);
}
