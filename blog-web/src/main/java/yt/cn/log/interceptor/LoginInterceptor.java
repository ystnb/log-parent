package yt.cn.log.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import yt.cn.log.common.utils.CookieUtils;
import yt.cn.log.service.SsoFeignClient;
import yt.cn.log.service.lUserService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private lUserService userService;
	@Autowired
	private SsoFeignClient ssoFeignClient;
	
	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*System.out.println("SSO======单点登录系统");
		String token=CookieUtils.getCookieValue(request, "TT_TOKEN");
		if(StringUtils.isBlank(token)){
			response.sendRedirect("login");
			return false;
		}
		String user=userService.getByToken(token);
		if(StringUtils.isBlank(user)){
			ssoFeignClient.login();
			return false;
		}*/
		
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
