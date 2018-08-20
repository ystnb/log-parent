package yt.cn.log.common.result;

import java.util.List;

import yt.cn.log.pojo.Forum;
import yt.cn.log.pojo.Replies;

public class ForumRepliesResult {
	private Forum forum;
	private List<Replies> replies;
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public List<Replies> getReplies() {
		return replies;
	}
	public void setReplies(List<Replies> replies) {
		this.replies = replies;
	}
	

}
