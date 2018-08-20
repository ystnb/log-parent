package yt.cn.log.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yt.cn.log.dao.RepliesMapper;
import yt.cn.log.pojo.Replies;
import yt.cn.log.pojo.RepliesExample;
import yt.cn.log.pojo.RepliesExample.Criteria;
import yt.cn.log.service.RepliesService;
@Service
@Transactional
public class RepliesServiceImpl implements RepliesService {

	@Autowired
	private RepliesMapper repliesMapper;
	
	/**
	 *  根据论坛id查询相应的回帖内容
	 */
	@Override
	public List<Replies> getByFid(String fId) {
		RepliesExample example=new RepliesExample();
		Criteria criteria=example.createCriteria();
		criteria.andFIdEqualTo(fId);
		List<Replies> list=repliesMapper.selectByExample(example);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public int insert(Replies replies) {
		return repliesMapper.insert(replies);
	}

}
