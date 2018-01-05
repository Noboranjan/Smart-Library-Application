import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Statistics extends JFrame {
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	
	private JTable table;
	private JTable table_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void JTable(){
		try{
			String sql="select Book_ID,Name,Edition,Publisher,Price,Pages from Issue";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void JTable2(){
		try{
			String sql="select Student_ID,SName,Father_Name,Course,Branch,DateofReturn,Semester from Return";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
	public Statistics() {
		
		super("Statistic");
		conn = javaConnect.ConnectionDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 42, 599, 190);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(45, 299, 599, 182);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Issue Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 664, 244);
		getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Return Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(10, 266, 664, 244);
		getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Home ob=new Home();
				ob.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(302, 521, 89, 23);
		getContentPane().add(btnNewButton);
		
		JTable();
		JTable2();
		

	}
}
