package com.sj.project.service;

import java.util.List;

import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.TourReplyVO;

public interface TourReplyService {
	public abstract int create(TourReplyVO vo);
	public abstract List<TourReplyVO> read(int trip_no);
	public abstract List<PersonalVO> readPerson(int trip_no);
	public abstract int update(TourReplyVO vo);
	public abstract int delete(int rno);
	public abstract int allDelete(int parentrno);
}// end interface TourReplyService
