package com.sj.project.domain;

public class NickReviewSearchResultDTO {
	
	private String img_url;
	private String title;
	private String region_name;
	private int review_no;
	private int hits;
	private int countofbest;

	public NickReviewSearchResultDTO() {

	}
	
	public NickReviewSearchResultDTO(String img_url, String title, String region_name, int review_no, int hits, int countofbest) {
		this.img_url = img_url;
		this.title = title;
		this.region_name = region_name;
		this.review_no = review_no;
		this.hits = hits;
		this.countofbest = countofbest;
	}
	
	public int getCountofbest() {
		return countofbest;
	}

	public void setCountofbest(int countofbest) {
		this.countofbest = countofbest;
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

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return img_url;
	}
}
