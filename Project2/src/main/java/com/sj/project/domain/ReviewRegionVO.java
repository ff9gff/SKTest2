package com.sj.project.domain;

public class ReviewRegionVO {
	
	private int review_no;
	private String region_name;
	private int region_no;
	
	public ReviewRegionVO() {
		
	}
	
	public ReviewRegionVO(int review_no, String region_name, int region_no) {
		this.review_no = review_no;
		this.region_name = region_name;
		this.region_no = region_no;
	}
	
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	public int getRegion_no() {
		return region_no;
	}
	public void setRegion_no(int region_no) {
		this.region_no = region_no;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return region_name;
	}
	
	
} // end class ReviewRegionVO