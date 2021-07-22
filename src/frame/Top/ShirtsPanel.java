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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import customDAO.CartDAO;
import customDAO.ItemDAO;
import customDAO.Items;
import customDAO.MyInfo;
import customDAO.SellDAO;
import frame.CartPanel;
import frame.FindInfo;
import frame.Kinds;
import frame.MyPage;
import frame.mainFrame;
import view.CustomFont;
import view.RoundedButton;

public class ShirtsPanel extends JPanel {

	public ShirtsPanel(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();
		Font font2 = baemin.getCreateFont();

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		// 셔츠1의 정보
		ImageIcon item1 = new ImageIcon("라멜T.jpg");
		Image ximg = item1.getImage();
		Image yimg = ximg.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg = new ImageIcon(yimg);
		JButton itemBtn1 = new JButton(newimg);
		itemBtn1.setName("Lamel");

		itemBtn1.setSize(185, 220);
		itemBtn1.setLocation(72, 105);
		add(itemBtn1);

		JLabel aLabel = new JLabel("Lamel");
		aLabel.setBounds(142, 330, 185, 20);
		aLabel.setFont(font2);
		add(aLabel);
		//
		JLabel aLabel2 = new JLabel("38,000");
		aLabel2.setBounds(143, 350, 185, 20);
		aLabel2.setFont(font2);
		add(aLabel2);

		itemBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Items item1 = new ItemDAO().searchItem("Lamel");
				mainFrame.getInstance(new TopInfoPanel(item1, m, cart, history));
			}
		});

		// 셔츠2의 정보
		ImageIcon item2 = new ImageIcon("라블로T.jpg");
		Image ximg2 = item2.getImage();
		Image yimg2 = ximg2.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg2 = new ImageIcon(yimg2);
		JButton itemBtn2 = new JButton(newimg2);
		itemBtn2.setName("Lablo");

		itemBtn2.setSize(185, 220);
		itemBtn2.setLocation(320, 105);
		add(itemBtn2);

		JLabel bLabel = new JLabel("Lablo");
		bLabel.setBounds(389, 330, 185, 20);
		bLabel.setFont(font2);
		add(bLabel);

		JLabel bLabel2 = new JLabel("42,000");
		bLabel2.setBounds(385, 350, 185, 20);
		bLabel2.setFont(font2);
		add(bLabel2);

		itemBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item2 = new ItemDAO().searchItem("Lablo");
				mainFrame.getInstance(new TopInfoPanel(item2, m, cart, history));
			}
		});

		// 셔츠3의 정보
		ImageIcon item3 = new ImageIcon("셔링T.jpg");
		Image ximg3 = item3.getImage();
		Image yimg3 = ximg3.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg3 = new ImageIcon(yimg3);
		JButton itemBtn3 = new JButton(newimg3);
		itemBtn3.setName("Shirring");

		itemBtn3.setSize(185, 220);
		itemBtn3.setLocation(72, 380);
		add(itemBtn3);

		JLabel cLabel = new JLabel("Shirring");
		cLabel.setBounds(135, 600, 185, 30);
		cLabel.setFont(font2);
		add(cLabel);

		JLabel cLabel2 = new JLabel("40,000");
		cLabel2.setBounds(138, 620, 185, 30);
		cLabel2.setFont(font2);
		add(cLabel2);

		itemBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item3 = new ItemDAO().searchItem("Shirring");
				mainFrame.getInstance(new TopInfoPanel(item3, m, cart, history));
			}
		});

		// 셔츠4의 정보
		ImageIcon item4 = new ImageIcon("썸머T.jpg");
		Image ximg4 = item4.getImage();
		Image yimg4 = ximg4.getScaledInstance(185, 250, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg4 = new ImageIcon(yimg4);
		JButton itemBtn4 = new JButton(newimg4);
		itemBtn4.setName("Summer");

		itemBtn4.setSize(185, 220);
		itemBtn4.setLocation(320, 380);
		add(itemBtn4);

		JLabel dLabel = new JLabel("Summer");
		dLabel.setBounds(380, 600, 185, 30);
		dLabel.setFont(font2);
		add(dLabel);

		JLabel dLabel2 = new JLabel("38,000");
		dLabel2.setBounds(384, 620, 185, 30);
		dLabel2.setFont(font2);
		add(dLabel2);

		itemBtn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item4 = new ItemDAO().searchItem("Summer");
				mainFrame.getInstance(new TopInfoPanel(item4, m, cart, history));
			}
		});

		// 이전페이지

		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(219,206,190));
		backBtn.setFont(font);
		//backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new TopPanel(m, cart, history));
			}
		});

		add(bottomSet);
		
		JPanel topLogo = new JPanel();
		topLogo.setBounds(0,0,600,70);
		topLogo.setBackground(new Color(219,206,190));
		topLogo.setLayout(null);
		add(topLogo);
		
		RoundedButton sName = new RoundedButton("marchen");
		sName.setBackground(new Color(219,206,190));
		sName.setBorderPainted(false);
		sName.setBounds(204,0,180,70);
		sName.setFont(font.deriveFont(38f));
		topLogo.add(sName);
		
		sName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m, cart, history));
				
			}
		});
		
		
		ImageIcon icon = new ImageIcon("cartimg4.png");

		Image image3 = icon.getImage();
		Image newImg3 = image3.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon3 = new ImageIcon(newImg3);

		JButton cartImgBtn = new JButton(newIcon3);
		cartImgBtn.setBackground(new Color(219,206,190));
		cartImgBtn.setBorderPainted(false);
		cartImgBtn.setBounds(520, 17, 40, 40);

		topLogo.add(cartImgBtn);
		
		cartImgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new CartPanel(m,cart,history));
				
			}
		});
		
		ImageIcon icon2 = new ImageIcon("mypageIcon2.png");
		Image image2 = icon2.getImage();
		Image newImg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon myIcon = new ImageIcon(newImg2);
		
		JButton myPageImgBtn = new JButton(myIcon);
		myPageImgBtn.setBackground(new Color(219,206,190));
		myPageImgBtn.setBorderPainted(false);
		myPageImgBtn.setBounds(485, 22, 30, 30);
		
		myPageImgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MyPage(m,cart,history));
				
			}
		});
		
		topLogo.add(myPageImgBtn);
		
		ImageIcon icon4 = new ImageIcon("search.png");
		Image image4 = icon4.getImage();
		Image newImg4 = image4.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon myIcon4 = new ImageIcon(newImg4);

		JButton searchBtn = new JButton(myIcon4);
		searchBtn.setBackground(new Color(219, 206, 190));
		searchBtn.setBorderPainted(false);
		searchBtn.setBounds(445, 22, 30, 30);
		// myPageImgBtn.setBounds(465, 22, 30, 30);

		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Kinds.searchItem.clear();
				String itemName = JOptionPane.showInputDialog("찾으실 상품을 입력하시오");

				boolean flag = true;
				if (!(itemName == null)) {
					if (!itemName.equals("")) {

						for (int i = 0; i < ItemDAO.itemList.size(); i++) {
							if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
								Kinds.searchItem.add(ItemDAO.itemList.get(i));
								flag = false;
								mainFrame.getInstance(new FindInfo(m, cart, history, Kinds.searchItem));
							} else if (!(ItemDAO.itemList.get(i).getName().toLowerCase()
									.contains(itemName.toLowerCase()))) {
								if (flag) {

									JOptionPane.showMessageDialog(null, "상품이 존재하지 않습니다.");
									break;
								}

							}

						}
					}
				}
			}
		});

		topLogo.add(searchBtn);


	}
}
