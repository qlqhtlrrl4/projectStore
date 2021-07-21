package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import customDAO.CartDAO;
import customDAO.CustomDAO;
import customDAO.MyInfo;
import customDAO.SellDAO;
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
		
		

		JButton loginButton = new JButton("LOGIN");
		JButton joinButton = new JButton("JOIN");
		JButton infoCheckBtn = new JButton("아이디 찾기");
		JButton infoCheckBtn2 = new JButton("비밀번호 찾기");

		CustomFont font = new CustomFont();

		setF = font.getCreateFont();
		
		CustomFont baedal = new CustomFont();
		Font setF2 = baedal.getCreateFont2();

		loginButton.setFont(setF2);
		joinButton.setFont(setF2);
		infoCheckBtn.setFont(setF2);
		infoCheckBtn2.setFont(setF2);

		loginButton.setBackground(new Color(219,206,190));
		joinButton.setBackground(new Color(219,206,190));
		infoCheckBtn.setBackground(new Color(219,206,190));
		infoCheckBtn2.setBackground(new Color(219,206,190));
		
		loginButton.setBounds(55,400,475,50);
		joinButton.setBounds(55,460,475,50);
		infoCheckBtn.setBounds(55,520,240,50);
		infoCheckBtn2.setBounds(300,520,230,50);
		
		add(loginButton);
		add(joinButton);
		add(infoCheckBtn);
		add(infoCheckBtn2);
		
		JPanel topSet = new JPanel();
		topSet.setSize(585,70);
		topSet.setLocation(0,0);
		topSet.setLayout(null);
		
		topSet.setBackground(new Color(219,206,190));
		
		JLabel shoppingName = new JLabel("marchen ");
		shoppingName.setBackground(new Color(219,206,190));
		shoppingName.setFont(setF2.deriveFont(38f));
		shoppingName.setBounds(0,0,600,70);
		shoppingName.setHorizontalAlignment(JLabel.CENTER);
		topSet.add(shoppingName);
		
		
		add(shoppingName);
		
		add(topSet);
		
		
		JLabel lo = new JLabel("LOGIN");
		lo.setBounds(55,(int)getLocation().getY() / 2 + 180,100,50);
		lo.setFont(setF2.deriveFont(20f));
		add(lo);
		
		userText = new JTextField(20);
		userText.setText("아이디");
		userText.setFont(setF);
		userText.setForeground(Color.GRAY);
		userText.setBounds(55, (int) getLocation().getY() / 2 + 240, 475, 50);
				
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
		passText.setBounds(55, (int) getLocation().getY() / 2 + 300, 475, 50);
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
					
					CartDAO cart = new CartDAO(m.getId());
					SellDAO history = new SellDAO(m.getId());
					
					mainFrame.getInstance(new Kinds(UserInfo.UserInfoMap.get(m.getId()),cart,history));
					
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
