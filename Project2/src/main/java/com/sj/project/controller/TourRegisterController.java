package com.sj.project.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sj.project.domain.ImageFile;
import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.RegionVO;
import com.sj.project.domain.TourRegisterVO;
import com.sj.project.service.ImageService;
import com.sj.project.service.ImageView;
import com.sj.project.service.TourRegisterService;
import com.sj.project.service.TourSearchService;

@Controller
@RequestMapping(value = "/tour")
public class TourRegisterController {
	private static final Logger logger = LoggerFactory.getLogger(TourRegisterController.class);

	public static final String SAVE_IMAGE_DIR = "resources/photo_upload/";

	private int TourRegisterID = 1;

	// 웹사이트에서 동일한 부분 코드 수정
	// 이클립스에서 동일한 부분 코드 수정
	// 이클립스에서 커밋앤푸쉬하려니 불가능!
	// 뭐지? 이상하네 싶어서 중앙리파지토리에서 pull을 했더니
	// 웹사이트, 이클립스에서 수정한 부분이 모두 뜬다!
	// 선택을 해야 한다! 뭐가 더 나은 코드인지 확인 후 필터링
	// 필터링이 다 됐으면 add to index를 하고
	// 커밋앤푸시를 하면 반영 완료!

	// 커밋만 하면 로컬리파지토리에만 저장된다.
	// 로컬에서 푸시를 해야 git허브에 저장된다

	@Resource(name = "imageView")
	ImageView imageView;

	@Autowired
	ImageService imageService;

	@Autowired
	private TourSearchService tourSelectService;

	@Autowired
	private TourRegisterService tourRegisterService;

	// 메인에서 지역/기간 검색 후 뜨는 사진을 클릭했을 때
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String tourRegister3(int trip_no, Model model) {
		
		logger.info("trip_no: " + trip_no);
		TourRegisterVO tourVO = tourSelectService.read_trip_by_no(trip_no);

		if (tourVO != null) {
			ImgVO img = tourSelectService.read_trip_profile(tourVO.getMno());
			PersonalVO person = tourSelectService.read_trip_person(tourVO.getMno());
			String region = tourSelectService.read_trip_region_name(tourVO.getTrip_no());
			
			model.addAttribute("tourVO", tourVO);
			
			if (person != null) {
				model.addAttribute("inserterNickname", person.getNickname());
				model.addAttribute("inserterIntro", person.getIntroduce());
			}
			if (img != null) {
				model.addAttribute("inserterImg", img.getImg_url());
			}
			if (region != null) {
				model.addAttribute("inserterRegion", region);
			}
		}

		return "tour/detail";

	}

	@RequestMapping(value = "/toggle_msg", method = RequestMethod.POST)
	public String toggleMsg(int msg_setter, int msg_getter, String[] msg_getnick, String msg_address, Model model) {
		
		System.out.println("setter: " + msg_setter);
		System.out.println("getter: " + msg_getter);
		System.out.println("tour####msg_getnick: " + msg_getnick.length);

		model.addAttribute("msg_setter", msg_setter);
		model.addAttribute("msg_getter", msg_getter);
		model.addAttribute("msg_getnick", msg_getnick);
		model.addAttribute("msg_address", msg_address);

		return "toggle_msg";
	}

	@RequestMapping(value = "/toggle_msg", method = RequestMethod.GET)
	public String toggleMsg() {
		return "toggle_msg";
	}

	// 메인에서 "여행 등록하러 가기" 클릭 --> 새로운 여행 일정 등록하러 가기
	@RequestMapping(value = "/GoRegister", method = RequestMethod.GET)
	public String createRegister2() {
		return "tour/TourRegister";
	}

