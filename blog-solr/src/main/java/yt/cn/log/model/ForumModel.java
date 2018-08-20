package yt.cn.log.model;

import lombok.Data;

public class ForumModel {
	
	private String id;
    private String ftitle;
    private String fauthor;
    private String fcontent;
    private String ftype;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFauthor() {
		return fauthor;
	}
	public void setFauthor(String fauthor) {
		this.fauthor = fauthor;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
    
}
