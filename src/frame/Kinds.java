package frame;

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
import customDAO.MyInfo;
import customDAO.SellDAO;
import customDAO.UserInfo;
import frame.Bottom.BottomPanel;
import frame.Shoes.ShoesPanel;
import frame.Top.TopPanel;
import view.CustomFont;
import view.RoundedButton;

public class Kinds extends JPanel {

	public Kinds() {
	}

	public Kinds(MyInfo m, CartDAO cart, SellDAO history) {
		
		setBackground(new Color(232, 232, 232));
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();
		
		RoundedButton shopBtn = new RoundedButton("CATEGORY");
		shopBtn.setBackground(Color.WHITE);
		shopBtn.setSize(200, 70);
		shopBtn.setLocation(190, 100);
		shopBtn.setFont(font);
		add(shopBtn);
		
		shopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m, cart,history));
			}
		});
		
		RoundedButton topBtn = new RoundedButton("TOP");

		topBtn.setBackground(Color.WHITE);
		topBtn.setSize(200, 70);
		topBtn.setLocation(190, 260);
		topBtn.setFont(font);
		add(topBtn);
		
		topBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new TopPanel(m, cart,history));
			}
		});

		RoundedButton bottomBtn = new RoundedButton("BOTTOM");

		bottomBtn.setBackground(Color.WHITE);
		bottomBtn.setSize(200, 70);
		bottomBtn.setLocation(190, 420);
		bottomBtn.setFont(font);
		add(bottomBtn);

		bottomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomPanel(m, cart,history));
			}
		});

		RoundedButton shoesBtn = new RoundedButton("SHOES");

		shoesBtn.setBackground(Color.WHITE);
		shoesBtn.setSize(200, 70);
		shoesBtn.setLocation(190, 580);
		
		shoesBtn.setFont(font);
		add(shoesBtn);

		shoesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShoesPanel(m, cart,history));
			}
		});
		
		JPanel topLogo = new JPanel();
		topLogo.setBounds(0,0,600,70);
		topLogo.setBackground(new Color(219,206,190));
		topLogo.setLayout(null);
		add(topLogo);
		
		ImageIcon icon = new ImageIcon("cartimg3.png");

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
