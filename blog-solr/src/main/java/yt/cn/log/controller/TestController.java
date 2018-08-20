package yt.cn.log.controller;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import yt.cn.log.service.BlogSolrService;

@RestController
public class TestController {

	@Autowired
	private SolrClient client;
	@Autowired
	private BlogSolrService blogSolrService;
	
	
	
	@GetMapping("import")
	public String importall(){
		try {
			blogSolrService.query();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@GetMapping("fourm")
	public String importfourm(){
		try {
			blogSolrService.forumQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@GetMapping("test")
	public String test() throws Exception{
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "test001");
		document.addField("log_title", "测试商品2");
		document.addField("log_desc", "测试是的的的的");
		//把文档对象写入索引库
		client.add(document);
		//提交
		client.commit();
		SolrQuery query = new SolrQuery();// 查询
        query.setQuery("id:test001");
        QueryResponse response = client.query(query);
        SolrDocumentList solrDocumentList = response.getResults();
       StringBuffer buffer=new StringBuffer();
        for (SolrDocument sd : solrDocumentList) {
        	buffer.append(sd.getFieldValue("log_title").toString()+sd.getFieldValue("log_desc"));
            System.out.println("solr获取值：" + sd.getFieldValue("id"));
            System.out.println("solr获取值：" + sd.getFieldValue("log_title"));
            System.out.println("solr获取值：" + sd.getFieldValue("log_desc"));
        }
        return buffer.toString();
	}
}
