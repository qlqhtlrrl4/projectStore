package frame.Top;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class TopPanel extends JPanel {

	public TopPanel(MyInfo m, CartDAO cart,SellDAO history) {
		
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		JPanel bottomSet = new JPanel();
		
		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton TBtn = new RoundedButton("T-SHIRT");
		TBtn.setBackground(Color.WHITE);
		TBtn.setSize(200, 70);
		TBtn.setLocation(190, 120);
		TBtn.setFont(font);
		add(TBtn);

		TBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new TPanel(m, cart, history));
			}
		});

		RoundedButton KnitBtn = new RoundedButton("KNIT");

		KnitBtn.setBackground(Color.WHITE);
		KnitBtn.setSize(200, 70);
		KnitBtn.setLocation(190, 240);
		KnitBtn.setFont(font);
		add(KnitBtn);

		// 니트페이지
		KnitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new KnitPanel(m, cart, history));
			}
		});

		RoundedButton BlouseBtn = new RoundedButton("BLOUSE");
		BlouseBtn.setBackground(Color.WHITE);
		BlouseBtn.setSize(200, 70);
		BlouseBtn.setLocation(190, 360);
		//BlouseBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		BlouseBtn.setFont(font);
		add(BlouseBtn);

		// 셔츠블라우스페이지
		BlouseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShirtsPanel(m, cart, history));
			}
		});
		

		RoundedButton MtmBtn = new RoundedButton("MTM");

		MtmBtn.setBackground(Color.WHITE);
		MtmBtn.setSize(200, 70);
		MtmBtn.setLocation(190, 480);
		//MtmBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		MtmBtn.setFont(font);
		add(MtmBtn);

		// 맨투맨후드티페이지
		MtmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MtmPanel(m, cart, history));
			}
		});

		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(32, 32, 32));
		//backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setFont(font);
		backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m, cart, history));
			}
		});

		add(bottomSet);
		
		JPanel topLogo = new JPanel();
		topLogo.setBounds(0,0,600,70);
		topLogo.setBackground(new Color(219,206,190));
		topLogo.setLayout(null);
		add(topLogo);
		
		ImageIcon icon = new ImageIcon("cartimg4.png");

		Image image = icon.getImage();
		Image newImg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);

		JButton cartImgBtn = new JButton(newIcon);
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
		
	}

}
