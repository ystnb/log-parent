package yt.cn.log.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import yt.cn.log.pojo.Blog;
import yt.cn.log.pojo.BlogExample;
import yt.cn.log.pojo.DescBlog;

@Mapper
public interface DescBlogMapper {
   List<DescBlog> getDescList();
}