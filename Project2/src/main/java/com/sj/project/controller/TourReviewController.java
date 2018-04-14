package com.sj.project.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sj.project.domain.BestVO;
import com.sj.project.domain.ImageFile;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.ReviewRegionVO;
import com.sj.project.domain.ReviewVO;
import com.sj.project.service.ImageService;
import com.sj.project.service.ImageView;
import com.sj.project.service.TourReviewService;

@Controller
@RequestMapping(value = "/review")
public class TourReviewController {

	private static final Logger logger = LoggerFactory.getLogger(TourReviewController.class);

	public static final String SAVE_IMAGE_DIR = "resources/photo_upload/";

	private int ReviewRegisterID = 2;

	@Autowired
	private TourReviewService tourReviewService;

	@Resource(name = "imageView")
	private ImageView imageView;

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/reviewBoard", method = RequestMethod.GET)
	public void reviewBoard() {
		// totalReview 페이지 이동

	} // end reviewBoard()

	@RequestMapping(value = "/review_register", method = RequestMethod.GET)
	public void reviewRegister() {
		// review_register.jsp 페이지 이동
	} // end reviewRegister()

	@RequestMapping(value = "/likeCheck/{review_no}/{mno}", method = RequestMethod.GET)
	public String likeCheck(@PathVariable("review_no") int review_no, @PathVariable("mno") int mno) {

		int selectLike = 0;

		try {
			// 먼저 사용자가 게시글에 따봉을 눌렀는지 확인!
			selectLike = tourReviewService.readReviewLike(review_no, mno);

			logger.info("selectLike=? : " + selectLike);
		} catch (Exception e) {
			// TODO: handle exception

			logger.info("따봉을 누른 흔적이 없으니 새 따봉을 입력합니다.");
			// 이 게시글에 이미 따봉을 눌렀습니다. 따봉의 흔적을 지웁니다
			int insertLike = tourReviewService.createReviewLike(review_no, mno);
		}

		if (selectLike == 1) {
			// 따봉을 누른 흔적이 없으니 새 따봉을 입력합니다.
			logger.info("따봉 눌렀으니까 삭제합시다.");
			int deleteLike = tourReviewService.deleteReviewLike(review_no, mno);
		}

		// 따봉 추가 삭제가 끝났으면 해당 게시글의 따봉 개수를 종합하여 wm_review 테이블에 업데이트 해줍시다
		int updateBest = tourReviewService.update_review_best(review_no);
		if (updateBest == 1) {
			logger.info(" wm_review 테이블 따봉 업데이트 성공");
		} else {
			logger.info(" wm_review 테이블 따봉 업데이트 실패");
		}

		return "redirect:../../review_detail?review_no=" + review_no;
	} // end reviewRegister()

	// 후기 등록 작업 DB Insert
	@RequestMapping(value = "/review_register", method = RequestMethod.POST)
	public String CreateReview(ReviewVO reviewvo, ReviewRegionVO reviewregionvo, ImgVO imgvo,
			@RequestParam MultipartFile imageFile, ModelMap modelMap, Model model) {

		int review_no = 0;

		// 썸네일 이미지 주소 생성
		ImageFile fileInfo = imageService.save(imageFile);
		if (fileInfo != null) {
			logger.info("대표 이미지 주소: " + SAVE_IMAGE_DIR + fileInfo.getFileName());

			// 다음 페이지에 볼 수 있게 modelMap에 넘기기
			modelMap.put("imageFile", fileInfo);
		} else {
			logger.info("썸네일 등록 실패 ");
		} // end if (fileInfo != null)

		if (reviewvo != null && reviewregionvo != null) {
			logger.info("mno 확인: " + reviewvo.getMno());

			// 이상 없으면 후기등록 DB insert!
			int review_result = tourReviewService.createReview(reviewvo);
			if (review_result == 1) { // 후기 등록 DB insert 성공
				logger.info("후기 등록 성공");

				// 썸네일과 장소를 등록하기 위해 review_no를 가져오자
				review_no = tourReviewService.readReview_no(reviewvo);
				logger.info("reviewNo : " + review_no);

				reviewvo = tourReviewService.readReviewRegisterData(review_no);
				model.addAttribute("reviewvo", reviewvo);

				String region_name = reviewregionvo.getRegion_name();
				logger.info("후기 지역: " + region_name);

				ReviewRegionVO reviewRegionvo2 = new ReviewRegionVO(review_no, region_name, 0);

				int reviewRegion_result = tourReviewService.createRegion(reviewRegionvo2);
				if (reviewRegion_result == 1) {

					logger.info("후기 지역 등록 성공");

					model.addAttribute("reviewregionvo", reviewRegionvo2);

					if (fileInfo.getFileName().length() < 40) {
	
						ImgVO imagevo = new ImgVO(ReviewRegisterID, review_no, 0,
								SAVE_IMAGE_DIR + "default-profile.jpg");
						int result2 = tourReviewService.createThumnail(imagevo);
						if (result2 == 1) {
							logger.info("후기 기본 썸네일 등록 성공");
						} else {
							logger.info("후기 기본 썸네일 등록 실패");
						}

					} else {

						ImgVO imagevo = new ImgVO(ReviewRegisterID, review_no, 0,
								SAVE_IMAGE_DIR + fileInfo.getFileName());
						int image_result = tourReviewService.createThumnail(imagevo);

						if (image_result == 1) {
							logger.info("후기 썸네일 직접 등록 성공");

							model.addAttribute("imagevo", imagevo);
							logger.info("imagevo 주소 : " + imagevo);
						} else {

							logger.info("후기 썸네일 직접 등록 실패");
						} // end if(image_result == 1)

					}

					// 이 부분에서 조회수(좋아요) 테이블에도 후기 게시글 번호를 입력해준다!

				} else {
					logger.info("후기 지역 등록 실패");
				} // end if(reviewRegion_result == 1)
			} else {
				logger.info("후기 등록실패");
			} // end if(review_result == 1)
		} // end if (reviewvo != null && reviewregionvo != null)

		return "redirect:review_detail?review_no=" + review_no;
	} // end CreateReview()

