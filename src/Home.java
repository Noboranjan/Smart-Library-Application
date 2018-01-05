import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;

public class Home extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 600);
		contentPane = new JPanel();
		contentPane.addHierarchyListener(new HierarchyListener() {
			public void hierarchyChanged(HierarchyEvent arg0) {
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnExit = new JMenuItem("Exit");
		mnExit.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\imagesttt.jpg"));
		mnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		mnNewMenu.add(mnExit);
		
		JMenuItem mnLogout = new JMenuItem("Logout");
		mnLogout.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images 77.jpg"));
		mnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				login ob=new login();
				ob.setVisible(true);
			}
		});
		mnNewMenu.add(mnLogout);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mnNewMenu_1 = new JMenuItem("About Us");
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				AboutUs ob=new AboutUs();
				ob.setVisible(true);
			}
		});
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\user106.png"));
		mnEdit.add(mnNewMenu_1);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\212.jpg"));
		lblNewLabel.setBounds(34, 11, 79, 79);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(239, 11, 100, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Smart Library");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(230, 42, 127, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("New Book");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(73, 259, 78, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Statistic");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(230, 259, 58, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New Student");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(386, 259, 86, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				NewBook ob=new NewBook();
				ob.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\Apps-Library-icon.png"));
		btnNewButton.setBounds(50, 137, 127, 120);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Statistics ob=new Statistics();
				ob.setVisible(true);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\download.png"));
		btnNewButton_1.setBounds(194, 137, 133, 120);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				student ob=new student();
				ob.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\444.jpg"));
		btnNewButton_2.setBounds(358, 137, 137, 120);
		contentPane.add(btnNewButton_2);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				Issue ob=new Issue();
				ob.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\images (1).png"));
		button.setBounds(34, 350, 132, 120);
		contentPane.add(button);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
				ReturnBook ob=new ReturnBook();
				ob.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\download (1).jpg"));
		btnNewButton_3.setBounds(183, 350, 144, 120);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				About ob=new About();
				ob.setVisible(true);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\Icon\\marketing-solutions.png"));
		btnNewButton_4.setBounds(357, 350, 138, 120);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("Issue Book");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(65, 472, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Return Book");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(217, 472, 79, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("About");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(401, 472, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel.setBounds(10, 112, 514, 188);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Action", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_1.setBounds(10, 322, 514, 196);
		contentPane.add(panel_1);
	}
}
