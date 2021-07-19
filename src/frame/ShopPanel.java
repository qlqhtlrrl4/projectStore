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
import view.CustomFont;
import view.RoundedButton;

public class ShopPanel extends JPanel {
	
	CartDAO cart;
	UserInfo uid;
	SellDAO history;
	CustomFont baemin = new CustomFont();

	public ShopPanel() {}

	// JPanel 구조
	public ShopPanel(MyInfo m) {
			
		cart = new CartDAO(m.getId());
		history = new SellDAO(m.getId());
		
		Font font = baemin.getCreateFont2();
		
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,3,5,0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton kindsBtn = new RoundedButton("KIND");
		
		kindsBtn.setBackground(new Color(32, 32, 32));
		//kindsBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		kindsBtn.setFont(font);
		kindsBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(kindsBtn);

		RoundedButton cartBtn = new RoundedButton("CART");

		
		cartBtn.setBackground(new Color(32, 32, 32));
		//cartBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		cartBtn.setFont(font);
		cartBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(cartBtn);

		RoundedButton myInfoBtn = new RoundedButton("My Page");

		
		myInfoBtn.setBackground(new Color(32, 32, 32));
		//myInfoBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		myInfoBtn.setFont(font);
		myInfoBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(myInfoBtn);

		add(bottomSet);

		kindsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m,cart,history));
			}
		});

		myInfoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MyPage(m,cart,history));
			}
		});

		cartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				mainFrame.getInstance(new CartPanel(m,cart,history));
			}
		});
		add(bottomSet);	
	}
}
