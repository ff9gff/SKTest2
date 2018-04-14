package com.sj.project.persistence;

import java.util.List;

import com.sj.project.domain.AdminMsgDTO;
import com.sj.project.domain.DomainDTO;
import com.sj.project.domain.MemberVO;
import com.sj.project.domain.MsgDTO;
import com.sj.project.pageutil.MsgPaginationCriteria;
import com.sj.project.pageutil.MyUserPaginationCriteria;

public interface AdminDAO {

	
	public abstract List<MemberVO> read();
	
	
	public abstract List<MemberVO> readAllUser12();
	
	public abstract int sendAllUserMsg(int mno , String msg_content);
	
	
	// 진짜 메인 화면에서 관리자의 모습을 보여 줄 화면 입니다. 
	public abstract List<DomainDTO> readRealDAdmim();
	
	// 레벨 0 인 사람들 불러 오기 
	
	public abstract List<Integer> readlevelZero();
	
	// 업데이트 하는 섭니다. 
	public abstract int updateLevelOne(int mno);
	
	
	// 유저의 정보를 레벨 2 로 관리자로 만듭니다. 
	public abstract int updateLevelTwo(int mno);
	
	//블랙 리스트 다운 그래이드 
	public abstract int downGradeTwo(int mno);
	
	
	//전체 유저를 보여주는 화면입니다. user level =1 
	public abstract List<DomainDTO> dominAlluserLeb1();
	
	
	//전체 유저를 보여주는 화면입니다. user level =2 
	public abstract List<DomainDTO> dominAllsubAdmin();
	
	//강등되는 회원에 대해서 소개하는 것입니다. 
	public abstract int downGradeLevelMSG(int mno);
	
	//관리자로 승격하는 소개하는 말입니다,. 
	public abstract int updateLevelTwoMSG(int mno);
	
	//admin의 말씀이니라 
	public abstract List<String> adminMSGAll();
	
	//admin to admin 
	public abstract List<AdminMsgDTO> adminMSGALL2();
	
	//admin  has active users
	public abstract int cntAllMyUser();
	
	//페이징 처리를 위한 
	public abstract List<DomainDTO> domainAllUserLeb1T(MyUserPaginationCriteria x);

}
