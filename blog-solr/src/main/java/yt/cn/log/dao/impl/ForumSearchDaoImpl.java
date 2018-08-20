package yt.cn.log.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yt.cn.log.dao.ForumSearchDao;
import yt.cn.log.model.ForumModel;
import yt.cn.log.model.ForumResult;

@Service
public class ForumSearchDaoImpl implements ForumSearchDao{

	@Autowired
	private SolrClient client;
	@Override
	public ForumResult search(SolrQuery solrQuery) throws Exception {
			ForumResult forumResult=new ForumResult();
		//根据查询条件查询索引库
				QueryResponse queryResponse = client.query(solrQuery);
				//取查询结果
				SolrDocumentList solrDocumentList = queryResponse.getResults();
				//取查询结果总数量
				forumResult.setRecordCount(solrDocumentList.getNumFound());
				//查询论坛
				List<ForumModel> forumModels = new ArrayList<>();
				//取商品列表
				for (SolrDocument solrDocument : solrDocumentList) {
					//创建一商品对象
					ForumModel forumModel = new ForumModel();
					forumModel.setId((String) solrDocument.get("id"));
					forumModel.setFtitle((String) solrDocument.get("f_title"));
					forumModel.setFauthor((String) solrDocument.get("f_author"));
					forumModel.setFtype((String) solrDocument.get("f_type"));
					forumModel.setFcontent((String)solrDocument.get("f_content"));
					//添加的商品列表
					forumModels.add(forumModel);
				}
				forumResult.setList(forumModels);
				System.out.println(forumResult);
		return forumResult;
	}

}
