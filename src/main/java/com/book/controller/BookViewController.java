package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BookDao;
import com.book.dto.BookDto;


@WebServlet("/view")
public class BookViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDao dao = new BookDao();
		BookDto dto = dao.view(request.getParameter("no"));
		request.setAttribute("bookDto", dto);
		
		dao.close();
		
		request.getRequestDispatcher("/book/view.jsp").forward(request, response);

	}
}
