package Main;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import DB.*;
import Bank.*;
import Branch.*;

/*
 * Main ȭ�� �Դϴ�.
 */

public class MainDB extends JFrame {
	
	private String colName1 [] = { "���� �ڵ�", "���� �̸�", "�ּ�"};
	private DefaultTableModel model1 = new DefaultTableModel(colName1, 0);
	private JTable table1 = new JTable(model1);
	private String row1[] = new String[3];
	
	private String colName2 [] = {"���� ��ȣ", "�� ��ȣ", "�� �̸�", "�� ��ȭ��ȣ"};
	private DefaultTableModel model2 = new DefaultTableModel(colName2, 0);
	private JTable table2 = new JTable(model2);
	private String row2[] = new String[4];
	
	public MainDB() {
		setVisible(true);
		setTitle("���� ���� ����");
		setSize(1200, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel1.setBounds(25, 66, 460, 250);
		getContentPane().add(panel1);
		panel1.add(new JScrollPane(table1));
		
		JLabel Label_Bank = new JLabel("���� ����");
		Label_Bank.setFont(new Font("����", Font.BOLD, 20));
		Label_Bank.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Bank.setBounds(136, 8, 197, 48);
		getContentPane().add(Label_Bank);
		
		JLabel Label_Branch_Cusomer = new JLabel("���� ���� �� ����");
		Label_Branch_Cusomer.setHorizontalAlignment(SwingConstants.CENTER);
		Label_Branch_Cusomer.setFont(new Font("����", Font.BOLD, 20));
		Label_Branch_Cusomer.setBounds(732, 10, 197, 48);
		getContentPane().add(Label_Branch_Cusomer);
		
		JButton Btn_Bank_Search = new JButton("�˻�");
		Btn_Bank_Search.setBounds(25, 343, 65, 30);
		getContentPane().add(Btn_Bank_Search);
		Btn_Bank_Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBconnection obj = new DBconnection();
				Statement stmt;
				stmt = obj.db_connect();
				
				try {
					ResultSet rs = stmt.executeQuery("select * from bank");
					while(rs.next()) {
						for(int i = 1; i < 4; i++) {
							row1[i-1] = rs.getString(i);
						}
						System.out.println();
						model1.addRow(row1);
					}
					
					
				}
				catch( SQLException e1) {
					System.out.println( "DB���� �о���� ����"+ e1);
				}
			}
			
		});
		
		JButton Btn_Bank_Add = new JButton("�߰�");
		Btn_Bank_Add.setBounds(160, 343, 65, 30);
		getContentPane().add(Btn_Bank_Add);
		Btn_Bank_Add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Bank_Add();
			}
			
		});
		
		JButton Btn_Bank_Delete = new JButton("����");
		Btn_Bank_Delete.setBounds(294, 343, 65, 30);
		getContentPane().add(Btn_Bank_Delete);
		Btn_Bank_Delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Bank_Delete();
			}
		});
		
		JButton Btn_Bank_Update = new JButton("����");
		Btn_Bank_Update.setBounds(437, 343, 65, 30);
		getContentPane().add(Btn_Bank_Update);
		Btn_Bank_Update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Bank_Update();
			}
			
		});
		
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel2.setBounds(600, 66, 460, 250);
		getContentPane().add(panel2);
		panel2.add(new JScrollPane(table2));
		
		JButton Btn_Branch_Search = new JButton("�˻�");
		Btn_Branch_Search.setBounds(600, 343, 65, 30);
		getContentPane().add(Btn_Branch_Search);
		Btn_Branch_Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DBconnection obj = new DBconnection();
				Statement stmt;
				stmt = obj.db_connect();
				
				try {
					ResultSet rs = stmt.executeQuery("select * from branch");
					while(rs.next()) {
						for(int i = 1; i < 5; i++) {
							row2[i-1] = rs.getString(i);
						}
						System.out.println();
						model2.addRow(row2);
					}
					
					
				}
				catch( SQLException e1) {
					System.out.println( "DB���� �о���� ����"+ e1);
				}
			}
			
		});
		
		JButton Btn_Branch_Add = new JButton("�߰�");
		Btn_Branch_Add.setBounds(732, 343, 65, 30);
		getContentPane().add(Btn_Branch_Add);
		Btn_Branch_Add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Branch_Add();
			}
			
		});
		
		JButton Btn_Branch_Delete = new JButton("����");
		Btn_Branch_Delete.setBounds(864, 343, 65, 30);
		getContentPane().add(Btn_Branch_Delete);
		Btn_Branch_Delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Branch_Delete();
			}
			
		});
		
		JButton Btn_Branch_Update = new JButton("����");
		Btn_Branch_Update.setBounds(982, 343, 65, 30);
		getContentPane().add(Btn_Branch_Update);
		Btn_Branch_Update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new Branch_Update();
			}
			
		});
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainDB();
	}
}
