package com.sj.project.service;

import java.util.List;

import com.sj.project.domain.AdminMsgDTO;
import com.sj.project.domain.DomainDTO;
import com.sj.project.domain.MemberVO;
import com.sj.project.pageutil.MyUserPaginationCriteria;

public interface AdminService {

	
	public List<MemberVO> newUserList();
	
	public List<MemberVO> userLevel12read();
	
	public int sendAllUserMessage( String msg_content);
	
	//관리자 메인 화면을 수정 하겠습니다. 11.28 
	public List<DomainDTO> readAdminDomain();
	
	
	//  유저 정보를 모두 가져옵니다. 레벨  0 
	public List<Integer> readLevelZero();
	
	// update 
	public int updateLevelOne(int mno);
	
	//관리자로 승격합니다 . 
	public int updateLevelTwo(int mno);
	
	//블랙리스트 입니다. 
	
	public int downGradeLevel(int mno);
	
	
	// admin에 있는  모습에 level 1인 사람들의 모든 모습 
	public List<DomainDTO> allMyActivUser();
	
	//admin에 있는 모습에 level 2인 사람들의 모습 
	public List<DomainDTO> allMySubAdminActivUser();
	
	//관리자의 말씀이니라 
	public List<String> allAdminMSG();
	
	public List<AdminMsgDTO> allAdminMSG2();
	
	public int cntAllMyUser();
	
	
	public List<DomainDTO> pagingAllMyUser(MyUserPaginationCriteria x);
}