	// 새 여행 일정 등록 / DB insert!
	@RequestMapping(value = "/TourRegisterInsert", method = RequestMethod.POST)
	public String submit(TourRegisterVO tourregistervo, RegionVO regionvo, ImgVO imgvo,
			@RequestParam MultipartFile imageFile, ModelMap modelMap, Model model) {

		// 썸네일 이미지 주소 생성
		ImageFile fileInfo = imageService.save(imageFile);

		int content_no = 0;

		logger.info("" + regionvo);

		if (fileInfo != null) {
			logger.info("대표 이미지 주소: " + SAVE_IMAGE_DIR + fileInfo.getFileName());
			logger.info("이미지 길이: " + fileInfo.getFileName().length());
		} else {
			logger.info("대실패 ");

		}

		if (tourregistervo != null && regionvo != null) {
			logger.info("mno 확인: " + tourregistervo.getMno());

			// 이상 없으면 여행등록 DB insert!
			int result = tourRegisterService.create(tourregistervo);
			if (result == 1) { // 여행등록 DB insert 성공
				logger.info("여행 등록 성공");

				// 썸네일과 장소를 등록하기 위해 trip_no를 가져오자
				content_no = tourRegisterService.readTrip_no(tourregistervo);
				logger.info("insert content_no: " + content_no);

				tourregistervo = tourSelectService.readRegisterData(content_no);

				model.addAttribute("vo", tourregistervo);
				model.addAttribute("vo2", regionvo);
				modelMap.put("imageFile", fileInfo);

				if (fileInfo.getFileName().length() < 40) {

					ImgVO imagevo = new ImgVO(TourRegisterID, content_no, 0, SAVE_IMAGE_DIR + "default-profile.jpg");
					int result2 = tourRegisterService.createThumnail(imagevo);

					logger.info("결과를 알려줘: " + result2);

					if (result2 == 1) {
						logger.info("기본 썸네일 등록 성공");
					} else {
						logger.info("기본 썸네일 등록 실패");
					}

				} else {

					ImgVO imagevo = new ImgVO(TourRegisterID, content_no, 0, SAVE_IMAGE_DIR + fileInfo.getFileName());
					int result2 = tourRegisterService.createThumnail(imagevo);

					if (result2 == 1) {
						logger.info("직접 썸네일 등록 성공");

						model.addAttribute("vo3", imagevo);
						logger.info("등록하는 이미지 주소: " + imagevo.getImg_url());

						String region_name = regionvo.getRegion_name();
						RegionVO regionvo2 = new RegionVO(content_no, region_name, 0);
						int result3 = tourRegisterService.createRegion(regionvo2);

						if (result3 == 1) {
							logger.info("장소 등록 성공");
						}

					} else {
						logger.info("직접 썸네일 등록 실패");
					}
				}
			} else { // DB insert 실패
				logger.info("여행 등록 실패");
			}

		} else {
			logger.info("응 실패^^");
		}
		/* return "tour/TourRegisterConfirm"; */
		return "redirect:detail?trip_no=" + content_no;

	}

	// DB insert 후 수정할지 말지 정하는 페이지. 수정 누르면 수정(TourRegisterUpdate) 페이지로 넘어간다
	@RequestMapping(value = "/TourRegisterComplete", method = RequestMethod.POST)
	public String tourUpdate(TourRegisterVO tourregistervo, RegionVO regionvo, @RequestParam MultipartFile imageFile,
			ModelMap modelMap, Model model) {

		ImageFile fileInfo = imageService.save(imageFile);

		if (fileInfo != null) {
			logger.info("대표 이미지 주소: " + SAVE_IMAGE_DIR + fileInfo.getFileName());
		} else {
			logger.info("대실패 ");
		}

		if (tourregistervo != null && regionvo != null) {
			model.addAttribute("vo", tourregistervo);
			model.addAttribute("vo2", regionvo);
			modelMap.put("imageFile", fileInfo);
		}

		return "tour/TourRegisterUpdate";
	}

