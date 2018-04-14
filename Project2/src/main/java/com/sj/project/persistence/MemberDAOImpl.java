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
import com.sj.project.domain.MemberVO;
import com.sj.project.domain.PersonalVO;

//@Component // 스프링에서 Component 빈으로 관리
@Repository // 스프링에서 DAO Componet 빈으로 관리
public class MemberDAOImpl implements MemberDAO {

   private static final String NAMESPACE = "com.sj.project.MemberMapper";
   private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

   // DB insert/update/delete/select 동작들은
   // SqlSession 객체를 사용해서 이루어지게 됨
   @Autowired
private SqlSession sqlSession;

   /*
    * MemberVO
    */
   @Override
   public MemberVO login(MemberVO membervo) {
      logger.info("login() 호출...");

      return sqlSession.selectOne(NAMESPACE + ".login", membervo);
   } // end login(vo)

   @Override
   public String selectUserid(String userid) {
      logger.info("selectUserid() 호출...");

      return sqlSession.selectOne(NAMESPACE + ".select-by-userid", userid);
   } // end select(userid)

   @Override
   public int insertMember(MemberVO membervo) {
      int member_result = sqlSession.insert(NAMESPACE + ".member-insert", membervo);

      return member_result;
   } // end insertMember(membervo)

   @Override
   public int selectUserMno(String userid) {

      return sqlSession.selectOne(NAMESPACE + ".select-by-userid2", userid); // Mno
                                                            // 리턴
   } // end selectUserMno

   /*
    * PersonalVO
    */
   @Override
   public String selectNickname(String nickname) {
      logger.info("selectNickname() 호출...");

      return sqlSession.selectOne(NAMESPACE + ".select-by-nickname", nickname);
   } // end select(nickname)

   @Override
   public int insertPersional(PersonalVO personalvo) {

      return sqlSession.insert(NAMESPACE + ".personal-insert", personalvo);
   }// end insertPersional(personalvo)
   
   @Override
	public String getNickname(int mno) {
		
		return sqlSession.selectOne(NAMESPACE + ".get-nickname", mno);
	} // end getNicknamemno)
   
   
   /*
    * ImgVO
    */
   @Override
   public int insertProfile(ImgVO imgvo) {

      return sqlSession.insert(NAMESPACE + ".profile-insert", imgvo);
   } // end insertProfile(imgvo)
   
   
   

   /***
    * 
    */
  @Override
	public List<String> find_id(String name, String phone, String email) {
	  Map<String, String> args = new HashMap<>();
	  args.put("name", name);
	  args.put("phone", phone);
	  args.put("email", email);
	  
	  return sqlSession.selectList(NAMESPACE + ".find_id", args);	  
	} // end find_id(String name, String phone, String email)

  @Override
	public String find_pwd(String userid, String name, String phone, String email) {
	  Map<String, String> args = new HashMap<>();
	  args.put("userid", userid);
	  args.put("name", name);
	  args.put("phone", phone);
	  args.put("email", email);
	  
	  return sqlSession.selectOne(NAMESPACE + ".find_pwd", args);
	}
  
   
   /**
    * 
    */

   @Override
   public MemberVO select(int mno) {
      // TODO Auto-generated method stub
      return null;
   }



} // end class MemberDAOImpl