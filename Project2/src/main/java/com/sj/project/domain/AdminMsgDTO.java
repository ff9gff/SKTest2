package com.sj.project.domain;

public class AdminMsgDTO {

	private String msg_content;
	private String msg_no;

	public AdminMsgDTO() {
		// TODO 자동 생성된 생성자 스텁
	}

	
	public AdminMsgDTO(String msg_content, String msg_no) {
		
		this.msg_content = msg_content;
		this.msg_no = msg_no;
	}


	
	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	public String getMsg_no() {
		return msg_no;
	}

	public void setMsg_no(String msg_no) {
		this.msg_no = msg_no;
	}
	
	
	
}//end 
