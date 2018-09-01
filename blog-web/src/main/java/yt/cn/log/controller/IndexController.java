package yt.cn.log.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.alibaba.fastjson.JSONObject;

import yn.cn.log.model.BlogModel;
import yt.cn.log.common.result.Utils;
import yt.cn.log.dao.DateBlogMapper;
import yt.cn.log.dao.DescBlogMapper;
import yt.cn.log.pojo.DateBlog;
import yt.cn.log.pojo.DescBlog;
import yt.cn.log.service.BlogService;
import yt.cn.log.service.SolrFeignClient;

@Controller
public class IndexController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private DateBlogMapper dateBlogMapper;
	@Autowired
	private DescBlogMapper descBlogMapper;
	@Autowired
	private SolrFeignClient feignClient;
	
	@GetMapping("/")
	public String index(Model model){
		List<DescBlog> descBlogs=descBlogMapper.getDescList();
		List<DateBlog> dateBlogs=dateBlogMapper.getDateList();
		model.addAttribute("descBlogs", descBlogs);
		model.addAttribute("dateBlogs", dateBlogs);
		String solr=feignClient.blogQuery("*:*");
		List<BlogModel> results=null;
		try {
			JSONObject jsonObject=JSONObject.parseObject(solr);
			results=Utils.jsonToList(jsonObject.get("itemList").toString(), BlogModel.class);
		} catch (Exception e) {
			e.printStackTrace();
			return "/index";
		}
		model.addAttribute("results", results);
		return "/index";
	}
}
