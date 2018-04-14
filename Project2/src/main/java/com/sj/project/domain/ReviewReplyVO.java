package com.sj.project.domain;

import java.util.Date;

public class ReviewReplyVO {
	
	private int rno;
	private int parentrno;
	private int review_no;
	private int mno;
	private String rcontent;
	private Date regdate;
	
	
	public ReviewReplyVO() {}
	public ReviewReplyVO(int rno, int parentrno, int review_no, int mno, String rcontent, Date regdate) {
		super();
		this.rno = rno;
		this.parentrno = parentrno;
		this.review_no = review_no;
		this.mno = mno;
		this.rcontent = rcontent;
		this.regdate = regdate;
	}

	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getParentrno() {
		return parentrno;
	}
	public void setParentrno(int parentrno) {
		this.parentrno = parentrno;
	}

	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	
} // end class ReviewReplyVO