package com.sj.project.controller;

/*import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
*/
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UrlPathHelper;

import com.sj.project.domain.MsgDTO;
import com.sj.project.pageutil.MsgPaginationCriteria;
import com.sj.project.pageutil.PageMaker;
import com.sj.project.service.MsgAllService;
import com.sj.project.service.SearchUserService;

@Controller
public class SendMSGcontroller {

	@Autowired
	private SearchUserService searchUserService;

	@Autowired
	private MsgAllService msgAllService;

	private static Logger logger = LoggerFactory.getLogger(SendMSGcontroller.class);

	@RequestMapping(value = "/SendMsg", method = RequestMethod.GET)
	public void sendMSgPage() {

	}

	// 메세지 보내는 코드
	@RequestMapping(value = "/sendMsgU", method = RequestMethod.POST)
	public String sendMSGU(int sd_mno, String[] nickname, String msg_content,String sd_url, RedirectAttributes attr, HttpServletRequest request) {
		System.out.println("msg_userid - > " + sd_mno);
		System.out.println("msg_nickname - > " + nickname[0]);
		logger.info("userid - > " + sd_mno); // content 넘어 가는 거 확인
		logger.info("neckname " + nickname);
		logger.info("msg_content" + msg_content);
		
		String requestUrl = request.getRequestURI().toString();
		System.out.println("requestUrl:"+requestUrl);
	
		
		String sendUrl = "redirect:"+sd_url;
		System.out.println("어디서 부른거니!111 =====> "+sendUrl);
		System.out.println("닉네임의 길이는? =====> "+nickname.length);
		

		int result = 0;
		for(int i=0; i<nickname.length; i++){
			result = searchUserService.sendMsgTO(sd_mno, nickname[i], msg_content);
		}
		
		
		if(result ==1){
			attr.addFlashAttribute("insert_result","success");
		}else{
			attr.addFlashAttribute("insert_result","fail");
		}
		
		return sendUrl;
	
	}

	
	//메세지 함을 확인 합니다. 일단 mno를 6으로 설정합니다. 나중에 합칠 경우에 대비해서 미리 적어 둔다 . 
	@RequestMapping(value = "/myMsg", method = RequestMethod.GET)
	public void stres(Model model , Integer page, Integer mno,HttpSession session) {

	

		String strmno = (String) session.getAttribute("mno");
		logger.info("#####strmno : " + strmno);
		int Usermno = 0;
		try {
			
			 Usermno = Integer.valueOf(strmno);
			logger.info("#####testmno : " + Usermno);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		mno = Usermno; 
		
		MsgPaginationCriteria x = new MsgPaginationCriteria(mno);
		
		if(page !=null){//요청 파라미터에 현재 페이지 정보가 있는 경우 
			x.setPage(page);
			
		}
		
		logger.info("hi "+msgAllService.getNumOfRecords(mno));
		List<MsgDTO> allList= msgAllService.readSendMsg2(x);
		PageMaker maker = new PageMaker();
		maker.setMsgcriteria(x);
		
		
		maker.setTotalCount(msgAllService.getNumOfRecords(mno));
		
		//maker.setPageData();
		maker.setMSGPageData();
		model.addAttribute("pageMaker", maker);
	
		
		
		//List<MsgDTO> allList = msgAllService.readGetMsg(mno);
		try {
			for (MsgDTO dto : allList) {
				String msg = dto.getMsg_content();
				if (msg.length() >= 20) {
					dto.setMsg_content(msg.substring(0, 20) + "...");
				}
			}
		
		} catch (Exception e) {
		
		}
	
		model.addAttribute("allList", allList);

		
	}//end 
	
	
	
	//MySendMsg
	@RequestMapping(value = "/MySendMsg", method = RequestMethod.GET)
	public void sendMyMsg(Model model ,Integer page ,Integer mno, HttpSession session) {
			//Model model , Integer page, Integer mno
		
		String strmno = (String) session.getAttribute("mno");
		logger.info("#####strmno : " + strmno);
		
		int Usermno = 0;
		try {
			
			 Usermno = Integer.valueOf(strmno);
			logger.info("#####testmno : " + Usermno);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		 
		mno = Usermno; 
		
		 MsgPaginationCriteria x = new MsgPaginationCriteria(mno);
		 
		 if(page != null){
			 x.setPage(page);
		 }
		 
		 List<MsgDTO> allList= msgAllService.readPageGetMsgTxt(x);
		 PageMaker maker = new PageMaker();
		 maker.setMsgcriteria(x);
		 
		 
		 maker.setTotalCount(msgAllService.pageGetMsgOfRecords(mno));
		//List<MsgDTO> allList = msgAllService.readSendMsg(mno);
		 maker.setMSGPageData();
		model.addAttribute("pageMaker", maker);
		 
		try {
			for (MsgDTO dto : allList) {
				String msg = dto.getMsg_content();
				if (msg.length() >= 20) {
					dto.setMsg_content(msg.substring(0, 20) + "...");
				}
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		model.addAttribute("allList", allList);	 
	}//end 
	

	
	@RequestMapping(value="/MiniMsg" ,method=RequestMethod.POST)
	public void test022(@ModelAttribute("postdata") String postdata ,@ModelAttribute("msg_content") String msg_content ,
			 Model model , @ModelAttribute("value") String value, @ModelAttribute("getname") String getname,String sendTxt,
			 @ModelAttribute("sendPage") String sendPage   ){
		
		//postdata=5&value=&msg_content=공지사항입니다.
		logger.info("userSearch2 호출 팝업 나와라 ");
		//logger.info("postdata " + postdata +msg_content);
		logger.info("value" + value +"getname" +getname);
		int mno = Integer.parseInt(value);
		logger.info(""+mno);
		logger.info("sendPage 값이 있을 까요 "+sendPage);
		sendTxt= msgAllService.selectMSGContext(mno);
		logger.info("여기는 컨트롤러 입니다."+sendTxt);
		model.addAttribute("sendTxt",sendTxt);
		model.addAttribute("sendPage",sendPage);
		
		
		
	}//end miniMsg 
	
	
	
	
	
	
	
	
	
	
	

}
