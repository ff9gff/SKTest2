package com.sj.project.service;

import java.util.List;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.ReviewReplyVO;

public interface TourReviewReplyService {
	
	public abstract int create(ReviewReplyVO reviewreplyvo);
	
	public abstract List<ReviewReplyVO> read(int review_no);
	
	public abstract List<PersonalVO> readPerson(int review_no);
	
	public abstract int update(ReviewReplyVO reviewreplyvo);
	
	public abstract int delete(int rno);
	
	public abstract int allDelete(int parentrno);
	
	public abstract ImgVO readProfile(int mno);
	
		
} // end interface TourReviewReplyService