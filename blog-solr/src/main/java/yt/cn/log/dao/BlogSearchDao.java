package yt.cn.log.dao;

import org.apache.solr.client.solrj.SolrQuery;
import yn.cn.log.model.BlogSearch;

public interface BlogSearchDao {
	BlogSearch search(SolrQuery query) throws Exception;

}
