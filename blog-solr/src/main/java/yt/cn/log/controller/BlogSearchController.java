package yt.cn.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yn.cn.log.model.BlogSearch;
import yt.cn.log.service.BlogSearchService;

@RequestMapping("blog")
@RestController
public class BlogSearchController {

	@Autowired
	private BlogSearchService blogSearchService;
	
	@GetMapping(value="query",produces = MediaType.APPLICATION_JSON_VALUE)
	public String query(@RequestParam("q")String queryString, 
			@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="20")Integer rows){
		BlogSearch blogSearch=null;
		try {
			blogSearch=blogSearchService.search(queryString, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return JSON.toJSON(blogSearch).toString();
		
	}
}
