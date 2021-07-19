package frame.Bottom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import customDAO.Items;
import customDAO.MyInfo;
import customDAO.SellDAO;
import frame.Kinds;
import frame.mainFrame;
import view.RoundedButton;
import customDAO.CartDAO;
import customDAO.ItemDAO;

public class BottomShorts extends JPanel {

	public BottomShorts(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		// 하의5 정보
		ImageIcon bottom5 = new ImageIcon("무신사 스탠다드.jpg");
		JButton btnBottom5 = new JButton(bottom5);
		btnBottom5.setName("무신사 스탠다드");

		btnBottom5.setSize(185, 250);
		btnBottom5.setLocation(72, 30);
		add(btnBottom5);

		btnBottom5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom5 = new ItemDAO().searchItem("무신사 스탠다드");
				mainFrame.getInstance(new BottomInfoPanel(bottom5, m, cart, history));

			}
		});

		// 하의6 정보
		ImageIcon bottom6 = new ImageIcon("에이본.jpg");
		JButton btnBottom6 = new JButton(bottom6);
		btnBottom6.setName("에이본");

		btnBottom6.setSize(185, 250);
		btnBottom6.setLocation(320, 30);
		add(btnBottom6);

		btnBottom6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom6 = new ItemDAO().searchItem("에이본");
				mainFrame.getInstance(new BottomInfoPanel(bottom6, m, cart, history));

			}
		});

		// 하의7 정보
		ImageIcon bottom7 = new ImageIcon("더블유브이.jpg");
		JButton btnBottom7 = new JButton(bottom7);
		btnBottom7.setName("더블유브이");

		btnBottom7.setSize(185, 250);
		btnBottom7.setLocation(72, 340);
		add(btnBottom7);

		btnBottom7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom7 = new ItemDAO().searchItem("더블유브이");
				mainFrame.getInstance(new BottomInfoPanel(bottom7, m, cart, history));

			}
		});

		// 하의8 정보
		ImageIcon bottom8 = new ImageIcon("소프트서울.jpg");
		JButton btnBottom8 = new JButton(bottom8);
		btnBottom8.setName("소프트서울");

		btnBottom8.setSize(185, 250);
		btnBottom8.setLocation(320, 340);
		add(btnBottom8);

		btnBottom8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom8 = new ItemDAO().searchItem("소프트서울");
				mainFrame.getInstance(new BottomInfoPanel(bottom8, m, cart, history));

			}
		});

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton btnBack = new RoundedButton("뒤로가기");

		btnBack.setBackground(new Color(32, 32, 32));
		/*btnBack.setSize(183, 87);
		btnBack.setLocation(5, 0);*/
		btnBack.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		btnBack.setForeground(new Color(255, 255, 255));
		bottomSet.add(btnBack);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new BottomPanel(m,cart,history));

			}
		});

		RoundedButton btnHome = new RoundedButton("처음 페이지");

		btnHome.setBackground(new Color(32, 32, 32));
		/*btnHome.setSize(183, 87);
		btnHome.setLocation(391, 0);*/
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnHome);

		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new Kinds(m, cart, history));
			}
		});

		add(bottomSet);
	}

}