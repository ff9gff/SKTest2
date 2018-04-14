package com.sj.project.domain;

public class RegionVO {
	
	private int trip_no;
	private String region_name;
	private int region_no;
	
	public RegionVO() {
		
	}

	public RegionVO(int trip_no, String region_name, int region_no) {
		this.trip_no = trip_no;
		this.region_name = region_name;
		this.region_no = region_no;
	}

	public int getTrip_no() {
		return trip_no;
	}

	public void setTrip_no(int trip_no) {
		this.trip_no = trip_no;
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

	

}
