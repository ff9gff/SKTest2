package com.sj.project.persistence;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.TourRegisterVO;

public interface TourRegisterDAO {

	public abstract int insert(TourRegisterVO vo);

	public abstract int insertThumnail(ImgVO vo);

	public abstract int selectTrip_no(TourRegisterVO vo);

	public abstract int insertRegion(RegionVO vo);

	public abstract int update(TourRegisterVO vo);

	public abstract int updateThumnail(ImgVO vo);

	public abstract int updateRegion(RegionVO vo);

	// 여행 삭제
	public abstract int delete(int trip_no);

	// 썸네일 삭제
	public abstract int deleteThumnail(int trip_no);

	// 지역 삭제
	public abstract int deleteRegion(int trip_no);
	
	////////////////////////////////////////////////////////
	
	// 여행 게시글에서 수정버튼 클릭 --> 수정페이지로 데이터 넘기기위한 select
	public abstract TourRegisterVO selectTourInfo(int trip_no);
	public abstract RegionVO selectTourRegionInfo(int trip_no);
	public abstract ImgVO selectTourMainImage(int trip_no);

}
