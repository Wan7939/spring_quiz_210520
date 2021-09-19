package com.quiz.lesson05.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson05.model.weatherHistory;

@Repository
public interface weatherHistoryDAO {
	public List<weatherHistory> selectweatherHistoryList();
}
