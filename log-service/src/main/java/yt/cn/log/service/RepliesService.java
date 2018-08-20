package yt.cn.log.service;

import java.util.List;

import yt.cn.log.pojo.Replies;

public interface RepliesService {
	
	List<Replies> getByFid(String fId);
	int insert(Replies replies);

}
