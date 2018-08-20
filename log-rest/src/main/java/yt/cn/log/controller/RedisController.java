package yt.cn.log.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import yt.cn.log.common.utils.CookieUtils;
import yt.cn.log.service.RedisService;

@RestController
public class RedisController {
	
	@Autowired
	private RedisService redisService;
	
	
	

}
