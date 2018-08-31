package yt.cn.log.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("log-solr")
public interface WriteFeignClient {
	
	@GetMapping("blog/writeBlog")
	void writeBlog(@RequestParam("blog")String blogjson) throws Exception;
	@GetMapping("forum/writeForum")
	void writeForum(@RequestParam("forum")String forumjson) throws Exception;
}
