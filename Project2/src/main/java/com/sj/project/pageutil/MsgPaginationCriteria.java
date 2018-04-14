package com.sj.project.pageutil;


public class MsgPaginationCriteria extends PaginationCriteria{
	private int mno;
	

	
	public MsgPaginationCriteria() {
		// TODO 자동 생성된 생성자 스텁
	}


	public MsgPaginationCriteria(int mno) {
		super();
		this.mno = mno;
	}




	public int getMno() {
		return mno;
	}




	public void setMno(int mno) {
		this.mno = mno;
	}
	
	
	
}//end 

