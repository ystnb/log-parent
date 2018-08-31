package yt.cn.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yt.cn.log.kafkaUtils.Sender;

@RestController
public class KafkaController {
	
	@Autowired
	private Sender sender;
	
	@GetMapping("cs")
	public String cs(){
		return "kafka服务启动成功！";
	}
	
	@GetMapping("blogKafka")
	public void blogKafka(@RequestParam("blog")String blog){
		try {
			sender.blogKafka(blog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("forumKafka")
	public void forumKafka(@RequestParam("forum")String forum){
		try {
			sender.forumKafka(forum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
