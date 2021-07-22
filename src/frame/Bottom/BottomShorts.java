package frame.Bottom;

import java.awt.BorderLayout;
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
import customDAO.CartDAO;
import customDAO.ItemDAO;

public class BottomShorts extends JPanel {

	public BottomShorts(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();
		Font font2 = baemin.getCreateFont();

		// 하의5 정보
		ImageIcon bottom5 = new ImageIcon("무신사 스탠다드.jpg");
		JButton btnBottom5 = new JButton(bottom5);
		btnBottom5.setName("무신사 스탠다드");

		btnBottom5.setSize(185, 220);
		btnBottom5.setLocation(72, 105);
		add(btnBottom5);
		
		JLabel aLabel = new JLabel("무신사 스탠다드");
		aLabel.setBounds(113, 330, 185, 20);
		aLabel.setFont(font2);
		add(aLabel);
		
		JLabel aLabel2 = new JLabel("25,000");
		aLabel2.setBounds(135, 350, 185, 20);
		aLabel2.setFont(font2);
		add(aLabel2);

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

		btnBottom6.setSize(185, 220);
		btnBottom6.setLocation(320, 105);
		add(btnBottom6);
		
		JLabel bLabel = new JLabel("에이본");
		bLabel.setBounds(390, 330, 185, 20);
		bLabel.setFont(font2);
		add(bLabel);

		JLabel bLabel2 = new JLabel("33,000");
		bLabel2.setBounds(385, 350, 185, 20);
		bLabel2.setFont(font2);
		add(bLabel2);

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

		btnBottom7.setSize(185, 220);
		btnBottom7.setLocation(72, 380);
		add(btnBottom7);
		
		JLabel cLabel = new JLabel("더블유브이");
		cLabel.setBounds(130, 600, 185, 30);
		cLabel.setFont(font2);
		add(cLabel);

		JLabel cLabel2 = new JLabel("34,000");
		cLabel2.setBounds(138, 620, 185, 30);
		cLabel2.setFont(font2);
		add(cLabel2);

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

		btnBottom8.setSize(185, 220);
		btnBottom8.setLocation(320, 380);
		add(btnBottom8);
		
		JLabel dLabel = new JLabel("소프트서울");
		dLabel.setBounds(375, 600, 185, 30);
		dLabel.setFont(font2);
		add(dLabel);

		JLabel dLabel2 = new JLabel("100,000");
		dLabel2.setBounds(377, 620, 185, 30);
		dLabel2.setFont(font2);
		add(dLabel2);

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

		RoundedButton btnBack = new RoundedButton("BACK");

		btnBack.setBackground(new Color(219,206,190));
		btnBack.setFont(font);
		//btnBack.setForeground(new Color(255, 255, 255));
		bottomSet.add(btnBack);

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new BottomPanel(m,cart,history));

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

				int d = 0;
				if (!(itemName == null)) {
					if (!itemName.equals("")) {

						for (int i = 0; i < ItemDAO.itemList.size(); i++) {
							
							if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
								Kinds.searchItem.add(ItemDAO.itemList.get(i));
								mainFrame.getInstance(new FindInfo(m, cart, history, Kinds.searchItem));
								d++;
							}
							
						}
						if(d ==0) {
							JOptionPane.showMessageDialog(null, "상품이 존재하지 않습니다.");
						}
						
					}
				}
			}
		});

		topLogo.add(searchBtn);

	}

}