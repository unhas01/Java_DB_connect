package DB;

import java.io.*;
import java.lang.*;
import java.sql.*;
import java.util.logging.*;

/*
 * ����Ŭ DB�� �����ϴ� Ŭ�����Դϴ�.
 * ������ seo�̰� ��й�ȣ�� 1234�Դϴ�.
 */

public class DBconnection {
	final String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	final String db_id = "seo";
	final String db_password = "1234"; // DB���� ����
	Connection conn = null;
	Statement stmt = null; 
	
	public Statement db_connect() {
		try {
			// ���� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password); 
			System.out.println("DB���� ����");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);   
			
		} 
		catch (SQLException ex) 
		{
			System.out.println("DB���� ����");
		} 
		catch (ClassNotFoundException ex) 
		{
			System.out.println("JDBC ����̹� �ε� ���� "); 
		}
		
		return stmt;
	}  
	
	/**
	* �����ͺ��̽����� ���� ����
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

