package com.sj.project.domain;

public class BestVO {

	private int mno;
	private int review_no;
	private int state;
	
	public BestVO() {
	
	}

	public BestVO(int mno, int review_no, int state) {
		this.mno = mno;
		this.review_no = review_no;
		this.state = state;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
} // end class BestVO