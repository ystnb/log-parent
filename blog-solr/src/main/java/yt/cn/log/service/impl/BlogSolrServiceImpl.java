package yt.cn.log.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yt.cn.log.pojo.Blog;
import yt.cn.log.pojo.Forum;
import yt.cn.log.service.BlogService;
import yt.cn.log.service.BlogSolrService;
import yt.cn.log.service.ForumService;

@Service
public class BlogSolrServiceImpl implements BlogSolrService{
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private SolrClient client;
	@Autowired
	private ForumService forumService;
	

	@Override
	public String query() throws Exception{
		Map map=new HashMap();
		List<Blog> list=blogService.queryGetByNames(map);
		if (list.size()>0) {
			for(int i=0;i<list.size();i++){
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", list.get(i).getId());
				document.addField("blog_title", list.get(i).getTitle());
				document.addField("blog_author", list.get(i).getAuthor());
				document.addField("blog_attribute", list.get(i).getAttribute());
				document.addField("blog_frequency", list.get(i).getFrequency());
				document.addField("blog_content", list.get(i).getContent());
				//把文档对象写入索引库
				client.add(document);
				//提交
				client.commit();
			}
			
		}
		return "ok";
	}


	@Override
	public String forumQuery() throws Exception {
		Map map=new HashMap();
		List<Forum> list=forumService.queryGetByNames(map);
		if (list.size()>0) {
			for(int i=0;i<list.size();i++){
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", list.get(i).getId());
				document.addField("f_title", list.get(i).getfTitle());
				document.addField("f_author", list.get(i).getfAuthor());
				document.addField("f_type", list.get(i).getType());
				document.addField("f_content", list.get(i).getfContent());
				//把文档对象写入索引库
				client.add(document);
				//提交
				client.commit();
			}
			
		}
		return "ok";
	}

}
