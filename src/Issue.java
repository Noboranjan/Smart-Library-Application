import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Issue extends JFrame {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JDateChooser dateChooser;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue frame = new Issue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Issue() {
		
		super("Issue Book");
		conn = javaConnect.ConnectionDb();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookId.setBounds(31, 52, 63, 22);
		contentPane.add(lblBookId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(31, 85, 54, 22);
		contentPane.add(lblName);
		
		JLabel lblPublisher = new JLabel("Edition");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPublisher.setBounds(31, 118, 63, 22);
		contentPane.add(lblPublisher);
		
		JLabel lblPublisher_1 = new JLabel("Publisher");
		lblPublisher_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPublisher_1.setBounds(31, 151, 63, 22);
		contentPane.add(lblPublisher_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(31, 184, 63, 22);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPages.setBounds(31, 217, 63, 22);
		contentPane.add(lblPages);
		
		textField = new JTextField();
		textField.setBounds(110, 54, 98, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(110, 87, 98, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(110, 120, 98, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(110, 153, 98, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(110, 186, 98, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(110, 219, 98, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="select * from Book where Book_ID=?";
				try{
					pst=conn.prepareStatement(sql);
					pst.setString(1, textField.getText() );
					rs=pst.executeQuery();
					if(rs.next()){
						String add1=rs.getString("Name");
						textField_1.setText(add1);
						String add2=rs.getString("Edition");
						textField_2.setText(add2);
						String add3=rs.getString("Publisher");
						textField_3.setText(add3);
						String add4=rs.getString("Price");
						textField_4.setText(add4);
						String add5=rs.getString("Pages");
						textField_5.setText(add5);
						rs.close();
						pst.close();
					}
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Error");
				}finally{
					try{
						
						rs.close();
						pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
			}});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images (2).jpg"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(73, 250, 106, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Book Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 25, 237, 278);
		contentPane.add(panel);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentId.setBounds(317, 57, 74, 22);
		contentPane.add(lblStudentId);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName_1.setBounds(317, 90, 74, 22);
		contentPane.add(lblName_1);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFatherName.setBounds(317, 123, 74, 22);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCourse.setBounds(317, 156, 74, 22);
		contentPane.add(lblCourse);
		
		JLabel lblYear = new JLabel("Branch");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear.setBounds(317, 189, 74, 22);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Year");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemester.setBounds(317, 222, 74, 22);
		contentPane.add(lblSemester);
		
		JLabel lblSemester_1 = new JLabel("Semester");
		lblSemester_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemester_1.setBounds(317, 256, 74, 25);
		contentPane.add(lblSemester_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(416, 54, 118, 25);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(416, 87, 118, 25);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(416, 125, 118, 25);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(416, 158, 118, 25);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(416, 191, 118, 25);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(416, 224, 118, 25);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(416, 257, 118, 25);
		contentPane.add(textField_12);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="select * from Student where Student_ID=?";
				try{
					pst=conn.prepareStatement(sql);
					pst.setString(1, textField_6.getText() );
					rs=pst.executeQuery();
					if(rs.next()){
						String add1=rs.getString("Name");
						textField_7.setText(add1);
						String add2=rs.getString("Father_Name");
						textField_8.setText(add2);
						String add3=rs.getString("Course");
						textField_9.setText(add3);
						String add4=rs.getString("Branch");
						textField_10.setText(add4);
						String add5=rs.getString("Year");
						textField_11.setText(add5);
						String add6=rs.getString("Semester");
						textField_12.setText(add6);
						rs.close();
						pst.close();
					}
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Error");
				}finally{
					try{
						
						rs.close();
						pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBounds(544, 53, 79, 23);
		contentPane.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Student Detail", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(281, 25, 363, 278);
		contentPane.add(panel_1);
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfIssue.setBounds(242, 344, 86, 22);
		contentPane.add(lblDateOfIssue);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(348, 344, 164, 22);
		contentPane.add(dateChooser);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="insert into Issue(Book_ID,Name,Edition,Publisher,Price,Pages,Student_ID,SName,Father_Name,Course,Branch,Year,Semester,DateofIssue) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		        try{
					
					pst=conn.prepareStatement(sql);
					pst.setInt(1,Integer.parseInt(textField.getText()) );
					pst.setString(2,textField_1.getText());
					pst.setString(3,textField_2.getText());
					pst.setString(4,textField_3.getText() );
					pst.setInt(5,Integer.parseInt(textField_4.getText()) );
					pst.setInt(6,Integer.parseInt(textField_5.getText()));
					pst.setInt(7,Integer.parseInt(textField_6.getText()));
					pst.setString(8,textField_7.getText());
					pst.setString(9,textField_8.getText());
					pst.setString(10,textField_9.getText());
					pst.setString(11,textField_10.getText());
					pst.setInt(12,Integer.parseInt(textField_11.getText()));
					pst.setInt(13,Integer.parseInt(textField_12.getText()));
					pst.setString(14, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());//for JdataChanger
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book Issued");
						//rs.close();
						//pst.close();
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "Error");
					}
				
			}
		});
		btnIssue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIssue.setBounds(281, 395, 86, 30);
		contentPane.add(btnIssue);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				Home ob=new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(404, 395, 86, 30);
		contentPane.add(btnBack);
	}
}
