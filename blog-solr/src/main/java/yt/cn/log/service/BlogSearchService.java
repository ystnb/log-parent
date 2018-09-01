package yt.cn.log.service;

import yn.cn.log.model.BlogSearch;

public interface BlogSearchService {
	BlogSearch search(String queryString, int page, int rows) throws Exception;

}
