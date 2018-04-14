package com.sj.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.ReviewRegionVO;
import com.sj.project.domain.ReviewVO;
import com.sj.project.domain.TourRegisterVO;

@Repository
public class MypageDAOImpl implements MypageDAO {
	
	private static final String NAMESPACE = "com.sj.project.MypageMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public PersonalVO selectpersonal(int mno) {
		
		return sqlSession.selectOne(NAMESPACE + ".select-personalbymno", mno);
	}
	
	@Override
	public List<PersonalVO> selectPerson(int mno) {

		return sqlSession.selectList(NAMESPACE + ".select-personalbymno", mno);
	}
	
	@Override
	public List<ImgVO> select_mno(int mno) {
		List<ImgVO> list = sqlSession.selectList(NAMESPACE + ".select_trip_mno", mno);
		return list;
	}
	
	@Override
	public ImgVO selectProfile(int mno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".selectProfile", mno);
	}

	@Override
	public List<ImgVO> select_join_mno(int mno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".selectJoin", mno);
	}

	@Override
	public List<TourRegisterVO> select_mytour_title(int mno) {

		return sqlSession.selectList(NAMESPACE + ".select_mytour_title", mno);
	}

	@Override
	public List<RegionVO> select_mytour_region(int mno) {

		return sqlSession.selectList(NAMESPACE + ".select_mytour_region", mno);
	}
	
	// 내가 선택한 여행 게시글 타이틀
	public java.util.List<TourRegisterVO> select_mytourjoin_title(int mno) {
		
		return sqlSession.selectList(NAMESPACE + ".select_mytourjoin_title", mno);
	};
	
	// 내가 선택한 여행 게시글 지역
	public java.util.List<RegionVO> select_mytourjoin_region(int mno) {
		
		return sqlSession.selectList(NAMESPACE + ".select_mytourjoin_region", mno);
	};
	
	// 후기 게시글 이미지
	@Override
	public List<ImgVO> select_review_mno(int mno) {
		
		return sqlSession.selectList(NAMESPACE + ".selectreview", mno);
	}
	
	// 후기 게시글 타이틀
	@Override
	public List<ReviewVO> select_review_title(int mno) {
	
		return sqlSession.selectList(NAMESPACE + ".select_review_title", mno);
	}
	
	// 후기 게시글 지역
	@Override
	public List<ReviewRegionVO> select_review_region(int mno) {
	
		return sqlSession.selectList(NAMESPACE + ".select_review_region", mno);
	}
	
	@Override
	public int updateProfile(PersonalVO vo) {
	
		return sqlSession.update(NAMESPACE + ".update-profile", vo);
	}

}