	@RequestMapping(value = "/review_detail", method = RequestMethod.GET)
	public String reviewDetail(int review_no, Model model, HttpSession session) {
		// review_detail.jsp 페이지 이동
		// DAO 통해서 view 테이블 불러오게..
		logger.info("reviewDetail() 호출...");
		logger.info("review_no : " + review_no);

		// 클릭할 때마다 조회수 + 1
		int currentHit = tourReviewService.read_current_review_hits(review_no);
		logger.info("조회수  : " + currentHit);

		// 업데이트 할 조회수 = 현재 조회수 + 1
		currentHit = currentHit + 1;
		logger.info("업데이트 조회수  : " + currentHit);

		// 조회수 업데이트!
		ReviewVO updatehitvo = new ReviewVO(review_no, null, null, 0, 0, currentHit, null);

		int updatehitResult = tourReviewService.update_review_hits(updatehitvo);

		if (updatehitResult == 1) {
			logger.info("업데이트 조회수  : " + currentHit);
		} else {
			logger.info("조회수 업데이트 실패");
		}

		ReviewVO reviewvo = tourReviewService.read_review_by_no(review_no);

		if (reviewvo != null) {
			logger.info("reviewvo.getMno: " + reviewvo.getMno());

			ImgVO img = tourReviewService.read_review_profile(reviewvo.getMno());
			logger.info("img: " + img);

			PersonalVO personalvo = tourReviewService.read_review_personal(reviewvo.getMno());
			String region = tourReviewService.read_review_region_name(reviewvo.getReview_no());

			model.addAttribute("reviewVO", reviewvo);

			if (personalvo != null) {
				model.addAttribute("inserterNickname", personalvo.getNickname());
				model.addAttribute("inserterIntro", personalvo.getIntroduce());
			}

			if (img != null) {
				model.addAttribute("inserterImg", img.getImg_url());
			}

			if (region != null) {
				model.addAttribute("inserterRegion", region);
			}
		} // end if

		
		// 내가 이 게시물에 따봉을 눌렀는가? state를 조회해보면 알 수 있다
		int selectLike = 0;

		String mnoString = (String) (session.getAttribute("mno"));

		if (mnoString == null) {
			logger.info("로그인된 아이디가 없음");
		} else {

			// 문제가 있음
			int mno = Integer.valueOf(mnoString);

			try {
				// 먼저 사용자가 게시글에 따봉을 눌렀는지 확인!
				selectLike = tourReviewService.readReviewLike(review_no, mno);
				logger.info("selectLike=? : " + selectLike);
				
			} catch (Exception e) {
				// TODO: handle exception
				logger.info("따봉을 누른 흔적이 없습니다.");

				BestVO vo = new BestVO(mno, review_no, 0);
				model.addAttribute("likecheck", vo);
			}

			if (selectLike == 1) {
				// 따봉을 누른 흔적이 없으니 새 따봉을 입력합니다.
				logger.info("따봉 누른 흔적이 있습니다.");
				BestVO vo = new BestVO(mno, review_no, selectLike);
				model.addAttribute("likecheck", vo);
			}
		}

	
		return "review/review_detail";
	} // end reviewDetail()

