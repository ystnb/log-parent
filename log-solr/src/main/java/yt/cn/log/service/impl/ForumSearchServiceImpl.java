package yt.cn.log.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yt.cn.log.dao.ForumSearchDao;
import yt.cn.log.model.BlogSearch;
import yt.cn.log.model.ForumResult;
import yt.cn.log.service.ForumSearchService;

@Service
public class ForumSearchServiceImpl implements ForumSearchService{
	
	@Autowired
	private ForumSearchDao forumSearchDao;

	@Override
	public ForumResult search(String queryString, int page, int rows) throws Exception {
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(queryString);
		//设置分页
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		//设置默认搜素域
		query.set("df", "f_keywords");
		
		//执行查询
		ForumResult forumResult = forumSearchDao.search(query);
		//计算查询结果总页数
		long recordCount = forumResult.getRecordCount();
		long pageCount = recordCount / rows;
		if (recordCount % rows > 0) {
			pageCount++;
		}
		forumResult.setPageCount(pageCount);
		forumResult.setCurPage(page);
		return forumResult;
	}


}
