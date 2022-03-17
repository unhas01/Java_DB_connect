package Branch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import Main.*;
import java.sql.*;

/*
 * Branch 테이블에 삭제를 하는 클래스 입니다.
 */

public class Branch_Delete extends JFrame {
	private JTextField txt_branchnum;
	
	public Branch_Delete() {
		setTitle("분점 삭제 입력창");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel Label_Branchnum = new JLabel("분점 번호");
		Label_Branchnum.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Branchnum.setBounds(104, 103, 104, 59);
		getContentPane().add(Label_Branchnum);
		
		txt_branchnum = new JTextField();
		txt_branchnum.setBounds(223, 122, 144, 29);
		getContentPane().add(txt_branchnum);
		txt_branchnum.setColumns(10);
		
		JButton Btn_delete = new JButton("삭제");
		Btn_delete.setBounds(174, 199, 104, 45);
		getContentPane().add(Btn_delete);
		Btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBconnection obj = new DBconnection();
				Statement stmt = obj.db_connect();
				
				try {
					ResultSet rs = stmt.executeQuery("delete from branch where branchnum = '" + txt_branchnum.getText() + "'");
				}
				catch( SQLException e1) {
					System.out.println( "DB에 데이터 삭제 실패"+ e1);
				}
				setVisible(false);
				new MainDB();
			}
			
		});
		
	}
}
