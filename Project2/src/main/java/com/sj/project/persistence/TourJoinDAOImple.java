package com.sj.project.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.TourJoinVO;

@Repository
public class TourJoinDAOImple implements TourJoinDAO {
	private static final String NAMESPACE=
			"com.sj.project.TourJoinMapper";
	private static final Logger logger=
			LoggerFactory.getLogger(TourJoinDAOImple.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<TourJoinVO> selectList(int trip_no) {
		logger.info("select() 호출: trip_no="+trip_no);
		return sqlSession.selectList(NAMESPACE+".selectlist", trip_no);
	}
	
	@Override
	public List<PersonalVO> selectPerson(int trip_no) {
		return sqlSession.selectList(NAMESPACE+".selectperson", trip_no);
	}
	
	@Override
	public int updateApproval(int approval, int list_no) {
		System.out.println("approval="+approval);
		System.out.println("list_no="+list_no);
		Map<String, Integer> value = new HashMap<>();
		value.put("approval", approval);
		value.put("list_no", list_no);
		return sqlSession.update(NAMESPACE+".updateapproval",value);
	}
	
	@Override
	public int insertApproval(int trip_no, int mno) {
		Map<String, Integer> value = new HashMap<>();
		value.put("trip_no", trip_no);
		value.put("mno", mno);
		return sqlSession.insert(NAMESPACE+".insert", value);
	}

	@Override
	public ImgVO selectProfile(int mno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".selectProfile", mno);
	}
	
	@Override
	public int endTrip(int trip_no) {
		return sqlSession.update(NAMESPACE+".endtrip",trip_no);
	}
	
}
