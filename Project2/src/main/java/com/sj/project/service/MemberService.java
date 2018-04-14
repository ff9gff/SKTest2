package com.sj.project.service;

import java.util.List;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.MemberVO;
import com.sj.project.domain.PersonalVO;

// 비즈니스 로직을 구현하는 인터페이스
// CRUD: Create, Read, Update, Delete
public interface MemberService {

   // MemberVO
   public abstract MemberVO login(MemberVO membervo);

   public abstract String readUserid(String userid);

   public abstract int createMember(MemberVO membervo);

   public abstract int readMnobyUserid(String userid);

   
   // PersonalVO
   public abstract String readNickname(String nickname);

   public abstract int createPersional(PersonalVO personalvo);
   
   public abstract String getNickname(int mno);
   
   
   // ImgVO
   public abstract int createProfile(ImgVO imgvo);
   
   /**
    * 
    */
   public abstract List<String> find_id(String name, String phone, String email);
   public abstract String find_pwd(String userid, String name, String phone, String email);
   

   // 특정 회원 검색

   // PersonalVO

   // Create: 새로운 회원 가입
   // public abstract int create(MemberVO vo);
   // Read 1: 회원 전체 검색

   // Read 2: 특정 회원(userid) 검색

   // Update: 특정 회원(userid)의 비번(pwd)과 이메일(email) 수정
   // public abstract int update(MemberVO vo);
   // Delete: 특정 회원(userid)의 정보 삭제
   // public abstract int delete(String userid);

} // end interface MemberService