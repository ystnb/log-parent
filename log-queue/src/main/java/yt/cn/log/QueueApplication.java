package yt.cn.log;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class QueueApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(QueueApplication.class).web(true).run(args);
	}

}
