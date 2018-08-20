package yt.cn.log.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yt.cn.log.pojo.Blog;
import yt.cn.log.pojo.Forum;
import yt.cn.log.pojo.Replies;
import yt.cn.log.service.BlogService;
import yt.cn.log.service.ForumService;
import yt.cn.log.service.RepliesService;

/**
 * 论坛评论
 * @author yuanst
 *
 */
@RequestMapping("replies")
@RestController
public class RepliesController {
	
	@Autowired
	private RepliesService repliesService;
	@Autowired
	private BlogService blogService;

	@Autowired
	private ForumService forumService;
	
	/**
	 * 回复帖子
	 * @param rContent
	 * @param fid
	 * @return
	 */
	@PostMapping("addReplies")
	public String addReplies(@RequestParam("rContent")String rContent,@RequestParam("fid")String fid,@RequestParam("author")String author){
		Replies replies=new Replies();
		replies.setId(UUID.randomUUID().toString());
		replies.setCreateTime(new Date());
		replies.setrContent(rContent);
		replies.setfId(fid);
		replies.setAuthor(author);
		try {
			repliesService.insert(replies);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "ok";
	}
	/**
	 * 添加博客
	 * @param blog
	 * @return
	 */
	@PostMapping("addblog")
	public String addblog(@RequestBody Blog blog){
		blog.setId(UUID.randomUUID().toString());
		blog.setCreateTime(new Date());
		try {
			blogService.insertBlog(blog);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "ok";
		
	}
	/**
	 * 发表帖子
	 * @param forum
	 * @return
	 */
	@PostMapping("addForum")
	public String addForum(@RequestBody Forum forum){
		forum.setId(UUID.randomUUID().toString());
		forum.setCreateTime(new Date());
		try {
			forumService.insertBody(forum);
		} catch (Exception e) {
			return "添加失败请重试";
		}
		return "ok";
	}

	
}
