package yt.cn.log.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import yt.cn.log.common.utils.CookieUtils;
import yt.cn.log.controller.BaseURLService;
import yt.cn.log.pojo.lUser;
import yt.cn.log.service.SsoFeignClient;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private BaseURLService urlService;
	@Autowired
	private SsoFeignClient ssoFeignClient;
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		lUser user=null;
		System.out.println(urlService.SSO_BASE_URL+urlService.SSO_PAGE_LOGIN);
		String token=CookieUtils.getCookieValue(request, "TT_TOKEN");
		String url="http://"+request.getServerName()+":"+request.getServerPort()+request.getRequestURI();
		if(StringUtils.isBlank(token)){
			response.sendRedirect(urlService.SSO_BASE_URL+urlService.SSO_PAGE_LOGIN+"?redirect="+url);
			return false;
		}
		String userJson=ssoFeignClient.token(token);
		if(StringUtils.isBlank(userJson)){
			response.sendRedirect(urlService.SSO_BASE_URL+urlService.SSO_PAGE_LOGIN+"?redirect="+url);
			return false;
		}
		JSONObject jsonObject=JSONObject.parseObject(userJson);
		user=JSONObject.toJavaObject(jsonObject, lUser.class);
		request.setAttribute("user",user);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("SSO======单点登录系统postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("SSO======单点登录系统afterCompletion");

	}

}
