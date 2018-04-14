package com.sj.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.MemberVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.persistence.MemberDAO;

//@Component // 스프링 프레임워크가 bean으로 관리하는 클래스
@Service // 스프링 프레임워크가 Service bean으로 관리하는 클래스
public class MemberServiceImpl implements MemberService {

   @Autowired
   private MemberDAO memberDAO;

   /*
    * MemberVO
    */

   @Override
   public MemberVO login(MemberVO membervo) {

      return memberDAO.login(membervo);
   } // end login(vo)

   @Override
   public String readUserid(String userid) {

      return memberDAO.selectUserid(userid);
   } // end readUserid(userid)

   @Override
   public int createMember(MemberVO membervo) {

      return memberDAO.insertMember(membervo);
   } // end createMember(membervo)

   @Override
   public int readMnobyUserid(String userid) {

      return memberDAO.selectUserMno(userid);
   } // end readMember(userid)

   /*
    * PersonalVO
    */
   @Override
   public String readNickname(String nickname) {

      return memberDAO.selectNickname(nickname);
   } // end readNickname(nickname)

   @Override
   public int createPersional(PersonalVO personalvo) {

      return memberDAO.insertPersional(personalvo);
   } // end createPersional(personalvo)
   
   @Override
	public String getNickname(int mno) {

		return memberDAO.getNickname(mno);
	} // end getNickname(mno)
   
   /*
    * 
    */
   @Override
   public int createProfile(ImgVO imgvo) {
      
      return memberDAO.insertProfile(imgvo);
   } // end createProfile(imgvo)

   /**
    * 
    */
   @Override
	public List<String> find_id(String name, String phone, String email) {
		
		return memberDAO.find_id(name, phone, email);
	}
   
   @Override
	public String find_pwd(String userid, String name, String phone, String email) {

		return memberDAO.find_pwd(userid, name, phone, email);
	}

} // end class MemberServiceImpl