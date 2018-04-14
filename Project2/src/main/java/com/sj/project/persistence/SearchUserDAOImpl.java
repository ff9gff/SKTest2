package com.sj.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.MemberVO;
import com.sj.project.domain.MsgVO;




@Repository
public class SearchUserDAOImpl implements SearchUserDAO {

	private static final Logger logger =LoggerFactory.getLogger(SearchUserDAOImpl.class);
	private static final String NAMESPACE =
			"com.sj.project.SearchMember";
			//"edu.spring.wmmsg.MsgMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberVO> searchUser(String userid) {
		logger.info("여기는 SearchUserDAOIMPLE 입니다. user 값은 " + userid);
		userid = /*"%" +*/ userid + "%";
		List<MemberVO> list = sqlSession.selectList(NAMESPACE+".searchUserName", userid);
		
		return list;
		
	}
	
	
	@Override
	public int searchSndUno(String nickname) {
		
		int result = sqlSession.selectOne(NAMESPACE+".searchSndUno",nickname);
		logger.info("searchuserDAO 지남 "+result);
		return result;
	}


	@Override
	public int sendMsgToU(MsgVO vo) {
		
		int result = sqlSession.insert(NAMESPACE+".sendMSGU", vo);
		logger.info("searchuserDAO 지남  -> 에 메세지 insert 중입니다. "+result);
		
		return result;
	}
	
	
	

}
