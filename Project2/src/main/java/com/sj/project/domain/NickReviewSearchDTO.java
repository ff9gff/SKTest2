package com.sj.project.domain;

public class NickReviewSearchDTO {
	
	private String region_name;
	private String nickname;
	
	public NickReviewSearchDTO() {
		
	}

	public NickReviewSearchDTO(String region_name, String nickname) {
		this.region_name = region_name;
		this.nickname = nickname;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
