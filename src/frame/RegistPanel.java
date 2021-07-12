package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import customDAO.CustomDAO;

public class RegistPanel extends JPanel {
	
	private JPasswordField userPw;
	private JTextField userId;
	private JTextField userName;
	private JLabel userIdLabel;
	private JLabel uesrNameLabel;
	private JLabel uesrPwLabel;
	private JButton regist;
	private JButton cancel;
	
	
	public RegistPanel() {
		
		//JPanel 
		setLayout(null);
		//setBackground(Color.BLUE);
		setSize(600,800);
		
		userIdLabel = new JLabel("Id");
		userIdLabel.setSize(80,20);
		userIdLabel.setLocation(72,30);
		add(userIdLabel);
		
		userId = new JTextField(20);
		userId.setSize(80,20);
		userId.setLocation(150,30);
		add(userId);
		
		uesrNameLabel = new JLabel("Name");
		uesrNameLabel.setSize(80,20);
		uesrNameLabel.setLocation(72,60);
		add(uesrNameLabel);
		
		userName = new JTextField(20);
		userName.setSize(80,20);
		userName.setLocation(150,60);
		add(userName);
		
		uesrPwLabel = new JLabel("pw");
		uesrPwLabel.setSize(80,20);
		uesrPwLabel.setLocation(72,90);
		add(uesrPwLabel);
		
		userPw = new JPasswordField(20);
		userPw.setSize(80,20);
		userPw.setLocation(150,90);
		add(userPw);
		
		
		regist = new JButton("가입");
		regist.setSize(100,100);
		regist.setLocation(100,400);
		add(regist);
	
		cancel = new JButton("취소");
		cancel.setSize(100,100);
		cancel.setLocation(350,400);
		add(cancel);
		
		
		regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CustomDAO rd = new CustomDAO();
				
				if(rd.checkId(userId.getText())) {
					
					rd.registCustomer(userName.getText(),userId.getText(),String.valueOf(userPw.getPassword()));
					mainFrame.getInstance(new BeginPanel());
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Id 중복 오류");
				}
				
				
				
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BeginPanel());
				
			}
		});
		
		
		
		
		
	}
	
	

}
