package yt.cn.log.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yt.cn.log.common.result.ForumRepliesResult;
import yt.cn.log.pojo.Forum;
import yt.cn.log.service.ForumService;
import yt.cn.log.service.RepliesService;

@RequestMapping("forum")
@RestController
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	@Autowired
	private RepliesService repliesService;
	
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
	
}
