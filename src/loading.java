import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

public class loading extends JFrame implements Runnable {
	
	Connection conn;
	int s=0;
	Thread th;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JProgressBar progressBar;
	private JLabel lblPleaseWait;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loading frame = new loading();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void setUpLoading(){
		setVisible(false);
		th.start();
	}
	public void run(){
		try{
			for(int i=0;i<=200;i++){
				s=s+1;
				
				int m=progressBar.getMaximum();
				int v=progressBar.getValue();
				
				if(v<m){
					progressBar.setValue(progressBar.getValue()+1);
				}else{
					i=201;
					setVisible(false);
					Home ob=new Home();
					ob.setVisible(true);
				}Thread.sleep(50);
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error");
		
			
		}
		
	}
	
	
	public loading() {
		
		super("Loading");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    lblNewLabel = new JLabel("Smart Library");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(129, 67, 133, 39);
		contentPane.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setMaximum(200);
		progressBar.setValue(0);
		progressBar.setToolTipText("");
		progressBar.setBounds(116, 180, 146, 14);
		contentPane.add(progressBar);
		
		lblPleaseWait = new JLabel("Please wait..");
		lblPleaseWait.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseWait.setBounds(152, 205, 83, 14);
		contentPane.add(lblPleaseWait);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE, 1, true));
		panel.setBounds(20, 23, 340, 414);
		contentPane.add(panel);
		
		
	     th=new Thread((Runnable)this);
		
	}
}
