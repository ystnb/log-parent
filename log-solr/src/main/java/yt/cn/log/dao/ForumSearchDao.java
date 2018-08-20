package yt.cn.log.dao;

import org.apache.solr.client.solrj.SolrQuery;

import yt.cn.log.model.ForumResult;

public interface ForumSearchDao {
	ForumResult search(SolrQuery solrQuery) throws Exception;

}
