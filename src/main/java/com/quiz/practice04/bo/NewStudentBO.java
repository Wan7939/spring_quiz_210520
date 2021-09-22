package com.quiz.practice04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.practice04.dao.NewStudentDAO;
import com.quiz.practice04.model.NewStudent;

@Service
public class NewStudentBO {
	@Autowired
	private NewStudentDAO newStudentDAO;
	
	public void addNewStudent(NewStudent newStudent) {
		newStudentDAO.insertNewStudent(newStudent);
	}

	public NewStudent getNewStudentById(int id) {
		return newStudentDAO.selectNewStudentById(id);
	}
}
