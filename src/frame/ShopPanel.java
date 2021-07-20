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
import view.CustomFont;
import view.RoundedButton;

public class ShopPanel extends JPanel {

	CartDAO cart;
	UserInfo uid;
	SellDAO history;
	CustomFont baemin = new CustomFont();

	public ShopPanel() {
	}

	// JPanel 구조
	public ShopPanel(MyInfo m) {

		cart = new CartDAO(m.getId());
		history = new SellDAO(m.getId());

		Font font = baemin.getCreateFont2();

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		RoundedButton kindsBtn = new RoundedButton("KIND");

		kindsBtn.setBackground(Color.WHITE);
		kindsBtn.setSize(200, 70);
		kindsBtn.setLocation(190, 220);
		// TBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		kindsBtn.setFont(font);
		add(kindsBtn);

		RoundedButton cartBtn = new RoundedButton("CART");

		cartBtn.setBackground(Color.WHITE);
		cartBtn.setSize(200, 70);
		cartBtn.setLocation(190, 220);
		cartBtn.setFont(font);
		add(cartBtn);

		RoundedButton myInfoBtn = new RoundedButton("My Page");

		myInfoBtn.setBackground(new Color(32, 32, 32));
		myInfoBtn.setFont(font);
		myInfoBtn.setForeground(new Color(255, 255, 255));
		cartBtn.add(myInfoBtn);

		add(cartBtn);

		kindsBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m, cart, history));
			}
		});

		myInfoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MyPage(m, cart, history));
			}
		});

		cartBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new CartPanel(m, cart, history));
			}
		});

	}
}
