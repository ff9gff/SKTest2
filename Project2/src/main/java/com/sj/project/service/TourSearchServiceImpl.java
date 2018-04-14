package com.sj.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.DetailSearchResultDTO;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.TourRegisterVO;
import com.sj.project.persistence.TourSearchDAO;

@Service
public class TourSearchServiceImpl implements TourSearchService {
	
	@Autowired
	private TourSearchDAO dao;

	@Override
	public List<ImgVO> read_region(String region) {
		List<ImgVO> list = dao.select_region(region);
		return list;
	}
	
	@Override
	public List<ImgVO> read_region_date(TourRegisterVO vo) {
		List<ImgVO> list = dao.select_region_date(vo);
		return list;
	}


	@Override
	public TourRegisterVO read_trip_by_no(int trip_no) {
		TourRegisterVO vo = dao.select_trip_by_no(trip_no);
		return vo;
	}

	@Override
	public PersonalVO read_trip_person(int mno) {
		return dao.select_trip_person(mno);
	}
	
	@Override
	public ImgVO read_trip_profile(int mno) {
		// TODO Auto-generated method stub
		return dao.select_trip_profile(mno);
	}
	
	@Override
	public String read_trip_region_name(int trip_no) {
		// TODO Auto-generated method stub
		return dao.select_trip_region_name(trip_no);
	}

	@Override
	public List<TourRegisterVO> read_main_title_info(TourRegisterVO vo) {
		// TODO Auto-generated method stub
		return dao.select_main_title_info(vo);
	}

	@Override
	public List<RegionVO> read_main_region_info(TourRegisterVO vo) {
		// TODO Auto-generated method stub
		return dao.select_main_region_info(vo);
	}

	@Override
	public TourRegisterVO readRegisterData(int trip_no) {
		// TODO Auto-generated method stub
		return dao.select_register_data(trip_no);
	}

	@Override
	public List<TourRegisterVO> read_main_title_region(String region) {
		// TODO Auto-generated method stub
		return dao.select_main_title_region(region);
	}

	@Override
	public List<RegionVO> read_main_region_region(String region) {
		// TODO Auto-generated method stub
		return dao.select_main_region_region(region);
	}

	@Override
	public List<ImgVO> read_default_image() {
		// TODO Auto-generated method stub
		return dao.select_default_image();
	}

	@Override
	public List<TourRegisterVO> read_default_title() {
		// TODO Auto-generated method stub
		return dao.select_default_title();
	}

	@Override
	public List<RegionVO> read_default_region() {
		// TODO Auto-generated method stub
		return dao.select_default_region();
	}

	@Override
	public List<DetailSearchResultDTO> read_detail_search_image(String region_name, String start_date, int condition_sex,
			int condition_age) {
		return dao.select_detail_search_image(region_name, start_date, condition_sex, condition_age);
	}

}
