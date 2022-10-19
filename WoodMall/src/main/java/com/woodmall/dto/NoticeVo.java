package com.woodmall.dto;

public class NoticeVo {
	private int noticeNum;
	private String name;
	private String userId;
	private String noticeTitle;
	private String noticeContent;
	private int noticeHits;
	
	@Override
	public String toString() {
		return "NoticeVo [noticenum=" + noticeNum + ", name=" + name +", userid=" +userId+", noticetitle=" + noticeTitle + ", noticecontent=" + noticeContent +", noticehits =" + noticeHits + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeHits() {
		return noticeHits;
	}

	public void setNoticeHits(int noticeHits) {
		this.noticeHits = noticeHits;
	}
}
