package com.quiz.lesson05.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson05.dao.weatherHistoryDAO;
import com.quiz.lesson05.model.weatherHistory;

@Service
public class weatherHistoryBO {
	
	@Autowired
	private weatherHistoryDAO weatherHistoryDAO;
	
	public List<weatherHistory> selectweatherHistoryList() {
		return weatherHistoryDAO.selectweatherHistoryList();
	}
}
