package com.sj.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.DetailSearchDTO;
import com.sj.project.domain.DetailSearchResultDTO;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.TourRegisterVO;

@Repository
public class TourSearchDAOImpl implements TourSearchDAO {

	private static final String NAMESPACE2 =
			"com.sj.project.TourSearchMapper";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public List<ImgVO> select_region_date(TourRegisterVO vo) {
		List<ImgVO> list = sqlSession.selectList(NAMESPACE2 + ".select_main_trip_image", vo);
		return list;
	}
	
	@Override
	public TourRegisterVO select_trip_by_no(int trip_no) {
		TourRegisterVO vo = sqlSession.selectOne(NAMESPACE2 + ".select_trip_by_no", trip_no);
		return vo;
	}
	
	@Override
	public PersonalVO select_trip_person(int mno) {
		return sqlSession.selectOne(NAMESPACE2+".select_trip_person", mno);
	}

	@Override
	public ImgVO select_trip_profile(int mno) {
		return sqlSession.selectOne(NAMESPACE2+".select_trip_profile", mno);
	}
	
	@Override
	public String select_trip_region_name(int trip_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE2+".select_trip_region_name", trip_no);
	}

	@Override
	public List<TourRegisterVO> select_main_title_info(TourRegisterVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE2 + ".select_main_trip_title", vo);
	}

	@Override
	public List<RegionVO> select_main_region_info(TourRegisterVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE2 + ".select_main_trip_region", vo);
	}

	@Override
	public TourRegisterVO select_register_data(int trip_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE2 + ".select_register_data", trip_no);
	}
	
	
	
	@Override
	public List<ImgVO> select_region(String region) {
		region = "%" + region + "%";
		List<ImgVO> list = sqlSession.selectList(NAMESPACE2 + ".select_main_image_region", region);
		return list;
	}

	@Override
	public List<TourRegisterVO> select_main_title_region(String region) {
		// TODO Auto-generated method stub
		region = "%" + region + "%";
		return sqlSession.selectList(NAMESPACE2 + ".select_main_title_region", region);
	}

	@Override
	public List<RegionVO> select_main_region_region(String region) {
		// TODO Auto-generated method stub
		region = "%" + region + "%";
		return sqlSession.selectList(NAMESPACE2 + ".select_main_region_region", region);
	}

	@Override
	public List<ImgVO> select_default_image() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE2 + ".select_default_image", null);
	}

	@Override
	public List<TourRegisterVO> select_default_title() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE2 + ".select_default_title", null);
	}

	@Override
	public List<RegionVO> select_default_region() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE2 + ".select_default_region", null);
	}

	public List<DetailSearchResultDTO> select_detail_search_image(String region_name, String start_date, int condition_sex,	int condition_age) {
		
		List<DetailSearchResultDTO> list = null;
		if (!region_name.equals("없음") && start_date.equals("없음") && condition_sex == 2 && condition_age == 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO("%" + region_name + "%", null, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_1000", vo);
			
		} else if (!region_name.equals("없음") && !start_date.equals("없음") && condition_sex == 2 && condition_age == 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO("%" + region_name + "%", start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_1100", vo);
			
		} else if (!region_name.equals("없음") && !start_date.equals("없음") && condition_sex != 2 && condition_age == 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO("%" + region_name + "%", start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_1110", vo);
			
		} else if (!region_name.equals("없음") && !start_date.equals("없음") && condition_sex != 2 && condition_age != 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO("%" + region_name + "%", start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_1111", vo);
	
		} else if (!region_name.equals("없음") && !start_date.equals("없음") && condition_sex == 2 && condition_age != 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO("%" + region_name + "%", start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_1101", vo);
			
		} else if (!region_name.equals("없음") && start_date.equals("없음") && condition_sex != 2 && condition_age != 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO("%" + region_name + "%", start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_1011", vo);
			
		} else if (!region_name.equals("없음") && start_date.equals("없음") && condition_sex != 2 && condition_age == 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO("%" + region_name + "%", start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_1010", vo);
			
		} else if (!region_name.equals("없음") && start_date.equals("없음") && condition_sex == 2 && condition_age != 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO("%" + region_name + "%", start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_1001", vo);
			
		} else if (region_name.equals("없음") && !start_date.equals("없음") && condition_sex == 2 && condition_age == 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO(null, start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_0100", vo);
			
		} else if (region_name.equals("없음") && !start_date.equals("없음") && condition_sex == 2 && condition_age != 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO(null, start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_0101", vo);
			
		} else if (region_name.equals("없음") && !start_date.equals("없음") && condition_sex != 2 && condition_age == 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO(null, start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_0110", vo);
			
		} else if (region_name.equals("없음") && !start_date.equals("없음") && condition_sex != 2 && condition_age != 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO(null, start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_0111", vo);
			
		} else if (region_name.equals("없음") && start_date.equals("없음") && condition_sex != 2 && condition_age != 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO(null, start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_0011", vo);
			
		} else if (region_name.equals("없음") && start_date.equals("없음") && condition_sex != 2 && condition_age == 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO(null, start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_0010", vo);
			
		} else if (region_name.equals("없음") && start_date.equals("없음") && condition_sex == 2 && condition_age != 4) {
			
			DetailSearchDTO vo = new DetailSearchDTO(null, start_date, condition_sex, condition_age);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_0001", vo);
			
		} else if (region_name.equals("없음") && start_date.equals("없음")) {
			
			DetailSearchDTO vo = new DetailSearchDTO(null, start_date, 99, 99);
			list =  sqlSession.selectList(NAMESPACE2 + ".select_detail_search_0000", vo);
			
		}
		
		return list;
	}

}
