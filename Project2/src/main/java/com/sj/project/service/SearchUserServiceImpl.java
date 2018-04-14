package com.sj.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.MemberVO;
import com.sj.project.domain.MsgVO;
import com.sj.project.persistence.SearchUserDAO;


@Service
public class SearchUserServiceImpl implements SearchUserService {

	
	private static final Logger logger =
			LoggerFactory.getLogger(SearchUserServiceImpl.class);
	
	@Autowired
	private SearchUserDAO suDao;
	
	@Override
	public List<MemberVO> readuser(String userid) {
		
		logger.info("SearchUserServiceimple 을 지납니다.");
		logger.info("userid " +userid ); //잘 넘어감 
		List<MemberVO> list =	suDao.searchUser(userid);
		logger.info("list => "+list.size());
		return suDao.searchUser(userid);
	}

	@Override
	public int sendMsgTO(int sd_mno, String nickname , String msg_content) {

		logger.info("SearchUserServiceimple 을 지납니다. 편지 작성 하자 디비디비딥");
		
		int rc_mno = suDao.searchSndUno(nickname); 
		
		
		logger.info("보낸이 => "+ sd_mno +" 받는이 "+ rc_mno);
		
		MsgVO vo = new MsgVO(0, sd_mno, rc_mno, msg_content, null);
		
		return suDao.sendMsgToU(vo);
	}

}
