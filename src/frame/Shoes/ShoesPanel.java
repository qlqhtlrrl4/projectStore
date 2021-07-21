package frame.Shoes;

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
import customDAO.MyInfo;
import customDAO.SellDAO;
import frame.CartPanel;
import frame.Kinds;
import frame.MyPage;
import frame.mainFrame;
import view.CustomFont;
import view.RoundedButton;

public class ShoesPanel extends JPanel {
	CartDAO cart;

	public ShoesPanel() {
	}

	public ShoesPanel(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton MensShoesBtn = new RoundedButton("SHOES");
		MensShoesBtn.setBackground(Color.WHITE);
		MensShoesBtn.setSize(200, 70);
		MensShoesBtn.setLocation(190, 120);
		
		MensShoesBtn.setFont(font);

		add(MensShoesBtn);
		RoundedButton SlipperBtn = new RoundedButton("SLIPPER");

		SlipperBtn.setBackground(Color.WHITE);
		SlipperBtn.setSize(200, 70);
		SlipperBtn.setLocation(190, 240);
		SlipperBtn.setFont(font);
		add(SlipperBtn);

		RoundedButton rnBtn = new RoundedButton("SPORTS SHOES");
		rnBtn.setBackground(Color.WHITE);
		rnBtn.setSize(200, 70);
		rnBtn.setLocation(190, 360);

		rnBtn.setFont(font);
		add(rnBtn);

		RoundedButton sandleBtn = new RoundedButton("SANDAL");
		sandleBtn.setBackground(Color.WHITE);
		sandleBtn.setSize(200, 70);
		sandleBtn.setLocation(190, 480);
		
		sandleBtn.setFont(font);
		add(sandleBtn);

		// 이전페이지
		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(219,206,190));
		backBtn.setFont(font);
		//backBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(backBtn);

		add(bottomSet);

		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new Kinds(m, cart, history));
			}
		});

		// 구두페이지로 이동
		MensShoesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MensShoesPanel(m, cart, history));

			}
		});

		// 슬리퍼 페이지로 이동
		SlipperBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new SlipperPanel(m, cart, history));

			}
		});

		rnBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new rnShoesPanel(m, cart, history));

			}
		});
		
		sandleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new SandlePanel(m, cart, history));

			}
		});
		
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
