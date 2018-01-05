import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class student extends JFrame {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student frame = new student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public student() {
		
		super("New Student");
		conn = javaConnect.ConnectionDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentId.setBounds(20, 47, 75, 22);
		contentPane.add(lblStudentId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(20, 80, 75, 22);
		contentPane.add(lblName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFatherName.setBounds(20, 113, 86, 22);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourse.setBounds(20, 146, 75, 22);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBranch.setBounds(20, 179, 75, 22);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(20, 212, 75, 22);
		contentPane.add(lblYear);
		
		JLabel lblSemis = new JLabel("Semester");
		lblSemis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSemis.setBounds(20, 245, 75, 22);
		contentPane.add(lblSemis);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(131, 47, 145, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(131, 83, 145, 23);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(131, 116, 145, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(131, 182, 145, 23);
		contentPane.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select One", "BArch", "BSc", "MSc", "FBA", "MBA"}));
		comboBox.setBounds(131, 146, 145, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010"}));
		comboBox_1.setBounds(131, 215, 145, 22);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_2.setBounds(131, 248, 145, 22);
		contentPane.add(comboBox_2);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="insert into Student(Student_ID,Name,Father_Name,Course,Branch,Year,Semester) values (?,?,?,?,?,?,?)";
				
				
		        try{
		        		
					pst=conn.prepareStatement(sql);
					pst.setInt(1,Integer.parseInt(textField.getText()) );
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,(comboBox.getSelectedItem()).toString());// combo box pass object
					pst.setString(5,textField_3.getText() );
					pst.setString(6,(comboBox_1.getSelectedItem()).toString());
					pst.setString(7,(comboBox_2.getSelectedItem()).toString());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "New Student Added");
						//rs.close();
						//pst.close();
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Error");
					}
				
				
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegister.setBounds(66, 295, 86, 31);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				Home ob=new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(173, 295, 86, 31);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "New Student", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 314, 339);
		contentPane.add(panel);
	}
}
