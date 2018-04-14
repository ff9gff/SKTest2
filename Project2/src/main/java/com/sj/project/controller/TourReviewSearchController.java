package com.sj.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.NickReviewSearchResultDTO;
import com.sj.project.domain.ReviewRegionVO;
import com.sj.project.domain.ReviewVO;
import com.sj.project.service.TourReviewService;

@Controller
public class TourReviewSearchController {
	private static final Logger logger = LoggerFactory.getLogger(TourReviewSearchController.class);

	@Autowired
	private TourReviewService tourReviewService;

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 메인 페이지 디폴트 조회수 Top 4 후기 이미지
	@RequestMapping(value = "/review/Topdefaultimage", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxReviewTopImageTest() {

		ResponseEntity<List<ImgVO>> entity = null;

		List<ImgVO> list = tourReviewService.read_review_top_image();

		if (list != null) {
			// select 성공 한것이다.			
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.OK);
			logger.info("Top후기 이미지 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("Top후기 이미지 검색 실패 ");
		}

		logger.info("entity " + entity.getBody());
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 디폴트 ?개 후기 제목
	@RequestMapping(value = "/review/Topdefaulttitle", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewVO>> ajaxReviewTopTitleTest() {

		ResponseEntity<List<ReviewVO>> entity = null;

		List<ReviewVO> list = tourReviewService.read_review_top_title();

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ReviewVO>>(list, HttpStatus.OK);
			logger.info("Top후기 제목 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ReviewVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("Top후기 제목 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 디폴트 ?개 후기 지역
	@RequestMapping(value = "/review/Topdefaultregion", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewRegionVO>> ajaxReviewTopRegionTest() {

		ResponseEntity<List<ReviewRegionVO>> entity = null;

		List<ReviewRegionVO> list = tourReviewService.read_review_top_region();

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ReviewRegionVO>>(list, HttpStatus.OK);
			logger.info("Top후기 지역  검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ReviewRegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("Top후기 지역  검색 성공 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 메인 페이지 디폴트 최신순 4개 후기 이미지
	@RequestMapping(value = "/review/defaultimage", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxReviewTotalImageTest() {

		ResponseEntity<List<ImgVO>> entity = null;

		List<ImgVO> list = tourReviewService.read_review_default_image();

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.OK);
			logger.info("후기 이미지 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("후기 이미지 전체 검색 실패 ");
		}

		logger.info("entity " + entity.getBody());
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 디폴트 ?개 후기 제목
	@RequestMapping(value = "/review/defaulttitle", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewVO>> ajaxReviewTotalTitleTest() {

		ResponseEntity<List<ReviewVO>> entity = null;

		List<ReviewVO> list = tourReviewService.read_review_default_title();

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ReviewVO>>(list, HttpStatus.OK);
			logger.info("후기 제목 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ReviewVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("후기 제목 전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 디폴트 ?개 후기 지역
	@RequestMapping(value = "/review/defaultregion", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewRegionVO>> ajaxReviewTotalRegionTest() {

		ResponseEntity<List<ReviewRegionVO>> entity = null;

		List<ReviewRegionVO> list = tourReviewService.read_review_default_region();

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ReviewRegionVO>>(list, HttpStatus.OK);
			logger.info("후기 지역 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ReviewRegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("후기 지역  전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 후기 게시판 - 지역검색 - 이미지 가져오기
	@RequestMapping(value = "/review/regionimage/{region_name}", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxReviewRegionImageTest(@PathVariable("region_name") String region_name) {

		ResponseEntity<List<ImgVO>> entity = null;

		List<ImgVO> list = tourReviewService.read_review_region_image(region_name);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.OK);
			logger.info("후기 이미지 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("후기 이미지 검색 실패 ");
		}

		logger.info("entity " + entity.getBody());
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 후기 게시판 - 지역검색 - 제목 가져오기
	@RequestMapping(value = "/review/regiontitle/{region_name}", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewVO>> ajaxReviewRegionTitleTest(@PathVariable("region_name") String region_name) {

		ResponseEntity<List<ReviewVO>> entity = null;

		List<ReviewVO> list = tourReviewService.read_review_region_title(region_name);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ReviewVO>>(list, HttpStatus.OK);
			logger.info("후기 제목 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ReviewVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("후기 제목 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 후기 게시판 - 지역검색 - 지역 가져오기
	@RequestMapping(value = "/review/regionregion/{region_name}", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewRegionVO>> ajaxReviewRegionRegionTest(
			@PathVariable("region_name") String region_name) {

		ResponseEntity<List<ReviewRegionVO>> entity = null;

		List<ReviewRegionVO> list = tourReviewService.read_review_region_region(region_name);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ReviewRegionVO>>(list, HttpStatus.OK);
			logger.info("후기 지역 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ReviewRegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("후기 지역 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 후기 게시판 - 지역/닉네임 선택 검색
	@RequestMapping(value = "/review/nickname/{region_name}/{nickname}", method = RequestMethod.GET)
	public ResponseEntity<List<NickReviewSearchResultDTO>> ajaxReviewNicknameTest(@PathVariable("region_name") String region_name, @PathVariable("nickname") String nickname) {

		logger.info("여행 지역: " + region_name);
		logger.info("닉네임: " + nickname);
		
		ResponseEntity<List<NickReviewSearchResultDTO>> entity = null;
		
		List<NickReviewSearchResultDTO> list = tourReviewService.read_review_by_nickname(region_name, nickname);
		
		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<NickReviewSearchResultDTO>>(list, HttpStatus.OK);
			logger.info("후기 선택 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<NickReviewSearchResultDTO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("후기 선택 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;

	}

	// 웹사이트에서 동일한 부분 코드 수정

	// 이클립스에서 동일한 부분 코드 수정
	// 이클립스에서 커밋앤푸쉬하려니 불가능!
	// 뭐지? 이상하네 싶어서 중앙리파지토리에서 pull을 했더니
	// 웹사이트, 이클립스에서 수정한 부분이 모두 뜬다!
	// 선택을 해야 한다! 뭐가 더 나은 코드인지 확인 후 필터링
	// 필터링이 다 됐으면 add to index를 하고
	// 커밋앤푸시를 하면 반영 완료!

	// 커밋만 하면 로컬리파지토리에만 저장된다.
	// 로컬에서 푸시를 해야 git허브에 저장된다

}