package com.sj.project.domain;

import java.util.Date;

public class PersonalVO {

	private int mno;
	private String name;
	private int sex;
	private int age;
	private String nickname;
	private String phone;
	private int postcode;
	private String address1;
	private String address2;
	private String introduce;
	private String email;
	private Date joindate;

	public PersonalVO() {}
	public PersonalVO(MemberVO vo,String email, Date joindate){
		this.email = email;
		this.joindate = joindate;
	}
	public PersonalVO(int mno, String name, int sex, int age, String nickname, String phone, int postcode,
			String address1, String address2, String introduce, String email, Date joindate) {
		super();
		this.mno = mno;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.nickname = nickname;
		this.phone = phone;
		this.postcode = postcode;
		this.address1 = address1;
		this.address2 = address2;
		this.introduce = introduce;
		this.email = email;
		this.joindate = joindate;
	}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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
	
	
} // end class PersonalVO