package yt.cn.log.service;

import java.util.List;
import java.util.Map;

import yn.cn.log.model.BlogModel;
import yt.cn.log.pojo.Blog;
import yt.cn.log.pojo.BlogExample;

public interface BlogService {

	List<Blog> queryGetByNames(Map map);
	
	List<Blog> getCreateTimeDesc();
	
	List<Blog> getFrequencyDesc();
	
	Blog getById(String id);
	void insert(Blog blog);
	void insertBlog(Blog blog);
	List<Blog> getByExamel(String author);

	List<BlogModel> selectByExample(BlogExample example);
	
	List<Blog> getLikeContent(String content);

}