	// 여행 정보 수정 후 TourRegisterConfirm로 돌아간다
	@RequestMapping(value = "/TourRegisterCheck", method = RequestMethod.POST)
	public String tourRegisterCheck(TourRegisterVO tourregistervo, RegionVO regionvo,
			@RequestParam MultipartFile imageFile, ModelMap modelMap, Model model) {

		int content_no = 0;

		ImageFile fileInfo = imageService.save(imageFile);

		logger.info("대표 이미지 주소: " + SAVE_IMAGE_DIR + fileInfo.getFileName());

		if (tourregistervo != null && regionvo != null) {

			model.addAttribute("vo", tourregistervo);
			model.addAttribute("vo2", regionvo);
			modelMap.put("imageFile", fileInfo);

			logger.info("제목: " + tourregistervo.getTitle());
			logger.info("mno: " + tourregistervo.getMno());
			logger.info("trip_no: " + tourregistervo.getTrip_no());

			int result = tourRegisterService.update(tourregistervo);

			if (result == 1) { // 여행등록 DB insert 성공
				logger.info("여행 수정 성공");

				// 썸네일과 장소를 등록하기 위해 trip_no를 가져오자
				tourregistervo = new TourRegisterVO(0, tourregistervo.getMno(), tourregistervo.getTitle(), 0, 0,
						tourregistervo.getContent(), null, tourregistervo.getStart_date(), tourregistervo.getEnd_date(),
						0);
				content_no = tourRegisterService.readTrip_no(tourregistervo);
				logger.info("update content_no" + content_no);

				ImgVO imgvo = new ImgVO(TourRegisterID, content_no, 0, SAVE_IMAGE_DIR + fileInfo.getFileName());
				int result2 = tourRegisterService.updateThumnail(imgvo);

				if (result2 == 1) {
					logger.info("썸네일 수정 성공");

					String region_name = regionvo.getRegion_name();
					RegionVO regionvo2 = new RegionVO(content_no, region_name, 0);
					int result3 = tourRegisterService.updateRegion(regionvo2);

					if (result3 == 1) {
						logger.info("장소 수정 성공");
					}

				} else {
					logger.info("썸네일 수정 실패");
				}

			} else { // DB insert 실패
				logger.info("여행 수정 실패");
			}

		} else {
			logger.info("응 실패^^");
		}

		return "redirect:detail?trip_no=" + content_no;
		/* return "tour/TourRegisterConfirm"; */
	}

	// 여행 정보 등록 직후 칼삭제 : 삭제 후 TourRegister로 돌아간다(detail)
	@RequestMapping(value = "/TourRegisterInsert/{trip_no}", method = RequestMethod.GET)
	public void ajaxDeleteTest(@PathVariable("trip_no") int trip_no) {
		logger.info("여행 번호: " + trip_no);

		int result = tourRegisterService.delete(trip_no);

		if (result == 1) {
			logger.info("여행 삭제 성공");
			int result2 = tourRegisterService.deleteThumnail(trip_no);

			if (result2 == 1) {
				logger.info("썸네일 삭제 성공");
				int result3 = tourRegisterService.deleteRegion(trip_no);

				if (result3 == 1) {
					logger.info("장소 삭제 성공");
				}
			}

		} else {
			logger.info("여행 삭제 실패");
		}
	}

	// 여행 정보 등록 후 수정페이지에서 삭제하려고 할 때 : 삭제 후 TourRegister로 돌아간다
	@RequestMapping(value = "/TourRegisterCheck/{trip_no}", method = RequestMethod.GET)
	public void ajaxDeleteTest2(@PathVariable("trip_no") int trip_no) {
		logger.info("여행 번호: " + trip_no);

		int result = tourRegisterService.delete(trip_no);

		if (result == 1) {
			logger.info("여행 삭제 성공");
			int result2 = tourRegisterService.deleteThumnail(trip_no);

			if (result2 == 1) {
				logger.info("썸네일 삭제 성공");
				int result3 = tourRegisterService.deleteRegion(trip_no);

				if (result3 == 1) {
					logger.info("장소 삭제 성공");
				}
			}
		} else {
			logger.info("여행 삭제 실패");
		}
	}

	// 여행 게시글에서 삭제버튼 클릭 : 삭제 후 TourBoard로 돌아간다
	@RequestMapping(value = "/TourBoardDelete", method = RequestMethod.POST)
	public String ajaxDeleteTest2444(int trip_no) {
		logger.info("여행 번호: " + trip_no);

		int result = tourRegisterService.delete(trip_no);

		if (result == 1) {
			logger.info("여행 삭제 성공");
			int result2 = tourRegisterService.deleteThumnail(trip_no);

			if (result2 == 1) {
				logger.info("썸네일 삭제 성공");
				int result3 = tourRegisterService.deleteRegion(trip_no);

				if (result3 == 1) {
					logger.info("장소 삭제 성공");
				}
			}

		} else {
			logger.info("여행 삭제 실패");
		}
		return "tour/TourBoard";
	}

