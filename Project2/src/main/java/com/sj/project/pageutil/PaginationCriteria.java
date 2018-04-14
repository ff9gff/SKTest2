package com.sj.project.pageutil;

public class PaginationCriteria {

	
	
	
	
	private int page; //현재 화면에 보이는 페이지 번호 
	private int perPage;// 한페이지에 보여질 게시글 개수 
	
	
	public PaginationCriteria(){
		page =1;// 디폴트로 1페이지를 보여준다.,
		perPage =13;  // 디폴트로 한페이지  게시글 10 개씩 보여준다. 
		
		
	}//end public 
	
	
	
	public PaginationCriteria(int page , int perPage){
		
		this.page = page;
		this.perPage = perPage;
	}



	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public int getPerPage() {
		return perPage;
	}



	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
	
	
	// board - mapper. xml 에서 #{start}  #{end} 의 값으로 세팅하기 위해서 
	//다음과 같은 메소드를 설정한다. 
	//한페이지에 5개씩 보여진다고 가정하면 : 
	// 1 페이지 1 - 5   2번은 6 -10 3번은 
	//3 페이지 11 ~ 15
	
	public int getStart(){
		
		int start = (page -1) * perPage +1 ;
		return start;
		
	}
	
	public int getEnd(){
		
		int end = page *perPage;
		return end;
	}
	
	
	
	
	
	
	
	
	
	
	
}









