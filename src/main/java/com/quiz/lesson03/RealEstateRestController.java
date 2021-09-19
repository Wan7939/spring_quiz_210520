package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RestController
public class RealEstateRestController {
	
	@Autowired
	private RealEstateBO realEstateBo;
	
	@RequestMapping("/lesson03/quiz01")
	public RealEstate quiz01(
			@RequestParam(value="id", defaultValue="1") int id 
//			@RequestParam(value="rentPrice", defaultValue="90") int rentPrice //월세 조건 select
			) {
		
		RealEstate realEstate = realEstateBo.getRealEstateById(id);
//		RealEstate realEstate = realEstateBo.getRealEstateById(rentPrice);
		return realEstate;
	}
		@RequestMapping("/lesson03/quiz01/2")
		public List<RealEstate> quiz01_2(
				@RequestParam("rentPrice") int rentPrice) {
				List<RealEstate> realEstateList = realEstateBo.getRealEstateListByRentPrice(rentPrice) ;
				return realEstateList;
		}
		@RequestMapping("/lesson03/quiz01/3")
		public List<RealEstate> quiz01_3(
				@RequestParam(value = "area", required=true) int area,
				@RequestParam(value = "price") int price){
			
			List<RealEstate> realEstateList = realEstateBo.getRealEstateListByAreaAndPrice(area, price);
			return realEstateList;
			
		}
}
		
		
