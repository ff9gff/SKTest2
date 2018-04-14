package com.sj.project.persistence;

import java.util.List;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.ReviewReplyVO;

public interface TourReviewReplyDAO {
	
	// 댓글 입력
	public abstract int insert(ReviewReplyVO reviewreplyvo);
	
	// 댓글 검색
	public abstract List<ReviewReplyVO> select(int review_no);
	
	// 댓글 업데이트
	public abstract int update(ReviewReplyVO reviewreplyvo);
	
	// 댓글 삭제
	public abstract int delete(int rno);
	
	// 대댓글도 모두 삭제
	public abstract int allDelete(int parentrno);
	
	// 개인정보 검색
	public abstract List<PersonalVO> selectPerson(int review_no);
	
	public abstract ImgVO selectProfile(int mno);
	
	
} // end interface TourReviewReplyDAO