package com.sj.project.domain;

public class FavoriteVO {
	
	private int fav_no;
	private int mno;
	private int trip_no;
	
	public FavoriteVO() {
		
	}

	public FavoriteVO(int fav_no, int mno, int trip_no) {
		this.fav_no = fav_no;
		this.mno = mno;
		this.trip_no = trip_no;
	}

	public int getFav_no() {
		return fav_no;
	}

	public void setFav_no(int fav_no) {
		this.fav_no = fav_no;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getTrip_no() {
		return trip_no;
	}

	public void setTrip_no(int trip_no) {
		this.trip_no = trip_no;
	}
	
}
