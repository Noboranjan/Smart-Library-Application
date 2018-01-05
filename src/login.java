
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class login extends JFrame {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");//for jtattoo connection
					login frame = new login();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public login() {
		
		super("login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images.png"));
		conn = javaConnect.ConnectionDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(32, 41, 81, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(32, 90, 81, 27);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(182, 41, 156, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="select * from Account where Username=? and Password=?";
				try{
					pst=conn.prepareStatement(sql);
				pst.setString(1, textField.getText());
				pst.setString(2, passwordField.getText() );
				rs=pst.executeQuery();
				
				
				if(rs.next()){
					rs.close();
					pst.close();
					
					setVisible(false);
					loading ob=new loading();
					ob.setUpLoading();
					//ob.run();
					ob.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
			}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}finally{
				try{
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
					
				}
			}
			}});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images.jpg"));
		btnNewButton.setBounds(136, 140, 93, 27);
		contentPane.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				SignUp ob=new SignUp();//for connection
				ob.setVisible(true);
			}
		});
		btnSignUp.setBounds(257, 140, 81, 27);
		contentPane.add(btnSignUp);
		
		JButton btnForgetPassword = new JButton("Forgot Password");
		btnForgetPassword.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images (1).jpg"));
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Forgot ob=new Forgot();//for connection
				ob.setVisible(true);
			}
			
		});
		btnForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnForgetPassword.setBounds(168, 182, 156, 27);
		contentPane.add(btnForgetPassword);
		
		JLabel lblNewLabel_1 = new JLabel("Trouble Login!!");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 188, 131, 21);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			//change evt
			public void keyPressed(KeyEvent evt) {
					//code for key
				if(evt.getKeyCode()==KeyEvent.VK_ENTER){
				
				String sql="select * from Account where Username=? and Password=?";
				try{
					pst=conn.prepareStatement(sql);
				pst.setString(1, textField.getText());
				pst.setString(2, passwordField.getText() );
				rs=pst.executeQuery();
				
				
				if(rs.next()){
					rs.close();
					pst.close();
					
					setVisible(false);
					loading ob=new loading();
					ob.setUpLoading();
					ob.setVisible(true);
			}else{
				JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
			}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e);
			}finally{
				try{
					rs.close();
					pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
				
				
			}
				
			}
		});
		passwordField.setBounds(182, 90, 156, 25);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images.png"));
		lblNewLabel_2.setBounds(348, 41, 31, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\standard-house-key-14.png"));
		lblNewLabel_3.setBounds(334, 90, 44, 22);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Login", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
	}
}
