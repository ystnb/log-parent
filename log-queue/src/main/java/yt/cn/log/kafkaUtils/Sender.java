package yt.cn.log.kafkaUtils;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.alibaba.fastjson.JSON;
import com.google.gson.GsonBuilder;

@Component
public class Sender {

	@Autowired
	private  KafkaTemplate kafkaTemplate;

	/**
	 * 博客队列
	 * @param object
	 * @throws Exception
	 */
    public void blogKafka(String blog) throws Exception{
    	ListenableFuture send = kafkaTemplate.send("blog", "key", blog);
    }
    /**
     * 帖子
     * @param object
     * @throws Exception
     */
    public void forumKafka(String forum) throws Exception{
    	ListenableFuture send = kafkaTemplate.send("blog", "key", forum);
    }
}
