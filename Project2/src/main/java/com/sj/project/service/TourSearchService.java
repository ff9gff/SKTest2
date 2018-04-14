package com.sj.project.service;

import java.util.List;

import com.sj.project.domain.DetailSearchResultDTO;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.TourRegisterVO;

public interface TourSearchService {
	

	public abstract List<ImgVO> read_region(String region);
	
	public abstract List<ImgVO> read_region_date(TourRegisterVO vo);
	
	public abstract TourRegisterVO read_trip_by_no(int trip_no);

	public abstract ImgVO read_trip_profile(int mno);
	
	public abstract PersonalVO read_trip_person(int mno);
	
	public abstract String read_trip_region_name(int trip_no);	
	
	
	// 메인 썸네일 기간검색(사진 밑에 나올 제목/지역)
	public abstract List<TourRegisterVO> read_main_title_info(TourRegisterVO vo);
	public abstract List<RegionVO> read_main_region_info(TourRegisterVO vo);
	
	public abstract TourRegisterVO readRegisterData(int trip_no); // ok
	
	// 메인 썸네일 지역검색(사진 밑에 나올 제목/지역)
	public abstract List<TourRegisterVO> read_main_title_region(String region);
	public abstract List<RegionVO> read_main_region_region(String region);
	
	
	// 메인 페이지 여행 기본으로 뿌려줄 이미지
	public abstract List<ImgVO> read_default_image();
	public abstract List<TourRegisterVO> read_default_title();
	public abstract List<RegionVO> read_default_region();
	
	// 여행 상세검색
	public abstract List<DetailSearchResultDTO> read_detail_search_image(String region_name, String start_date, int condition_sex, int condition_age);

}
