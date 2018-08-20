package yt.cn.log.service;

import yt.cn.log.model.ForumResult;

public interface ForumSearchService {
	ForumResult search(String queryString,int page, int rows) throws Exception;

}
