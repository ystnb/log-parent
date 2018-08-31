package yt.cn.log.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;

import yt.cn.log.pojo.Blog;
import yt.cn.log.pojo.Forum;
import yt.cn.log.pojo.Replies;
import yt.cn.log.service.BlogService;
import yt.cn.log.service.ForumService;
import yt.cn.log.service.KafKaFeignClient;
import yt.cn.log.service.RepliesService;

/**
 * 论坛评论
 * @author yuanst
 *
 */
@RequestMapping("replies")
@Controller
public class RepliesController {
	
	@Autowired
	private RepliesService repliesService;
	@Autowired
	private BlogService blogService;

	@Autowired
	private ForumService forumService;
	
	@Autowired
	private KafKaFeignClient kaFeignClient;
	
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
	 * 进入添加博客
	 * @param blog
	 * @return
	 */
	@GetMapping("addBlog")
	public String addBlog(){
		return "/addBlog";
	}
	@GetMapping("addforum")
	public String addforum(){
		return "/addForum";
	}
	/**
	 * 添加博客
	 * @param blog
	 * @return
	 */
	@PostMapping("saveBlog")
	public String saveBlog(@ModelAttribute Blog blog){
		
		blog.setId(UUID.randomUUID().toString());
		blog.setCreateTime(new Date());
		try {
			blogService.insertBlog(blog);
			kaFeignClient.blogKafka(JSONObject.toJSONString(blog));
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/replies/addBlog";
		}
		return "redirect:/blog/blog";
		
	}
	/**
	 * 发表帖子
	 * @param forum
	 * @return
	 */
	@PostMapping("saveForum")
	public String addForum(@ModelAttribute Forum forum){
		forum.setId(UUID.randomUUID().toString());
		forum.setCreateTime(new Date());
		try {
			forumService.insertBody(forum);
			kaFeignClient.forumKafka(JSONObject.toJSONString(forum));
		} catch (Exception e) {
			return "redirect:/replies/addForum";
		}
		return "redirect:/forum/forum";
	}
	

	
}
