package frame.Bottom;

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
import frame.ShopPanel;
import frame.mainFrame;
import view.CustomFont;
import view.RoundedButton;

public class BottomPanel extends JPanel {

	public BottomPanel(MyInfo m, CartDAO cart,SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		// 청바지 버튼 설정
		RoundedButton btnJean = new RoundedButton("DENIM");
		btnJean.setBackground(Color.WHITE);
		btnJean.setSize(200, 70);
		btnJean.setLocation(190, 120);
		btnJean.setFont(font);
		add(btnJean);

		btnJean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomJean(m, cart,history));
			} // BottomJean으로 연결
		});

		// 반바지 버튼 설정
		RoundedButton btnShorts = new RoundedButton("SHORTS");
		btnShorts.setBackground(Color.WHITE);
		btnShorts.setSize(200, 70);
		btnShorts.setLocation(190, 240);
		btnShorts.setFont(font);
		add(btnShorts);

		btnShorts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomShorts(m, cart,history));
			}// BottomShorts로 연결
		});
		
		RoundedButton skirtBtn = new RoundedButton("SKIRT");
		skirtBtn.setBackground(Color.WHITE);
		skirtBtn.setSize(200, 70);
		skirtBtn.setLocation(190, 360);
		//BlouseBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		skirtBtn.setFont(font);
		add(skirtBtn);
		
		RoundedButton slacksBtn = new RoundedButton("SLACKS");
		slacksBtn.setBackground(Color.WHITE);
		slacksBtn.setSize(200, 70);
		slacksBtn.setLocation(190, 480);
		//BlouseBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		slacksBtn.setFont(font);
		add(slacksBtn);
		

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,2,5,0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(32, 32, 32));
		//backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setFont(font);
		backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new Kinds(m,cart,history));
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
