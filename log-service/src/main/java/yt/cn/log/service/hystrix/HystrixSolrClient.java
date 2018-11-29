package yt.cn.log.service.hystrix;

import com.alibaba.fastjson.JSON;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yn.cn.log.model.BlogModel;
import yn.cn.log.model.BlogSearch;
import yt.cn.log.pojo.BlogExample;
import yt.cn.log.service.BlogService;
import yt.cn.log.service.ForumService;
import yt.cn.log.service.SolrFeignClient;

import java.util.List;

@Service
public class HystrixSolrClient implements SolrFeignClient {

	private static Logger logger = LoggerFactory.getLogger(HystrixSolrClient.class);
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private ForumService forumService;
	
	@Override
	public String blogQuery(String q) {
		List list=null;
		logger.warn("solr查询失败：query={}",q);
		if(StringUtils.isBlank(q)){
			list = blogService.selectByExample(new BlogExample()); 
		}else{
			list = blogService.getLikeContent(q);
		}
		BlogSearch result = new BlogSearch();
		result.setItemList(list);
		return JSON.toJSONString(result);
	}

	@Override
	public String forumQuery(String q) {
		
		return "服务正忙，请稍后重试！";
	}

}
