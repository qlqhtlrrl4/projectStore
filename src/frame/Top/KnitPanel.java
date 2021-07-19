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
import view.RoundedButton;

public class KnitPanel extends JPanel {

	public KnitPanel(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		// 니트 1의 정보
		ImageIcon item1 = new ImageIcon("메이시T.jpg");
		Image ximg = item1.getImage();
		Image yimg = ximg.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg = new ImageIcon(yimg);
		JButton itemBtn1 = new JButton(newimg);
		itemBtn1.setName("Meish");

		itemBtn1.setSize(185, 250);
		itemBtn1.setLocation(72, 20);
		add(itemBtn1);

		JLabel aLabel = new JLabel("Meish");
		aLabel.setBounds(145, 280, 185, 20);
		aLabel.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		add(aLabel);
		
		JLabel aLabel2 = new JLabel("43,000");
		aLabel2.setBounds(140, 300, 185, 20);
		aLabel2.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		add(aLabel2);

		itemBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Items item1 = new ItemDAO().searchItem("Meish");
				mainFrame.getInstance(new TopInfoPanel(item1, m, cart, history));
			}
		});

		// 니트2의 정보
		ImageIcon item2 = new ImageIcon("베니T.jpg");
		Image ximg2 = item2.getImage();
		Image yimg2 = ximg2.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg2 = new ImageIcon(yimg2);
		JButton itemBtn2 = new JButton(newimg2);
		itemBtn2.setName("Benny");

		itemBtn2.setSize(185, 250);
		itemBtn2.setLocation(320, 20);
		add(itemBtn2);

		JLabel bLabel = new JLabel("Benny");
		bLabel.setBounds(383, 280, 185, 20);
		bLabel.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		add(bLabel);

		JLabel bLabel2 = new JLabel("38,000");
		bLabel2.setBounds(385, 300, 185, 20);
		bLabel2.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		add(bLabel2);

		itemBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item2 = new ItemDAO().searchItem("Benny");
				mainFrame.getInstance(new TopInfoPanel(item2, m, cart, history));
			}
		});

		// 니트3의 정보
		ImageIcon item3 = new ImageIcon("빈즈T.jpg");
		Image ximg3 = item3.getImage();
		Image yimg3 = ximg3.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg3 = new ImageIcon(yimg3);
		JButton itemBtn3 = new JButton(newimg3);
		itemBtn3.setName("Beans");

		itemBtn3.setSize(185, 250);
		itemBtn3.setLocation(72, 350);
		add(itemBtn3);

		JLabel cLabel = new JLabel("Beans");
		cLabel.setBounds(138, 600, 185, 30);
		cLabel.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		add(cLabel);

		JLabel cLabel2 = new JLabel("35,000");
		cLabel2.setBounds(138, 620, 185, 30);
		cLabel2.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		add(cLabel2);

		itemBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item3 = new ItemDAO().searchItem("Beans");
				mainFrame.getInstance(new TopInfoPanel(item3, m, cart, history));
			}
		});

		// 니트4의 정보
		ImageIcon item4 = new ImageIcon("허쉬T.jpg");
		Image ximg4 = item4.getImage();
		Image yimg4 = ximg4.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg4 = new ImageIcon(yimg4);
		JButton itemBtn4 = new JButton(newimg4);
		itemBtn4.setName("Hush");

		itemBtn4.setSize(185, 250);
		itemBtn4.setLocation(320, 350);
		add(itemBtn4);

		JLabel dLabel = new JLabel("Hush");
		dLabel.setBounds(388, 600, 185, 30);
		dLabel.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		add(dLabel);

		JLabel dLabel2 = new JLabel("35,000");
		dLabel2.setBounds(386, 620, 185, 30);
		dLabel2.setFont(new Font("나눔고딕코딩", Font.BOLD, 15));
		add(dLabel2);

		itemBtn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item4 = new ItemDAO().searchItem("Hush");
				mainFrame.getInstance(new TopInfoPanel(item4, m, cart, history));
			}
		});

		// 이전페이지

		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
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
