package com.quiz.practice02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.practice02.BO.UsedGoodsBO;
import com.quiz.practice02.model.UsedGoods;

@RestController
public class UsedGoodsRestController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;
	
	// 요청 URL : http://localhost/practice02/ex01
	@RequestMapping("/practice02/ex01")
	public List<UsedGoods> ex01(){
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList;
	}
}
