package com.sj.project.persistence;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.TourRegisterVO;

@Repository
public class TourRegisterDAOImpl implements TourRegisterDAO {
	
	private static final String NAMESPACE = "com.sj.project.TourRegisterMapper";
	
	private static final Logger logger = LoggerFactory.getLogger(TourRegisterDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(TourRegisterVO vo) {
		return sqlSession.insert(NAMESPACE + ".insert-register", vo);
	}

	@Override
	public int insertThumnail(ImgVO vo) {
		// TODO Auto-generated method stub
		logger.info("test: " + vo.getBoard_type());
		logger.info("test: " + vo.getContent_no());
		logger.info("test: " + vo.getImg_url());
		return sqlSession.insert(NAMESPACE + ".insert-thumnail", vo);
	}

	@Override
	public int selectTrip_no(TourRegisterVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".select-trip_no", vo);
	}

	@Override
	public int insertRegion(RegionVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + ".insert-region", vo);
	}
	
	@Override
	public int update(TourRegisterVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".update-register", vo);
	}
	
	@Override
	public int updateThumnail(ImgVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".update-thumnail", vo);
	}
	
	@Override
	public int updateRegion(RegionVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + ".update-region", vo);
	}

	@Override
	public int delete(int trip_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + ".delete-register", trip_no);
	}

	@Override
	public int deleteThumnail(int trip_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + ".delete-thumnail", trip_no);
	}

	@Override
	public int deleteRegion(int trip_no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + ".delete-region", trip_no);
	}

	@Override
	public TourRegisterVO selectTourInfo(int trip_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".select_tourInfo_by_trip_no", trip_no);
	}

	@Override
	public RegionVO selectTourRegionInfo(int trip_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".select_tourRegionInfo_by_trip_no", trip_no);
	}

	@Override
	public ImgVO selectTourMainImage(int trip_no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".select_tourMainImage_by_trip_no", trip_no);
	}


}
