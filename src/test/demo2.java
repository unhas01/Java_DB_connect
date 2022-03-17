package test;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class demo2 extends JFrame {
	private Connection conn = null;
	private JLabel state;
	// Table Header Name
	private String colName[] = { "은행코드", "은행이름", "주소" };
	// Table Data list (Header data, adding row)
	private DefaultTableModel model = new DefaultTableModel(colName, 0);
	//Create Table
	private JTable table = new JTable(model);
	private String row[] = new String[3];
	ImageIcon imageicon = new ImageIcon("./image/20174241.jpg");
	JLabel label = new JLabel(imageicon);
	
	// 	JFrame 생성자
	public demo2() {
		setTitle("DataBase Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// BorderLayout을활용해상중하로컴포넌트위치
		setLayout(new BorderLayout());
		// 하단부연결및출력버튼컴포넌트옹패널
		JPanel Btn_panel = new JPanel();
		JPanel panel = new JPanel();
		Btn_panel.setLayout(new FlowLayout());
		panel.setLayout(new FlowLayout());
		// 패널에버튼부착
		panel.add(label);
		//버튼이벤트리스너(액션리스너)
		//DB 연결부
		//DB 연결사용자함수호출
		//버튼이벤트리스너(액션리스너)
		//DB 읽는부
		//DB 상태출력용라벨
		state = new JLabel();
		state.setText("Oracle DB 연동테스트");
		//JFrame에배치관리자를활용한각자의위치부착
		add(state, BorderLayout.NORTH);
		//JScrollPane : 화면에넘어갈경우스크롤바가생김
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(Btn_panel, BorderLayout.EAST);
		add(panel, BorderLayout.WEST);
		try {
			// DB 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seo", "1234");
			state.setText("성공적연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			state.setText("DB 연결실패" + e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			state.setText("DB 연결실패" + e.toString());
		}
		try {
			// Quary
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from bank");
			while (rset.next()) {
				// row 값읽기
				for (int i = 1; i < 4; i++) {
					row[i - 1] = rset.getString(i);
				}
				System.out.println();
				// JTable에출력
				model.addRow(row);
			}
			state.setText("DB 읽기성공");
		} catch (SQLException e) {
			e.printStackTrace();
			state.setText("DB 읽기실패" + e.toString());
		}
		setSize(1300, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new demo2();
	}
}