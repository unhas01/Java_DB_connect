package test;

import java.lang.*;
import java.sql.*;
public class demo {
	
	private Connection conn = null;
						
	public void connect() {
		try {
			Class.forName( "oracle.jdbc.driver.OracleDriver"); //DriverManager 클래스에등록
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seo", "1234"); //DB 접속
			System.out.println( "성공적으로로딩되었음" );
			Statement stmt = conn.createStatement (); // Statement 생성
			ResultSet rset = stmt.executeQuery ("select * from bank"); // 쿼리문수행
			System.out.println("은행코드\t은행이름\t주소");
			while (rset.next ()) //쿼리문결과출력
			{
				for(int i = 1 ; i < 4 ; i++)
					System.out.print(rset.getString(i)+ "\t");
				System.out.println();
			}
		} catch( ClassNotFoundException e ) {
			System.out.println( "해당드라이버를찾을수없습니다.\n" + e);
		} catch( SQLException e) {
			System.out.println( "해당드라이버를찾을수없습니다.\n" + e);
		}
	}
	
	public static void main( String[] args ){
		new demo().connect();
	}
}


