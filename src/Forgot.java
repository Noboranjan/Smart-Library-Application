import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.JOptionPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Forgot extends JFrame {
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot frame = new Forgot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	

	
	public void search(){
		
		
		String a1=textField.getText();
		String sql="SELECT * FROM Account where Username='"+a1+"' ";
		try{
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(4));
				rs.close();
				pst.close();
				
			}
			else{
				
				JOptionPane.showMessageDialog(null, "Incorrect Username");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void Retrive()
	{
		String a1=textField.getText();
		String a2=textField_3.getText();
		
		
		String sql="select * from Account where Answer='"+a2+"'";
		try{
			
			//String sql="SELECT Password FROM Account where " + "Username=?"+"and Answer=?";
			
			pst=conn.prepareStatement(sql);
			//pst.setString(1, a1);
			//pst.setString(4, a2);
			
			//pst=conn.prepareStatement(sql1);
			rs=pst.executeQuery();
			if (rs.next()){
				textField_4.setText(rs.getString(3));
			}
            else{	
				JOptionPane.showMessageDialog(null, "Incorrect Answer");
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	public Forgot() {
		
		super("Forgot");
		conn = javaConnect.ConnectionDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(51, 76, 82, 23);
		contentPane.add(lblName);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecurityQuestion.setBounds(51, 126, 128, 23);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswer.setBounds(56, 174, 82, 23);
		contentPane.add(lblAnswer);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(51, 221, 82, 23);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(189, 78, 190, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(189, 128, 190, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(189, 176, 190, 23);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(189, 223, 190, 23);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setIcon(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Forgot ob=new Forgot();
				search();
			}
		});
		btnNewButton.setBounds(395, 36, 79, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retrive");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Forgot ob=new Forgot();
				Retrive();
			}
		});
		btnNewButton_1.setBounds(389, 176, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				login ob=new login();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images.jpg"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(234, 275, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(51, 36, 82, 23);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(189, 37, 190, 23);
		contentPane.add(textField);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Forgot Password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 474, 319);
		contentPane.add(panel);
	}

}
