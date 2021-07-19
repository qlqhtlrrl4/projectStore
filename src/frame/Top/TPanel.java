package frame.Top;

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


import frame.mainFrame;
import view.CustomFont;
import view.RoundedButton;

public class TPanel extends JPanel {

	public TPanel(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		// 티셔츠1의 정보
		ImageIcon item1 = new ImageIcon("비치모노T.jpg");
		Image ximg = item1.getImage();
		Image yimg = ximg.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg = new ImageIcon(yimg);
		JButton itemBtn1 = new JButton(newimg);
		itemBtn1.setName("beachmono");

		itemBtn1.setSize(185, 250);
		itemBtn1.setLocation(72, 20);
		add(itemBtn1);

		JLabel aLabel = new JLabel("beachmono");
		aLabel.setBounds(118, 280, 185, 20);
		aLabel.setFont(font);
		add(aLabel);
		
		JLabel aLabel2 = new JLabel("34,000");
		aLabel2.setBounds(133, 300, 185, 20);
		aLabel2.setFont(font);
		add(aLabel2);

		itemBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Items item1 = new ItemDAO().searchItem("beachmono");
				mainFrame.getInstance(new TopInfoPanel(item1, m, cart, history));
			}
		});

		// 티셔츠2의 정보
		ImageIcon item2 = new ImageIcon("곰돌이T.jpg");
		Image ximg2 = item2.getImage();
		Image yimg2 = ximg2.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg2 = new ImageIcon(yimg2);
		JButton itemBtn2 = new JButton(newimg2);
		itemBtn2.setName("kaibear");

		itemBtn2.setSize(185, 250);
		itemBtn2.setLocation(320, 20);
		add(itemBtn2);

		JLabel bLabel = new JLabel("kaibear");
		bLabel.setBounds(380, 280, 185, 20);
		bLabel.setFont(font);
		add(bLabel);

		JLabel bLabel2 = new JLabel("22,000");
		bLabel2.setBounds(385, 300, 185, 20);
		bLabel2.setFont(font);
		add(bLabel2);

		itemBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item2 = new ItemDAO().searchItem("kaibear");
				mainFrame.getInstance(new TopInfoPanel(item2, m, cart, history));
			}
		});

		// 티셔츠3의 정보
		ImageIcon item3 = new ImageIcon("플라워T.jpg");
		Image ximg3 = item3.getImage();
		Image yimg3 = ximg3.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg3 = new ImageIcon(yimg3);
		JButton itemBtn3 = new JButton(newimg3);
		itemBtn3.setName("flower");

		itemBtn3.setSize(185, 250);
		itemBtn3.setLocation(72, 350);
		add(itemBtn3);

		JLabel cLabel = new JLabel("flower");
		cLabel.setBounds(138, 600, 185, 30);
		cLabel.setFont(font);
		add(cLabel);

		JLabel cLabel2 = new JLabel("28,000");
		cLabel2.setBounds(138, 620, 185, 30);
		cLabel2.setFont(font);
		add(cLabel2);

		itemBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item3 = new ItemDAO().searchItem("flower");
				mainFrame.getInstance(new TopInfoPanel(item3, m, cart, history));
			}
		});

		// 티셔츠4의 정보
		ImageIcon item4 = new ImageIcon("옹브레T.jpg");
		Image ximg4 = item4.getImage();
		Image yimg4 = ximg4.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg4 = new ImageIcon(yimg4);
		JButton itemBtn4 = new JButton(newimg4);
		itemBtn4.setName("ongbre");

		itemBtn4.setSize(185, 250);
		itemBtn4.setLocation(320, 350);
		add(itemBtn4);

		JLabel dLabel = new JLabel("ongbre");
		dLabel.setBounds(380, 600, 185, 30);
		dLabel.setFont(font);
		add(dLabel);

		JLabel dLabel2 = new JLabel("32,000");
		dLabel2.setBounds(382, 620, 185, 30);
		dLabel2.setFont(font);
		add(dLabel2);

		itemBtn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item4 = new ItemDAO().searchItem("ongbre");
				mainFrame.getInstance(new TopInfoPanel(item4, m, cart, history));
			}
		});

		// 이전페이지

		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(font);
		backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new TopPanel(m, cart, history));
			}
		});

		add(bottomSet);

	}
}