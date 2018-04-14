package com.sj.project.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.ReviewReplyVO;

@Repository
public class TourReviewReplyDAOImpl implements TourReviewReplyDAO {
	
	private static final String NAMESPACE = "com.sj.project.TourReviewReplyMapper";
	private static final Logger logger = LoggerFactory.getLogger(TourReviewReplyDAOImpl.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReviewReplyVO reviewreplyvo) {
		logger.info("insert() 호출...");
		
		return sqlSession.insert(NAMESPACE + ".insert", reviewreplyvo);
	} // end insert(reviewreplyvo)

	@Override
	public List<ReviewReplyVO> select(int review_no) {
		logger.info("select() 호출...");
		logger.info("review_no : " + review_no);
		
		return sqlSession.selectList(NAMESPACE + ".select", review_no);
	} // end select(review_no)

	@Override
	public int update(ReviewReplyVO reviewreplyvo) {
		logger.info("update() 호출...");
		logger.info("rno : " + reviewreplyvo.getRno());
		
		
		return sqlSession.update(NAMESPACE + ".update", reviewreplyvo);
	} // end update(reviewreplyvo)

	@Override
	public int delete(int rno) {
		logger.info("delete() 호출...");
		logger.info("rno : " + rno);
		
		return sqlSession.delete(NAMESPACE + ".delete", rno);
	} // end delete(rno)

	@Override
	public int allDelete(int parentrno) {
		logger.info("delete() 호출...");
		logger.info("rno : " + parentrno);
		
		return sqlSession.delete(NAMESPACE + ".alldelete", parentrno);
	} // end allDelete(parentrno)

	@Override
	public List<PersonalVO> selectPerson(int review_no) {
		logger.info("selectPerson() 호출...");
		
		return sqlSession.selectList(NAMESPACE+".selectperson", review_no);
	} // end selectPerson(review_no)
	
	@Override
	public ImgVO selectProfile(int mno) {

		return sqlSession.selectOne(NAMESPACE+".selectProfile", mno);
	} // end selectProfile(mno)
	
	
} // end class TourReviewReplyDAOImpl