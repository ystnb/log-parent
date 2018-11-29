package yt.cn.log.service;

import java.util.List;
import java.util.Map;

import yt.cn.log.pojo.Forum;

public interface ForumService {
	
	Forum getById(String id);
	List<Forum> queryGetByNames(Map map);
	void insertBody(Forum forum);
	
	List<Forum> getLikeContent(String fcontent);

}
