package com.sj.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.NickReviewSearchResultDTO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.ReviewRegionVO;
import com.sj.project.domain.ReviewVO;
import com.sj.project.persistence.TourReviewDAO;

@Service
public class TourReviewServiceImpl implements TourReviewService {
	
	private static final Logger logger = LoggerFactory.getLogger(TourRegisterServiceImpl.class);
	
	@Autowired
	private TourReviewDAO tourReviewDAO;
	
	/**
	 * Create
	 */
	@Override
	public int createReview(ReviewVO reviewvo) {
		logger.info("createReview() 호출...");
		
		return tourReviewDAO.insertReview(reviewvo);
	} // end createeReview(reviewvo)
	
	@Override
	public int createThumnail(ImgVO imgvo) {		
		logger.info("createThumnail() 호출...");

		return tourReviewDAO.insertThumnail(imgvo);
	} // end createThumnail(imgvo)
	
	@Override
	public int createRegion(ReviewRegionVO reviewregionvo) {
		logger.info("createRegion() 호출...");
		
		return tourReviewDAO.insertRegion(reviewregionvo);
	} // end createRegion(reviewregionvo)
	
	/**
	 * Update
	 */
	@Override
	public int updateReview(ReviewVO reviewvo) {

		return tourReviewDAO.updateReview(reviewvo);
	} // end updateReview(reviewvo)
	
	@Override
	public int updateThumnail(ImgVO imgvo) {

		return tourReviewDAO.updateThumnail(imgvo);
	} // end updateThumnail(imgvo)
	
	@Override
	public int updateRegion(ReviewRegionVO reviewRegionvo) {

		return tourReviewDAO.updateRegion(reviewRegionvo);
	} // end updateRegion(reviewregionvo)
	
	/**
	 * Delete
	 */
	@Override
	public int deleteReview(int review_no) {

		return tourReviewDAO.deleteReview(review_no);
	} // end deleteReview(review_no)

	@Override
	public int deleteThumnail(int review_no) {

		return tourReviewDAO.deleteThumnail(review_no);
	} // end deleteThumnail(review_no)

	@Override
	public int deleteRegion(int review_no) {

		return tourReviewDAO.deleteRegion(review_no);
	} // end deleteRegion(review_no)
	
	/**
	 * Read
	 */
	@Override
	public int readReview_no(ReviewVO reviewvo) {
		logger.info("readReview_no() 호출...");

		return tourReviewDAO.selectReview_no(reviewvo);
	} // end readReview_no(reviewvo)
	
	@Override
	public ReviewVO readReviewRegisterData(int review_no) {
		logger.info("readRegisterData() 호출...");
		logger.info("review_no: " + review_no);
		
		return tourReviewDAO.selectReviewRegister_data(review_no);
	} // end readRegisterData(review_no)
	
	
	
	@Override
	public ReviewVO read_review_by_no(int review_no) {
		return tourReviewDAO.select_review_by_no(review_no);
	} // end read_review_by_no(review_no)	
	
	@Override
	public ImgVO read_review_profile(int mno) {
		logger.info("read_review_profile() 호출...");
		
		return tourReviewDAO.select_review_profile(mno);
	} // end read_review_profile(mno)
	
	@Override
	public PersonalVO read_review_personal(int mno) {
		logger.info("read_review_personal() 호출...");
		
		return tourReviewDAO.select_review_personal(mno);
	} // end read_review_personal(mno)
	
	@Override
	public String read_review_region_name(int review_no) {
		logger.info("read_review_region_name() 호출...");
		
		return tourReviewDAO.select_review_region_name(review_no);
	} // end read_review_region_name(review_no)
	
	
	
	@Override
	public ReviewVO readReviewInfo(int review_no) {

		return tourReviewDAO.selectReviewInfo(review_no);
	} // end readReviewInfo(review_no)
	
	@Override
	public ReviewRegionVO readReviewRegionInfo(int review_no) {

		return tourReviewDAO.selectReviewRegionInfo(review_no);
	} // end readReviewRegionInfo(review_no)
	
	@Override
	public ImgVO readReviewMainImage(int review_no) {

		return tourReviewDAO.selectReviewMainImage(review_no);
	} // end readReviewMainImage(review_no)
	
	
	
	/**
	 * Read
	 */

	

	

	

	


	
	// 디폴트 ?개 후기 사진
	@Override
	public List<ImgVO> read_review_default_image() {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_default_image();
	}

	// 디폴트 ?개 후기 제목
	@Override
	public List<ReviewVO> read_review_default_title() {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_default_title();
	}

	// 디폴트 ?개 후기 지역
	@Override
	public List<ReviewRegionVO> read_review_default_region() {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_default_region();
	}

	@Override
	public List<ImgVO> read_review_region_image(String region_name) {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_region_image(region_name);
	}

	@Override
	public List<ReviewVO> read_review_region_title(String region_name) {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_region_title(region_name);
	}

	@Override
	public List<ReviewRegionVO> read_review_region_region(String region_name) {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_region_region(region_name);
	}

	@Override
	public List<ImgVO> read_review_top_image() {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_top_image();
	}

	@Override
	public List<ReviewVO> read_review_top_title() {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_top_title();
	}

	@Override
	public List<ReviewRegionVO> read_review_top_region() {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_top_region();
	}

	@Override
	public List<NickReviewSearchResultDTO> read_review_by_nickname(String region_name, String nickname) {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_review_by_nickname(region_name, nickname);
	}

	@Override
	public int read_current_review_hits(int review_no) {
		// TODO Auto-generated method stub
		return tourReviewDAO.select_current_review_hits(review_no);
	}

	@Override
	public int update_review_hits(ReviewVO vo) {
		// TODO Auto-generated method stub
		return tourReviewDAO.update_review_hits(vo);
	}

	@Override
	public int readReviewLike(int review_no, int mno) {
		// TODO Auto-generated method stub
		return tourReviewDAO.selectReviewLike(review_no, mno);
	}

	@Override
	public int createReviewLike(int review_no, int mno) {
		// TODO Auto-generated method stub
		return tourReviewDAO.insertReviewLike(review_no, mno);
	}

	@Override
	public int deleteReviewLike(int review_no, int mno) {
		// TODO Auto-generated method stub
		return tourReviewDAO.deleteReviewLike(review_no, mno);
	}

	@Override
	public int update_review_best(int review_no) {
		// TODO Auto-generated method stub
		return tourReviewDAO.update_review_best(review_no);
	}


	
	

	
	
	
	
	
	
} // end class TourReviewServiceImpl