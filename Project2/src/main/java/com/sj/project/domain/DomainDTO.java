package com.sj.project.domain;

import java.util.Date;

//domain DTO 관리자 모드로 들어갈 때의 모습입니다. 
// 관리자 메인 화면을 보여줄 모습입니다. 
public class DomainDTO {
	private int mno;
	private String userid;
	private String phone;
	private String email;
	private Date joindate;
	private String nickname;
	
	
public DomainDTO() {

}










public DomainDTO(int mno, String userid, String nickname, String phone, String email, Date joindate) {

	this.mno = mno;
	this.userid = userid;
	this.nickname = nickname;
	this.phone = phone;
	this.email = email;
	this.joindate = joindate;
}










public String getNickname() {
	return nickname;
}










public void setNickname(String nickname) {
	this.nickname = nickname;
}










public DomainDTO(int mno, String userid, String phone, String email, Date joindate) {
	super();
	this.mno = mno;
	this.userid = userid;
	this.phone = phone;
	this.email = email;
	this.joindate = joindate;
}






public int getMno() {
	return mno;
}


public void setMno(int mno) {
	this.mno = mno;
}


public String getUserid() {
	return userid;
}


public void setUserid(String userid) {
	this.userid = userid;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public Date getJoindate() {
	return joindate;
}


public void setJoindate(Date joindate) {
	this.joindate = joindate;
}
	
	



	
	
	
}//end class 
