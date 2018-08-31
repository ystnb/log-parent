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

import com.alibaba.fastjson.JSONObject;

import yt.cn.log.common.result.BlogSearchResult;
import yt.cn.log.common.result.Utils;
import yt.cn.log.dao.DateBlogMapper;
import yt.cn.log.dao.DescBlogMapper;
import yt.cn.log.pojo.Blog;
import yt.cn.log.pojo.DateBlog;
import yt.cn.log.pojo.DescBlog;
import yt.cn.log.service.BlogService;
import yt.cn.log.service.SolrFeignClient;

@RequestMapping("blog")
@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private DateBlogMapper dateBlogMapper;
	@Autowired
	private DescBlogMapper descBlogMapper;
	
	@Autowired
	private SolrFeignClient feignClient;
	
	@GetMapping("blog")
	public String blog(Model model,HttpServletRequest request){
		List<DescBlog> descBlogs=descBlogMapper.getDescList();
		List<DateBlog> dateBlogs=dateBlogMapper.getDateList();
		model.addAttribute("descBlogs", descBlogs);
		model.addAttribute("dateBlogs", dateBlogs);
		String solr=null;
		String queryString=request.getParameter("q");
		if(StringUtils.isBlank(queryString)){
			solr=feignClient.blogQuery("*:*");
		}else{
			model.addAttribute("q", queryString);
			solr=feignClient.blogQuery(queryString);
		}
		List<BlogSearchResult> results=null;
		try {
			JSONObject jsonObject=JSONObject.parseObject(solr);
			results=Utils.jsonToList(jsonObject.get("itemList").toString(), BlogSearchResult.class);
		} catch (Exception e) {
			e.printStackTrace();
			return "/little";
		}
		model.addAttribute("results", results);
		return "/little";
	}

	@GetMapping("deial/{id}")
	public String deial(@PathVariable String id,Model model){
		Blog blog=null;
		blog=blogService.getById(id);
		List<DescBlog> descBlogs=descBlogMapper.getDescList();
		List<DateBlog> dateBlogs=dateBlogMapper.getDateList();
		model.addAttribute("descBlogs", descBlogs);
		model.addAttribute("dateBlogs", dateBlogs);
		model.addAttribute("blog", blog);
		return "/litleDeial";
	}
	@GetMapping("userDeial/{author}")
	public String userDeial(@PathVariable String author,Model model){
		List<Blog> blog=blogService.getByExamel(author);
		model.addAttribute("iblog", blog);
		return "/userDeail";
	}

	
	
}
