package com.sj.project.persistence;

import java.util.List;

import com.sj.project.domain.BestVO;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.NickReviewSearchResultDTO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.ReviewRegionVO;
import com.sj.project.domain.ReviewVO;

public interface TourReviewDAO {

	// insert
	public abstract int insertReview(ReviewVO reviewvo);

	public abstract int insertThumnail(ImgVO imgvo);

	public abstract int insertRegion(ReviewRegionVO reviewRegionvo);

	// update
	public abstract int updateReview(ReviewVO reviewvo);

	public abstract int updateThumnail(ImgVO imgvo);

	public abstract int updateRegion(ReviewRegionVO reviewRegionvo);

	// delete
	public abstract int deleteReview(int review_no);

	public abstract int deleteThumnail(int review_no);

	public abstract int deleteRegion(int review_no);

	// select
	public abstract int selectReview_no(ReviewVO reviewvo);

	public abstract ReviewVO selectReviewRegister_data(int review_no);

	public abstract ReviewVO select_review_by_no(int review_no);

	public abstract ImgVO select_review_profile(int mno);

	public abstract PersonalVO select_review_personal(int mno);

	public abstract String select_review_region_name(int review_no);

	public abstract ReviewVO selectReviewInfo(int review_no);

	public abstract ReviewRegionVO selectReviewRegionInfo(int review_no);

	public abstract ImgVO selectReviewMainImage(int review_no);

	// select

	// 메인/후기 게시판 - 디폴트 4개 후기 등록순 뿌리기
	// 1. 사진 뿌리기
	public abstract List<ImgVO> select_review_default_image();

	// 2. 제목 뿌리기
	public abstract List<ReviewVO> select_review_default_title();

	// 3. 지역 뿌리기
	public abstract List<ReviewRegionVO> select_review_default_region();

	// 메인/후기 게시판 - 디폴트 4개 후기 조회수순 뿌리기
	// 1. 사진 뿌리기
	public abstract List<ImgVO> select_review_top_image();

	// 2. 제목 뿌리기
	public abstract List<ReviewVO> select_review_top_title();

	// 3. 지역 뿌리기
	public abstract List<ReviewRegionVO> select_review_top_region();

	// 후기 게시판 - 지역검색
	// 1. 사진 뿌리기
	public abstract List<ImgVO> select_review_region_image(String region_name);

	// 2. 제목 뿌리기
	public abstract List<ReviewVO> select_review_region_title(String region_name);

	// 3. 지역 뿌리기
	public abstract List<ReviewRegionVO> select_review_region_region(String region_name);

	// 후기 게시판 - 닉네임 검색
	public abstract List<NickReviewSearchResultDTO> select_review_by_nickname(String region_name, String nickname);

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 조회수
	public abstract int select_current_review_hits(int review_no);
	public abstract int update_review_hits(ReviewVO vo);

	// 따봉
	public abstract int selectReviewLike(int review_no, int mno);
	public abstract int insertReviewLike(int review_no, int mno);
	public abstract int deleteReviewLike(int review_no, int mno);
	public abstract int update_review_best(int review_no);

	/**
	 * BestVO
	 */
	public abstract int insertBest(BestVO bestvo);
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 이 아래 에서 새로운 Imple을 작성하시오!
	 */

} // end interface TourReviewDAO