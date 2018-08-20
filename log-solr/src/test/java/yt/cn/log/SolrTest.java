package yt.cn.log;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolrTest {
	@Autowired
	private SolrClient solrClient;
	
	@Test
	public void solr() throws Exception{
		/*SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "test001");
		document.addField("log_title", "测试商品2");
		document.addField("log_desc", "什么玩意啊啊啊啊");
		//把文档对象写入索引库
		solrClient.add(document);
		//提交
		solrClient.commit();*/
		

	}

	
}
