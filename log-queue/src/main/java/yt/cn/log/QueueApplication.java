package yt.cn.log;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class QueueApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(QueueApplication.class).web(true).run(args);
	}

}
