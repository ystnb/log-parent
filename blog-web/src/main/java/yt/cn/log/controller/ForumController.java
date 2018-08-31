package yt.cn.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import yt.cn.log.common.result.ForumRepliesResult;
import yt.cn.log.service.ForumService;
import yt.cn.log.service.RepliesService;
import yt.cn.log.service.SolrFeignClient;

@RequestMapping("forum")
@Controller
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private RepliesService repliesService;
	
	@Autowired
	private SolrFeignClient feignClient;
	
	@GetMapping("deail/{id}")
	public String deail(@PathVariable String id){
		String forumJson="";
		ForumRepliesResult forumRepliesResult=new ForumRepliesResult();
		try {
			forumRepliesResult.setForum(forumService.getById(id));
			forumRepliesResult.setReplies(repliesService.getByFid(id));
		} catch (Exception e) {
			e.printStackTrace();
			return forumJson;
		}
		forumJson=JSON.toJSON(forumRepliesResult).toString();
		return forumJson;
	}
	
	@GetMapping("forum")
	public String forum(Model model){
		String forumSolr=feignClient.forumQuery("*:*");
		System.out.println(forumSolr);
		return "/forum";
	}
}
