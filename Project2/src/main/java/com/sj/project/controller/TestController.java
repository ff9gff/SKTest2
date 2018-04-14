package com.sj.project.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sj.project.domain.ImageFile;
import com.sj.project.domain.TourRegisterVO;
import com.sj.project.service.ImageService;
import com.sj.project.service.ImageView;

@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

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

	/**
	 * 이미지 업로드를 위한 페이지 매핑
	 */
	@RequestMapping("/uploadPage")
	private String uploadView() {
		return "upload";
	}

	/**
	 * 이미지 업로드 페이지의 폼에서 전송 시 받게 되는 메서드
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	private String upload(@RequestParam MultipartFile imageFile, ModelMap modelMap) {
		ImageFile fileInfo = imageService.save(imageFile);

		modelMap.put("imageFile", fileInfo);

		return "TourRegister";
	}

	@RequestMapping("/image/{imageId}")
	private ImageView getImage(@PathVariable String imageId, TourRegisterVO vo, ModelMap modelMap) {
		ImageFile imageFile = imageService.get(imageId);

		logger.info("" + vo.getTrip_no());

		modelMap.put("imageFile", imageFile);

		return imageView;
	}

	@RequestMapping("/form")
	public String form() {
		return "form";
	}

	@RequestMapping("/MyPage")
	public String myPage() {
		return "MyPage";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void main() {
		logger.info("index.jsp 소환");
	}

}
