package yt.cn.log.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yt.cn.log.common.utils.JsonUtils;
import yt.cn.log.dao.lUserMapper;
import yt.cn.log.pojo.lUser;
import yt.cn.log.pojo.lUserExample;
import yt.cn.log.pojo.lUserExample.Criteria;
import yt.cn.log.service.RedisService;
import yt.cn.log.service.SsoFeignClient;
import yt.cn.log.service.lUserService;

@Service
@Transactional
public class lUserServiceImpl implements lUserService {
	
	@Autowired
	private RedisService redisService;
	
	@Autowired
	private lUserMapper userMapper;


	@Override
	public void insertBody(lUser user) {
		userMapper.insertBody(user);
		
	}

	@Override
	public String getByNameAndPwd(String nickname, String password) {
		lUserExample example=new lUserExample();
		Criteria criteria=example.createCriteria();
		criteria.andNicknameEqualTo(nickname);
		criteria.andPasswordEqualTo(password);
		List<lUser> users=userMapper.selectByExample(example);
		
		if(users.size()>0){
			String token=UUID.randomUUID().toString();
			redisService.set("TT_TOKEN_"+token, JsonUtils.objectToJson(users.get(0)), 30*60*1000);
			return token;
		}
		return null;
	}

}
