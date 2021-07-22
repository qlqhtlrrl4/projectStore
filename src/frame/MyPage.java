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

import customDAO.CartDAO;
import customDAO.ItemDAO;
import customDAO.MyInfo;
import customDAO.SellDAO;
import customDAO.UserInfo;
import view.CustomFont;
import view.RoundedButton;
import view.RoundedButton2;

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
		Font font = baemin.getCreateFont2();
		
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(600, 800);
		
		JPanel topLogo = new JPanel();
		topLogo.setBounds(0,0,600,70);
		topLogo.setBackground(new Color(219,206,190));
		topLogo.setLayout(null);
		add(topLogo);
		
		RoundedButton sName = new RoundedButton("marchen");
		sName.setBackground(new Color(219,206,190));
		sName.setBorderPainted(false);
		sName.setBounds(204,0,180,70);
		sName.setFont(font.deriveFont(38f));
		topLogo.add(sName);
		
		sName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m, cart, history));
				
			}
		});
		
		ImageIcon icon4 = new ImageIcon("search.png");
		Image image4 = icon4.getImage();
		Image newImg4 = image4.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon myIcon4 = new ImageIcon(newImg4);

		JButton searchBtn = new JButton(myIcon4);
		searchBtn.setBackground(new Color(219, 206, 190));
		searchBtn.setBorderPainted(false);
		searchBtn.setBounds(445, 22, 30, 30);
		// myPageImgBtn.setBounds(465, 22, 30, 30);

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Kinds.searchItem.clear();
				String itemName = JOptionPane.showInputDialog("찾으실 상품을 입력하시오");

				boolean flag = true;
				if (!(itemName == null)) {
					if (!itemName.equals("")) {

						for (int i = 0; i < ItemDAO.itemList.size(); i++) {
							if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
								Kinds.searchItem.add(ItemDAO.itemList.get(i));
								flag = false;
								mainFrame.getInstance(new FindInfo(m, cart, history, Kinds.searchItem));
							} else if (!(ItemDAO.itemList.get(i).getName().toLowerCase()
									.contains(itemName.toLowerCase()))) {
								if (flag) {

									JOptionPane.showMessageDialog(null, "상품이 존재하지 않습니다.");
									break;
								}

							}

						}
					}
				}

			}
		});

		topLogo.add(searchBtn);
		
		
		ImageIcon icon = new ImageIcon("cartimg4.png");

		Image image = icon.getImage();
		Image newImg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);

		JButton cartImgBtn = new JButton(newIcon);
		cartImgBtn.setBackground(new Color(219,206,190));
		cartImgBtn.setBorderPainted(false);
		cartImgBtn.setBounds(520, 17, 40, 40);

		topLogo.add(cartImgBtn);
		
		cartImgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new CartPanel(m,cart,history));
				
			}
		});
		
		ImageIcon icon2 = new ImageIcon("mypageIcon2.png");
		Image image2 = icon2.getImage();
		Image newImg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon myIcon = new ImageIcon(newImg2);
		
		JButton myPageImgBtn = new JButton(myIcon);
		myPageImgBtn.setBackground(new Color(219,206,190));
		myPageImgBtn.setBorderPainted(false);
		myPageImgBtn.setBounds(485, 22, 30, 30);
		
		myPageImgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MyPage(m,cart,history));
				
			}
		});
		
		topLogo.add(myPageImgBtn);
		
		ImageIcon item1 = new ImageIcon("my.png");
		Image ximg=item1.getImage();
		Image yimg= ximg.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg=new ImageIcon(yimg);
		
		JLabel prof = new JLabel(newimg);
		prof.setBounds(100,150,200,150);
		add(prof);
		
		
		
		JLabel info = new JLabel(UserInfo.UserInfoMap.get(m.getId()).getName()+"님");
		info.setFont(font.deriveFont(24f));
		info.setBackground(new Color(229,243,197));
		info.setSize(200,70);
		info.setLocation(320,150);
		add(info);
		
		JLabel hello = new JLabel("안녕하세요");
		hello.setFont(font.deriveFont(24f));
		hello.setBackground(new Color(229,243,197));
		hello.setSize(200,70);
		hello.setLocation(320,180);
		add(hello);
		
		JButton member = new RoundedButton(UserInfo.getUserInfoMap((m.getId())).gradeCheck(UserInfo.getUserInfoMap(m.getId()).getTotal()));
		
		if(UserInfo.getUserInfoMap((m.getId())).gradeCheck(UserInfo.getUserInfoMap(m.getId()).getTotal()).equals("SILVER")) {
			member.setBackground(new Color(140,140,136));
		}
		else if(UserInfo.getUserInfoMap((m.getId())).gradeCheck(UserInfo.getUserInfoMap(m.getId()).getTotal()).equals("GOLD")) {
			member.setBackground(new Color(242,216,87));
		
		}
		
		else if(UserInfo.getUserInfoMap((m.getId())).gradeCheck(UserInfo.getUserInfoMap(m.getId()).getTotal()).equals("VIP")) {
			member.setBackground(new Color(136,28,166));
		
		}
		else {
			member.setBackground(Color.BLACK);
		}
		
		member.setFont(font);
		member.setSize(140,60);
		member.setLocation(320,235);
		member.setForeground(Color.WHITE);
		add(member);
	
		//정보 넣을 패널 
		JPanel panel = new JPanel();
		panel.setSize(300, 200);
		panel.setLocation(105, 350);
		panel.setLayout(new GridLayout(4, 2,2,2));
		panel.setBackground(Color.WHITE);
		
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

	
		/*uesrPwLabel = new JLabel("등급 : ");
		uesrPwLabel.setSize(150, 20);
		uesrPwLabel.setFont(font);
		uesrPwLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(uesrPwLabel);
		
		uesrPwValueLabel = new JLabel(UserInfo.UserInfoMap.get(m.getId()).getName());
		uesrPwValueLabel.setSize(150, 20);
		uesrPwValueLabel.setFont(font);
		uesrPwValueLabel.setHorizontalAlignment(JLabel.RIGHT);
		panel.add(uesrPwValueLabel);*/

		
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
		
		backBtn.setBackground(new Color(219,206,190));
		backBtn.setFont(font);
		
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m,cart,history));
			}
		});
	

		RoundedButton logOutBtn = new RoundedButton("LOGOUT");

		logOutBtn.setBackground(new Color(219,206,190));
		logOutBtn.setFont(font);
		
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

		cartBnt.setBackground(new Color(219,206,190));
		cartBnt.setFont(font);
		
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
