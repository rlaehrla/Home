package com.book.dao;

import java.sql.SQLException;

import com.book.dto.FileDto;
import com.common.DBConnPool;

public class FileDao extends DBConnPool {
	
	public int regFile(FileDto fileDto) {
		String sql = "INSERT INTO tbl_file ( file_no, name, title, cate, ofile, sfile)\r\n"
				+ "VALUES (seq_tbl_file_seq.nextval, ?, ?, ?, ?, ?)";
		int res = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileDto.getName());
			pstmt.setString(2, fileDto.getTitle());
			pstmt.setString(3, fileDto.getCate());
			pstmt.setString(4, fileDto.getOfile());
			pstmt.setString(5, fileDto.getSfile());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return res;
	}
}
