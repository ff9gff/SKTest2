package com.sj.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.TourReplyVO;

@Repository
public class TourReplyDAOImpl implements TourReplyDAO {
	private static final String NAMESPACE = "com.sj.project.TourReplyMapper";
	private static final Logger logger = LoggerFactory.getLogger(TourReplyDAOImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(TourReplyVO vo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}// end insert()

	@Override
	public List<TourReplyVO> select(int trip_no) {
		logger.info("select() 호출: trip_no=" + trip_no);
		return sqlSession.selectList(NAMESPACE + ".select", trip_no);
	}

	@Override
	public int update(TourReplyVO vo) {
		logger.info("update() 호출: rno = " + vo.getRno());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int rno) {
		logger.info("delete() 호출: rno = " + rno);
		return sqlSession.delete(NAMESPACE + ".delete", rno);
	}

	@Override
	public int allDelete(int parentrno) {
		return sqlSession.delete(NAMESPACE + ".alldelete", parentrno);
	}

	@Override
	public List<PersonalVO> selectPerson(int trip_no) {
		return sqlSession.selectList(NAMESPACE+".selectperson", trip_no);
	}
}
