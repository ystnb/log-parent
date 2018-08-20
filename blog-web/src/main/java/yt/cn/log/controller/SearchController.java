package yt.cn.log.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yt.cn.log.service.SolrFeignClient;

@RequestMapping("search")
@RestController
public class SearchController {
	
	@Autowired
	private SolrFeignClient feignClient;
	
	@GetMapping("fourm")
	public String fourm(@RequestParam("q")String q){
		String json=feignClient.forumQuery(q);
		return json;
	}
	@GetMapping("blog")
	public String blog(@RequestParam("q")String q){
		String json=feignClient.blogQuery(q);
		return json;
	}

}
