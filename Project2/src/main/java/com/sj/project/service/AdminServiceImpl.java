package com.sj.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.AdminMsgDTO;
import com.sj.project.domain.DomainDTO;
import com.sj.project.domain.MemberVO;
import com.sj.project.pageutil.MyUserPaginationCriteria;
import com.sj.project.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService{


	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Autowired AdminDAO aDao;
	
	
	@Override
	public List<MemberVO> newUserList() {
		
		logger.info("adminService 지납니다. 여기에서 뷰에 리스트 뿌림");
		return aDao.read();
		
	}


	@Override
	public List<MemberVO> userLevel12read() {
		logger.info("integer 로 구성된 mno들을 뽑아냄 ");
		return aDao.readAllUser12();
	}


	
	@Override
	public int sendAllUserMessage( String msg_content) {
		int result=0;  
		List<MemberVO> user12List =aDao.readAllUser12();//get(0).toString()
		logger.info("sendAllUserMessage 지나요 user12List.size() -> "+user12List.size()); //Integer.parseInt(args[0]);
		//logger.info("sendAllUserMessage toString "+ user12List.get(0)); 
		logger.info("msg_content-> "+msg_content);
		//logger.info("sendAllUserMessage 지나요 "+ user12List.get(0).toString());
		//logger.info("sew 버여져 "+user12List.get(0).intValue());
		//logger.info("sendAllUserMessage 지나요 "+ Integer.parseInt(user12List.get(0).toString()));
		for(int i = 0 ; i <user12List.size();i++){
		result =aDao.sendAllUserMsg(user12List.get(i).getMno(), msg_content);
		
		}
		result= aDao.sendAllUserMsg(1, msg_content);
		return result;
	}


	@Override
	public List<DomainDTO> readAdminDomain() {
		logger.info("여기는 지금 adminService에 있는 readAdminDomain입니다.");
		List<DomainDTO> list = aDao.readRealDAdmim();
		return list;
	}


	@Override
	public List<Integer> readLevelZero() {
	  
		List<Integer> list = aDao.readlevelZero();
		logger.info("레벨이 0 인 애들을 부릅니다. "+  list.size());
 		return list;
 		
	}


	@Override
	public int updateLevelOne(int mno) {
		int result = 0;
		 result = aDao.updateLevelOne(mno);
		return result;
	}


	@Override
	public int updateLevelTwo(int mno) {
		int result = aDao.updateLevelTwo(mno);
		 logger.info("level 2 로 승격 " + result);
		 aDao.updateLevelTwoMSG(mno); // 메세지 보내는 부분 입니다. 
		 
		return result;
	}//end level 2 


	@Override
	public int downGradeLevel(int mno) {
		int result =aDao.downGradeTwo(mno);
		//Msg를 보내는 부분입니다. 
					aDao.downGradeLevelMSG(mno);
		return result;
	}


	@Override
	public List<DomainDTO> allMyActivUser() {
		
		return aDao.dominAlluserLeb1();
	}


	@Override
	public List<DomainDTO> allMySubAdminActivUser() {
		
		return aDao.dominAllsubAdmin();
	}


	@Override
	public List<String> allAdminMSG() {
	
		return aDao.adminMSGAll();
	}


	@Override
	public List<AdminMsgDTO> allAdminMSG2() {
		
		return aDao.adminMSGALL2();
	}


	@Override
	public int cntAllMyUser() {
		
		return aDao.cntAllMyUser();
	}


	@Override
	public List<DomainDTO> pagingAllMyUser(MyUserPaginationCriteria x) {
		
		return aDao.domainAllUserLeb1T(x);
	}
	
	

	
	
}//end class 
