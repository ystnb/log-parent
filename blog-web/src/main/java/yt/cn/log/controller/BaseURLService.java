package yt.cn.log.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:resource.properties")
public class BaseURLService {
	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL;
	@Value("${SSO_PAGE_LOGIN}")
	public String SSO_PAGE_LOGIN;

}
