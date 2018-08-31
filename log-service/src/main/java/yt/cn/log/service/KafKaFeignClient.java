package yt.cn.log.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import yt.cn.log.pojo.Blog;
import yt.cn.log.pojo.Forum;


@FeignClient("log-queue")
public interface KafKaFeignClient {
	
	@GetMapping("blogKafka")
	public void blogKafka(@RequestParam("blog") String blog);
	@GetMapping("forumKafka")
	public void forumKafka(@RequestParam("forum") String forum);

}
