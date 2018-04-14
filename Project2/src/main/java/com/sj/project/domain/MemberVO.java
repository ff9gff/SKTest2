package com.sj.project.domain;

public class MemberVO {
	
	private int mno;
	private String userid;
	private String pwd;
	private int authority;
	
	public MemberVO() {}	
	public MemberVO(int mno, String userid, String pwd, int authority) {
		this.mno = mno;
		this.userid = userid;
		this.pwd = pwd;
		this.authority = authority;
	}
	
	/*수정 완료 */
	public MemberVO(PersonalVO vo ,String userid , String pwd, int authority ){
		this.userid = userid;
		this.pwd = pwd;
		this.authority = authority;		
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

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(mno);
	} // end toString()
	
	
} // end class MemberVO