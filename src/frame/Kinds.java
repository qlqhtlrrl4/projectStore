package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,1,5,0));
		bottomSet.setBackground(Color.WHITE);
		
		RoundedButton topBtn = new RoundedButton("TOP");

		topBtn.setBackground(Color.WHITE);
		topBtn.setSize(200, 70);
		topBtn.setLocation(190, 120);
		//TBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
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
		bottomBtn.setLocation(190, 280);
		//KnitBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
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
		shoesBtn.setLocation(190, 440);
		//BlouseBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		shoesBtn.setFont(font);
		add(shoesBtn);

		shoesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShoesPanel(m, cart,history));
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
				mainFrame.getInstance(new ShopPanel(m));
			}
		});
		
		add(bottomSet);
		

	}

}
