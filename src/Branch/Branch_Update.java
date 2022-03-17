package Branch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import Main.*;
import java.sql.*;

/*
 * Branch 테이블에 변경을하는 클래스입니다.
 */

public class Branch_Update extends JFrame {
	private JTextField txt_branchnum;
	private JTextField txt_customernum;
	private JTextField txt_customername;
	private JTextField txt_customerphone;
	
	DBconnection obj = new DBconnection();
	
	public Branch_Update() {
		setTitle("분점 업데이트 입력창");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel Label_Branchnum = new JLabel("분점 번호");
		Label_Branchnum.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Branchnum.setBounds(86, 60, 79, 40);
		getContentPane().add(Label_Branchnum);
		
		JLabel Label_Customernum = new JLabel("고객 번호");
		Label_Customernum.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Customernum.setBounds(86, 121, 79, 40);
		getContentPane().add(Label_Customernum);
		
		JLabel Label_Customername = new JLabel("고객 이름");
		Label_Customername.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Customername.setBounds(86, 187, 79, 40);
		getContentPane().add(Label_Customername);
		
		JLabel Label_Customerphone = new JLabel("고객 전화번호");
		Label_Customerphone.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Customerphone.setBounds(86, 252, 79, 40);
		getContentPane().add(Label_Customerphone);
		
		txt_branchnum = new JTextField();
		txt_branchnum.setBounds(217, 70, 130, 30);
		getContentPane().add(txt_branchnum);
		txt_branchnum.setColumns(10);
		
		txt_customernum = new JTextField();
		txt_customernum.setColumns(10);
		txt_customernum.setBounds(217, 131, 130, 30);
		getContentPane().add(txt_customernum);
		
		txt_customername = new JTextField();
		txt_customername.setColumns(10);
		txt_customername.setBounds(217, 197, 130, 30);
		getContentPane().add(txt_customername);
		
		txt_customerphone = new JTextField();
		txt_customerphone.setColumns(10);
		txt_customerphone.setBounds(217, 262, 130, 30);
		getContentPane().add(txt_customerphone);
		
		JButton Btn_Check = new JButton("분점 번호 체크");
		Btn_Check.setBounds(359, 60, 115, 30);
		getContentPane().add(Btn_Check);
		Btn_Check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Statement stmt = obj.db_connect();
				try { 
					ResultSet rs = stmt.executeQuery("select * from branch where branchnum = '" + txt_branchnum.getText() + "'");
					
					String temp = "";
					
					while(rs.next()) {
						temp = rs.getString("branchnum");
					}
					
					if(txt_branchnum.getText().equals(temp)) {
						txt_branchnum.setEnabled(false);
						Btn_Check.setEnabled(false);
					}
					
				}
				catch( SQLException e1) {
					System.out.println( "DB에서 기본값 읽어오기 실패"+ e1);
				}
			}
			
		});
		
		JButton Btn_Update = new JButton("변경");
		Btn_Update.setBounds(172, 312, 130, 41);
		getContentPane().add(Btn_Update);
		Btn_Update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Statement stmt = obj.db_connect();
				try { 
					ResultSet rs = stmt.executeQuery("update branch set customernum = '" + txt_customernum.getText() + "', customername = '" + txt_customername.getText() +
							"', customerphone = '" + txt_customerphone.getText() + "' where branchnum = '" + txt_branchnum.getText() + "'");
					
					
				}
				catch( SQLException e1) {
					System.out.println( "DB에서 변경 실패"+ e1);
				}
				
				setVisible(false);
				new MainDB();
			}
			
		});
	}
}
