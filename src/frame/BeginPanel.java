package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import customDAO.CustomDAO;
import customDAO.MyInfo;

public class BeginPanel extends JPanel {

	private JButton btnLogin;
	private JButton btnInit;
	private JPasswordField passText;
	private JTextField userText;

	public BeginPanel() {

		setLayout(null);
		setSize(600, 800);

		CustomDAO custom = new CustomDAO();

		JButton loginButton = new JButton("로그인");
		JButton joinButton = new JButton("회원가입");

		loginButton.setSize(300, 150);
		loginButton.setLocation(((int) getSize().getWidth() / 2) - 310, (int) getLocation().getY() / 2 + 610);

		joinButton.setSize(300, 150);
		joinButton.setLocation((int) loginButton.getLocation().getX() + 300, (int) loginButton.getLocation().getY());

		add(joinButton); // button 추가
		add(loginButton); // button 추가

		JLabel userLabel = new JLabel("User Id");
		userLabel.setBounds((int) getSize().getWidth() / 2 - 150, (int) getLocation().getY() / 2 + 290, 80, 25);
		add(userLabel);

		JLabel passLabel = new JLabel("Pass");
		passLabel.setBounds((int) getSize().getWidth() / 2 - 150, (int) getLocation().getY() / 2 + 320, 80, 25);
		add(passLabel);

		userText = new JTextField(20);
		userText.setBounds((int) getSize().getWidth() / 2 - 50, (int) getLocation().getY() / 2 + 290, 160, 25);
		add(userText);

		passText = new JPasswordField(20);
		passText.setBounds((int) getSize().getWidth() / 2 - 50, (int) getLocation().getY() / 2 + 320, 160, 25);
		add(passText);

		joinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new RegistPanel());

			}
		});

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//로그인 정보 가져가기위해서 객체넘김
				if(!(custom.loginCheck(userText.getText(), String.valueOf(passText.getPassword())).getId().equals(""))) {
					MyInfo m = custom.loginCheck(userText.getText(), String.valueOf(passText.getPassword()));
					mainFrame.getInstance(new ShopPanel(m));
					
					
					
					System.out.println(m.getName());
				} else {
					JOptionPane.showMessageDialog(null, "로그인 정보 오류");
				}

			}
		});

	}

}
