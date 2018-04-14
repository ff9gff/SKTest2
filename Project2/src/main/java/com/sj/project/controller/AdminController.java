package com.sj.project.controller;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sj.project.domain.AdminMsgDTO;
import com.sj.project.domain.DomainDTO;
import com.sj.project.domain.MsgVO;
import com.sj.project.pageutil.MyUserPaginationCriteria;
import com.sj.project.pageutil.PageMakerMyUser;
import com.sj.project.service.AdminService;
import com.sj.project.service.SearchUserService;

@Controller

@RequestMapping(value="/admin")
public class AdminController {
	private static final Logger logger =
			LoggerFactory.getLogger(AdminController.class);
	
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SearchUserService searchUserService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public void callAdmin(Model model) {
		//여기를 수정하겠습니다. 11.28 수정 완료 부분 
		List<DomainDTO> list2 = adminService.readAdminDomain();
		logger.info("admin.jsp 소환 ");
		model.addAttribute("newMemberList", list2);
	}
	
	// 아이디 정보를 찾는 거다 . 
	@RequestMapping(value="/MyUserInfo", method=RequestMethod.GET)
	public void MyUserInfomation(){
			
	}
	
	//admin 페이지에서 가입승인 메뉴바 눌렀을때  다시 보던 창이 뜨게 만드는 리퀘스트 멥핑 
	@RequestMapping(value="/callbackAdmin", method=RequestMethod.GET )
	public String callAdminPage(){	
		return "redirect:admin";
	}
	
	
	@RequestMapping(value="/AdminMsg", method=RequestMethod.GET )
	public void adminMsg(){
		
		
	}
	
	
	

	

	@RequestMapping(value="/sendAllMyUser", method=RequestMethod.POST)
	public String sendUserText(@ModelAttribute("msg_content") String msg_content ,@ModelAttribute("value") String value, MsgVO vo){
		//@ModelAttribute("value") String value
		//logger.info("vo "+ vo.getMsg_content());
		//@ModelAttribute("msg_content")
		logger.info("msg.value 나와라 !"+value);
		//logger.info("msg.content 나와라 !"+msg_content);
		if(msg_content ==null){
			msg_content ="공지사항입니다.";
		}
		
	int result=	adminService.sendAllUserMessage(value);
		
		logger.info("메세지 보내기 결과 입니다. "+ result);
		
		return "redirect:MiniSendToAllMyUser";
	}//
	
	

	
	
	
	
	@RequestMapping(value="/AllMyUser" ,method=RequestMethod.GET)
	public void AllMyUser(Model model,Integer page){
		
		//여기서 세팅을 한다. 
		//AllMyUser로 보내기 
		
		int cntUsers = adminService.cntAllMyUser();
		List<DomainDTO> list2 = adminService.allMyActivUser();
		logger.info("All 나의 활동 유저 페이지로 가자 소환 ");
		model.addAttribute("newMemberList", list2);
		model.addAttribute("cntUsers" , cntUsers);
		
		
		MyUserPaginationCriteria x = new MyUserPaginationCriteria();
		
		
		if(page !=null){//요청 파라미터에 현재 페이지 정보가 있는 경우 
			x.setPage(page);
			
		}
		List<DomainDTO> listPage = adminService.pagingAllMyUser(x);
		PageMakerMyUser maker = new PageMakerMyUser();
		
		maker.setMyUcriteria(x);
		
		
		maker.setTotalCount(cntUsers);
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
		model.addAttribute("listPage",listPage);
		
		
		
	}//
	
	@RequestMapping(value="/AllMySubAdmin" ,method=RequestMethod.GET)
	public void AllMySubAdmin(Model model){
		//AllMyUser로 보내기 
		List<DomainDTO> list2 = adminService.allMySubAdminActivUser();
		logger.info("All 나의 활동 유저 페이지로 가자 소환 ");
		model.addAttribute("newMemberList", list2);
		
		
	}
	
	@RequestMapping(value="/AllAdminMSG" ,method=RequestMethod.GET)
	public void adminMsgAll(Model model){
		
		
		List<String> list = adminService.allAdminMSG();
		
		List<AdminMsgDTO> msgList = adminService.allAdminMSG2();
		
		Set<String>  msgContext = new LinkedHashSet<>(); 
				//HashSet<>();
		
		try {
			for(int i=0 ; i < list.size(); i++){
				msgContext.add(list.get(i).toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	
		
		model.addAttribute("msgContext",msgContext);
		model.addAttribute("msgList", msgList);
		
		
	}//end 
	
	//MiniSendToAllMyUser
	//전체 유저에게 보내는 관리자의 화면입니다. 
	@RequestMapping(value="/MiniSendToAllMyUser", method=RequestMethod.GET)
	public void MiniSendToAllMyUserpage(){
		logger.info("안녕 새창이야 .");
		
				
	}
	
	
	// MiniMSGpageU ///
	@RequestMapping(value="/MiniMSGpageU", method=RequestMethod.GET)
	public void MiniSendToUser(String msg_address, Model model){
		logger.info("/MiniMSGpageU 호출 ");			
		System.out.println("어디로 가니 너는 " + msg_address);
		model.addAttribute("msg_address", msg_address);
		
	}
	

}//end class 

