package yt.cn.log.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yt.cn.log.dao.ForumMapper;
import yt.cn.log.pojo.Forum;
import yt.cn.log.service.ForumService;

@Service
@Transactional
public class ForumServiceImpl implements ForumService {

	@Autowired
	private ForumMapper forumMapper;
	/**
	 * 根据id查询论坛信息
	 */
	@Override
	public Forum getById(String id) {
		
		return forumMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<Forum> queryGetByNames(Map map) {
		return forumMapper.queryGetByNames(map);
	}
	@Override
	public void insertBody(Forum forum) {
		forumMapper.insertBody(forum);
		
	}

}
