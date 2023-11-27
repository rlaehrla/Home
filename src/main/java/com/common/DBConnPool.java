package com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnPool {

		public Connection con;
		public Statement stmt;
		public PreparedStatement pstmt;
		public ResultSet rs;
		
		public DBConnPool() {			
			try {
				Context initContext = new InitialContext();
				Context envContext = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
				
				con = ds.getConnection();
				
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		public void close() {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
					
					System.out.println("자원 반납 성공");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
		
		 
		
}
