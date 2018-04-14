package com.sj.project.domain;

public class ImgVO {
	
	private int board_type;
	private int content_no;
	private int photo_no;
	private String img_url;
	
	public ImgVO() {
		
	}

	public ImgVO(int board_type, int content_no, int photo_no, String img_url) {
		this.board_type = board_type;
		this.content_no = content_no;
		this.photo_no = photo_no;
		this.img_url = img_url;
	}

	public int getBoard_type() {
		return board_type;
	}

	public void setBoard_type(int board_type) {
		this.board_type = board_type;
	}

	public int getContent_no() {
		return content_no;
	}

	public void setContent_no(int content_no) {
		this.content_no = content_no;
	}

	public int getPhoto_no() {
		return photo_no;
	}

	public void setPhoto_no(int photo_no) {
		this.photo_no = photo_no;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return img_url;
	}
	
	

}
