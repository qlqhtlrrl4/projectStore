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
		CustomFont baemin = new CustomFont();
		//Font setF = font.getCreateFont();
		Font font = baemin.getCreateFont2();
		Font titleF = baemin.TitleFont();
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(600, 800);
		
		JPanel topLogo = new JPanel();
		topLogo.setBounds(0,0,600,70);
		topLogo.setBackground(new Color(219,206,190));
		topLogo.setLayout(null);
		add(topLogo);
		
		ImageIcon icon = new ImageIcon("cartimg4.png");

		Image image3 = icon.getImage();
		Image newImg3 = image3.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newImg3);

		JButton cartImgBtn = new JButton(newIcon3);
		cartImgBtn.setBackground(new Color(219,206,190));
		cartImgBtn.setBorderPainted(false);
		cartImgBtn.setBounds(500, 10, 50, 50);

		topLogo.add(cartImgBtn);
		
		cartImgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new CartPanel(m,cart,history));
				
			}
		});
		
		ImageIcon icon2 = new ImageIcon("mypageIcon2.png");
		Image image2 = icon2.getImage();
		Image newImg2 = image2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		ImageIcon myIcon = new ImageIcon(newImg2);
		
		JButton myPageImgBtn = new JButton(myIcon);
		myPageImgBtn.setBackground(new Color(219,206,190));
		myPageImgBtn.setBorderPainted(false);
		myPageImgBtn.setBounds(430, 10, 50, 50);
		
		myPageImgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MyPage(m,cart,history));
				
			}
		});
		
		topLogo.add(myPageImgBtn);
		
		ImageIcon item1 = new ImageIcon("my.png");
		Image ximg=item1.getImage();
		Image yimg= ximg.getScaledInstance(150, 100, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg=new ImageIcon(yimg);
		
		
		
		JLabel info = new JLabel(UserInfo.UserInfoMap.get(m.getId()).getName(),newimg,SwingConstants.LEADING);
		info.setFont(titleF);
		info.setBackground(new Color(229,243,197));
		info.setSize(200,100);
		info.setLocation(0,90);
		add(info);
		
		RoundedButton member = new RoundedButton(UserInfo.getUserInfoMap((m.getId())).gradeCheck(UserInfo.getUserInfoMap(m.getId()).getTotal()));
		member.setBackground(new Color(255,192,203));
		member.setFont(font);
		member.setSize(140,60);
		member.setLocation(280,110);
		add(member);
		
		RoundedButton topLogoutBtn = new RoundedButton("LOGOUT");	
		topLogoutBtn.setFont(font);
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
		userIdLabel.setFont(font);
		userIdLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userIdLabel);
		
		userIdValueLabel = new JLabel(UserInfo.UserInfoMap.get(m.getId()).getName());
		userIdValueLabel.setSize(150, 20);
		userIdValueLabel.setFont(font);
		userIdValueLabel.setHorizontalAlignment(JLabel.RIGHT);
		
		panel.add(userIdValueLabel);

	
		uesrPwLabel = new JLabel("비밀번호 : ");
		uesrPwLabel.setSize(150, 20);
		uesrPwLabel.setFont(font);
		uesrPwLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(uesrPwLabel);
		
		uesrPwValueLabel = new JLabel(UserInfo.UserInfoMap.get(m.getId()).getName());
		uesrPwValueLabel.setSize(150, 20);
		uesrPwValueLabel.setFont(font);
		uesrPwValueLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(uesrPwValueLabel);

		
		// 결제금액
		userGrade = new JLabel("등급 : ");
		userGrade.setSize(150, 20);
		userGrade.setFont(font);
		userGrade.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userGrade);
		
		JLabel userGradeValue = new JLabel(UserInfo.getUserInfoMap((m.getId())).gradeCheck(UserInfo.getUserInfoMap(m.getId()).getTotal()));
		userGradeValue.setSize(150, 20);
		userGradeValue.setFont(font);
		userGradeValue.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userGradeValue);
		
		userTotal = new JLabel("총 결제 금액 :");
		userTotal.setSize(150, 20);
		userTotal.setFont(font);
		userTotal.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userTotal);
		
		JLabel userTotalValue = new JLabel(String.valueOf(UserInfo.getUserInfoMap(m.getId()).getTotal()));
		userTotalValue.setSize(150, 20);
		userTotalValue.setFont(font);
		userTotalValue.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(userTotalValue);

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,3,5,0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("BACK");
		
		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(font);
		backBtn.setForeground(new Color(255, 255, 255));
		
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m,cart,history));
			}
		});
	

		RoundedButton logOutBtn = new RoundedButton("LOGOUT");

		logOutBtn.setBackground(new Color(32, 32, 32));
		logOutBtn.setFont(font);
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

		RoundedButton cartBnt = new RoundedButton("HISTORY");

		cartBnt.setBackground(new Color(32, 32, 32));
		cartBnt.setFont(font);
		cartBnt.setForeground(new Color(255, 255, 255));
		
		bottomSet.add(cartBnt);

		cartBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.getInstance(new HistoryPanel(m, cart,history));
			}
		});

		add(bottomSet);

	}

}
