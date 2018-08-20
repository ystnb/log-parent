package yt.cn.log.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yt.cn.log.dao.BlogSearchDao;
import yt.cn.log.model.BlogModel;
import yt.cn.log.model.BlogSearch;

@Service
public class BlogSearchDaoImpl implements BlogSearchDao {
	@Autowired
	private SolrClient solrClient;

	@Override
	public BlogSearch search(SolrQuery query) throws Exception {
	
		BlogSearch result = new BlogSearch();
		//根据查询条件查询索引库
		QueryResponse queryResponse = solrClient.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		//取查询结果总数量
		result.setRecordCount(solrDocumentList.getNumFound());
		//商品列表
		List<BlogModel> itemList = new ArrayList<>();
		//取高亮显示
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		//取商品列表
		for (SolrDocument solrDocument : solrDocumentList) {
			//创建一商品对象
			BlogModel item = new BlogModel();
			item.setId((String) solrDocument.get("id"));
			//取高亮显示的结果
			List<String> list = highlighting.get(solrDocument.get("id")).get("blog_title");
			String title = "";
			if (list != null && list.size()>0) {
				title = list.get(0);
			} else {
				title = (String) solrDocument.get("blog_title");
			}
			item.setTitle(title);
			
			item.setAuthor((String) solrDocument.get("blog_author"));
			item.setAttribute((String) solrDocument.get("blog_attribute"));
			if(null!=solrDocument.get("blog_frequency")&&"null".equals(solrDocument.get("blog_frequency"))){
				
				item.setFrequency(((Long) solrDocument.get("blog_frequency")).intValue());
			}else{
				item.setFrequency(0);
			}
			item.setContent((String)solrDocument.get("blog_content"));
			//添加的商品列表
			itemList.add(item);
		}
		result.setItemList(itemList);
		return result;
	}

}
