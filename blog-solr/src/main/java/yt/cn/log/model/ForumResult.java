package yt.cn.log.model;

import java.util.List;

import lombok.Data;

public class ForumResult {
	private List<ForumModel> list;
	//总记录数
	private long recordCount;
	//总页数
	private long pageCount;
	//当前页
	private long curPage;
	public List<ForumModel> getList() {
		return list;
	}
	public void setList(List<ForumModel> list) {
		this.list = list;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public long getCurPage() {
		return curPage;
	}
	public void setCurPage(long curPage) {
		this.curPage = curPage;
	}
	

}
