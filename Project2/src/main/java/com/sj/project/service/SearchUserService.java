package com.sj.project.service;

import java.util.List;

import com.sj.project.domain.MemberVO;

public interface SearchUserService {

	public abstract List<MemberVO> readuser(String userid); // userSearch

	public abstract int sendMsgTO(int sd_mno, String getUser, String msg);
	// public abstract int

	
}
