package com.sj.project.domain;

public class TourJoinVO {
	
	private int trip_no;
	private int list_no;
	private int mno;
	private int approval;
	
	public TourJoinVO() {
		
	}

	public TourJoinVO(int trip_no, int list_no, int mno, int approval) {
		this.trip_no = trip_no;
		this.list_no = list_no;
		this.mno = mno;
		this.approval = approval;
	}
	

	public int getTrip_no() {
		return trip_no;
	}

	public void setTrip_no(int trip_no) {
		this.trip_no = trip_no;
	}

	public int getList_no() {
		return list_no;
	}

	public void setList_no(int list_no) {
		this.list_no = list_no;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}


	

}
