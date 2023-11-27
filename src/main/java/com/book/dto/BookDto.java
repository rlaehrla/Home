package com.book.dto;

public class BookDto {
	private String no;
	private String title;
	private String rentyn;
	private String author;	
	private String rentynStr;	
	
	
	@Override
	public String toString() {
		return "[no : " + no + " title : " + title + " rentyn : " + rentyn + " author : " + author +"]";
	}

	public BookDto(String no, String title, String rentyn, String author) {
		super();
		this.no = no;
		this.title = title;
		this.rentyn = rentyn;
		this.author = author;
		
		this.rentynStr = rentyn.equals("Y") ? "대여중" : "대여 가능";
	}
	public BookDto() {
		// TODO Auto-generated constructor stub
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRentyn() {
		return rentyn;
	}
	public void setRentyn(String rentyn) {
		this.rentyn = rentyn;
		this.rentynStr = rentyn.equals("Y") ? "대여중" : "대여 가능";
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRentynStr() {
		return rentynStr;
	}

	public void setRentynStr(String rentynStr) {
		this.rentynStr = rentynStr;
	}
	
	
}
