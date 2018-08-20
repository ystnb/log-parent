package yt.cn.log.service.hystrix;

import org.springframework.stereotype.Service;

import yt.cn.log.service.SolrFeignClient;

@Service
public class HystrixSolrClient implements SolrFeignClient {

	@Override
	public String blogQuery(String q) {
		return "服务正忙，请稍后重试！";
	}

	@Override
	public String forumQuery(String q) {
		return "服务正忙，请稍后重试！";
	}

}
