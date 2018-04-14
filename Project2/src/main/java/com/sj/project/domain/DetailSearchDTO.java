package com.sj.project.domain;

public class DetailSearchDTO {
	private String region_name;
	private String start_date;
	private int condition_sex;
	private int condition_age;
	
	public DetailSearchDTO() {
		
	}

	public DetailSearchDTO(String region_name, String start_date, int condition_sex, int condition_age) {
		this.region_name = region_name;
		this.start_date = start_date;
		this.condition_sex = condition_sex;
		this.condition_age = condition_age;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public int getCondition_sex() {
		return condition_sex;
	}

	public void setCondition_sex(int condition_sex) {
		this.condition_sex = condition_sex;
	}

	public int getCondition_age() {
		return condition_age;
	}

	public void setCondition_age(int condition_age) {
		this.condition_age = condition_age;
	}
}
