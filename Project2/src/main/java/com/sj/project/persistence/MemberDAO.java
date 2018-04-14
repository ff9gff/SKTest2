package com.sj.project.persistence;

import java.util.List;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.MemberVO;
import com.sj.project.domain.PersonalVO;

public interface MemberDAO {

   // MemberVO
   public abstract MemberVO login(MemberVO membervo);

   public abstract String selectUserid(String userid);

   public abstract int insertMember(MemberVO membervo);

   public abstract int selectUserMno(String userid);

   
   // PersonalVO
   public abstract String selectNickname(String nickname);

   public abstract int insertPersional(PersonalVO personalvo);
   
   public abstract String getNickname(int mno);
   
   
   
   //
   public abstract List<String> find_id(String name, String phone, String email);
   public abstract String find_pwd(String userid, String name, String phone, String email);
   
   
   
   // ImgVO
   public abstract int insertProfile(ImgVO imgvo);

   /**
    *
    */
   public abstract MemberVO select(int mno);

} // end interface MemberDAO