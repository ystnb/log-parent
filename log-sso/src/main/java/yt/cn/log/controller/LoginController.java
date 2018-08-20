package yt.cn.log.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import yt.cn.log.common.result.LogResult;
import yt.cn.log.pojo.lUser;
import yt.cn.log.service.RedisService;
import yt.cn.log.service.lUserService;


@RequestMapping("sso")
@RestController
public class LoginController {
	
	@Autowired
	private RedisService redisService;
	@Autowired
	private lUserService userService;
	
	@GetMapping("token/{token}")
	public String token(@PathVariable("token")String token){
		String userToken=(String) redisService.get("TT_TOKEN_"+token);
		if(StringUtils.isBlank(userToken)){
			return null;
		}else{
			redisService.set("TT_TOKEN_"+token, userToken, 60*60*1000);
		}
		return userToken;
	}
	@PostMapping("login")
	public String login(@RequestParam("nickname")String nickname,
			@RequestParam("password")String password){
		String token="";
		LogResult logResult=null;
		 try {
			 token=userService.getByNameAndPwd(nickname, password);
			if(!StringUtils.isBlank(token)){
				logResult=logResult.ok(token);
			}else{
				logResult=logResult.error(500, "用户错误了");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logResult=logResult.error(400, e.getMessage());
			return JSON.toJSON(logResult).toString();
		}
		return JSON.toJSON(logResult).toString();
	}
	@PostMapping("addUser")
	public String addUser(@RequestBody lUser user){
		try {
			userService.insertBody(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
		
	}

}
