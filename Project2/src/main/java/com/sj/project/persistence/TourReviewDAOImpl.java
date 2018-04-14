package com.sj.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.BestVO;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.NickReviewSearchDTO;
import com.sj.project.domain.NickReviewSearchResultDTO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.ReviewRegionVO;
import com.sj.project.domain.ReviewVO;

@Repository
public class TourReviewDAOImpl implements TourReviewDAO {

	private static final Logger logger = LoggerFactory.getLogger(TourReviewDAOImpl.class);

	private static final String NAMESPACE = "com.sj.project.TourReviewMapper";

	private static final String NAMESPACE2 = "com.sj.project.TourReviewSearchMapper";

	@Autowired
	private SqlSession sqlSession;

	/**
	 * insert
	 */
	@Override
	public int insertReview(ReviewVO reviewvo) {

		return sqlSession.insert(NAMESPACE + ".insert-review", reviewvo);
	} // end insertReview(reviewvo)

	@Override
	public int insertThumnail(ImgVO imgvo) {

		return sqlSession.insert(NAMESPACE + ".insert-thumnail", imgvo);
	} // end insertThumnail(vo)

	@Override
	public int insertRegion(ReviewRegionVO reviewRegionvo) {

		return sqlSession.insert(NAMESPACE + ".insert-region", reviewRegionvo);
	} // end insertRegion(reviewRegionvo)

	
	/**
	 * update
	 */
	@Override
	public int updateReview(ReviewVO reviewvo) {

		return sqlSession.update(NAMESPACE + ".update-review", reviewvo);
	} // end updateReview(reviewvo)

	@Override
	public int updateThumnail(ImgVO imgvo) {
		
		return sqlSession.update(NAMESPACE + ".update-thumnail", imgvo);
	} // end updateThumnail(imgvo)

	@Override
	public int updateRegion(ReviewRegionVO reviewRegionvo) {

		return sqlSession.update(NAMESPACE + ".update-region", reviewRegionvo);
	} // end updateRegion(reviewRegionvo)
	
	
	/**
	 * delete
	 */
	@Override
	public int deleteReview(int review_no) {

		return sqlSession.delete(NAMESPACE + ".delete-review", review_no);
	} // end deleteReview(review_no)

	@Override
	public int deleteThumnail(int review_no) {

		return sqlSession.delete(NAMESPACE + ".delete-thumnail", review_no);
	} // end deleteThumnail(review_no)
	
	@Override
	public int deleteRegion(int review_no) {

		return sqlSession.delete(NAMESPACE + ".delete-region", review_no);
	} // end deleteRegion(review_no)
	
	
	
	/**
	 * select
	 */	
	@Override
	public int selectReview_no(ReviewVO reviewvo) {

		return sqlSession.selectOne(NAMESPACE + ".select-review_no", reviewvo);
	} // end selectReview_no(reviewvo)
	
	@Override
	public ReviewVO selectReviewRegister_data(int review_no) {
		
		logger.info("review_no : " + review_no);

		return sqlSession.selectOne(NAMESPACE + ".select_review-register_data", review_no);
	} // end selectRegister_data(review_no)
	
	
	
	@Override
	public ReviewVO select_review_by_no(int review_no) {

		ReviewVO reviewvo = sqlSession.selectOne(NAMESPACE + ".select_review_by_no", review_no);

		return reviewvo;
	} // end select_review_by_no(review_no)
	
	@Override
	public ImgVO select_review_profile(int mno) {
		
		return sqlSession.selectOne(NAMESPACE + ".select_review_profile", mno);
	} // end select_review_profile(mno)
	
	@Override
	public PersonalVO select_review_personal(int mno) {

		return sqlSession.selectOne(NAMESPACE + ".select_review_personal", mno);
	} // end select_review_personal(mno)
	
	@Override
	public String select_review_region_name(int review_no) {
		
		return sqlSession.selectOne(NAMESPACE + ".select_review_region_name", review_no);
	} // end select_review_region_name(review_no)
	
	
	
	@Override
	public ReviewVO selectReviewInfo(int review_no) {
		
		return sqlSession.selectOne(NAMESPACE + ".select_ReviewInfo_by_review_no", review_no);
	} // end selectReviewInfo(review_no)
	
	@Override
	public ReviewRegionVO selectReviewRegionInfo(int review_no) {
		
		return sqlSession.selectOne(NAMESPACE + ".select_ReviewRegionInfo_by_review_no", review_no);
	} // end selectReviewRegionInfo(review_no)
	
