package com.book.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.dto.BookDto;
import com.book.dto.Criteria;
import com.common.DBConnPool;

public class BookDao extends DBConnPool{

	/**
	 * DB에서 도서목록 조회 해서 리스트에 담아서 반환 해줌
	 * @return
	 */
	public List<BookDto> getList(Criteria cri) {
		List<BookDto> list = new ArrayList<>();
		String where = "";
		if(!"".equals(cri.getSearchField()) && !"".equals(cri.getSearchWord())) {
			where = " where " + cri.getSearchField() + " like '%" + cri.getSearchWord() + "%'";
		}
		String sql = "SELECT * FROM (\r\n"
				+ "    SELECT t.*, ROWNUM rnum \r\n"
				+ "    FROM (\r\n"
				+ "        SELECT * \r\n"
				+ "        FROM book \r\n"
				+ where
				+ "        ORDER BY no ASC\r\n"
				+ "    ) t\r\n"
				+ ") \r\n"
				+ "WHERE rnum BETWEEN ? AND ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			// 페이지 파라메터 세팅
			pstmt.setInt(1, cri.getStartNum());
			pstmt.setInt(2, cri.getEndNum());
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("no");
				String title = rs.getString("title");
				String rentyn = rs.getString("rentyn");
				String author = rs.getString("author");
				
				BookDto dto = new BookDto(no, title, rentyn, author);
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}
	
	/**
	 * 도서의 상세 정보를 조회 후 반환함
	 * @param no
	 * @return
	 */
	public BookDto view (String no) {
		BookDto dto = new BookDto();
		String sql = "select * from book where no = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNo(rs.getString("no"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setRentyn(rs.getString("rentyn"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	
	/**
	 * 도서의 총 건수를 조회 합니다.
	 * @return
	 */
	public int getTotalCnt(){
		int res = 0;
		String sql = "select count(*) from book";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int regBook(BookDto dto) {
		String sql = "insert into book(no, title, rentyn, author) values (seq_book_no.nextval, ?, 'N', ?)";
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getAuthor());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
}
