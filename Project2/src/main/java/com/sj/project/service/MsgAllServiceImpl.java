package com.sj.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.MsgDTO;
import com.sj.project.domain.MsgVO;
import com.sj.project.pageutil.MsgPaginationCriteria;
import com.sj.project.pageutil.PaginationCriteria;
import com.sj.project.persistence.MsgAllDAO;

@Service
public class MsgAllServiceImpl implements MsgAllService {

	
	private static Logger logger = LoggerFactory.getLogger(MsgAllServiceImpl.class);
	
	@Autowired
	private MsgAllDAO msgAlldao;
	
	
	@Override
	public List<MsgVO> readMyMsg(int mno) {
		
		logger.info("msg all service 지남" + mno);
		
		List<MsgVO> list = msgAlldao.read(mno);
	
		logger.info("list 사이즈 확인 "+ list.size());
		return list;
	}


	@Override
	public String readNickname(int mno) {
		logger.info("닉네임 찾는 서비스 ");
		logger.info("ㅡmno -> "+mno);
	String s1=	msgAlldao.selectNick(mno);
	logger.info(s1);
		return msgAlldao.selectNick(mno);
	}


	@Override
	public List<MsgDTO> readGetMsg(int mno) {
		// TODO 자동 생성된 메소드 스텁
		//readGetMsg readAllget dao 
		//msgAlldao.readAllget(mno);
		logger.info("mno "+ mno);
	List<MsgDTO> list =msgAlldao.readAllget(mno);
	
	logger.info("sssss" +list.size());
	logger.info("mno 다시와  "+ mno);
		return list;
	}


	@Override
	public List<MsgDTO> readSendMsg(int mno) {
		logger.info("여기는 mno sendMsg" + mno);
		List<MsgDTO> read = msgAlldao.readAllsend(mno);
		logger.info("read의 사이즈는 " + read.size());
		
		return read;
	}


	@Override
	public List<MsgDTO> readSendMsg2(MsgPaginationCriteria x) {
		
		return msgAlldao.readAllget2(x);
		
	}


	@Override
	public int deleteSelectMSGContext(int mno) {
		 
		return msgAlldao.deleteSelectMSG(mno);
	}


	@Override
	public String selectMSGContext(int mni) {
	String ss=	 msgAlldao.selectContextMSG(mni);
		logger.info("text" +ss);
		return ss;
	}


	@Override
	public int getNumOfRecords(int mno) {
		
		return msgAlldao.getNumOfRecords(mno);
	}


	@Override
	public int pageGetMsgOfRecords(int mno) {
		// TODO 자동 생성된 메소드 스텁
		return msgAlldao.getMsgTotalNumOfRecords(mno);
	}


	@Override
	public List<MsgDTO> readPageGetMsgTxt(MsgPaginationCriteria x) {
		// TODO 자동 생성된 메소드 스텁
		return msgAlldao.readGetPagingMSG(x);
	}





}
