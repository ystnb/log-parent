package yt.cn.log.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import yn.cn.log.model.BlogModel;
import yt.cn.log.common.result.ForumRepliesResult;
import yt.cn.log.common.result.Utils;
import yt.cn.log.pojo.Forum;
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
	public String deail(@PathVariable String id,Model model){
		String forumJson="";
		Forum list=null;
		try {
			 list=forumService.getById(id);
			//forumRepliesResult.setForum(forumService.getById(id));
			//forumRepliesResult.setReplies(repliesService.getByFid(id));
		} catch (Exception e) {
			e.printStackTrace();
			return "forumDeail";
		}
	//	forumJson=JSON.toJSON(forumRepliesResult).toString();
		model.addAttribute("forum",list);
		return "forumDeail";
	}
	
	@GetMapping("forum")
	public String forum(Model model,HttpServletRequest request){
		String query=request.getParameter("q");
		String forumSolr="";
		List<Forum> list=null;
		if(StringUtils.isBlank(query)){
			 forumSolr=feignClient.forumQuery("*:*");
		}else{
			forumSolr=feignClient.forumQuery(query);
		}
		try {
			list=Utils.jsonToList(forumSolr, Forum.class);
			model.addAttribute("listForum",list);
		} catch (Exception e) {
			return "forum";
		}
		model.addAttribute("q",query);
		return "forum";
	}
}
