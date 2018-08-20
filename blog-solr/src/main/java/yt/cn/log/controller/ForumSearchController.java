package yt.cn.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yt.cn.log.model.ForumResult;
import yt.cn.log.service.ForumSearchService;

@RequestMapping("forum")
@RestController
public class ForumSearchController {

	@Autowired
	private ForumSearchService forumSearchService;
	
	@GetMapping("query")
	public String query(@RequestParam("q")String queryString, 
			@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="20")Integer rows){
		String json="";
		try {
			ForumResult result=forumSearchService.search(queryString, page, rows);
			json=JSON.toJSON(result).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return json;
		}
		return json;
	}
}
