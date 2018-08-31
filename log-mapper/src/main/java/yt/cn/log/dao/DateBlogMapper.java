package yt.cn.log.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import yt.cn.log.pojo.DateBlog;

@Mapper
public interface DateBlogMapper {
  List<DateBlog> getDateList();
}