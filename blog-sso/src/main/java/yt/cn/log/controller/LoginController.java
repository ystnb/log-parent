package yt.cn.log.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import yt.cn.log.common.result.LogResult;
import yt.cn.log.common.utils.CookieUtils;
import yt.cn.log.common.utils.SendMailUtil;
import yt.cn.log.pojo.lUser;
import yt.cn.log.service.RedisService;
import yt.cn.log.service.lUserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("sso")
@RestController
public class LoginController {
	
	@Autowired
	private RedisService redisService;

	@Autowired
	private lUserService userService;
	
	@GetMapping("token/{token}")
	public String token(@PathVariable("token")String token){
		String userToken=(String) redisService.get(token);
		if(StringUtils.isBlank(userToken)){
			return null;
		}else{
			redisService.set(token, userToken, 60*60);
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
			try {
				String code=SendMailUtil.getSixDom();
				SendMailUtil.CodeEmail("邮件验证",code ,email);
				redisService.set(email, code, 2*60);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
			return "success";
		}else{
			return "existed";
		}
		
	}
	
	@GetMapping("cookie")
	public String cookie(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String cookie=CookieUtils.getCookieValue(request, "TT_TOKEN");
		if(StringUtils.isBlank(cookie)){
			return null;
		}
		return cookie;
	}
	@GetMapping("code")
	public String code(@RequestParam("email") String email){
		String code=SendMailUtil.getSixDom();
		String subject="邮件验证";
		try {
			String result=	SendMailUtil.CodeEmail(subject, code, email);
			if(result.equals("SUCCESS")){
				redisService.set(email, code, 100);
				return "ok";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "error";
	}

}