	// 여행 글에서 수정페이지에서 수정하려고 할 때 : 수정 페이지로 먼저 보낸다
	@RequestMapping(value = "/TourBoardUpdateRequest", method = RequestMethod.POST)
	public String UpdateTest(int trip_no, Model model) {

		// 여행 번호를 가지고 select * from wm_tour 검색 --> vo1으로 받고 model에 실어서 다음 페이지로!
		// select * from wm_tour_region 검색 --> vo2로 받고 model에 실어서 다음 페이지로!

		TourRegisterVO vo1 = tourRegisterService.readTourInfo(trip_no);
		RegionVO vo2 = tourRegisterService.readTourRegionInfo(trip_no);
		ImgVO vo3 = tourRegisterService.readTourMainImage(trip_no);

		if (vo1 != null && vo2 != null && vo3 != null) {

			String start_date = vo1.getStart_date().substring(0, 10);
			String end_date = vo1.getEnd_date().substring(0, 10);

			TourRegisterVO vo4 = new TourRegisterVO(trip_no, vo1.getMno(), vo1.getTitle(), vo1.getCondition_sex(),
					vo1.getCondition_age(), vo1.getContent(), vo1.getRegdate(), start_date, end_date, vo1.getExpire());

			model.addAttribute("tourVO", vo4);
			model.addAttribute("regionVO", vo2);
			model.addAttribute("imgVO", vo3);

			logger.info("수정하기 위한 검색작업 완료");
		} else {
			logger.info("수정하기 위한 검색작업 실패");
		}

		return "tour/TourBoardUpdate";
	}

	// 여행 글에서 수정페이지에서 수정!: 수정 완료하면 redirect
	@RequestMapping(value = "/TourBoardUpdate", method = RequestMethod.POST)
	public String UpdateTest2(TourRegisterVO vo1, RegionVO vo2, @RequestParam MultipartFile imageFile) {

		if (vo1 != null && vo2 != null) {

			int result = tourRegisterService.update(vo1);

			if (result == 1) { // 여행등록 DB insert 성공
				logger.info("여행 수정 성공");

				int result2 = tourRegisterService.updateRegion(vo2);

				if (result2 == 1) {
					logger.info("장소 수정 성공");

					ImageFile fileInfo = imageService.save(imageFile);

					if (fileInfo.getFileName().length() < 40) {
						logger.info("썸네일 수정 안할겁니다");
					} else {

						ImgVO imgvo = new ImgVO(TourRegisterID, vo1.getTrip_no(), 0,
								SAVE_IMAGE_DIR + fileInfo.getFileName());
						int result3 = tourRegisterService.updateThumnail(imgvo);

						if (result3 == 1) {
							logger.info("새로운 여행 썸네일 수정 성공");
						} else {
							logger.info("새로운 여행 썸네일 수정 실패");
						}
					}
				} else {
					logger.info("장소 수정 실패");
				}
			} else {
				logger.info("여행 수정 실패");
			}

		} else { // DB insert 실패
			logger.info("값을 못 받아 왔음");
		}

		return "redirect:detail?trip_no=" + vo1.getTrip_no();
	}

	@RequestMapping("/cancelTourRegister")
	public String tourRegister() {
		return "tour/TourRegister";
	}

	@RequestMapping("/cancelTourRegister2")
	public String gotourRegister() {
		return "tour/TourRegister";
	}

	@RequestMapping("/cancelTourRegister3")
	public String tourRegisterConfirm() {
		return "/TourRegisterComplete";
	}

	// index.jsp 에서 여행 게시판으로 갈때
	@RequestMapping(value = "/tourBoard", method = RequestMethod.GET)
	public String maintotourBoard() {
		logger.info("여행선택 전체게시판");
		return "tour/TourBoard";
	}

	// 여행 등록 후 여행 게시판으로 갈때
	@RequestMapping(value = "/TourBoard", method = RequestMethod.GET)
	public String insertAftertourBoard() {
		logger.info("여행선택 전체게시판");
		return "tour/TourBoard";
	}
}