	@Override
	public ImgVO selectReviewMainImage(int review_no) {
		
		return sqlSession.selectOne(NAMESPACE + ".select_ReviewMainImage_by_review_no", review_no);
	} // end selectReviewMainImage(review_no)
	
	
	
	







	/**
	 * BestVO
	 */
	@Override
	public int insertBest(BestVO bestvo) {
		// TODO Auto-generated method stub
		return 0;
	} // end insertBest(bestvo)

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 메인페이지 디폴트 4개 조회수순으로 뿌리기
	@Override
	public List<ImgVO> select_review_top_image() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_top_review_image");
	}

	@Override
	public List<ReviewVO> select_review_top_title() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_top_review_title");
	}

	@Override
	public List<ReviewRegionVO> select_review_top_region() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_top_review_region");
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 메인/후기 게시판 - 디폴트 4개 후기 등록순 뿌리기
	// 이미지 가져오기
	@Override
	public List<ImgVO> select_review_default_image() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_default_review_image");
	}

	// 제목 가져오기
	@Override
	public List<ReviewVO> select_review_default_title() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_default_review_title");
	}

	// 지역 가져오기
	@Override
	public List<ReviewRegionVO> select_review_default_region() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".select_default_review_region");
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 후기 게시판 - 지역 검색
	// 이미지 가져오기
	@Override
	public List<ImgVO> select_review_region_image(String region_name) {
		// TODO Auto-generated method stub
		region_name = "%" + region_name + "%";
		return sqlSession.selectList(NAMESPACE + ".select_region_search_image", region_name);
	}

	// 제목 가져오기
	@Override
	public List<ReviewVO> select_review_region_title(String region_name) {
		// TODO Auto-generated method stub
		region_name = "%" + region_name + "%";
		return sqlSession.selectList(NAMESPACE + ".select_region_search_title", region_name);
	}

	// 지역 가져오기
	@Override
	public List<ReviewRegionVO> select_review_region_region(String region_name) {
		// TODO Auto-generated method stub
		region_name = "%" + region_name + "%";
		return sqlSession.selectList(NAMESPACE + ".select_region_search_region", region_name);
	}


	@Override
	public List<NickReviewSearchResultDTO> select_review_by_nickname(String region_name, String nickname) {
		
		List<NickReviewSearchResultDTO> list = null;
		
		if (!region_name.equals("없음") && !nickname.equals("없음")) {
			
			NickReviewSearchDTO vo = new NickReviewSearchDTO("%" + region_name + "%", nickname);
			list = sqlSession.selectList(NAMESPACE2 + ".select_nickname_search_11", vo);
			
		} else if (!region_name.equals("없음") && nickname.equals("없음")) {
			
			NickReviewSearchDTO vo = new NickReviewSearchDTO("%" + region_name + "%", nickname);
			list = sqlSession.selectList(NAMESPACE2 + ".select_nickname_search_10", vo);
			
		} else if (region_name.equals("없음") && !nickname.equals("없음")) {
			
			NickReviewSearchDTO vo = new NickReviewSearchDTO(region_name, nickname);
			list = sqlSession.selectList(NAMESPACE2 + ".select_nickname_search_01", vo);
			
		} else if (region_name.equals("없음") && nickname.equals("없음")) {
			
			NickReviewSearchDTO vo = new NickReviewSearchDTO(region_name, nickname);
			list = sqlSession.selectList(NAMESPACE2 + ".select_nickname_search_00", vo);
			
		}
		
		return list;
	}

	// 조회수 조회
	@Override
	public int select_current_review_hits(int review_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".select_current_review_hits", review_no);
	}

	// 조회수 업데이트
	@Override
	public int update_review_hits(ReviewVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".update_review_hits", vo);
	}
	
	
	// 현재 따봉 상태
	@Override
	public int selectReviewLike(int review_no, int mno) {
		// TODO Auto-generated method stub
		logger.info("리뷰 번호: " + review_no);
		BestVO vo = new BestVO(mno, review_no, 0);
		return sqlSession.selectOne(NAMESPACE + ".selectReviewLike", vo);
	}

	// 따봉 추가
	@Override
	public int insertReviewLike(int review_no, int mno) {
		// TODO Auto-generated method stub
		BestVO vo = new BestVO(mno, review_no, 1);
		return sqlSession.insert(NAMESPACE + ".insertReviewLike", vo);
	}
	
	// 따봉 삭제 
	@Override
	public int deleteReviewLike(int review_no, int mno) {
		BestVO vo = new BestVO(mno, review_no, 0);
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + ".deleteReviewLike", vo);
	}

	@Override
	public int update_review_best(int review_no) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".update_review_best", review_no);
	}

} // end class TourReviewDAOImpl