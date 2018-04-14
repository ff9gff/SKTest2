package com.sj.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.MsgDTO;
import com.sj.project.domain.MsgVO;
import com.sj.project.pageutil.MsgPaginationCriteria;
import com.sj.project.pageutil.PaginationCriteria;

@Repository
public class MsgAllDAOImpl implements MsgAllDAO{

	
	private static Logger logger = LoggerFactory.getLogger(MsgAllDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.sj.project.MemberMapper";
	//private static final String NAMESPACE =
	//"com.sj.project.MemberMapper";
	
	@Override
	public List<MsgVO> read(int mno) {
		
		logger.info("여기는 msgAlldaoimple 지납ㄴ다. " + mno);
		List<MsgVO> vo=	sqlSession.selectList(NAMESPACE+".selectMsg" ,mno);
		
		
		return vo;
		
	}

	@Override
	public String selectNick(int mno) {
		
		
		logger.info("select닉네임 입니다. ");
		String ss = sqlSession.selectOne(NAMESPACE+".selectNickname", mno);
		logger.info("닉네임 몰까 여기는 selectnick "+ ss);
		
		return ss;
		
	}

	@Override
	public List<MsgDTO> readAllget(int mno) {
		logger.info("select Msg DTO닉네임 입니다. ");
		
		return sqlSession.selectList(NAMESPACE+".selectGetMsg", mno);
	}

	@Override
	public List<MsgDTO> readAllsend(int mno) {
		
		logger.info("select Msg DTO send name 닉네임 입니다. ");

		return sqlSession.selectList(NAMESPACE+".selectSendMsg", mno);
	}

	@Override
	public List<MsgDTO> readAllget2(MsgPaginationCriteria x) {
	 
		return sqlSession.selectList(NAMESPACE+".pageListsendMsg" , x );
	}

	@Override
	public int deleteSelectMSG(int mno) {
		
		return sqlSession.delete(NAMESPACE+".deleteSelectMSG", mno);
	}

	@Override
	public String selectContextMSG(int mno) {
		String ss2  =sqlSession.selectOne(NAMESPACE+".getContentMSG", mno);
	
		return ss2;
	}

	
	
	@Override
	public int getNumOfRecords(int mno) {
		// TODO 자동 생성된 메소드 스텁 totalcount
		return sqlSession.selectOne(NAMESPACE+".totalcount",mno);
	}

	@Override
	public int getMsgTotalNumOfRecords(int mno) {
		//받은 메일함 개수를 나타 냅니다.
		return sqlSession.selectOne(NAMESPACE+".getMsgTotalcount", mno);
	}

	
	
	@Override //받은 쪽지함을 만드는 페이징 처리 입니다. 
	public List<MsgDTO> readGetPagingMSG(MsgPaginationCriteria x) {
	
		return sqlSession.selectList(NAMESPACE+".pageListGetMsg", x);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}// end class 
