package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import Main.*;
import java.sql.*;

/*
 * Bank 테이블에 값을 변경하는 클래스입니다.
 */

public class Bank_Update extends JFrame {
	private JTextField txt_bcode;
	private JTextField txt_baddress;

	DBconnection obj = new DBconnection();
	
	public Bank_Update() {
		setTitle("은행 업데이트 입력창");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel Label_bcode = new JLabel("은행 코드");
		Label_bcode.setHorizontalAlignment(SwingConstants.CENTER);
		Label_bcode.setBounds(101, 85, 81, 33);
		getContentPane().add(Label_bcode);
		
		JLabel Label_bname = new JLabel("은행 이름");
		Label_bname.setHorizontalAlignment(SwingConstants.CENTER);
		Label_bname.setBounds(101, 150, 81, 33);
		getContentPane().add(Label_bname);
		
		JLabel Label_baddress = new JLabel("은행 주소");
		Label_baddress.setHorizontalAlignment(SwingConstants.CENTER);
		Label_baddress.setBounds(101, 222, 81, 33);
		getContentPane().add(Label_baddress);
		
		txt_bcode = new JTextField();
		txt_bcode.setBounds(221, 91, 132, 27);
		getContentPane().add(txt_bcode);
		txt_bcode.setColumns(10);
		
		JTextField txt_bname = new JTextField();
		txt_bname.setBounds(221, 153, 135, 27);
		getContentPane().add(txt_bname);
		txt_bname.setColumns(10);
		
		txt_baddress = new JTextField();
		txt_baddress.setBounds(221, 222, 240, 33);
		getContentPane().add(txt_baddress);
		txt_baddress.setColumns(10);
		
		JButton Btn_check = new JButton("은행 코드 체크");
		Btn_check.setBounds(329, 50, 132, 27);
		getContentPane().add(Btn_check);
		Btn_check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Statement stmt = obj.db_connect();
				try { 
					ResultSet rs = stmt.executeQuery("select * from bank where bcode = '" + txt_bcode.getText() + "'");
					
					String temp = "";
					
					while(rs.next()) {
						temp = rs.getString("bcode");
					}
					
					if(txt_bcode.getText().equals(temp)) {
						txt_bcode.setEnabled(false);
						Btn_check.setEnabled(false);
					}
					
				}
				catch( SQLException e1) {
					System.out.println( "DB에서 기본값 읽어오기 실패"+ e1);
				}
				
			}
			
		});
		
		JButton Btn_Update = new JButton("변경");
		Btn_Update.setBounds(173, 289, 100, 33);
		getContentPane().add(Btn_Update);
		Btn_Update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Statement stmt = obj.db_connect();
				try {
					ResultSet rs = stmt.executeQuery("update bank set bname = '" + txt_bname.getText() + "', baddress = '" + txt_baddress.getText() + "' where bcode = '" + txt_bcode.getText() + "'");

				}
				catch( SQLException e1) {
					System.out.println( "DB 변경 실패"+ e1);
				}
				
				setVisible(false);
				new MainDB();
			}
			
		});
		
	}
	
	
}
