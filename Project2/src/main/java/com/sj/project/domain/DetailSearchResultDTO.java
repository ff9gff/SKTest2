package com.sj.project.domain;

public class DetailSearchResultDTO {

	private String img_url;
	private String title;
	private String region_name;
	private int condition_sex;
	private int condition_age;
	private int trip_no;
	private int expire;

	public DetailSearchResultDTO() {

	}

	public DetailSearchResultDTO(String img_url, String title, String region_name, int condition_sex, int condition_age,
			int trip_no, int expire) {
		this.img_url = img_url;
		this.title = title;
		this.region_name = region_name;
		this.condition_sex = condition_sex;
		this.condition_age = condition_age;
		this.trip_no = trip_no;
		this.expire = expire;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
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

	public int getTrip_no() {
		return trip_no;
	}

	public void setTrip_no(int trip_no) {
		this.trip_no = trip_no;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return img_url;
	}
	
}
