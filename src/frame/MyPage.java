package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import customDAO.MyInfo;

public class MyPage extends JPanel {

	String name;
	String id;
	String pw;

	private JPasswordField userPw;
	private JTextField userId;
	private JTextField userName;
	private JLabel userIdLabel;
	private JLabel uesrNameLabel;
	private JLabel uesrPwLabel;

	public MyPage() {
	}

	public MyPage(MyInfo m) {


		// JPanel
		setLayout(null);
		// setBackground(Color.BLUE);
		setSize(600, 800);

		userIdLabel = new JLabel("Id");
		userIdLabel.setSize(80, 20);
		userIdLabel.setLocation(72, 30);
		add(userIdLabel);

		userId = new JTextField(20);
		userId.setSize(80, 20);
		userId.setLocation(150, 30);
		userId.setText(m.getId());
		add(userId);

		uesrNameLabel = new JLabel("Name");
		uesrNameLabel.setSize(80, 20);
		uesrNameLabel.setLocation(72, 60);
		add(uesrNameLabel);

		userName = new JTextField(20);
		userName.setSize(80, 20);
		userName.setLocation(150, 60);
		userName.setText(m.getName());
		add(userName);

		uesrPwLabel = new JLabel("pw");
		uesrPwLabel.setSize(80, 20);
		uesrPwLabel.setLocation(72, 90);
		add(uesrPwLabel);

		userPw = new JPasswordField(20);
		userPw.setSize(80, 20);
		userPw.setLocation(150, 90);
		userPw.setText(m.getPw());
		add(userPw);

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(0, 660, 600, 100);
		bottomSet.setLayout(null);
		bottomSet.setBackground(new Color(0xFFD700));

		JButton backBtn = new JButton("뒤로가기");
		backBtn.setBackground(new Color(0xA6A6A6));
		backBtn.setSize(183, 87);
		backBtn.setLocation(5, 0);
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m));
			}
		});
	

		JButton sellBtn = new JButton("구매하기");

		sellBtn.setBackground(new Color(0xA6A6A6));
		sellBtn.setSize(183, 87);
		sellBtn.setLocation(198, 0);
		sellBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(sellBtn);

		sellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "구매하기");

			}
		});

		JButton cartBnt = new JButton("장바구니");

		cartBnt.setBackground(new Color(0xA6A6A6));
		cartBnt.setSize(183, 87);
		cartBnt.setLocation(391, 0);
		cartBnt.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(cartBnt);

		cartBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "장바구니 담기");
			}
		});

		add(bottomSet);

	}

}
