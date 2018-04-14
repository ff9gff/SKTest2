package com.sj.project.persistence;

import java.util.List;

import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.TourReplyVO;

public interface TourReplyDAO {
	// 댓글 입력
	public abstract int insert(TourReplyVO vo);
	// 댓글 검색
	public abstract List<TourReplyVO> select(int trip_no);
	// 댓글 업데이트
	public abstract int update(TourReplyVO vo);
	// 댓글 삭제
	public abstract int delete(int rno);
	// 대댓글도 모두 삭제
	public abstract int allDelete(int parentrno);
	// 개인정보 검색
	public abstract List<PersonalVO> selectPerson(int trip_no);
	
	
}// end interface TourReplyDAO
