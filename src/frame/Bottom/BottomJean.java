package frame.Bottom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customDAO.CartDAO;
import customDAO.ItemDAO;
import customDAO.Items;
import customDAO.MyInfo;
import customDAO.SellDAO;
import frame.CartPanel;
import frame.Kinds;
import frame.MyPage;
import frame.mainFrame;
import view.CustomFont;
import view.RoundedButton;

public class BottomJean extends JPanel {

	public BottomJean(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		ImageIcon bottom1 = new ImageIcon("모드나인.jpg");
		JButton btnBottom1 = new JButton(bottom1);
		btnBottom1.setName("모드나인");
		
		JLabel aLabel = new JLabel("모드나인");
		aLabel.setBounds(125, 330, 185, 20);
		aLabel.setFont(font);
		add(aLabel);
		
		JLabel aLabel2 = new JLabel("80,000");
		aLabel2.setBounds(133, 350, 185, 20);
		aLabel2.setFont(font);
		add(aLabel2);
		

		btnBottom1.setSize(185, 220);
		btnBottom1.setLocation(72, 105);
		add(btnBottom1);

		btnBottom1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom1 = new ItemDAO().searchItem("모드나인");
				mainFrame.getInstance(new BottomInfoPanel(bottom1, m, cart, history));
			}
		});

		ImageIcon bottom2 = new ImageIcon("브랜디드.jpg");
		JButton btnBottom2 = new JButton(bottom2);
		btnBottom2.setName("브랜디드");

		btnBottom2.setSize(185, 220);
		btnBottom2.setLocation(320, 105);
		add(btnBottom2);
		
		JLabel bLabel = new JLabel("브랜디드");
		bLabel.setBounds(380, 330, 185, 20);
		bLabel.setFont(font);
		add(bLabel);

		JLabel bLabel2 = new JLabel("98,000");
		bLabel2.setBounds(385, 350, 185, 20);
		bLabel2.setFont(font);
		add(bLabel2);

		btnBottom2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom2 = new ItemDAO().searchItem("브랜디드");
				mainFrame.getInstance(new BottomInfoPanel(bottom2, m, cart, history));
			}
		});

		ImageIcon bottom3 = new ImageIcon("마리떼.jpg");
		JButton btnBottom3 = new JButton(bottom3);
		btnBottom3.setName("마리떼");

		btnBottom3.setSize(185, 220);
		btnBottom3.setLocation(72, 380);
		add(btnBottom3);
		
		JLabel cLabel = new JLabel("마리떼");
		cLabel.setBounds(138, 600, 185, 30);
		cLabel.setFont(font);
		add(cLabel);

		JLabel cLabel2 = new JLabel("98,000");
		cLabel2.setBounds(138, 620, 185, 30);
		cLabel2.setFont(font);
		add(cLabel2);

		btnBottom3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom3 = new ItemDAO().searchItem("마리떼");
				mainFrame.getInstance(new BottomInfoPanel(bottom3, m, cart, history));
			}
		});

		ImageIcon bottom4 = new ImageIcon("스파오.jpg");
		JButton btnBottom4 = new JButton(bottom4);
		btnBottom4.setName("스파오");

		btnBottom4.setSize(185, 220);
		btnBottom4.setLocation(320, 380);
		add(btnBottom4);
		
		JLabel dLabel = new JLabel("스파오");
		dLabel.setBounds(380, 600, 185, 30);
		dLabel.setFont(font);
		add(dLabel);

		JLabel dLabel2 = new JLabel("30,000");
		dLabel2.setBounds(382, 620, 185, 30);
		dLabel2.setFont(font);
		add(dLabel2);

		btnBottom4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom4 = new ItemDAO().searchItem("스파오");
				mainFrame.getInstance(new BottomInfoPanel(bottom4, m, cart, history));
			}
		});

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,2,5,0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton btnBack = new RoundedButton("BACK");

		btnBack.setBackground(new Color(219,206,190));
		btnBack.setFont(font);
		//btnBack.setForeground(new Color(255, 255, 255));
		bottomSet.add(btnBack);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomPanel(m, cart, history));
			}
		});


		add(bottomSet);
		
		JPanel topLogo = new JPanel();
		topLogo.setBounds(0,0,600,70);
		topLogo.setBackground(new Color(219,206,190));
		topLogo.setLayout(null);
		add(topLogo);
		
		JLabel sName = new JLabel("marchen");
		sName.setBounds(0,0,365,70);
		sName.setFont(font.deriveFont(38f));
		sName.setHorizontalAlignment(JLabel.RIGHT);
		topLogo.add(sName);
		
		
		ImageIcon icon = new ImageIcon("cartimg4.png");

		Image image3 = icon.getImage();
		Image newImg3 = image3.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newImg3);

		JButton cartImgBtn = new JButton(newIcon3);
		cartImgBtn.setBackground(new Color(219,206,190));
		cartImgBtn.setBorderPainted(false);
		cartImgBtn.setBounds(500, 17, 40, 40);

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
		myPageImgBtn.setBounds(465, 22, 30, 30);
		
		myPageImgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MyPage(m,cart,history));
				
			}
		});
		
		topLogo.add(myPageImgBtn);


	}

}