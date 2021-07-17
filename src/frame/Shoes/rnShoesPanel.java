package frame.Shoes;

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
import view.RoundedButton;

public class rnShoesPanel extends JPanel {

	public rnShoesPanel(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		// 운동화1의 정보
		ImageIcon item1 = new ImageIcon("운동화1.jpg");
		Image ximg=item1.getImage();
		Image yimg= ximg.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg=new ImageIcon(yimg);
		JButton itemBtn1 = new JButton(newimg);
		itemBtn1.setName("나이키 에어포스");

		itemBtn1.setSize(185, 250);
		itemBtn1.setLocation(72, 20);
		add(itemBtn1);

		itemBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Items item1 = new ItemDAO().searchItem("나이키 에어포스");
				mainFrame.getInstance(new ShoesInfoPanel(item1, m, cart, history));
			}
		});

		// 운동화2의 정보
		ImageIcon item2 = new ImageIcon("운동화2.jpg");
		Image ximg2=item2.getImage();
		Image yimg2= ximg2.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg2=new ImageIcon(yimg2);
		JButton itemBtn2 = new JButton(newimg2);
		itemBtn2.setName("아디다스 제트엑스");

		itemBtn2.setSize(185, 250);
		itemBtn2.setLocation(320, 20);
		add(itemBtn2);

		itemBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item2 = new ItemDAO().searchItem("아디다스 제트엑스");
				mainFrame.getInstance(new ShoesInfoPanel(item2, m, cart, history));
			}
		});

		// 운동화3의 정보
		ImageIcon item3 = new ImageIcon("운동화3.jpg");
		Image ximg3=item3.getImage();
		Image yimg3= ximg3.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg3=new ImageIcon(yimg3);
		JButton itemBtn3 = new JButton(newimg3);
		itemBtn3.setName("뉴발란스 480");

		itemBtn3.setSize(185, 250);
		itemBtn3.setLocation(72, 350);
		add(itemBtn3);

		itemBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item3 = new ItemDAO().searchItem("뉴발란스 480");
				mainFrame.getInstance(new ShoesInfoPanel(item3, m, cart, history));
			}
		});

		// 운동화4의 정보
		ImageIcon item4 = new ImageIcon("운동화4.jpg");
		Image ximg4=item4.getImage();
		Image yimg4= ximg4.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg4=new ImageIcon(yimg4);
		JButton itemBtn4 = new JButton(newimg4);
		itemBtn4.setName("COURT-MASTER");

		itemBtn4.setSize(185, 250);
		itemBtn4.setLocation(320, 350);
		add(itemBtn4);

		itemBtn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item4 = new ItemDAO().searchItem("COURT-MASTER");
				mainFrame.getInstance(new ShoesInfoPanel(item4, m, cart, history));
			}
		});

		// 이전페이지

		RoundedButton backBtn = new RoundedButton("이전 페이지");

		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new ShoesPanel(m, cart, history));
			}
		});

		add(bottomSet);
	}

}
