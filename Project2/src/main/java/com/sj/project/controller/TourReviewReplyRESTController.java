
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
import com.sj.project.domain.ReviewReplyVO;
import com.sj.project.service.TourReviewReplyService;

@RestController
@RequestMapping(value = "/review/detail/reply")
public class TourReviewReplyRESTController {

	@Autowired
	private TourReviewReplyService reviewReplyService;

	// 데이터 입력
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> createReply(@RequestBody ReviewReplyVO reviewreplyvo) {
		ResponseEntity<Integer> entity = null;
		
		int result = reviewReplyService.create(reviewreplyvo);		
		if (result == 1) { // DB insert 성공
			entity = new ResponseEntity<Integer>(1, HttpStatus.OK);
		} else { // DB insert 실패
			entity = new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
		} // end if()

		return entity;
	}// end createReply()

	// 해당 게시글의 모든 댓글 목록을 읽어오는 메소드
	@RequestMapping(value = "/all/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<ReviewReplyVO>> readReplies(@PathVariable("no") Integer review_no) {
		
		System.out.println("##### review_no : " + review_no);
		
		List<ReviewReplyVO> list = reviewReplyService.read(review_no);
		ResponseEntity<List<ReviewReplyVO>> entity = null;
		
		if (list != null) { // select 성공
			entity = new ResponseEntity<List<ReviewReplyVO>>(list, HttpStatus.OK);
		} else { // select 실패
			entity = new ResponseEntity<List<ReviewReplyVO>>(list, HttpStatus.BAD_REQUEST);
		} // end if

		return entity;
	}// end readReplies()
	
	/**
	 *
	 */
	// 해당 신청자의 프로필을 읽어오는 메소드 → 댓글 쓴 사람들의 프로필을 읽어오는 메소드
	@RequestMapping(value="/person/{no}", method = RequestMethod.GET)
	public ResponseEntity<List<PersonalVO>> readPerson(@PathVariable("no") Integer review_no){
		List<PersonalVO> list = reviewReplyService.readPerson(review_no);
		ResponseEntity<List<PersonalVO>> entity = null;
		
		if(list != null){ // select 성공
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		}else{ // select 실패
			entity = new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}// end if
		
		return entity;
	} // end readPerson()

	// 해당 댓글을 수정
	@RequestMapping(value = "/{no}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateReply(@PathVariable("no") Integer rno, @RequestBody ReviewReplyVO reviewreplyvo) {
		ResponseEntity<String> entity = null;

		reviewreplyvo.setRno(rno);
		
		int result = reviewReplyService.update(reviewreplyvo);
		if (result == 1) { // update 성공
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else { // update 실패
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		} // end if()

		return entity;
		
	}// end updateReply()

	// 해당 댓글을 삭제
	@RequestMapping(value = "/{no}/{parent}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReply(@PathVariable("no") Integer rno, @PathVariable("parent") Integer parentrno) {
		ResponseEntity<String> entity = null;
		int result = 0;

		result = reviewReplyService.delete(rno);
		if (parentrno == 0) {
			reviewReplyService.allDelete(rno);
		} // end if (parentrno == 0)

		if (result == 1) { // delete 성공
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} else { // delete 실패
			entity = new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		} // end if(result == 1)

		return entity;
	}// end deleteReply()
	
	// 해당 프로필의 이미지 주소를 읽어오는 메소드
	@RequestMapping(value = "/profile/{no}", method = RequestMethod.GET)
	public ResponseEntity<String> readImg(@PathVariable("no") Integer mno) {
		ImgVO src = reviewReplyService.readProfile(mno);
		String address = src.getImg_url();
		ResponseEntity<String> entity = null;
		if (src != null) { // select 성공
			entity = new ResponseEntity<>(address, HttpStatus.OK);
		} else { // select 실패
			entity = new ResponseEntity<>(address, HttpStatus.BAD_REQUEST);
		} // end if

		return entity;
	} // end readImg()
	

}// end class TourReviewReplyRESTController