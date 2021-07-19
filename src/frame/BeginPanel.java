package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import customDAO.CustomDAO;
import customDAO.MyInfo;
import customDAO.UserInfo;
import view.CustomFont;


import view.RoundedButton;

public class BeginPanel extends JPanel {

	private JButton btnLogin;
	private JButton btnInit;
	private JPasswordField passText;
	private JTextField userText;
	Font setF;
	UserInfo userInfo;

	public BeginPanel() {

		setLayout(null);
		setSize(600, 800);
		// setBackground(new Color(229,243,197));
		setBackground(Color.WHITE);
		CustomDAO custom = new CustomDAO();
		

		RoundedButton loginButton = new RoundedButton("로그인");
		RoundedButton joinButton = new RoundedButton("회원가입");
		RoundedButton infoCheckBtn = new RoundedButton("아이디 찾기");
		RoundedButton infoCheckBtn2 = new RoundedButton("비밀번호 찾기");

		CustomFont font = new CustomFont();

		setF = font.getCreateFont();

		loginButton.setFont(setF);
		loginButton.setForeground(Color.WHITE);
		joinButton.setFont(setF);
		infoCheckBtn.setFont(setF);
		infoCheckBtn2.setFont(setF);

		loginButton.setBackground(new Color(32, 32, 32));
		joinButton.setBackground(new Color(224, 224, 224));
		infoCheckBtn.setBackground(new Color(229, 243, 197));
		infoCheckBtn2.setBackground(new Color(229, 243, 197));

		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(4, 10, 0, 10));
		bottom.setBounds(1, 560, 582, 200);
		bottom.setBackground(Color.WHITE);

		bottom.add(loginButton); // button 추가
		bottom.add(joinButton); // button 추가

		bottom.add(infoCheckBtn);
		bottom.add(infoCheckBtn2);
		add(bottom);
		
		JPanel topSet = new JPanel();
		topSet.setSize(585,70);
		topSet.setLocation(0,0);
		topSet.setLayout(new GridLayout(1,4,2,0));
		
		JButton topLoginBtn = new JButton("로그인");
		JButton topJoinBtn = new JButton("회원가입");
		JButton topShoppingBtn = new JButton("마이쇼핑");
		JButton topCartBtn = new JButton("장바구니");
		
		topLoginBtn.setBackground(new Color(224,224,224));
		topJoinBtn.setBackground(new Color(224,224,224));
		topShoppingBtn.setBackground(new Color(224,224,224));
		topCartBtn.setBackground(new Color(224,224,224));

		topLoginBtn.setFont(setF);
		topJoinBtn.setFont(setF);
		topShoppingBtn.setFont(setF);
		topCartBtn.setFont(setF);
		
		topSet.add(topLoginBtn); // button 추가
		topSet.add(topJoinBtn); // button 추가

		topSet.add(topShoppingBtn);
		topSet.add(topCartBtn);
		add(topSet);
		

		userText = new JTextField(20);
		userText.setText("아이디");
		userText.setFont(setF);
		userText.setForeground(Color.GRAY);
		userText.setBounds(1, (int) getLocation().getY() / 2 + 240, 582, 50);
				
		userText.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				String id = userText.getText();
				if (id.equals("아이디")) {
					userText.setForeground(Color.BLACK);
					userText.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				String id = userText.getText();
				if (id.equals("")) {
					userText.setText("아이디");
					userText.setForeground(Color.GRAY);
				}
			}
		});

		add(userText);

		passText = new JPasswordField(20);
		passText.setBounds(1, (int) getLocation().getY() / 2 + 300, 582, 50);
		passText.setFont(setF);
		passText.setText("비밀번호");
		
		passText.setForeground(Color.GRAY);

		passText.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				String pw = String.valueOf(passText.getPassword());
				
				if (pw.equals("비밀번호")) {
					passText.setForeground(Color.BLACK);
					passText.setText("");
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				String pw = String.valueOf(passText.getPassword());
				if (pw.equals("")) {
					passText.setText("비밀번호");
					passText.setForeground(Color.GRAY);

				}
			}	
		});
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
				// 로그인 정보 가져가기위해서 객체넘김
				if (!(custom.loginCheck(userText.getText(), String.valueOf(passText.getPassword())).getId().equals(""))) {
					MyInfo m = custom.loginCheck(userText.getText(), String.valueOf(String.valueOf(passText.getPassword())));
					userInfo = new UserInfo(m.getId(), m);
					
					mainFrame.getInstance(new ShopPanel(UserInfo.UserInfoMap.get(m.getId())));
					
				} else {
					JOptionPane.showMessageDialog(null, "로그인 정보 오류");
				}
			}
		});

		infoCheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = JOptionPane.showInputDialog("이름을 입력하시오 ");

				if (!(custom.findId(name) == "")) {
					String id = custom.findId(name);
					JOptionPane.showMessageDialog(null, "아이디 : " + id);
				} else {
					JOptionPane.showMessageDialog(null, "정보가 없습니다.");
				}
			}
		});

		infoCheckBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = JOptionPane.showInputDialog("아이디를 입력하시오 ");

				if (!(custom.findPw(id) == "")) {
					String pw = custom.findPw(id);
					JOptionPane.showMessageDialog(null, "pw : " + pw);
				} else {
					JOptionPane.showMessageDialog(null, "정보가 없습니다.");
				}
			}

		});
		
		

	}

}
