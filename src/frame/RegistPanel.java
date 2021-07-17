package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import customDAO.CustomDAO;
import view.CustomFont;
import view.RoundedButton;

public class RegistPanel extends JPanel {

	private JPasswordField userPw;
	private JPasswordField conFirmPw;
	private JTextField userId;
	private JTextField userName;
	private JLabel userIdLabel;
	private JLabel uesrNameLabel;
	private JLabel uesrPwLabel;
	private JLabel conFirmPwLabel;
	private RoundedButton regist;
	private RoundedButton cancel;

	public RegistPanel() {

		CustomFont font = new CustomFont();
		Font setF = font.getCreateFont();
		Font titleF = font.TitleFont();
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(600, 800);
		
		JLabel shopName = new JLabel("쇼핑몰 이름");
		shopName.setFont(titleF);
		shopName.setOpaque(true);
		shopName.setBackground(new Color(229,243,197));
		shopName.setSize(600,70);
		shopName.setLocation(0,0);
		shopName.setHorizontalAlignment(JLabel.CENTER);
		add(shopName);
				
		
		JLabel join = new JLabel("회원 가입하기");
		join.setFont(titleF);
		join.setSize(600, 60);
		join.setLocation(0,150);
		join.setHorizontalAlignment(JLabel.CENTER);
		add(join);

		JPanel panel = new JPanel();
		panel.setSize(300, 300);
		panel.setLocation(150, 250);
		panel.setLayout(new GridLayout(8, 1));
		panel.setBackground(Color.WHITE);
		// panel.setBackground(new Color(229,243,197));
		add(panel);

		userIdLabel = new JLabel("아이디");
		userIdLabel.setSize(80, 20);
		userIdLabel.setFont(setF);
		panel.add(userIdLabel);

		userId = new JTextField(20);
		userId.setSize(80, 20);
		userId.setFont(setF);
		panel.add(userId);

		uesrNameLabel = new JLabel("이름");
		uesrNameLabel.setSize(80, 20);
		uesrNameLabel.setFont(setF);
		panel.add(uesrNameLabel);

		userName = new JTextField(20);
		userName.setSize(80, 20);
		userName.setFont(setF);
		panel.add(userName);

		uesrPwLabel = new JLabel("비밀번호");
		uesrPwLabel.setSize(80, 20);
		uesrPwLabel.setFont(setF);
		panel.add(uesrPwLabel);

		userPw = new JPasswordField(20);
		userPw.setSize(80, 20);
		userPw.setFont(setF);
		panel.add(userPw);
		
		conFirmPwLabel = new JLabel("비밀번호 확인");
		conFirmPwLabel.setSize(80, 20);
		conFirmPwLabel.setFont(setF);
		panel.add(conFirmPwLabel);

		conFirmPw = new JPasswordField(20);
		conFirmPw.setSize(80, 20);
		conFirmPw.setFont(setF);
		panel.add(conFirmPw);

		JPanel bottomSet = new JPanel();
		bottomSet.setLayout(new GridLayout(2, 1,0,5));
		bottomSet.setBounds(0, 660, 585, 100);
		bottomSet.setBackground(Color.WHITE);

		regist = new RoundedButton("가입");
		//regist.setBorder(new RoundedBorder(25));
		regist.setSize(100, 100);
		regist.setFont(setF);
		regist.setBackground(new Color(229, 243, 197));
		
		bottomSet.add(regist);

		cancel = new RoundedButton("취소");
		
		cancel.setSize(100, 100);
		cancel.setBackground(new Color(229, 243, 197));
		//cancel.setBorder(new RoundedBorder(25));
		cancel.setFont(setF);
		
		bottomSet.add(cancel);

		regist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CustomDAO rd = new CustomDAO();
				String pw = String.valueOf(userPw.getPassword());
				String cofirmPw = String.valueOf(conFirmPw.getPassword());
				
				if (!(userId.getText().equals("") && userName.getText().equals("")
						&& String.valueOf(userPw.getPassword()).equals(""))) {
					if (rd.checkId(userId.getText())) {
						rd.registCustomer(userName.getText(), userId.getText(), String.valueOf(userPw.getPassword()));
						mainFrame.getInstance(new BeginPanel());
					} else if (!pw.equals(cofirmPw)) {
						JOptionPane.showMessageDialog(null, "비밀번호를 확인 해주세요.");
					}

					else {
						JOptionPane.showMessageDialog(null, "Id 중복 오류");
					}
				} else {
					if (userId.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
					} else if (userName.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");

					} else {
						JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
					}
				}
			}
		});

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BeginPanel());
			}
		});

		add(bottomSet);
	}
}
