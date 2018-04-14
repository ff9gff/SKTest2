package com.sj.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sj.project.domain.DomainDTO;
import com.sj.project.domain.MemberVO;
import com.sj.project.service.AdminService;
import com.sj.project.service.SearchUserService;

@RestController
@RequestMapping(value = "/users")
public class SearchUserRESTcontroller {

	private static final Logger logger = LoggerFactory.getLogger(SearchUserRESTcontroller.class);

	@Autowired
	private SearchUserService suRestService;

	
	@Autowired
	private AdminService adminService;

	// List는 강퇴에 대한 설정을 하기 위한 설정 입니다. 
	List<MemberVO> list2= new ArrayList<>();
	@RequestMapping(value = "/all/{userid}", method = RequestMethod.GET)
	public ResponseEntity<List<MemberVO>> readSearchUser(@PathVariable("userid") String userid) {
		logger.info("read My Search user ->" + userid);
		ResponseEntity<List<MemberVO>> entity = null;

		List<MemberVO> list = suRestService.readuser(userid);
		list2 = list;
		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<MemberVO>>(list, HttpStatus.OK);
			logger.info("select 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<MemberVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("select 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		
		return entity;

	}
	
//'/project/users/num/'+no; // 관리자 딜리트에 대한 설명 입니다. 
	@RequestMapping(value = "/num/{no}", method = RequestMethod.GET)
	public int DeleteUserLevel(@PathVariable("no") int no) {
		logger.info("" + no);
		logger.info("");
		try {
			
			logger.info(" 번호에 해당하는 유저의 권한 번호 보여주기 "+list2.get(no-1).getAuthority());
			adminService.updateLevelTwo(list2.get(no-1).getMno());
		} catch (Exception e) {
			logger.info("index 사이즈 오류 입니다. ");
		}//end exception 설정 합니다. 
		
		return 0;
		
	}
	
	
	@RequestMapping(value = "/deluser/{no}", method = RequestMethod.GET)
	public int UpdateUserLevel(@PathVariable("no") int no) {
		logger.info("" + no);
		
		
		
		logger.info("여기는 delete 입니다. ");
		
		try {
			
			logger.info(" 번호에 해당하는 유저의 권한 번호 보여주기 "+list2.get(no-1).getAuthority());
			//여기는 블랙 리스트를 만듭니다.     list2.get(no-1).getMno() 이게 바로 mno 정보이지 .
			adminService.downGradeLevel(list2.get(no-1).getMno());
		} catch (Exception e) {
			logger.info("index 사이즈 오류 입니다. ");
		}//end exception 설정 합니다. 
		
		return 0;

	}
	
	
	@RequestMapping(value = "/adTouser/{no}", method = RequestMethod.GET)
	public int downAdminToUser(@PathVariable("no") int no) {
		logger.info("되나 모르겠네" + no);
		List<DomainDTO> list2 = adminService.allMySubAdminActivUser();
		//updateLevelOne
		adminService.updateLevelOne(list2.get(no-1).getMno());
		
		logger.info("여기는 관리자에서 일반 유저로 보내는 곳 입니다. "+list2.get(no-1).getUserid()); // 출력 완료 
		
		
		
		return 0;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="updateLevelOne" , method=RequestMethod.PUT)
	public int upgradeLevel1(){
		
		logger.info("여기야 여기 살려죠 update ");
		List<Integer> list =adminService.readLevelZero();
		int result =0 ;
		
		try {
			for (int i = 0 ; i < list.size(); i++){
				
				adminService.updateLevelOne(Integer.parseInt(list.get(i).toString()));
				
			}//end for 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(list.size() !=0){
			return 1;
		}
		
		logger.info("result "+result);
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
}// end clas\s
