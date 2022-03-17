package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import Main.*;
import java.sql.*;

/*
 * Bank ���̺� �߰��ϴ� Ŭ�����Դϴ�.
 */

public class Bank_Add extends JFrame {
	private JTextField txt_bcode;
	private JTextField txt_bname;
	private JTextField txt_baddress;
	public Bank_Add() {
		setTitle("���� �߰� �Է�â");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel Label_bcode = new JLabel("���� �ڵ�");
		Label_bcode.setHorizontalAlignment(SwingConstants.CENTER);
		Label_bcode.setBounds(79, 81, 88, 42);
		getContentPane().add(Label_bcode);
		
		JLabel Label_bname = new JLabel("���� �̸�");
		Label_bname.setHorizontalAlignment(SwingConstants.CENTER);
		Label_bname.setBounds(79, 137, 88, 42);
		getContentPane().add(Label_bname);
		
		JLabel Label_baddress = new JLabel("�ּ�");
		Label_baddress.setHorizontalAlignment(SwingConstants.CENTER);
		Label_baddress.setBounds(79, 209, 88, 42);
		getContentPane().add(Label_baddress);
		
		txt_bcode = new JTextField();
		txt_bcode.setBounds(210, 92, 129, 31);
		getContentPane().add(txt_bcode);
		txt_bcode.setColumns(10);
		
		txt_bname = new JTextField();
		txt_bname.setColumns(10);
		txt_bname.setBounds(210, 148, 129, 31);
		getContentPane().add(txt_bname);
		
		txt_baddress = new JTextField();
		txt_baddress.setColumns(10);
		txt_baddress.setBounds(210, 220, 235, 31);
		getContentPane().add(txt_baddress);
		
		JButton Btn_add = new JButton("�߰�");
		Btn_add.setBounds(160, 289, 96, 31);
		getContentPane().add(Btn_add);
		Btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBconnection obj = new DBconnection();
				Statement stmt = obj.db_connect();
				
				try {
					ResultSet rs = stmt.executeQuery("insert into bank values('" + txt_bcode.getText() + "', '" + txt_bname.getText() + "', '" + txt_baddress.getText() + "')");
					

				}
				catch( SQLException e1) {
					System.out.println( "DB�� ������ �߰� ����"+ e1);
				}
				
				setVisible(false);
				new MainDB();
			}
			
		});
		
	}
}
