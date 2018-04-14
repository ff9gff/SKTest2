package com.sj.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.ReviewRegionVO;
import com.sj.project.domain.ReviewVO;
import com.sj.project.domain.TourRegisterVO;
import com.sj.project.persistence.MypageDAO;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private MypageDAO mypageDAO;

	@Override
	public PersonalVO selectpersonal(int mno) {
		
		return mypageDAO.selectpersonal(mno);
	}
	
	@Override
	public List<PersonalVO> readPerson(int mno) {
	
		return mypageDAO.selectPerson(mno);
	}
	
	@Override
	public List<ImgVO> read_mno(int mno) {
		List<ImgVO> list = mypageDAO.select_mno(mno);
		return list;
	}
	
	@Override
	public ImgVO readProfile(int mno) {
		// TODO Auto-generated method stub
		return mypageDAO.selectProfile(mno);
	}

	@Override
	public List<ImgVO> read_join_mno(int mno) {
		// TODO Auto-generated method stub
		return mypageDAO.select_join_mno(mno);
	}

	@Override
	public List<TourRegisterVO> read_mytour_title(int mno) {

		return mypageDAO.select_mytour_title(mno);
	}

	@Override
	public List<RegionVO> read_mytour_region(int mno) {

		return mypageDAO.select_mytour_region(mno);
	}
	
	@Override
	public List<TourRegisterVO> read_mytourjoin_title(int mno) {
	
		return mypageDAO.select_mytourjoin_title(mno);
	}
	
	@Override
	public List<RegionVO> read_mytourjoin_region(int mno) {
	
		return mypageDAO.select_mytourjoin_region(mno);
	}
	
	@Override
	public int update_profile(PersonalVO vo) {
	
		return mypageDAO.updateProfile(vo);
	}
	
	// 후기 게시글 
	@Override
	public List<ImgVO> read_review_mno(int mno) {

		return mypageDAO.select_review_mno(mno);
	}
	
	// 후기 게시글 타이틀
	@Override
	public List<ReviewVO> read_review_title(int mno) {
	
		return mypageDAO.select_review_title(mno);
	}
	
	// 후기 게시르 지역
	@Override
	public List<ReviewRegionVO> read_review_region(int mno) {
	
		return mypageDAO.select_review_region(mno);
	}

}
