package yt.cn.log.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yt.cn.log.pojo.Blog;
import yt.cn.log.service.BlogService;



@RequestMapping("blog")
@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@GetMapping("search")
	public String search(){
		Map map =new HashMap();
		List<Blog>  list=blogService.queryGetByNames(map);
		return JSON.toJSON(list).toString();
	}
	@GetMapping("dateDesc")
	public String dateDesc(){
		List<Blog>  list=blogService.getCreateTimeDesc();
		return JSON.toJSON(list).toString();
	}
	@GetMapping("rate")
	public String rate(){
		List<Blog>  list=blogService.getFrequencyDesc();
		return JSON.toJSON(list).toString();
	}
	@GetMapping("deial/{id}")
	public String deial(@PathVariable String id){
		Blog blog=null;
		blog=blogService.getById(id);
		return JSON.toJSON(blog).toString();
	}
	@GetMapping("userDeial/{author}")
	public String userDeial(@PathVariable String author){
		List<Blog> blog=blogService.getByExamel(author);
		return JSON.toJSON(blog).toString();
	}

	
	
}
