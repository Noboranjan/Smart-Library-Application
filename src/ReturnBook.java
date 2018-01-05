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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

public class ReturnBook extends JFrame {
	
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
	private JTextField textField_13;
	private JDateChooser dateChooser;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void Delete(){
		
		String sql="delete from Issue where Student_ID=?";
		try{
			pst=conn.prepareStatement(sql);
			pst.setString(1, textField.getText());
			pst.execute();
			
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	public void ReturnUpdate()
	{
		String sql="insert into Return(Student_ID,SName,Father_Name,Course,Branch,Year,Semester,Book_ID,Name,Edition,Publisher,Price,Page,DateofIssue,DateofReturn) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			
			pst=conn.prepareStatement(sql);
			pst.setInt(1,Integer.parseInt(textField.getText()) );
			pst.setString(2,textField_1.getText());
			pst.setString(3,textField_2.getText());
			pst.setString(4,textField_3.getText() );
			pst.setString(5,textField_4.getText() );
			pst.setInt(6,Integer.parseInt(textField_5.getText()) );
			pst.setInt(7,Integer.parseInt(textField_6.getText()) );
			pst.setInt(8,Integer.parseInt(textField_7.getText()) );
			pst.setString(9,textField_8.getText());
			pst.setString(10,textField_9.getText() );
			pst.setString(11,textField_10.getText() );
			pst.setInt(12,Integer.parseInt(textField_11.getText()) );
			pst.setInt(13,Integer.parseInt(textField_12.getText()) );
			pst.setString(14,textField_13.getText() );
			pst.setString(15, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
			
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Book Returned");
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public ReturnBook() {
		
		super("Return Book");
		conn = javaConnect.ConnectionDb();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentId.setBounds(40, 63, 75, 22);
		contentPane.add(lblStudentId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(40, 102, 75, 22);
		contentPane.add(lblName);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFatherName.setBounds(40, 135, 80, 22);
		contentPane.add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCourse.setBounds(40, 168, 75, 22);
		contentPane.add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBranch.setBounds(40, 201, 75, 22);
		contentPane.add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear.setBounds(40, 234, 75, 22);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemester.setBounds(40, 267, 75, 22);
		contentPane.add(lblSemester);
		
		textField = new JTextField();
		textField.setBounds(145, 63, 124, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(145, 104, 124, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(145, 137, 124, 22);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(145, 169, 124, 22);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(145, 202, 124, 22);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(145, 236, 124, 22);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(145, 269, 124, 22);
		contentPane.add(textField_6);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql="select * from Issue where Student_ID=? ";
				
				try{
					pst=conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					rs=pst.executeQuery();
					if(rs.next()){
						String add1=rs.getString("SName");
						textField_1.setText(add1);
						String add2=rs.getString("Father_Name");
						textField_2.setText(add2);
						String add3=rs.getString("Course");
						textField_3.setText(add3);
						String add4=rs.getString("Branch");
						textField_4.setText(add4);
						String add5=rs.getString("Year");
						textField_5.setText(add5);
						String add6=rs.getString("Semester");
						textField_6.setText(add6);
						String add7=rs.getString("Book_ID");
						textField_7.setText(add7);
						String add8=rs.getString("Name");
						textField_8.setText(add8);
						String add9=rs.getString("Edition");
						textField_9.setText(add9);
						String add10=rs.getString("Publisher");
						textField_10.setText(add10);
						String add11=rs.getString("Price");
						textField_11.setText(add11);
						String add12=rs.getString("Pages");
						textField_12.setText(add12);
						String add13=rs.getString("DateofIssue");
						textField_13.setText(add13);
						
						
						
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
		btnSearch.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images (2).jpg"));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(279, 62, 38, 23);
		contentPane.add(btnSearch);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookId.setBounds(343, 63, 75, 22);
		contentPane.add(lblBookId);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName_1.setBounds(343, 102, 75, 22);
		contentPane.add(lblName_1);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdition.setBounds(343, 135, 75, 22);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPublisher.setBounds(343, 173, 75, 22);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(343, 206, 75, 22);
		contentPane.add(lblPrice);
		
		JLabel lblPage = new JLabel("Page");
		lblPage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPage.setBounds(343, 239, 75, 22);
		contentPane.add(lblPage);
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfIssue.setBounds(343, 272, 80, 22);
		contentPane.add(lblDateOfIssue);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(443, 62, 124, 22);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(443, 104, 124, 22);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(443, 137, 124, 22);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(443, 175, 124, 22);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(443, 208, 124, 22);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(443, 241, 124, 22);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(443, 274, 124, 22);
		contentPane.add(textField_13);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Return Book", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 28, 634, 314);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Return Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(279, 353, 77, 22);
		contentPane.add(lblNewLabel);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(387, 353, 145, 22);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Delete();
				ReturnUpdate();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(303, 403, 86, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				Home ob=new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(408, 403, 86, 23);
		contentPane.add(btnBack);
	}
}
