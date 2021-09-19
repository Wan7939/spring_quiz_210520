package com.quiz.practice02.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.practice02.model.UsedGoods;

@Repository
public interface UsedGoodsDAO {
	
	public List<UsedGoods> selectUsedGoodsList();
}
