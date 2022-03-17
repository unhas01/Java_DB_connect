package DB;

import java.io.*;
import java.lang.*;
import java.sql.*;
import java.util.logging.*;

/*
 * 오라클 DB와 연결하는 클래스입니다.
 * 계정은 seo이고 비밀번호는 1234입니다.
 */

public class DBconnection {
	final String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	final String db_id = "seo";
	final String db_password = "1234"; // DB연결 관련
	Connection conn = null;
	Statement stmt = null; 
	
	public Statement db_connect() {
		try {
			// 연결 생성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password); 
			System.out.println("DB연결 성공");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);   
			
		} 
		catch (SQLException ex) 
		{
			System.out.println("DB연결 오류");
		} 
		catch (ClassNotFoundException ex) 
		{
			System.out.println("JDBC 드라이버 로드 오류 "); 
		}
		
		return stmt;
	}  
	
	/**
	* 데이터베이스와의 연결 해제
	*/
	public void db_close() { 
		try 
		{
			conn.close();
		} 
		catch (SQLException ex) {
			Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex); 
		}
	}

}

