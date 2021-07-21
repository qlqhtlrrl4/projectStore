package frame;

import java.awt.Color;
import java.awt.Font;
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
		
		JLabel shopBtn = new JLabel("CATEGORY");
		shopBtn.setBackground(Color.WHITE);
		shopBtn.setSize(200, 70);
		shopBtn.setLocation(230, 120);
		shopBtn.setFont(font);
				
		RoundedButton topBtn = new RoundedButton("TOP");

		topBtn.setBackground(Color.WHITE);
		topBtn.setSize(200, 70);
		topBtn.setLocation(190, 280);
		topBtn.setFont(font);
		
		
		topBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new TopPanel(m, cart,history));
			}
		});

		RoundedButton bottomBtn = new RoundedButton("BOTTOM");

		bottomBtn.setBackground(Color.WHITE);
		bottomBtn.setSize(200, 70);
		bottomBtn.setLocation(190, 360);
		bottomBtn.setFont(font);
		

		bottomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomPanel(m, cart,history));
			}
		});

		RoundedButton shoesBtn = new RoundedButton("SHOES");

		shoesBtn.setBackground(Color.WHITE);
		shoesBtn.setSize(200, 70);
		shoesBtn.setLocation(190, 440);
		
		shoesBtn.setFont(font);
		
		

		shoesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShoesPanel(m, cart,history));
			}
		});
		
		RoundedButton todayBtn = new RoundedButton("당일발송");

		todayBtn.setBackground(Color.WHITE);
		todayBtn.setSize(200, 70);
		todayBtn.setLocation(190, 200);
		
		todayBtn.setFont(font);
		
		
		/*RoundedButton madeBtn = new RoundedButton("MARCHEN MADE");

		madeBtn.setBackground(Color.WHITE);
		madeBtn.setSize(200, 70);
		madeBtn.setLocation(190, 520);
		
		madeBtn.setFont(font);
		*/		
		
		RoundedButton accBtn = new RoundedButton("ACC");

		accBtn.setBackground(Color.WHITE);
		accBtn.setSize(200, 70);
		accBtn.setLocation(190, 520);
		
		accBtn.setFont(font);
		
		
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

		Image image = icon.getImage();
		Image newImg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);

		JButton cartImgBtn = new JButton(newIcon);
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
		add(shopBtn);
		add(todayBtn);
		add(topBtn);
		add(bottomBtn);
		add(shoesBtn);		
		add(accBtn);

		
		
	}

}
