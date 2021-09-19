package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.BO.FavoriteBO;
import com.quiz.lesson06.model.Favorite;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lseeon06Quiz01Controller {
	
	@Autowired
	private FavoriteBO favoriteBO;
	
	@RequestMapping("/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/addFavorite";
	}
	
	// submit : @Controller -> view 리턴
	// ajax: @Controller + @ResponseBody -> String, JSON (데이터만 보낸다) 
	
	@ResponseBody
	@PostMapping("/add_favorite")
	public Map<String, String> addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// DB INSERT
		favoriteBO.addFavorite(name, url);
		
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
	
	@RequestMapping("/favorite_list")
	public String favoriteList(Model model) {
		// DB에서 즐겨찾기 목록을 SELECT
		
		List<Favorite> favoriteList = favoriteBO.getFavoriteList();
		// model 객체에 세팅한다.
		model.addAttribute("favoriteList", favoriteList);
		
		return"lesson06/favoriteList";
	}
	
	@PostMapping("/check_duplication_url")
	@ResponseBody
	public Map<String, Boolean> checkDuplicationUrl(
			@RequestParam("url") String url){
		
		// url DB 조회 중복 체크
		Favorite favorite = favoriteBO.getFavoriteByUrl(url);
		
		// 결과 map 구성
		Map<String, Boolean> result = new HashMap<>();
		result.put("isDuplication", false);
		
		if (favorite != null) {
			result.put("isDuplication", true);
		}
		
		return result;
	}
	
	@PostMapping("/delete_favorite")
	@ResponseBody
	public Map<String, String> deleteFavorite(
			@RequestParam("favorite_id") int id){
		
		// DB delte - id
		
		int deletedRow = favoriteBO.deleteFavoriteById(id);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		if (deletedRow == 0) {
			result.put("result", "success");
		}
		
		return result;
	}
}
