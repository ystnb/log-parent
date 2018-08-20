package yt.cn.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yt.cn.log.service.RedisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testrest {
	@Autowired
	private RedisService redisService;

	@Test
	public void cs(){
		redisService.set("zs","11111zs");
		System.out.println(redisService.get("zs"));
	}
	
}
