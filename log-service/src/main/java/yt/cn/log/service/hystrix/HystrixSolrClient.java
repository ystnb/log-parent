package yt.cn.log.service.hystrix;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yn.cn.log.model.BlogModel;
import yn.cn.log.model.BlogSearch;
import yt.cn.log.pojo.BlogExample;
import yt.cn.log.service.BlogService;
import yt.cn.log.service.SolrFeignClient;

import java.util.List;

@Service
public class HystrixSolrClient implements SolrFeignClient {

	private static Logger logger = LoggerFactory.getLogger(HystrixSolrClient.class);
	@Autowired
	private BlogService blogService;
	@Override
	public String blogQuery(String q) {
		logger.warn("solr查询失败：query={}",q);
		List<BlogModel> list = blogService.selectByExample(new BlogExample());
		BlogSearch result = new BlogSearch();
		result.setItemList(list);
		return JSON.toJSONString(result);
	}

	@Override
	public String forumQuery(String q) {
		return "服务正忙，请稍后重试！";
	}

}
