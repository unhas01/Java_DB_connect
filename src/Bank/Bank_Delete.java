package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import Main.*;
import java.sql.*;

/*
 * Bank���̺��� �����ϴ� Ŭ�����Դϴ�.
 */

public class Bank_Delete extends JFrame {
	private JTextField txt_bcode;
	public Bank_Delete() {
		setTitle("���� ���� �Է�â");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel Label_bcode = new JLabel("���� �ڵ�");
		Label_bcode.setHorizontalAlignment(SwingConstants.CENTER);
		Label_bcode.setBounds(102, 91, 76, 44);
		getContentPane().add(Label_bcode);
		
		txt_bcode = new JTextField();
		txt_bcode.setBounds(214, 103, 123, 29);
		getContentPane().add(txt_bcode);
		txt_bcode.setColumns(10);
		
		JButton Btn_delete = new JButton("����");
		Btn_delete.setBounds(170, 183, 103, 29);
		getContentPane().add(Btn_delete);
		Btn_delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBconnection obj = new DBconnection();
				Statement stmt = obj.db_connect();
				
				try {
					ResultSet rs = stmt.executeQuery("delete from bank where bcode = '" + txt_bcode.getText() + "'");
				}
				catch( SQLException e1) {
					System.out.println( "DB�� ������ ���� ����"+ e1);
				}
				setVisible(false);
				new MainDB();
			}
			
		});
		
		
	}
}
