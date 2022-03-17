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
	private String colName[] = { "�����ڵ�", "�����̸�", "�ּ�" };
	// Table Data list (Header data, adding row)
	private DefaultTableModel model = new DefaultTableModel(colName, 0);
	//Create Table
	private JTable table = new JTable(model);
	private String row[] = new String[3];
	ImageIcon imageicon = new ImageIcon("./image/20174241.jpg");
	JLabel label = new JLabel(imageicon);
	
	// 	JFrame ������
	public demo2() {
		setTitle("DataBase Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// BorderLayout��Ȱ���ػ����Ϸ�������Ʈ��ġ
		setLayout(new BorderLayout());
		// �ϴܺο������¹�ư������Ʈ���г�
		JPanel Btn_panel = new JPanel();
		JPanel panel = new JPanel();
		Btn_panel.setLayout(new FlowLayout());
		panel.setLayout(new FlowLayout());
		// �гο���ư����
		panel.add(label);
		//��ư�̺�Ʈ������(�׼Ǹ�����)
		//DB �����
		//DB ���������Լ�ȣ��
		//��ư�̺�Ʈ������(�׼Ǹ�����)
		//DB �дº�
		//DB ������¿��
		state = new JLabel();
		state.setText("Oracle DB �����׽�Ʈ");
		//JFrame����ġ�����ڸ�Ȱ���Ѱ�������ġ����
		add(state, BorderLayout.NORTH);
		//JScrollPane : ȭ�鿡�Ѿ��콺ũ�ѹٰ�����
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(Btn_panel, BorderLayout.EAST);
		add(panel, BorderLayout.WEST);
		try {
			// DB ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seo", "1234");
			state.setText("����������");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			state.setText("DB �������" + e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			state.setText("DB �������" + e.toString());
		}
		try {
			// Quary
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from bank");
			while (rset.next()) {
				// row ���б�
				for (int i = 1; i < 4; i++) {
					row[i - 1] = rset.getString(i);
				}
				System.out.println();
				// JTable�����
				model.addRow(row);
			}
			state.setText("DB �б⼺��");
		} catch (SQLException e) {
			e.printStackTrace();
			state.setText("DB �б����" + e.toString());
		}
		setSize(1300, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new demo2();
	}
}