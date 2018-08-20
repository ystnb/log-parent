package yt.cn.log.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yt.cn.log.pojo.lUser;
import yt.cn.log.service.SsoFeignClient;
import yt.cn.log.service.lUserService;

@RequestMapping("user")
@RestController
public class UserController {
	
	@Autowired
	private SsoFeignClient ssoFeignClient;
	@Autowired
	private lUserService lUserService;
	
	
	@GetMapping("token/{token}")
	public String token(@PathVariable("token")String token){
		return ssoFeignClient.token(token);
	}
	@PostMapping("login")
	public String login(@RequestParam("nickname")String nickname,
			@RequestParam("password")String password){
		String json=ssoFeignClient.login(nickname, password);
		return json;
	}
	@PostMapping("addUser")
	public String addUser(@RequestBody lUser user){
		return ssoFeignClient.addUser(user);
		
	}
	

}
