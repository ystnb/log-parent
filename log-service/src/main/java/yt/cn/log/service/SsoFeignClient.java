package yt.cn.log.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import yt.cn.log.pojo.lUser;
import yt.cn.log.service.hystrix.HystrixSsoClient;

@FeignClient(name="log-sso",fallback=HystrixSsoClient.class)
public interface SsoFeignClient {
	
	@GetMapping("sso/token/{token}")
	String token(@PathVariable("token") String token);
	@PostMapping("sso/login")
	String login(@RequestParam("nickname") String nickname,
                 @RequestParam("password") String password);
	@PostMapping("sso/addUser")
	String addUser(@RequestBody lUser user);
	@GetMapping("login")
	public String Userlogin();
	

}
