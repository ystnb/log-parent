package yt.cn.log.service.hystrix;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import yt.cn.log.pojo.lUser;
import yt.cn.log.service.SsoFeignClient;
@Service
public class HystrixSsoClient implements SsoFeignClient{

	@Override
	public String token(@PathVariable("token")String token) {
		return "服务正忙，请稍后！";
	}

	@Override
	public String login(String nickname, String password) {
		return "服务正忙，请稍后！";
	}

	@Override
	public String addUser(lUser user) {
		return "服务正忙，请稍后！";
	}

	@Override
	public String Userlogin() {
		
		return null;
	}

	


	

}
