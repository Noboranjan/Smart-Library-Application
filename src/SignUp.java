import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SignUp extends JFrame {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SignUp() {
		
		super("Signup");
		conn = javaConnect.ConnectionDb();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 29, 69, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Name");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(37, 66, 93, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(37, 103, 69, 26);
		contentPane.add(lblPassword);
		
		JLabel lblSecurityQuestions = new JLabel("Security Question");
		lblSecurityQuestions.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecurityQuestions.setBounds(37, 140, 130, 26);
		contentPane.add(lblSecurityQuestions);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswer.setBounds(37, 177, 69, 26);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(194, 29, 230, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(194, 71, 230, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(194, 106, 230, 25);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(194, 177, 230, 25);
		contentPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select One", "What is your mother toungue?", "What is your nick name?", "What is your first childhood friend?", "What is your school name?"}));
		comboBox.setBounds(194, 140, 230, 25);
		contentPane.add(comboBox);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String sql="Insert into Account (Username,Name,Password,Security_Question,Answer) values(?,?,?,?,?)";
				
				try{
					
					pst=conn.prepareStatement(sql);
					pst.setString(1,textField.getText() );
					pst.setString(2,textField_1.getText() );
					pst.setInt(3, Integer.parseInt(textField_2.getText()));
					pst.setString(4,(comboBox.getSelectedItem()).toString());
					pst.setString(5,textField_3.getText() );
					pst.execute();
					JOptionPane.showMessageDialog(null, "New Account Created");
					//rs.close();
					//pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnCreate.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images.png"));
		btnCreate.setBounds(84, 233, 112, 34);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				login ob=new login();//for connection
				ob.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images.jpg"));
		btnBack.setBounds(240, 233, 101, 34);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "New Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 464, 304);
		contentPane.add(panel);
	}
}
