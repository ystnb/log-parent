package yt.cn.log.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yn.cn.log.model.BlogModel;
import yt.cn.log.dao.BlogMapper;
import yt.cn.log.pojo.Blog;
import yt.cn.log.pojo.BlogExample;
import yt.cn.log.pojo.BlogExample.Criteria;
import yt.cn.log.service.BlogService;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogMapper blogMapper;

	@Override
	public List<Blog> queryGetByNames(Map map) {
		List<Blog> list=blogMapper.queryGetByNames(map);
		if(list.size()>0){
			return list;
		}
		return null;
	}
	/**
	 * 查询最新5条博客
	 */
	@Override
	public List<Blog> getCreateTimeDesc() {
		return blogMapper.getCreateTimeDesc();
	}
	/**
	 * 查询点击最多的5条博客
	 */
	@Override
	public List<Blog> getFrequencyDesc() {
		return blogMapper.getFrequencyDesc();
	}
	@Override
	public Blog getById(String id) {
		return blogMapper.selectByPrimaryKey(id);
	}
	@Override
	public void insert(Blog blog) {
		blogMapper.insert(blog);
		
	}
	@Override
	public void insertBlog(Blog blog) {
		blogMapper.insertBlog(blog);
		
	}
	@Override
	public List<Blog> getByExamel(String author) {
		BlogExample blogExample=new BlogExample();
		Criteria criteria=blogExample.createCriteria();
		criteria.andAuthorEqualTo(author);
		List<Blog> list=blogMapper.selectByExample(blogExample);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	public List<BlogModel> selectByExample(BlogExample example){
		List<Blog> list = blogMapper.selectByExample(example);
		return list.stream().map(this::convert).collect(Collectors.toList());
	}

	private BlogModel convert(Blog blog){
		BlogModel blogModel = new BlogModel();
		BeanUtils.copyProperties(blog,new BlogModel());
		return blogModel;
	}

}
