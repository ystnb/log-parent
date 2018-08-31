package yt.cn.log.kafkaUtils;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import yt.cn.log.service.WriteFeignClient;

@Component
public class Receiver {
	
	@Autowired
	private WriteFeignClient solrFeignClient;

	
	  public static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

	    
	    @KafkaListener(topics = {"forum"})
	    public void forum(String forum) throws InterruptedException {
	    	try {
				solrFeignClient.writeForum(forum);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	/*JSONObject jsonobject = JSONObject.parseObject(forum);
	    		Forum	forumjson=JSONObject.toJavaObject(jsonobject, Forum.class);
	    		System.out.println(forumjson.getfTitle());
	    		System.out.println(forumjson.getfContent());*/
	      
	    }
	    @KafkaListener(topics = {"blog"})
	    public void blog(String blog) throws InterruptedException {
	    	try {
				solrFeignClient.writeBlog(blog);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	/*JSONObject jsonobject = JSONObject.parseObject(blog);
	    	Blog forumjson=JSONObject.toJavaObject(jsonobject, Blog.class);
	    	System.out.println(forumjson.getTitle());
    		System.out.println(forumjson.getContent());*/
	    }
}
