import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class NewBook extends JFrame {
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBox;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBook frame = new NewBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


    // public void Random(){
	//java.util.Random rd=new java.util.Random();
	//textField.setText(""+rd.nextInt(1000+1));
	//}
	public NewBook() {
		
		super("New Book");
		conn = javaConnect.ConnectionDb();
		//Random();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 42, 68, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(20, 77, 68, 24);
		contentPane.add(lblName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdition.setBounds(20, 112, 68, 24);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPublisher.setBounds(20, 147, 68, 24);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(20, 182, 68, 24);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPages.setBounds(20, 217, 68, 24);
		contentPane.add(lblPages);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(142, 115, 134, 20);
		contentPane.add(comboBox);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String sql="insert into Book(Book_ID,Name,Edition,Publisher,Price,Pages) values (?,?,?,?,?,?)";
				
				
	        try{
					
				pst=conn.prepareStatement(sql);
				pst.setInt(1,Integer.parseInt(textField.getText()) );
				pst.setString(2,textField_1.getText());
				pst.setString(3,(comboBox.getSelectedItem()).toString());// combo box pass object
				pst.setString(4,textField_3.getText() );
				pst.setInt(5,Integer.parseInt(textField_4.getText()));
				pst.setInt(6,Integer.parseInt(textField_5.getText()));
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "New Book Added");
					//rs.close();
					//pst.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(69, 269, 81, 30);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				Home ob=new Home();
				ob.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(182, 269, 81, 30);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(142, 45, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 80, 134, 20);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(142, 150, 134, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(142, 185, 134, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(142, 220, 134, 20);
		contentPane.add(textField_5);
		

		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "New Book", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 11, 314, 339);
		contentPane.add(panel);
	}
}
