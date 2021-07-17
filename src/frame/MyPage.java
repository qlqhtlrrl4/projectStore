package frame;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import customDAO.CartDAO;
import customDAO.MyInfo;
import customDAO.SellDAO;
import customDAO.UserInfo;
import view.CustomFont;
import view.RoundedButton;

public class MyPage extends JPanel {

	private String name;
	private String id;	
	private JTextField userPw;
	private JTextField userId;
	private JTextField userName;
	private JLabel userIdLabel;
	private JLabel uesrPwValueLabel;
	private JLabel userIdValueLabel;
	private JLabel uesrPwLabel;
	private JLabel userTotal;
	private JLabel userGrade;

	public MyPage() {
	}

	public MyPage(MyInfo m, CartDAO cart, SellDAO history) {

		// JPanel
		CustomFont font = new CustomFont();
		Font setF = font.getCreateFont();
		Font titleF = font.TitleFont();
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(600, 800);
		
		//맨위 
		JLabel shopName = new JLabel("마이 페이지");
		shopName.setFont(titleF);
		shopName.setOpaque(true);
		shopName.setBackground(new Color(229,243,197));
		shopName.setSize(600,70);
		shopName.setLocation(0,0);
		//shopName.setHorizontalAlignment(JLabel.CENTER);
		add(shopName);
		
		ImageIcon item1 = new ImageIcon("hu.jpg");
		Image ximg=item1.getImage();
		Image yimg= ximg.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg=new ImageIcon(yimg);
		
		
		
		JLabel info = new JLabel(m.getName(),newimg,SwingConstants.LEADING);
		info.setFont(titleF);
		info.setBackground(new Color(229,243,197));
		info.setSize(200,100);
		info.setLocation(0,90);
		add(info);
		
		RoundedButton member = new RoundedButton(m.getGrade());
		member.setBackground(new Color(255,192,203));
		member.setFont(setF);
		member.setSize(140,60);
		member.setLocation(280,110);
		add(member);
		
		RoundedButton topLogoutBtn = new RoundedButton("로그아웃");	
		topLogoutBtn.setFont(setF);
		topLogoutBtn.setBackground(new Color(220,255,255));
		topLogoutBtn.setSize(150,60);
		topLogoutBtn.setLocation(430,110);
		add(topLogoutBtn);
		
		topLogoutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, m.getName()+"님 로그아웃 하시겠습니까 ?","Confirm",JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "로그아웃 취소");
				}
				else if(result == JOptionPane.YES_OPTION) {
					//로그아웃
					JOptionPane.showMessageDialog(null, m.getName()+"님이 로그아웃 하셨습니다.");
					mainFrame.getInstance(new BeginPanel());
				}
				else {
					JOptionPane.showMessageDialog(null, "로그아웃 취소");
				} 
			}
		});
		
		//정보 넣을 패널 
		JPanel panel = new JPanel();
		panel.setSize(300, 200);
		panel.setLocation(105, 350);
		panel.setLayout(new GridLayout(4, 2,2,2));
		panel.setBackground(Color.WHITE);
		//panel.setBorder(new LineBorder(Color.lightGray));
		
		add(panel);
		
		userIdLabel = new JLabel("이름 : ");
		userIdLabel.setSize(100, 20);
		userIdLabel.setFont(setF);
		userIdLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userIdLabel);
		
		userIdValueLabel = new JLabel(m.getName());
		userIdValueLabel.setSize(150, 20);
		userIdValueLabel.setFont(setF);
		userIdValueLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		panel.add(userIdValueLabel);

	
		uesrPwLabel = new JLabel("비밀번호 : ");
		uesrPwLabel.setSize(150, 20);
		uesrPwLabel.setFont(setF);
		uesrPwLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(uesrPwLabel);
		
		uesrPwValueLabel = new JLabel(m.getPw());
		uesrPwValueLabel.setSize(150, 20);
		uesrPwValueLabel.setFont(setF);
		uesrPwValueLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(uesrPwValueLabel);

		
		// 결제금액
		userGrade = new JLabel("등급 : ");
		userGrade.setSize(150, 20);
		userGrade.setFont(setF);
		userGrade.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userGrade);
		
		JLabel userGradeValue = new JLabel(UserInfo.getUserInfoMap((m.getId())).gradeCheck(UserInfo.getUserInfoMap(m.getId()).getTotal()));
		userGradeValue.setSize(150, 20);
		userGradeValue.setFont(setF);
		userGradeValue.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userGradeValue);
		
		userTotal = new JLabel("총 결제 금액 :");
		userTotal.setSize(150, 20);
		userTotal.setFont(setF);
		userTotal.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userTotal);
		
		JLabel userTotalValue = new JLabel(String.valueOf(UserInfo.getUserInfoMap(m.getId()).getTotal()));
		userTotalValue.setSize(150, 20);
		userTotalValue.setFont(setF);
		userTotalValue.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userTotalValue);

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,3,5,0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("초기화면");
		
		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setForeground(new Color(255, 255, 255));
		
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShopPanel(m));
			}
		});
	

		RoundedButton logOutBtn = new RoundedButton("로그아웃");

		logOutBtn.setBackground(new Color(32, 32, 32));
		logOutBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		logOutBtn.setForeground(new Color(255, 255, 255));
		
		bottomSet.add(logOutBtn);

		logOutBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, m.getName()+"님 로그아웃 하시겠습니까 ?","Confirm",JOptionPane.YES_NO_CANCEL_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					JOptionPane.showMessageDialog(null, "로그아웃 취소");
				}
				else if(result == JOptionPane.YES_OPTION) {
					//로그아웃
					JOptionPane.showMessageDialog(null, m.getName()+"님이 로그아웃 하셨습니다.");
					mainFrame.getInstance(new BeginPanel());
				}
				else {
					JOptionPane.showMessageDialog(null, "로그아웃 취소");
				} 
			}
		});

		RoundedButton cartBnt = new RoundedButton("구매내역");

		cartBnt.setBackground(new Color(32, 32, 32));
		cartBnt.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		cartBnt.setForeground(new Color(255, 255, 255));
		
		bottomSet.add(cartBnt);

		cartBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.getInstance(new HistoryPanel(m, history));
			}
		});

		add(bottomSet);

	}

}
