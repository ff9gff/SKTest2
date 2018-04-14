package com.sj.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sj.project.domain.ImageFile;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.MemberVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.ReviewRegionVO;
import com.sj.project.domain.ReviewVO;
import com.sj.project.domain.TourRegisterVO;
import com.sj.project.service.ImageService;
import com.sj.project.service.MemberService;
import com.sj.project.service.MypageService;
import com.sj.project.service.TourJoinService;
import com.sj.project.service.TourRegisterService;
import com.sj.project.service.TourSearchService;

@Controller
@RequestMapping(value = "/mypage")
public class MypageController {

	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);

	public static final String SAVE_IMAGE_DIR = "resources/photo_upload/";

	private int TourRegisterID = 3;

	@Autowired
	private MypageService mypageService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private ImageService imageService;

	@Autowired
	private TourRegisterService tourRegisterService;

	@RequestMapping(value = "/MyPage", method = RequestMethod.GET)
	public String selectPesrsonal(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		int mno = Integer.valueOf(session.getAttribute("mno").toString());
		logger.info("mno: " + mno);
		PersonalVO vo = mypageService.selectpersonal(mno);
		logger.info("닉네임 : " + vo.getNickname());
		logger.info("성별 : " + vo.getSex());
		logger.info("나이 : " + vo.getAge());
		logger.info("자기소개 : " + vo.getIntroduce());
		logger.info("이메일 : " + vo.getEmail());

		/*
		 * ImgVO img = tourSelectService.read_trip_profile(mno);
		 * model.addAttribute("inserterImg", img.getImg_url());
		 * logger.info("inserterImg: " + img.getImg_url());
		 */

		ImgVO src = mypageService.readProfile(mno);
		model.addAttribute("inserterImg", src.getImg_url());
		logger.info("src: " + src);

		model.addAttribute("pageVO", vo);

		return "mypage/MyPage";
	}

	@RequestMapping(value = "/UserPage/{amno}", method = RequestMethod.GET)
	public String selectUserPesrsonal(@PathVariable("amno") Integer mno, Model model) {

		PersonalVO vo = mypageService.selectpersonal(mno);

		ImgVO src = mypageService.readProfile(mno);
		model.addAttribute("inserterImg", src.getImg_url());
		logger.info("src: " + src);

		model.addAttribute("pageVO", vo);

		return "mypage/UserPage";
	}

	// mno 검색 Ajax 처리
	// 해당 mno 검색 메소드
	@RequestMapping(value = "/MyPage/list/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxlistTest(@PathVariable("mno") int mno, Model model) {

		logger.info("mno: " + mno);
		ResponseEntity<List<ImgVO>> entity = null;

		List<ImgVO> list = mypageService.read_mno(mno);

		model.addAttribute("list", list);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.OK);

			logger.info("mno 검색 성공 ");

		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ImgVO>>(list, HttpStatus.BAD_REQUEST);

			logger.info("mno 검색 실패 ");

		}

		logger.info("entity " + entity.getBody());
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// mno 검색 Ajax 처리
	// 해당 mno 이미지 아래 제목 검색 메소드
	@RequestMapping(value = "/MyPage/title/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<TourRegisterVO>> ajaxtitleTest(@PathVariable("mno") int mno) {

		ResponseEntity<List<TourRegisterVO>> entity = null;

		List<TourRegisterVO> list = mypageService.read_mytour_title(mno);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.OK);
			logger.info("제목 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("제목 전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	@RequestMapping(value = "/MyPage/region/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<RegionVO>> ajaxregionTest(@PathVariable("mno") int mno) {

		ResponseEntity<List<RegionVO>> entity = null;

		List<RegionVO> list = mypageService.read_mytour_region(mno);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.OK);
			logger.info("지역 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("지역  전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	@RequestMapping(value = "/MyPage/joinlist/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxjoinlistTest(@PathVariable("mno") int mno, Model model) {

		logger.info("mno222: " + mno);
		ResponseEntity<List<ImgVO>> joinentity = null;

		List<ImgVO> joinlist = mypageService.read_join_mno(mno);
		model.addAttribute("joinlist", joinlist);

		if (joinlist != null) {
			joinentity = new ResponseEntity<List<ImgVO>>(joinlist, HttpStatus.OK);
			logger.info("joinmno 검색 성공 ");
		} else {
			joinentity = new ResponseEntity<List<ImgVO>>(joinlist, HttpStatus.BAD_REQUEST);
			logger.info("hoinmno 검색 실패 ");
		}

		logger.info("joinentity " + joinentity.getBody());
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return joinentity;
	}

	// mno 검색 Ajax 처리
	// 해당 mno 이미지 아래 제목 검색 메소드
	@RequestMapping(value = "/MyPage/jointitle/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<TourRegisterVO>> ajaxjointitleTest(@PathVariable("mno") int mno) {

		ResponseEntity<List<TourRegisterVO>> entity = null;

		List<TourRegisterVO> list = mypageService.read_mytourjoin_title(mno);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.OK);
			logger.info("제목 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<TourRegisterVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("제목 전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	@RequestMapping(value = "/MyPage/joinregion/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<RegionVO>> ajaxjoinregionTest(@PathVariable("mno") int mno) {

		ResponseEntity<List<RegionVO>> entity = null;

		List<RegionVO> list = mypageService.read_mytourjoin_region(mno);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.OK);
			logger.info("지역 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<RegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("지역  전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// 후기 리스트
	@RequestMapping(value = "/MyPage/reviewlist/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<ImgVO>> ajaxreviewlistTest(@PathVariable("mno") int mno, Model model) {

		logger.info("mno3: " + mno);
		ResponseEntity<List<ImgVO>> reviewentity = null;

		List<ImgVO> reviewlist = mypageService.read_review_mno(mno);
		model.addAttribute("reviewlist", reviewlist);

		if (reviewlist != null) {
			reviewentity = new ResponseEntity<List<ImgVO>>(reviewlist, HttpStatus.OK);
			logger.info("reviewmno 검색 성공 ");
		} else {
			reviewentity = new ResponseEntity<List<ImgVO>>(reviewlist, HttpStatus.BAD_REQUEST);
			logger.info("reviewmno 검색 실패 ");
		}

		logger.info("reviewentity " + reviewentity.getBody());
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return reviewentity;
	}

	// mno 검색 Ajax 처리
	// 해당 mno 이미지 아래 제목 검색 메소드
	@RequestMapping(value = "/MyPage/reviewtitle/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewVO>> ajaxreviewtitleTest(@PathVariable("mno") int mno) {

		ResponseEntity<List<ReviewVO>> entity = null;

		List<ReviewVO> list = mypageService.read_review_title(mno);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ReviewVO>>(list, HttpStatus.OK);
			logger.info("제목 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ReviewVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("제목 전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	// mno 검색 Ajax 처리
	// 해당 mno 이미지 아래 지역 검색 메소드
	@RequestMapping(value = "/MyPage/reviewregion/{mno}", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewRegionVO>> ajaxreivewregionTest(@PathVariable("mno") int mno) {

		ResponseEntity<List<ReviewRegionVO>> entity = null;

		List<ReviewRegionVO> list = mypageService.read_review_region(mno);

		if (list != null) {
			// select 성공 한것이다.
			entity = new ResponseEntity<List<ReviewRegionVO>>(list, HttpStatus.OK);
			logger.info("지역 전체 검색 성공 ");
		} else {
			// select 실패이다.
			entity = new ResponseEntity<List<ReviewRegionVO>>(list, HttpStatus.BAD_REQUEST);
			logger.info("지역  전체 검색 실패 ");
		}

		logger.info("entity " + entity);
		// logger.info("list.mno "+ list.get(0).getUserid());
		// 출력 됨
		return entity;
	}

	////////////////////////////// 프로필 수정 작업 중... 수정하기 위해서 데이터를 검색 후
	////////////////////////////// updatePersonal.jsp로
	////////////////////////////// 보내주자/////////////////////////////////////
	@RequestMapping(value = "updatePersonal/{mno}", method = RequestMethod.GET)
	public String readPerson(@PathVariable("mno") int mno, Model model) {

		logger.info("mno: " + mno);
		PersonalVO vo = mypageService.selectpersonal(mno);
		logger.info("닉네임 : " + vo.getNickname());
		logger.info("성별 : " + vo.getSex());
		logger.info("나이 : " + vo.getAge());
		logger.info("자기소개 : " + vo.getIntroduce());
		logger.info("이메일 : " + vo.getEmail());

		model.addAttribute("vo", vo);

		return "mypage/updatePersonal";

	}

	////////////////////////////// 프로필 수정 작업 중... 업데이트 쿼리 실행 후 마이페이지로
	////////////////////////////// 돌아간다/////////////////////////////////////

	@RequestMapping(value = "/updatePersonal/profile_update", method = RequestMethod.POST)
	public String readPerson2(PersonalVO vo2) {
		logger.info("프로필수정 메소드 들어왔니?");

		if (vo2 != null) {

			logger.info("회원 번호: " + vo2.getMno());
			logger.info("유저 나이: " + vo2.getAge());
			logger.info("유저 닉네임: " + vo2.getNickname());
			logger.info("유저 핸드폰: " + vo2.getPhone());
			logger.info("유저 우편번호: " + vo2.getPostcode());
			logger.info("유저 주소1: " + vo2.getAddress1());
			logger.info("유저 주소2: " + vo2.getAddress2());
			logger.info("유저 이메일: " + vo2.getEmail());
			logger.info("유저 자소서: " + vo2.getIntroduce());

			// update 쿼리 실행
			int result = mypageService.update_profile(vo2);
			if (result == 1) { // profile 업데이트 성공
				logger.info("프로필 수정 성공");
			} else { // 업데이트 실패
				logger.info("프로필 수정 실패");
			}
		}

		return "redirect:../MyPage";
	}

	@RequestMapping(value = "checknick", method = RequestMethod.POST)
	public void checkid(@RequestBody PersonalVO vo, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		logger.info("userid: " + vo.getNickname());

		String checknick = memberService.readNickname(vo.getNickname());
		logger.info("checkid : " + checknick);

		PrintWriter out = response.getWriter();

		if (checknick != null) {
			out.print("NOK");
		} // end if
	}

	// 해당 프로필의 이미지 업데이트 메소드
	@RequestMapping(value = "MyPage", method = RequestMethod.POST)
	public String prifleimageupdate(HttpServletRequest req, @RequestParam MultipartFile imageFile) {
		HttpSession session = req.getSession();
		int mno = Integer.valueOf(session.getAttribute("mno").toString());

		logger.info("prifleimageupdate() 호출...");
		logger.info("prifleimageupdate() 호출..." + mno);
		logger.info("prifleimageupdate() 호출..." + imageFile);

		ImageFile fileInfo = imageService.save(imageFile);

		/* logger.info("대표 이미지 주소: " + SAVE_IMAGE_DIR + fileInfo.getFileName()); */

		ImgVO imgvo = new ImgVO(TourRegisterID, mno, 0, SAVE_IMAGE_DIR + fileInfo.getFileName());
		int result2 = tourRegisterService.updateThumnail(imgvo);

		if (result2 == 1) {
			logger.info("썸네일 수정 성공");
		} else {
			logger.info("썸네일 수정 실패");
		}

		return "redirect:MyPage";
	}

	@RequestMapping(value = "/MiniMSGpageU2", method = RequestMethod.GET)
	public void MiniSendToUser(String msg_address, Model model, String value2) {
		logger.info("/MiniMSGpageU 마이 페이지에서 호출 ");
		System.out.println("valu2 " + value2);
		// System.out.println("어디로 가니 너는 " + msg_address);
		model.addAttribute("value2", value2);

		// return "redirect:../mypage/MiniMSGpageU2";
	}

}
