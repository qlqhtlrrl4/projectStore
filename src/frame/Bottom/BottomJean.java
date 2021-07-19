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

import customDAO.CartDAO;
import customDAO.ItemDAO;
import customDAO.Items;
import customDAO.MyInfo;
import customDAO.SellDAO;
import frame.Kinds;
import frame.mainFrame;
import view.RoundedButton;

public class BottomJean extends JPanel {

	public BottomJean(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		ImageIcon bottom1 = new ImageIcon("모드나인.jpg");
		JButton btnBottom1 = new JButton(bottom1);
		btnBottom1.setName("모드나인");

		btnBottom1.setSize(185, 250);
		btnBottom1.setLocation(72, 30);
		add(btnBottom1);

		btnBottom1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom1 = new ItemDAO().searchItem("모드나인");
				mainFrame.getInstance(new BottomInfoPanel(bottom1, m, cart, history));
			}
		});

		ImageIcon bottom2 = new ImageIcon("브랜디드.jpg");
		JButton btnBottom2 = new JButton(bottom2);
		btnBottom2.setName("브랜디드");

		btnBottom2.setSize(185, 250);
		btnBottom2.setLocation(320, 30);
		add(btnBottom2);

		btnBottom2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom2 = new ItemDAO().searchItem("브랜디드");
				mainFrame.getInstance(new BottomInfoPanel(bottom2, m, cart, history));
			}
		});

		ImageIcon bottom3 = new ImageIcon("마리떼.jpg");
		JButton btnBottom3 = new JButton(bottom3);
		btnBottom3.setName("마리떼");

		btnBottom3.setSize(185, 250);
		btnBottom3.setLocation(72, 340);
		add(btnBottom3);

		btnBottom3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom3 = new ItemDAO().searchItem("마리떼");
				mainFrame.getInstance(new BottomInfoPanel(bottom3, m, cart, history));
			}
		});

		ImageIcon bottom4 = new ImageIcon("스파오.jpg");
		JButton btnBottom4 = new JButton(bottom4);
		btnBottom4.setName("스파오");

		btnBottom4.setSize(185, 250);
		btnBottom4.setLocation(320, 340);
		add(btnBottom4);

		btnBottom4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items bottom4 = new ItemDAO().searchItem("스파오");
				mainFrame.getInstance(new BottomInfoPanel(bottom4, m, cart, history));
			}
		});

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,2,5,0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton btnBack = new RoundedButton("뒤로가기");

		btnBack.setBackground(new Color(32, 32, 32));
		btnBack.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		btnBack.setForeground(new Color(255, 255, 255));
		bottomSet.add(btnBack);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomPanel(m, cart, history));
			}
		});

		RoundedButton btnNext = new RoundedButton("처음 페이지");

		btnNext.setBackground(new Color(32, 32, 32));
		btnNext.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		btnNext.setForeground(new Color(255, 255, 255));
		bottomSet.add(btnNext);

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.getInstance(new Kinds(m, cart, history));
			}
		});

		add(bottomSet);

	}

}