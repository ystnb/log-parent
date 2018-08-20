package yt.cn.log.service;

import yt.cn.log.model.BlogSearch;

public interface BlogSearchService {
	BlogSearch search(String queryString, int page, int rows) throws Exception;

}
