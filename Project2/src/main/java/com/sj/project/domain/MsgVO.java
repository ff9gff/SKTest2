package com.sj.project.domain;

import java.util.Date;

public class MsgVO {
	
	private int msg_no; // 쪽지 고유 번호 
	private int sd_mno; // 보낸 사람 회원 번호
	private int rc_mno; // 받은 사람 회원 번호
	private String msg_content; // 쪽지 내용
	private Date msg_date; // 메시지 전송 시간
	
	

	
	
	public MsgVO() {
		
	}
	
	
	
	

	public MsgVO(int msg_no, int sd_mno, int rc_mno, String msg_content, Date msg_date) {
		this.msg_no = msg_no;
		this.sd_mno = sd_mno;
		this.rc_mno = rc_mno;
		this.msg_content = msg_content;
		this.msg_date = msg_date;
	}

	public int getMsg_no() {
		return msg_no;
	}



	public int getSd_mno() {
		return sd_mno;
	}

	public void setSd_mno(int sd_mno) {
		this.sd_mno = sd_mno;
	}

	public int getRc_mno() {
		return rc_mno;
	}

	public void setRc_mno(int rc_mno) {
		this.rc_mno = rc_mno;
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
