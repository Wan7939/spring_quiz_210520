package com.quiz.practice04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.practice04.dao.NewUserDAO;
import com.quiz.practice04.model.NewUser;

@Service
public class NewUserBO {
	
	@Autowired
	private NewUserDAO newUserDAO;
	
	public void  addUser(String name, String yyyymmdd, String introduce, String email) {
		newUserDAO.insertNewUser(name, yyyymmdd, introduce, email);
	}
	
	public NewUser getLastUser() {
		return newUserDAO.selectLastNewUser();
	}
}
