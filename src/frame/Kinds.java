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
import view.RoundedButton;

public class Kinds extends JPanel {

	public Kinds() {
	}

	public Kinds(MyInfo m, CartDAO cart, SellDAO history) {
		
		setBackground(new Color(232, 232, 232));
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,4,5,0));
		bottomSet.setBackground(Color.WHITE);
		
		RoundedButton topBtn = new RoundedButton("상의");

		topBtn.setBackground(new Color(32, 32, 32));
		topBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		topBtn.setForeground(new Color(255, 255, 255));
		
		bottomSet.add(topBtn);
		
		topBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new TopPanel(m, cart,history));
			}
		});

		RoundedButton bottomBtn = new RoundedButton("하의");

		bottomBtn.setBackground(new Color(32, 32, 32));
		bottomBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		bottomBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(bottomBtn);

		bottomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomPanel(m, cart,history));
			}
		});

		RoundedButton shoesBtn = new RoundedButton("신발");

		shoesBtn.setBackground(new Color(32, 32, 32));
		shoesBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		shoesBtn.setForeground(new Color(255, 255, 255));
		
		
		bottomSet.add(shoesBtn);

		shoesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShoesPanel(m, cart,history));
			}
		});

		RoundedButton backBtn = new RoundedButton("이전 페이지");

		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
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
