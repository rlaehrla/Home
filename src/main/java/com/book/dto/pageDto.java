package com.book.dto;

public class pageDto {

	// 페이지 블럭 시작번호
	int startNo;
	// 페이지 블럭 끝번호
	int endNo;
	// 게시물의 끝 페이지 번호 (총 게시물의 수 / 페이지당 게시물의 수)
	int realEnd;
	// 이전, 다음 버튼( true : 보여주기 )
	boolean prev, next;
	
	// 위의 정보들을 세팅하기 위해서 필요한 값들
	
	// 총 게시물의 수
	int totalCnt;
	// 요청 페이지번호, 페이지당 게시물의 수
	Criteria cri;
	// 페이지블럭에 보여줄 페이지의 수
	int blockAmount = 5;
	
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getRealEnd() {
		return realEnd;
	}
	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getBlockAmount() {
		return blockAmount;
	}
	public void setBlockAmount(int blockAmount) {
		this.blockAmount = blockAmount;
	}
	
	public pageDto(int totalCnt, Criteria cri) {
		this.totalCnt = totalCnt;
		this.cri = cri;
		
		// 요청 페이지, 블럭당 페이지 수에 따라 블럭의 범위가 정해집니다.
		// 페이지 블럭의 시작 번호, 끝 번호
		endNo = (int)Math.ceil(cri.getPageNo()/(blockAmount * 1.0)) * blockAmount;
		startNo = endNo - (blockAmount - 1);
		
		// 페이지 끝번호
		realEnd = (int)Math.ceil((totalCnt * 1.0)/cri.getAmount());
		
		// 게시물이 67건인 경우
		// 페이지 진짜 끝번호는 7인데 블럭의 끝번호는 10 입니다.
		endNo = endNo > realEnd ? realEnd : endNo;
		
		prev = startNo == 1 ? false : true;
		next = endNo == realEnd ? false : true;
		
		System.out.println("blockAmount : " + blockAmount);
		System.out.println("시작번호 : " + startNo);
		System.out.println("끝번호 : " + endNo);
		System.out.println("진짜끝번호 : " + realEnd);
		System.out.println("prev : " + prev);
		System.out.println("next : " + next);
		System.out.println("==============================");
		System.out.println("요청페이지번호 : " + cri.getPageNo());
		System.out.println("페이지당 게시물의 수 : " + cri.getAmount());
		System.out.println("총 게시물의 수 : " + totalCnt);
		
	}
	
	public pageDto(int totalCnt, Criteria cri, String blockAmount){
		this(totalCnt, cri);
		
		if(blockAmount != null && !"".equals(blockAmount)) {
			this.blockAmount = Integer.parseInt(blockAmount);
		}
	}
	
	
}
