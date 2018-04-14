package com.sj.project.pageutil;

public class PageMakerMyUser {

		// 현재 페이지 번호, 한 페이지에 보여줄 게시글 개수

		private MyUserPaginationCriteria myUcriteria;
		// 전체 게시글 개수
		private int totalCount;
		// 화면에서 보여지는 시작 페이지 링크의 번호
		private int startPageNum;
		// 화면에서 보여지는 끝 페이지 링크의 번호
		private int endPageNum;
		// 화면에서 보여질 페이지 링크의 개수
		private int numOfPageLink;
		// 이전, 다음 페이지 링크가 있는 지
		private boolean hasPrev;
		private boolean hasNext;

		public PageMakerMyUser() {
			numOfPageLink = 5; // 페이지 링크의 개수를 디폴트로 5개로 세팅
		}

		
		

		


		public MyUserPaginationCriteria getMyUcriteria() {
			return myUcriteria;
		}





		public void setMyUcriteria(MyUserPaginationCriteria myUcriteria) {
			this.myUcriteria = myUcriteria;
		}





		public int getTotalCount() {
			return totalCount;
		}

		public int getStartPageNum() {
			return startPageNum;
		}

		public int getEndPageNum() {
			return endPageNum;
		}

		public int getNumOfPageLink() {
			return numOfPageLink;
		}

		public boolean isHasPrev() {
			return hasPrev;
		}

		public boolean isHasNext() {
			return hasNext;
		}
		
		
		
//		
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		
		
			
			
		
		public void setPageData() {
			System.out.println("토탈카운트 입니다."+totalCount);

			int maxPageLink = (int)
					Math.ceil((double)totalCount / myUcriteria.getPerPage());
		
			System.out.println("ssss"+maxPageLink);
			int temp = (int)
					(Math.ceil(myUcriteria.getPage() / (double) numOfPageLink) 
							* numOfPageLink);
			System.out.println("sssss"+temp);
			if (temp < maxPageLink) {
				endPageNum = temp;
			} else {
				endPageNum = maxPageLink;
			}
			
			startPageNum = 
					((endPageNum - 1) / numOfPageLink) * numOfPageLink + 1;
			
		
			if (startPageNum == 1) {
				hasPrev = false;
			} else {
				hasPrev = true;
			}
			
			if (endPageNum * myUcriteria.getPerPage() < totalCount) {
				hasNext= true;
			} else {
				hasNext= false;
			}
		}
		
	}



