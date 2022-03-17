package Branch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import Main.*;
import java.sql.*;


/*
 * Branch ���̺� �߰��ϴ� Ŭ�����Դϴ�.
 */

public class Branch_Add extends JFrame {
	private JTextField txt_branchnum;
	private JTextField txt_customernum;
	private JTextField txt_customername;
	private JTextField txt_customerphone;
	
	public Branch_Add() {
		setTitle("���� �߰� �Է�â");
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel Label_Branchnum = new JLabel("���� ��ȣ");
		Label_Branchnum.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Branchnum.setBounds(95, 77, 83, 27);
		getContentPane().add(Label_Branchnum);
		
		JLabel Label_Customernum = new JLabel("�� ��ȣ");
		Label_Customernum.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Customernum.setBounds(95, 125, 83, 27);
		getContentPane().add(Label_Customernum);
		
		JLabel Label_Customername = new JLabel("�� �̸�");
		Label_Customername.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Customername.setBounds(95, 179, 83, 27);
		getContentPane().add(Label_Customername);
		
		JLabel Label_Customerphone = new JLabel("�� ��ȭ��ȣ");
		Label_Customerphone.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Customerphone.setBounds(95, 232, 83, 27);
		getContentPane().add(Label_Customerphone);
		
		txt_branchnum = new JTextField();
		txt_branchnum.setBounds(229, 80, 124, 24);
		getContentPane().add(txt_branchnum);
		txt_branchnum.setColumns(10);
		
		txt_customernum = new JTextField();
		txt_customernum.setColumns(10);
		txt_customernum.setBounds(229, 128, 124, 24);
		getContentPane().add(txt_customernum);
		
		txt_customername = new JTextField();
		txt_customername.setColumns(10);
		txt_customername.setBounds(229, 182, 124, 24);
		getContentPane().add(txt_customername);
		
		txt_customerphone = new JTextField();
		txt_customerphone.setColumns(10);
		txt_customerphone.setBounds(229, 235, 124, 24);
		getContentPane().add(txt_customerphone);
		
		JButton Btn_add = new JButton("�߰�");
		Btn_add.setBounds(175, 290, 91, 40);
		getContentPane().add(Btn_add);
		Btn_add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBconnection obj = new DBconnection();
				Statement stmt = obj.db_connect();
				
				try {
					ResultSet rs = stmt.executeQuery("insert into branch values('" + txt_branchnum.getText() + "', '" + txt_customernum.getText() 
					+ "', '" + txt_customername.getText() + "', '" + txt_customerphone.getText()  + "')");

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
