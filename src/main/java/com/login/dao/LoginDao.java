package com.login.dao;

import java.sql.SQLException;

import com.common.DBConnPool;
import com.login.dto.LoginDto;

public class LoginDao extends DBConnPool{
	
	public LoginDto login(String id, String pw) {
		LoginDto dto = new LoginDto();
		String sql = "select * from member where id = ? and pass = ?";
		
		try {
			// 입력받은 사용자 정보를 DB로 부터 조회
			pstmt = con.prepareStatement(sql);
			// 파라메터 세팅
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				return dto;
			} else {
				// 로그인 실패
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
