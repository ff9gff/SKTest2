package com.sj.project.domain;

public class LevelVO {
	
	private int seq_no;
	private int mno;
	private int point;
	private int level;
	
	public LevelVO() {
		
	}

	public LevelVO(int seq_no, int mno, int point, int level) {
		this.seq_no = seq_no;
		this.mno = mno;
		this.point = point;
		this.level = level;
	}

	public int getSeq_no() {
		return seq_no;
	}

	public void setSeq_no(int seq_no) {
		this.seq_no = seq_no;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
