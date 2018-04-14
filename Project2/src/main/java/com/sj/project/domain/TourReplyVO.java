package com.sj.project.domain;

import java.util.Date;

public class TourReplyVO {
	
	private int rno;
	private int parentrno;
	private int trip_no;
	private int mno;
	private String rcontent;
	private Date regdate;
	
	public TourReplyVO() {
		
	}

	public TourReplyVO(int rno, int parentrno, int trip_no, int mno, String rcontent, Date regdate) {
		this.rno = rno;
		this.parentrno = parentrno;
		this.trip_no = trip_no;
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

	public int getTrip_no() {
		return trip_no;
	}

	public void setTrip_no(int trip_no) {
		this.trip_no = trip_no;
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


	


}
