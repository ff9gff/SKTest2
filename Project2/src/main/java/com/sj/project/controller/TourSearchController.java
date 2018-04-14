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

import com.sj.project.domain.DetailSearchResultDTO;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.TourRegisterVO;

import com.sj.project.service.TourSearchService;

@Controller
public class TourSearchController {
	private static final Logger logger = LoggerFactory.getLogger(TourSearchController.class);

	@Autowired
	private TourSearchService tourSelectService;


	// 지역 검색 Ajax 처리
	// 해당 지역 검색 메소드
	@RequestMapping(value = "/index/defaultimage", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxTotalImageTest() {

		ResponseEntity<List<ImgVO>> entity = null;

		List<ImgVO> list = tourSelectService.read_default_image();

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.OK);
			logger.info("이미지 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("이미지 전체 검색 실패 ");
		}


		logger.info("entity " + entity.getBody());
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 지역 검색 Ajax 처리
	// 해당 지역 썸네일 이미지 아래 제목 검색 메소드
	@RequestMapping(value = "/index/defaulttitle", method = RequestMethod.GET)
	public ResponseEntity<List<TourRegisterVO>> ajaxTotalTitleTest() {

		ResponseEntity<List<TourRegisterVO>> entity = null;

		List<TourRegisterVO> list = tourSelectService.read_default_title();

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.OK);
			logger.info("제목 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("제목 전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 지역 검색 Ajax 처리
	// 해당 지역 썸네일 이미지 아래 지역 검색 메소드
	@RequestMapping(value = "/index/defaultregion", method = RequestMethod.GET)
	public ResponseEntity<List<RegionVO>> ajaxTotalRegionTest() {

		ResponseEntity<List<RegionVO>> entity = null;

		List<RegionVO> list = tourSelectService.read_default_region();

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.OK);
			logger.info("지역 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("지역  전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 지역 검색 Ajax 처리
	// 해당 지역 검색 메소드
	@RequestMapping(value = "/index/regionimage/{region_name}", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxRegionImageTest(@PathVariable("region_name") String region_name) {
		logger.info("여행 지역: " + region_name);
		ResponseEntity<List<ImgVO>> entity = null;

		List<ImgVO> list = tourSelectService.read_region(region_name);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.OK);
			logger.info("지역 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("지역 검색 실패 ");
		}

		logger.info("entity " + entity.getBody());
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 지역 검색 Ajax 처리
	// 해당 지역 썸네일 이미지 아래 제목 검색 메소드
	@RequestMapping(value = "/index/regiontitle/{region_name}", method = RequestMethod.GET)
	public ResponseEntity<List<TourRegisterVO>> ajaxRegionTitleTest(@PathVariable("region_name") String region_name) {

		logger.info("여행 지역: " + region_name);
		ResponseEntity<List<TourRegisterVO>> entity = null;

		List<TourRegisterVO> list = tourSelectService.read_main_title_region(region_name);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.OK);
			logger.info("지역  - 제목 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("지역  - 제목 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 지역 검색 Ajax 처리
	// 해당 지역 썸네일 이미지 아래 지역 검색 메소드
	@RequestMapping(value = "/index/regionregion/{region_name}", method = RequestMethod.GET)
	public ResponseEntity<List<RegionVO>> ajaxRegionRegionTest(@PathVariable("region_name") String region_name) {
		logger.info("여행 지역: " + region_name);

		ResponseEntity<List<RegionVO>> entity = null;

		List<RegionVO> list = tourSelectService.read_main_region_region(region_name);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.OK);
			logger.info("지역  - 지역 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("지역  - 지역 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 기간 검색 Ajax 처리
	// 해당 기간 썸네일 이미지 검색 메소드
	@RequestMapping(value = "/index/periodimage/{start_date}/{end_date}", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxPeriodImageTest(@PathVariable("start_date") String start_date,
			@PathVariable("end_date") String end_date) {
		logger.info("시작 날짜: " + start_date);
		logger.info("종료 날짜: " + end_date);

		ResponseEntity<List<ImgVO>> entity = null;

		TourRegisterVO vo2 = new TourRegisterVO(0, 0, null, 0, 0, null, null, start_date, end_date, 0);

		List<ImgVO> list = tourSelectService.read_region_date(vo2);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.OK);
			logger.info("기간 이미지 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("기간 이미지 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 기간 검색 Ajax 처리
	// 해당 기간 썸네일 이미지 아래 제목 검색 메소드
	@RequestMapping(value = "/index/periodtitle/{start_date}/{end_date}", method = RequestMethod.GET)
	public ResponseEntity<List<TourRegisterVO>> ajaxPeriodTitleTest(@PathVariable("start_date") String start_date,
			@PathVariable("end_date") String end_date) {
		logger.info("시작 날짜: " + start_date);
		logger.info("종료 날짜: " + end_date);

		ResponseEntity<List<TourRegisterVO>> entity = null;

		TourRegisterVO vo2 = new TourRegisterVO(0, 0, null, 0, 0, null, null, start_date, end_date, 0);

		List<TourRegisterVO> list = tourSelectService.read_main_title_info(vo2);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.OK);
			logger.info("기간  - 제목 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("기간  - 제목 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 기간 검색 Ajax 처리
	// 해당 기간 썸네일 이미지 아래 지역 검색 메소드
	@RequestMapping(value = "/index/periodregion/{start_date}/{end_date}", method = RequestMethod.GET)
	public ResponseEntity<List<RegionVO>> ajaxPeriodRegionTest(@PathVariable("start_date") String start_date,
			@PathVariable("end_date") String end_date) {
		logger.info("시작 날짜: " + start_date);
		logger.info("종료 날짜: " + end_date);

		ResponseEntity<List<RegionVO>> entity = null;

		TourRegisterVO vo2 = new TourRegisterVO(0, 0, null, 0, 0, null, null, start_date, end_date, 0);

		List<RegionVO> list = tourSelectService.read_main_region_info(vo2);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.OK);
			logger.info("기간  - 지역 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("기간  - 지역 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 상세 검색 Ajax 처리
	@RequestMapping(value = "/index/detailsearchImage/{region_name}/{start_date}/{condition_sex}/{condition_age}", method = RequestMethod.GET)
	public ResponseEntity<List<DetailSearchResultDTO>> ajaxDetailSearchImageTest(@PathVariable("region_name") String region_name,
			@PathVariable("start_date") String start_date, @PathVariable("condition_sex") int condition_sex,
			@PathVariable("condition_age") int condition_age) {
		logger.info("여행 지역: " + region_name);
		logger.info("시작 날짜: " + start_date);
		logger.info("성별 구분: " + condition_sex);
		logger.info("나이 구분: " + condition_age);		
		
		List<DetailSearchResultDTO> list = tourSelectService.read_detail_search_image(region_name, start_date, condition_sex, condition_age);

		ResponseEntity<List<DetailSearchResultDTO>> entity = null;

		if (list != null) {	
			// select 성공 한것이다.
			entity = new ResponseEntity<List<DetailSearchResultDTO>>(list, HttpStatus.OK);
			logger.info("상세검색(지역) 이미지 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<DetailSearchResultDTO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("상세검색(지역) 이미지 검색 실패 ");
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