package com.sj.project.persistence;

import java.util.List;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.TourJoinVO;



public interface TourJoinDAO {
	// 리스트 검색
	public abstract List<TourJoinVO> selectList(int trip_no);
	// 개인정보 검색
	public abstract List<PersonalVO> selectPerson(int trip_no);
	// 승인수정
	public abstract int updateApproval(int approval, int list_no);
	// 신청
	public abstract int insertApproval(int trip_no, int mno);
	
	public abstract ImgVO selectProfile(int mno);
	
	// 여행 마감
	public abstract int endTrip(int trip_no);
}
