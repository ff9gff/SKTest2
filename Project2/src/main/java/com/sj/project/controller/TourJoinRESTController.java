package com.sj.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sj.project.domain.ImgVO;
import com.sj.project.domain.PersonalVO;
import com.sj.project.domain.TourJoinVO;
import com.sj.project.service.TourJoinService;

@RestController
@RequestMapping(value = "/tour/detail/apply")
public class TourJoinRESTController {

	@Autowired
	private TourJoinService service;

	// 신청하기
	@RequestMapping(value="/insert/{trip}/{mno}", method = RequestMethod.POST)
	public ResponseEntity<Integer> createApply(@PathVariable("trip") Integer trip_no, @PathVariable("mno") Integer mno) {
		ResponseEntity<Integer> entity = null;
		int result = service.create(trip_no, mno);

		if (result == 1) { // DB insert 성공
			entity = new ResponseEntity<Integer>(1, HttpStatus.OK);
		} else { // DB insert 실패
			entity = new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 해당 게시글의 모든 신청 목록을 읽어오는 메소드
	@RequestMapping(value = "/all/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<TourJoinVO>> readApply(@PathVariable("no") Integer trip_no) {
		List<TourJoinVO> list = service.readList(trip_no);
		ResponseEntity<List<TourJoinVO>> entity = null;

		if (list != null) { // select 성공
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} else { // select 실패
			entity = new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		} // end if

		return entity;
	}

	// 해당 신청자의 프로필을 읽어오는 메소드
	@RequestMapping(value = "/person/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<PersonalVO>> readPerson(@PathVariable("no") Integer trip_no) {
		List<PersonalVO> list = service.readPerson(trip_no);
		ResponseEntity<List<PersonalVO>> entity = null;
		if (list != null) { // select 성공
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		} else { // select 실패
			entity = new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		} // end if
		return entity;
	}

	// 해당 프로필의 이미지 주소를 읽어오는 메소드
	@RequestMapping(value = "/profile/{no}", method = RequestMethod.GET)
	public ResponseEntity<String> readImg(@PathVariable("no") Integer mno) {
		ImgVO src = service.readProfile(mno);
		String address = src.getImg_url();
		ResponseEntity<String> entity = null;
		if (src != null) { // select 성공
			entity = new ResponseEntity<>(address, HttpStatus.OK);
		} else { // select 실패
			entity = new ResponseEntity<>(address, HttpStatus.BAD_REQUEST);
		} // end if

		return entity;
	}

	// 해당 신청자의 승인여부
	@RequestMapping(value = "/{no}/{list_no}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateApply(@PathVariable("no") Integer approval,
			@PathVariable("list_no") Integer list_no) {
		ResponseEntity<String> entity = null;

		int result = service.update(approval, list_no);
		if (result == 1) { // update 성공
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else { // update 실패
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		} // end if()

		return entity;
	}
	
	// 해당 여행의 마감 여부
		@RequestMapping(value = "/end/{trip_no}", method = RequestMethod.PUT)
		public ResponseEntity<String> endTrip(@PathVariable("trip_no") Integer trip_no) {
			ResponseEntity<String> entity = null;

			int result = service.endTrip(trip_no);
			if (result == 1) { // update 성공
				entity = new ResponseEntity<String>("success", HttpStatus.OK);
			} else { // update 실패
				entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
			} // end if()

			return entity;
		}

}// end class TourJoinRESTController
