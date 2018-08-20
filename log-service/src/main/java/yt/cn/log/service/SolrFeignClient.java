package yt.cn.log.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yt.cn.log.service.hystrix.HystrixSolrClient;

@FeignClient(name="log-solr",fallback=HystrixSolrClient.class)
public interface SolrFeignClient {
	
	@GetMapping("blog/query")
	String blogQuery(@RequestParam("q")String q);
	@GetMapping("forum/query")
	String forumQuery(@RequestParam("q")String q);
	

}
