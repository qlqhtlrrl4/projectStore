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

public class FindInfo extends JPanel {
	
	private JPasswordField userPw;
	private JTextField userId;
	private JTextField userName;
	private JLabel userIdLabel;
	private JLabel uesrNameLabel;
	private JLabel uesrPwLabel;
	private JButton findId;
	private JButton findPw;

	// JPanel
	public FindInfo() {

		setLayout(null);
		// setBackground(Color.BLUE);
		setSize(600, 800);


		userId = new JTextField(20);
		userId.setSize(80, 20);
		userId.setLocation(150, 30);
		add(userId);

		uesrNameLabel = new JLabel("Name");
		uesrNameLabel.setSize(80, 20);
		uesrNameLabel.setLocation(72, 60);
		add(uesrNameLabel);

		userName = new JTextField(20);
		userName.setSize(80, 20);
		userName.setLocation(150, 60);
		add(userName);

		uesrPwLabel = new JLabel("pw");
		uesrPwLabel.setSize(80, 20);
		uesrPwLabel.setLocation(72, 90);
		add(uesrPwLabel);

		userPw = new JPasswordField(20);
		userPw.setSize(80, 20);
		userPw.setLocation(150, 90);
		add(userPw);

		findId = new JButton("id 찾기");
		findId.setSize(100, 100);
		findId.setLocation(100, 400);
		add(findId);

		findPw = new JButton("pw 찾기");
		findPw.setSize(100, 100);
		findPw.setLocation(350, 400);
		add(findPw);

		findId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				

				

			}
		});

		findPw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BeginPanel());

			}
		});

	}

}
