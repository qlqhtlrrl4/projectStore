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
	private JButton regist;
	private JButton cancel;

	public RegistPanel() {

		CustomFont font = new CustomFont();
		Font setF = font.getCreateFont2();
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(600, 800);

		JLabel shopName = new JLabel("merchen");
		shopName.setFont(setF.deriveFont(38f));
		shopName.setOpaque(true);
		shopName.setBackground(new Color(219,206,190));
		shopName.setSize(600, 70);
		shopName.setLocation(0, 0);
		shopName.setHorizontalAlignment(JLabel.CENTER);
		add(shopName);

		JLabel join = new JLabel("JOIN");
		join.setFont(setF.deriveFont(32f));
		join.setSize(600, 60);
		join.setLocation(0, 115);
		join.setHorizontalAlignment(JLabel.CENTER);
		add(join);

		JPanel panel = new JPanel();
		panel.setSize(300, 300);
		panel.setLocation(150, 215);
		panel.setLayout(new GridLayout(8, 1));
		panel.setBackground(Color.WHITE);

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

		

		regist = new JButton("가입");
		
		regist.setFont(setF);
		regist.setBackground(new Color(219,206,190));


		cancel = new JButton("취소");
		cancel.setBackground(new Color(219,206,190));
		cancel.setFont(setF);
		
		regist.setBounds(150,535,145,50);
		cancel.setBounds(300,535,150,50);

		add(cancel);
		add(regist);

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
				} else if (userId.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
				} else if (userName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해주세요.");

				} else {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
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
