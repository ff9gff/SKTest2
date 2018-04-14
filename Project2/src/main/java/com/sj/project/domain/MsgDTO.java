package com.sj.project.domain;

import java.util.Date;

public class MsgDTO {
	private int msg_no;
	private String nickname;
	private String msg_content;
	private Date msg_date;
	

	public MsgDTO() {
		// TODO 자동 생성된 생성자 스텁
	}




	
	
	

	public MsgDTO(int msg_no, String nickname, String msg_content, Date msg_date) {
		super();
		this.msg_no = msg_no;
		this.nickname = nickname;
		this.msg_content = msg_content;
		this.msg_date = msg_date;
	}







	public int getMsg_no() {
		return msg_no;
	}


	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}




	public String getNickname() {
		return nickname;
	}





	public void setNickname(String nickname) {
		this.nickname = nickname;
	}





	public String getMsg_content() {
		return msg_content;
	}





	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}





	public Date getMsg_date() {
		return msg_date;
	}





	public void setMsg_date(Date msg_date) {
		this.msg_date = msg_date;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
