package frame.Top;

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

public class TopPanel extends JPanel {

	public TopPanel(MyInfo m, CartDAO cart,SellDAO history) {
		
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,2,5,0));
		bottomSet.setBackground(Color.WHITE);

		ImageIcon item1 = new ImageIcon("비치모노T.jpg");
		JButton itemBtn1 = new JButton(item1);
		itemBtn1.setName("비치모노T");

		itemBtn1.setSize(230, 270);
		itemBtn1.setLocation(45, 60);

		add(itemBtn1);

		itemBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Items item1 = new ItemDAO().searchItem("a");
				mainFrame.getInstance(new TopInfoPanel(item1, m, cart,history));
			}
		});

		// 상의 2
		ImageIcon item2 = new ImageIcon("곰돌이T.jpg");
		JButton itemBtn2 = new JButton(item2);
		itemBtn2.setName("곰돌이T");

		itemBtn2.setSize(230, 270);
		itemBtn2.setLocation(315, 60);
		add(itemBtn2);

		itemBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item2 = new ItemDAO().searchItem("b");
				mainFrame.getInstance(new TopInfoPanel(item2, m, cart,history));
			}
		});

		// 상의 3
		ImageIcon item3 = new ImageIcon("플라워T.jpg");
		JButton itemBtn3 = new JButton(item3);
		itemBtn3.setName("플라워T");

		itemBtn3.setSize(230, 270);
		itemBtn3.setLocation(45, 370);
		add(itemBtn3);

		itemBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item3 = new ItemDAO().searchItem("c");
				mainFrame.getInstance(new TopInfoPanel(item3, m, cart,history));
			}
		});

		// 상의 4
		ImageIcon item4 = new ImageIcon("옹브레T.jpg");
		JButton itemBtn4 = new JButton(item4);
		itemBtn4.setName("옹브레T");

		itemBtn4.setSize(230, 270);
		itemBtn4.setLocation(315, 370);
		add(itemBtn4);

		itemBtn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item4 = new ItemDAO().searchItem("d");
				mainFrame.getInstance(new TopInfoPanel(item4, m, cart,history));
			}
		});

		RoundedButton backBtn = new RoundedButton("뒤로가기");

		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setForeground(new Color(255, 255, 255));
		
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m, cart,history));
			}
		});
		
		RoundedButton nextBtn = new RoundedButton("다음 페이지");
		nextBtn.setBackground(new Color(32, 32, 32));
		nextBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		nextBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(nextBtn);

		add(bottomSet);
	}

}
