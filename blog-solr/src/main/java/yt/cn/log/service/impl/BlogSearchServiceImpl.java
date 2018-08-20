package yt.cn.log.service.impl;

import javax.naming.directory.SearchResult;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yt.cn.log.dao.BlogSearchDao;
import yt.cn.log.model.BlogSearch;
import yt.cn.log.service.BlogSearchService;

@Service
public class BlogSearchServiceImpl implements BlogSearchService{
	
	@Autowired
	private BlogSearchDao blogSearchDao;

	@Override
	public BlogSearch search(String queryString, int page, int rows) throws Exception {
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(queryString);
		//设置分页
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		//设置默认搜素域
		query.set("df", "log_keywords");
		//设置高亮显示
		query.setHighlight(true);
		query.addHighlightField("blog_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");
		//执行查询
		BlogSearch blogSearch = blogSearchDao.search(query);
		//计算查询结果总页数
		long recordCount = blogSearch.getRecordCount();
		long pageCount = recordCount / rows;
		if (recordCount % rows > 0) {
			pageCount++;
		}
		blogSearch.setPageCount(pageCount);
		blogSearch.setCurPage(page);
		
		return blogSearch;
	}

}
