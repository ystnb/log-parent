package yt.cn.log.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yt.cn.log.common.result.LogResult;
import yt.cn.log.common.utils.EmailUtils;
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
		String userToken=(String) redisService.get("BK_TOKEN_"+token);
		if(StringUtils.isBlank(userToken)){
			return null;
		}else{
			redisService.set("BK_TOKEN_"+token, userToken, 60*60*60);
		}
		return userToken;
	}
	@PostMapping("login")
	public String login(@RequestParam("email")String email,
			@RequestParam("password")String password,HttpServletRequest request,HttpServletResponse 
			response){
		String token="";
		LogResult logResult=null;
		 try {
			 token=userService.getByExample(email, password,request,response);
			if(!StringUtils.isBlank(token)){
				logResult=logResult.ok(token);
			}else{
				logResult=logResult.error(500, "用户错误了");
			}
			int code =(int)((Math.random()*9+1)*100000);
			String result=EmailUtils.SendEmailCode("邮箱验证", email, String.valueOf(code));
		} catch (Exception e) {
			e.printStackTrace();
			logResult=logResult.error(400, e.getMessage());
			return JSON.toJSON(logResult).toString();
		}
		return JSON.toJSON(logResult).toString();
	}
	
	@PostMapping("check")
	public String check(@RequestParam("email") String email){
		lUser user=null;
		try {
			user=userService.getEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		if(user==null){
			return "success";
		}else{
			return "existed";
		}
		
	}
	
	public static void main(String[] args) {
		int code =(int)((Math.random()*9+1)*100000);
		System.out.println(code);
	}

}
