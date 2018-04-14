package com.sj.project.service;

import java.util.List;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.TourJoinVO;

public interface TourJoinService {
	public abstract List<TourJoinVO> readList(int trip_no);
	public abstract List<PersonalVO> readPerson(int trip_no);
	public abstract int create(int trip_no, int mno);
	public abstract int update(int approval, int list_no);
	public abstract ImgVO readProfile(int mno);
	public abstract int endTrip(int trip_no);
	
}
