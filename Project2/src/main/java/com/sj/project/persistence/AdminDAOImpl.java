package com.sj.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.AdminMsgDTO;
import com.sj.project.domain.DomainDTO;
import com.sj.project.domain.MemberVO;
import com.sj.project.pageutil.MyUserPaginationCriteria;

@Repository
public class AdminDAOImpl implements AdminDAO {

	
	private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);
	
	private static final String NAMESPACE = "com.sj.project.SearchMember";
	//newUser
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override //관리자 메인 페이지에 뿌려주는 새로가입한 사람들 리스트 불러오게 함 
	public List<MemberVO> read() {
		logger.info("관리자 페이지에 들어가는 새로가입한 사람들 리스트를 보여줍니다. ");
		List<MemberVO> newlist = sqlSession.selectList(NAMESPACE+".newUser"); 
		return newlist;
	}//end read() 

	@Override
	public List<MemberVO> readAllUser12() {
		logger.info(" 1 2 등급의 유저");
		
		List<MemberVO> list = sqlSession.selectList(NAMESPACE+".userLevel12");
		return list;
	}

	@Override
	public int sendAllUserMsg(int mno , String msg_content) {
		logger.info(" 모든 유저에게 보낼 메세지입니다.");
		
		Map<String,Object> map = new HashMap<>();
		map.put("mno",mno );
		map.put("msg_content",msg_content);
		int result = sqlSession.insert(NAMESPACE+".sendAlluser12", map);
				
		
		
		
		
		/*
	@Override
	public int updateReplyCnt(int amount, int bno) {
		
		Map<String, Integer> map =new  HashMap<>();
		map.put("amount", amount);
		map.put("bno", bno); 
		// 문자열로 지정해서 보내주어야 받을 수 있다. 
		
		
		return sqlssesion.update(namespace+".updateReplyCnt",map );
	}*/		
		return result;
	}

	@Override
	public List<DomainDTO> readRealDAdmim() {
		//이젠 진짜 화면에 출력 할 것을 말한다.
		logger.info("여기는 현재 adminDAOimple 입니다. ");
		List<DomainDTO> list = sqlSession.selectList(NAMESPACE+".realDomainAdmin");
		return list;

	}

	@Override  //  유저 정보 입니다. 
	public List<Integer> readlevelZero() {
		 List<Integer> list = sqlSession.selectList(NAMESPACE+".selectLevelZero");
		return list;
	}

	@Override
	public int updateLevelOne(int mno) {
	  
		int result = 0;
		result  = sqlSession.update(NAMESPACE+".upgradeLevelOne" ,mno); 
	  return result;
	}

	@Override
	public int updateLevelTwo(int mno) {
		int result = sqlSession.update(NAMESPACE+".upgradeLevelTwo", mno);
		return result;
	}

	@Override
	public int downGradeTwo(int mno) {
		
		return sqlSession.update(NAMESPACE+".downGradeLevel", mno);
	}

	@Override
	public List<DomainDTO> dominAlluserLeb1() {
		
		return sqlSession.selectList(NAMESPACE+".realDomainAdminAllUser");
	}

	@Override
	public List<DomainDTO> dominAllsubAdmin() {
	
		return sqlSession.selectList(NAMESPACE+".realDomainSubMyAdmin");
	}

	@Override
	public int downGradeLevelMSG(int mno) {
	
		return sqlSession.insert(NAMESPACE+".downGradeLevelMSG", mno);
		
	}

	@Override
	public int updateLevelTwoMSG(int mno) {
		
		return sqlSession.insert(NAMESPACE+".upgradeLevelTwoMSG", mno);
	}

	@Override
	public List<String> adminMSGAll() {
		
		return sqlSession.selectList(NAMESPACE+".selectContextAdminMSG");
	}

	@Override
	public List<AdminMsgDTO> adminMSGALL2() {
		// TODO 자동 생성된 메소드 스텁
		return sqlSession.selectList(NAMESPACE+".selectToMSGFromMSGSelf");
	}

	@Override
	public int cntAllMyUser() {
		
		return sqlSession.selectOne(NAMESPACE+".cntAllActivUsers");
	}

	@Override
	public List<DomainDTO> domainAllUserLeb1T(MyUserPaginationCriteria x) {
		
		return sqlSession.selectList(NAMESPACE+".realDomainAdminAllUserT", x);
	}
	
	
}//end class 
