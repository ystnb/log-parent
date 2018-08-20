package yt.cn.log.service;

import yt.cn.log.pojo.lUser;

public interface lUserService {
	void insertBody(lUser user);
	
	String getByNameAndPwd(String nickname,String password);
	

}