	@RequestMapping(value = "/toggle_msg", method = RequestMethod.POST)
	public String toggleMsg(int msg_setter, int msg_getter, String[] msg_getnick, String msg_address, Model model) {
		System.out.println("setter: " + msg_setter);
		System.out.println("getter: " + msg_getter);
		System.out.println("review####msg_getnick: " + msg_getnick.length);
		// System.out.println("tour####msg_getnick[0]: " + msg_getnick[0]);
		// System.out.println("tour####msg_getnick[1]: " + msg_getnick[1]);

		model.addAttribute("msg_setter", msg_setter);
		model.addAttribute("msg_getter", msg_getter);
		model.addAttribute("msg_getnick", msg_getnick);
		model.addAttribute("msg_address", msg_address);

		return "toggle_msg";
	} // end toggleMsg(msg_setter, msg_getter, String[] msg_getnick,
		// msg_address, model)

	@RequestMapping(value = "/toggle_msg", method = RequestMethod.GET)
	public String toggleMsg() {

		return "toggle_msg";
	} // end toggleMsg()

	@RequestMapping(value = "/review_update_pre", method = RequestMethod.POST)
	public String reviewUpdatePre(int review_no, Model model) {
		logger.info("리뷰 번호 번호 : " + review_no);

		ReviewVO reviewvo = tourReviewService.readReviewInfo(review_no);
		logger.info("ReviewVO : " + reviewvo);
		ReviewRegionVO reviewRegionvo = tourReviewService.readReviewRegionInfo(review_no);
		logger.info("ReviewRegionVO : " + reviewRegionvo);
		ImgVO imgvo = tourReviewService.readReviewMainImage(review_no);
		logger.info("ImgVO : " + imgvo);

		if (reviewvo != null && reviewRegionvo != null && imgvo != null) {
			logger.info("수정하기 위한 검색 작업 완료...");
			model.addAttribute("ReviewVO", reviewvo);
			model.addAttribute("ReviewRegionVO", reviewRegionvo);
			model.addAttribute("ImgVO", imgvo);
			logger.info("수정하기 위한 vo model Add 완료...");
		} else {
			logger.info("수정하기 위한 검색 작업 실패...");
		}

		return "review/review_update";
	} // end ReviewUpdatePre(review_no, model)

	@RequestMapping(value = "/review_update_suf", method = RequestMethod.POST)
	public String reviewUpdateSuf(ReviewVO reviewvo, ReviewRegionVO reviewRegionvo, ImgVO imgvo,
			@RequestParam MultipartFile imageFile) {

		if (reviewvo != null && reviewRegionvo != null) {
			logger.info("vo 값 읽기 성공");

			int review_result = tourReviewService.updateReview(reviewvo);
			if (review_result == 1) {
				logger.info("후기 내용 수정 성공");

				int reviewregion_result = tourReviewService.updateRegion(reviewRegionvo);
				if (reviewregion_result == 1) {
					logger.info("후기 지역 수정 성공");

					ImageFile fileInfo = imageService.save(imageFile);

					if (fileInfo.getFileName().length() < 40) {
						logger.info("썸네일 수정 안할겁니다");
					} else {

						ImgVO imagevo = new ImgVO(ReviewRegisterID, reviewvo.getReview_no(), 0,
								SAVE_IMAGE_DIR + fileInfo.getFileName());

						int image_result = tourReviewService.updateThumnail(imagevo);
						if (image_result == 1) {
							logger.info("새로운 후기 썸네일 수정 성공");
						} else {
							logger.info("새로운 후기 썸네일 수정 실패");
						} // end if(image_result == 1)
					}
				} else {
					logger.info("후기 지역 수정 실패");
				} // end if(reviewregion_result == 1)
			} else {
				logger.info("후기 내용 수정 실패");
			} // end if(review_result == 1)
		} else {
			logger.info("vo 값 읽기 실패");
		} // end if(reviewvo != null && reviewRegionvo != null && imgvo != null)

		return "redirect:review_detail?review_no=" + reviewvo.getReview_no();
	} // end ReviewUpdateSuf()

	@RequestMapping(value = "review_delete", method = RequestMethod.POST)
	public String reviewDelete(int review_no) {
		logger.info("리뷰 번호 : " + review_no);

		int review_result = tourReviewService.deleteReview(review_no);
		if (review_result == 1) {
			logger.info("여행 리뷰 삭제 성공");

			int reviweRegion_result = tourReviewService.deleteRegion(review_no);
			if (reviweRegion_result == 1) {
				logger.info("여행 리뷰 지역 삭제 성공");

				int img_result = tourReviewService.deleteThumnail(review_no);
				if (reviweRegion_result == 1) {
					logger.info("썸네일 삭제 성공");
				} else {
					logger.info("썸네일 삭제 실패");
				}
			} else {
				logger.info("여행 리뷰 지역 삭제 실패");
			}
		} else {
			logger.info("여행 리뷰 삭제 실패");
		}

		return "redirect:reviewBoard";
	} // end reviewDelete(review_no)

	/////////////////////////////////////////////////////////////////////////////////////////////////////

	// 따봉충의 모험

} // end class TourReviewController