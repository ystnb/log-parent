package yt.cn.log;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RedisApplication.class).web(true).run(args);
	}

}
