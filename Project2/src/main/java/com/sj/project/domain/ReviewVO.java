package com.sj.project.domain;

import java.util.Date;

public class ReviewVO {
	
	private int review_no;
	private String title;
	private String content;
	private int mno;
	private int countofbest;
	private int hits;
	private Date regdate;
	
	public ReviewVO() {}
	public ReviewVO(int review_no, String title, String content, int mno, int countofbest, int hits, Date regdate) {		
		this.review_no = review_no;
		this.title = title;
		this.content = content;
		this.mno = mno;
		this.countofbest = countofbest;
		this.hits = hits;
		this.regdate = regdate;
	}

	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCountofbest() {
		return countofbest;
	}
	public void setCountofbest(int countofbest) {
		this.countofbest = countofbest;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title;
	}
	
	
} // end class ReviewVO