package test;

import java.lang.*;
import java.sql.*;
public class demo {
	
	private Connection conn = null;
						
	public void connect() {
		try {
			Class.forName( "oracle.jdbc.driver.OracleDriver"); //DriverManager Ŭ���������
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seo", "1234"); //DB ����
			System.out.println( "���������ηε��Ǿ���" );
			Statement stmt = conn.createStatement (); // Statement ����
			ResultSet rset = stmt.executeQuery ("select * from bank"); // ����������
			System.out.println("�����ڵ�\t�����̸�\t�ּ�");
			while (rset.next ()) //������������
			{
				for(int i = 1 ; i < 4 ; i++)
					System.out.print(rset.getString(i)+ "\t");
				System.out.println();
			}
		} catch( ClassNotFoundException e ) {
			System.out.println( "�ش����̹���ã���������ϴ�.\n" + e);
		} catch( SQLException e) {
			System.out.println( "�ش����̹���ã���������ϴ�.\n" + e);
		}
	}
	
	public static void main( String[] args ){
		new demo().connect();
	}
}


