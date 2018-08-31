package yt.cn.log.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yt.cn.log.pojo.lUser;

public interface lUserService {
	void insertBody(lUser user);
	
	String getByExample(String email, String password, HttpServletRequest request, HttpServletResponse
            response);
	
	lUser getEmail(String email);
	

}
