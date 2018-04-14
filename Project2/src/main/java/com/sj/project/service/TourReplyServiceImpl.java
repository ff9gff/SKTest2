package com.sj.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.TourReplyVO;
import com.sj.project.persistence.TourReplyDAO;

@Service
public class TourReplyServiceImpl implements TourReplyService {

	@Autowired
	private TourReplyDAO tourReplyDAO;
	
	@Override
	public int create(TourReplyVO vo) {
		int result = tourReplyDAO.insert(vo);
		return result;
	}

	@Override
	public List<TourReplyVO> read(int trip_no) {
		return tourReplyDAO.select(trip_no);
	}

	@Override
	public int update(TourReplyVO vo) {
		return tourReplyDAO.update(vo);
	}

	@Override
	public int delete(int rno) {
		return tourReplyDAO.delete(rno);
	}
	
	@Override
	public int allDelete(int parentrno) {
		return tourReplyDAO.allDelete(parentrno);
	}

	@Override
	public List<PersonalVO> readPerson(int trip_no) {
		return tourReplyDAO.selectPerson(trip_no);
	}
}
