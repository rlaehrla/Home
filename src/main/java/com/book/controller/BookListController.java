package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
import com.book.dto.BookDto;
import com.book.dto.Criteria;
import com.book.dto.pageDto;


@WebServlet("/bookList")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 요청 정보를 수집
		Criteria cri = new Criteria(request.getParameter("pageNo")
									, request.getParameter("amount")
									, request.getParameter("searchField")
									, request.getParameter("searchWord"));		
		System.out.println(cri);
		// 도서목록 조회 후 request 에 담아줌 > 화면에 출력 하기 위해서
		BookDao dao = new BookDao();
		List<BookDto> list = dao.getList(cri);
		request.setAttribute("list", list);
		
		// 페이지 블럭을 생성하기 위한 객체
		pageDto pageDto = new pageDto(dao.getTotalCnt(), cri);
		request.setAttribute("pageDto", pageDto);		
		
		// 자원반납
		dao.close();
		
		// JSP 화면으로 전환(forward방식)
		request.getRequestDispatcher("/book/bookMain.jsp").forward(request, response);
	}
}
