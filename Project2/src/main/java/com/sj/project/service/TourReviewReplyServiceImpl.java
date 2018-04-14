package com.sj.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.ReviewReplyVO;
import com.sj.project.persistence.TourReviewReplyDAO;

@Service
public class TourReviewReplyServiceImpl implements TourReviewReplyService {
	
	@Autowired
	private TourReviewReplyDAO tourReviewReplyDAO;

	@Override
	public int create(ReviewReplyVO reviewreplyvo) {

		return tourReviewReplyDAO.insert(reviewreplyvo);
	} // end create(reviewreplyvo)

	@Override
	public List<ReviewReplyVO> read(int review_no) {

		return tourReviewReplyDAO.select(review_no);
	} // end read(review_no)

	@Override
	public List<PersonalVO> readPerson(int review_no) {

		return tourReviewReplyDAO.selectPerson(review_no);
	} // end readPerson(review_no)

	@Override
	public int update(ReviewReplyVO reviewreplyvo) {

		return tourReviewReplyDAO.update(reviewreplyvo);
	} // end update(reviewreplyvo)

	@Override
	public int delete(int rno) {

		return tourReviewReplyDAO.delete(rno);
	} // end delete(rno)

	@Override
	public int allDelete(int parentrno) {

		return tourReviewReplyDAO.allDelete(parentrno);
	} // end allDelete(parentrno)
	
	@Override
	public ImgVO readProfile(int mno) {

		return tourReviewReplyDAO.selectProfile(mno);
	} // end readProfile(mno)
	
	
} // end class TourReviewReplyServiceImpl