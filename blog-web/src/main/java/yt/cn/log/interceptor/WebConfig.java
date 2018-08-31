package yt.cn.log.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
    public LoginInterceptor myAuthInterceptor() {
        return new LoginInterceptor();
    }

 	@Override
 	    public void addInterceptors(InterceptorRegistry registry) {
 	        // 注册拦截器
 	        InterceptorRegistration ir = registry.addInterceptor(myAuthInterceptor());
 	        // 配置拦截的路径
 	        ir.addPathPatterns("/replies/*");
 	        ir.addPathPatterns("/luser/*");
 	    }
	

	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }
}
