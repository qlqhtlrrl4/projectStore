package frame.Bottom;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

public class BottomInfoPanel extends JPanel {

	int payMoney;
	MyInfo m;
	CartDAO c;
	Items item;
	int itemId;
	JTextField countField;
	List<ImageIcon> itemImg;

	
	CustomFont baemin = new CustomFont();
	Font font = baemin.getCreateFont2();


	String str;
	
	public BottomInfoPanel(Items item, MyInfo m, CartDAO c, SellDAO history, List<Items>searchItem) {

		this.m = m;
		this.c = c;
		this.item = item;
		// JPanel 구조
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		itemImg = new ArrayList<>();

		for (int i = 0; i < ItemDAO.itemList.size(); i++) {

			itemImg.add(new ImageIcon(ItemDAO.itemList.get(i).getItemUrl()));
			if (item.getName().equals(ItemDAO.itemList.get(i).getName())) {
				itemId = ItemDAO.itemList.get(i).getId();

			}
		}
		
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
				mainFrame.getInstance(new Kinds(m, c, history));
				
			}
		});
		
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

				String itemName = JOptionPane.showInputDialog("찾으실 상품을 입력하시오");
				
				Kinds.searchItem.clear();
				int d = 0;
				if (!(itemName == null)) {
					if (!itemName.equals("")) {

						for (int i = 0; i < ItemDAO.itemList.size(); i++) {
							
							if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
								Kinds.searchItem.add(ItemDAO.itemList.get(i));
								mainFrame.getInstance(new FindInfo(m, c, history, Kinds.searchItem));
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
				mainFrame.getInstance(new CartPanel(m,c,history));
				
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
				mainFrame.getInstance(new MyPage(m,c,history));
				
			}
		});
		
		topLogo.add(myPageImgBtn);

		// 이미지를 JLabel에 붙여서 출력
		
		Image image = itemImg.get(itemId).getImage();
		Image newImg = image.getScaledInstance(285, 280, java.awt.Image.SCALE_SMOOTH);

		ImageIcon newIcon = new ImageIcon(newImg);
		JLabel img = new JLabel(newIcon);
		img.setBounds(50, 83, 285, 350);
		add(img);

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("BACK");
		backBtn.setBackground(new Color(219,206,190));
		backBtn.setFont(font);
		//backBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*if (16 <= item.getId() && item.getId() <= 19) {
					mainFrame.getInstance(new BottomJean(m, c, history));
				} else if (20 <= item.getId() && item.getId() <= 23) {
					mainFrame.getInstance(new BottomShorts(m, c, history));

				}*/
				mainFrame.getInstance(new FindInfo(m,c,history,searchItem));
			}
		});
		// add(backBtn);

		JLabel countLabel = new JLabel("수량");
		countLabel.setSize(80, 20);
		countLabel.setLocation(350, 310);
		add(countLabel);

		countField = new JTextField(20);
		countField.setSize(80, 20);
		countField.setLocation(400, 310);
		add(countField);
		
		JLabel countLabel2 = new JLabel("사이즈");
		countLabel2.setSize(50, 20);
		countLabel2.setLocation(350, 340);
		add(countLabel2);

		Choice size = new Choice();
		
		size.add("size");
		size.add("28");
		size.add("30");
		size.add("32");
		size.add("34");

		size.setSize(80, 0);
		size.setLocation(400, 340);
		add(size);

		TextArea info = new TextArea("\n  ●브랜드명" + "\n" + "   " + item.getName() + "\n\n" + "  ●상품가격" + "\n" + "   "
				+ item.getPrice() + "원" + "\n\n  ●상품설명" + "\n" + "   " + item.getItemInfo(), 0, 0,
				TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		info.setFont(font);
		info.setSize(580, 200);
		info.setLocation(0, 455);
		info.setBackground(new Color(255, 255, 255));
		info.setEditable(false);
		info.setFont(font);
		add(info);

		RoundedButton sellBtn = new RoundedButton("BUY NOW");

		sellBtn.setBackground(new Color(219,206,190));
		sellBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		//sellBtn.setForeground(new Color(255, 255, 255));
		//bottomSet.add(sellBtn);

		sellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (size.getSelectedItem().equals("size")) {
					JOptionPane.showMessageDialog(null, "사이즈를 고르세요.");
				}

				else if (!countField.getText().equals("")) {
					payMoney = Integer.parseInt(countField.getText()) * ItemDAO.itemList.get(itemId).getPrice();
					String grade = m.gradeCheck(m.getTotal());

					int result = JOptionPane.showConfirmDialog(null,
							"총 " + m.salePrice(grade, payMoney) + "원을 결제 하시겠습니까?", "Confirm",
							JOptionPane.YES_NO_CANCEL_OPTION);

					if (result == JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					} else if (result == JOptionPane.YES_OPTION) {

						SellDAO.historyMap.get(m.getId()).add(new Items(ItemDAO.itemList.get(itemId).getId(),
								ItemDAO.itemList.get(itemId).getName(), ItemDAO.itemList.get(itemId).getPrice(),
								ItemDAO.itemList.get(itemId).getItemUrl(), Integer.parseInt(countField.getText()),
								ItemDAO.itemList.get(itemId).getItemInfo(), ItemDAO.itemList.get(itemId).getKind(),
								size.getSelectedItem()));

						// 나중에 로그인 유저 결제금액 올려주는 method 추가
						JOptionPane.showMessageDialog(null, m.salePrice(grade, payMoney) + "원을 결제하셨습니다.");

						m.setTotal(m.salePrice(grade, m.salePrice(grade, payMoney)));
						

					} else {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "수량을 적으세요.");
				}
			}
		});

		RoundedButton cartBnt = new RoundedButton("ADD TO CART");

		cartBnt.setBackground(new Color(219,206,190));
		cartBnt.setFont(font);
		//cartBnt.setForeground(new Color(255, 255, 255));
		bottomSet.add(cartBnt);
		bottomSet.add(sellBtn);

		cartBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (size.getSelectedItem().equals("size")) {
					JOptionPane.showMessageDialog(null, "사이즈를 고르세요.");
				}

				else if (!countField.getText().equals("")) {
					if (c.registCart(m.getId(),
							new Items(ItemDAO.itemList.get(itemId).getId(), ItemDAO.itemList.get(itemId).getName(),
									ItemDAO.itemList.get(itemId).getPrice(), ItemDAO.itemList.get(itemId).getItemUrl(),
									ItemDAO.itemList.get(itemId).getItemInfo(),
									ItemDAO.itemList.get(itemId).getKind()))) {

						CartDAO.cartMap.get(m.getId()).add(new Items(ItemDAO.itemList.get(itemId).getId(),
								ItemDAO.itemList.get(itemId).getName(), ItemDAO.itemList.get(itemId).getPrice(),
								ItemDAO.itemList.get(itemId).getItemUrl(), Integer.parseInt(countField.getText()),
								ItemDAO.itemList.get(itemId).getItemInfo(), ItemDAO.itemList.get(itemId).getKind(),
								size.getSelectedItem()));

					} else {

						for (int i = 0; i < CartDAO.cartMap.get(m.getId()).size(); i++) {

							CartDAO.cartMap.get(m.getId()).get(i).setCnt(CartDAO.cartMap.get(m.getId()).get(i).getCnt()
									+ Integer.parseInt(countField.getText()));
						}
					}
					JOptionPane.showMessageDialog(null, "장바구니 담기");
				} else {
					JOptionPane.showMessageDialog(null, "수량을 입력하시오");
				}

			}
		});
		add(bottomSet);
	}	
	

	public BottomInfoPanel(Items item, MyInfo m, CartDAO c, SellDAO history) {

		this.m = m;
		this.c = c;
		this.item = item;
		// JPanel 구조
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		itemImg = new ArrayList<>();

		for (int i = 0; i < ItemDAO.itemList.size(); i++) {

			itemImg.add(new ImageIcon(ItemDAO.itemList.get(i).getItemUrl()));
			if (item.getName().equals(ItemDAO.itemList.get(i).getName())) {
				itemId = ItemDAO.itemList.get(i).getId();

			}
		}

		// 이미지를 JLabel에 붙여서 출력
		
		Image image = itemImg.get(itemId).getImage();
		Image newImg = image.getScaledInstance(285, 280, java.awt.Image.SCALE_SMOOTH);

		ImageIcon newIcon = new ImageIcon(newImg);
		JLabel img = new JLabel(newIcon);
		img.setBounds(50, 83, 285, 350);
		add(img);

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("BACK");
		backBtn.setBackground(new Color(219,206,190));
		backBtn.setFont(font);
		//backBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (16 <= item.getId() && item.getId() <= 19) {
					mainFrame.getInstance(new BottomJean(m, c, history));
				} else if (20 <= item.getId() && item.getId() <= 23) {
					mainFrame.getInstance(new BottomShorts(m, c, history));

				}
			}
		});
		// add(backBtn);

		JLabel countLabel = new JLabel("수량");
		countLabel.setSize(80, 20);
		countLabel.setLocation(350, 310);
		add(countLabel);

		countField = new JTextField(20);
		countField.setSize(80, 20);
		countField.setLocation(400, 310);
		add(countField);
		
		JLabel countLabel2 = new JLabel("사이즈");
		countLabel2.setSize(50, 20);
		countLabel2.setLocation(350, 340);
		add(countLabel2);

		Choice size = new Choice();
		
		size.add("size");
		size.add("28");
		size.add("30");
		size.add("32");
		size.add("34");

		size.setSize(80, 0);
		size.setLocation(400, 340);
		add(size);

		TextArea info = new TextArea("\n  ●브랜드명" + "\n" + "   " + item.getName() + "\n\n" + "  ●상품가격" + "\n" + "   "
				+ item.getPrice() + "원" + "\n\n  ●상품설명" + "\n" + "   " + item.getItemInfo(), 0, 0,
				TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		info.setFont(font);
		info.setSize(580, 200);
		info.setLocation(0, 455);
		info.setBackground(new Color(255, 255, 255));
		info.setEditable(false);
		info.setFont(font);
		add(info);

		RoundedButton sellBtn = new RoundedButton("BUY NOW");

		sellBtn.setBackground(new Color(219,206,190));
		sellBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		//sellBtn.setForeground(new Color(255, 255, 255));
		//bottomSet.add(sellBtn);

		sellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (size.getSelectedItem().equals("size")) {
					JOptionPane.showMessageDialog(null, "사이즈를 고르세요.");
				}

				else if (!countField.getText().equals("")) {
					payMoney = Integer.parseInt(countField.getText()) * ItemDAO.itemList.get(itemId).getPrice();
					String grade = m.gradeCheck(m.getTotal());

					int result = JOptionPane.showConfirmDialog(null,
							"총 " + m.salePrice(grade, payMoney) + "원을 결제 하시겠습니까?", "Confirm",
							JOptionPane.YES_NO_CANCEL_OPTION);

					if (result == JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					} else if (result == JOptionPane.YES_OPTION) {

						SellDAO.historyMap.get(m.getId()).add(new Items(ItemDAO.itemList.get(itemId).getId(),
								ItemDAO.itemList.get(itemId).getName(), ItemDAO.itemList.get(itemId).getPrice(),
								ItemDAO.itemList.get(itemId).getItemUrl(), Integer.parseInt(countField.getText()),
								ItemDAO.itemList.get(itemId).getItemInfo(), ItemDAO.itemList.get(itemId).getKind(),
								size.getSelectedItem()));

						// 나중에 로그인 유저 결제금액 올려주는 method 추가
						JOptionPane.showMessageDialog(null, m.salePrice(grade, payMoney) + "원을 결제하셨습니다.");

						m.setTotal(m.salePrice(grade, m.salePrice(grade, payMoney)));
						

					} else {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "수량을 적으세요.");
				}
			}
		});

		RoundedButton cartBnt = new RoundedButton("ADD TO CART");

		cartBnt.setBackground(new Color(219,206,190));
		cartBnt.setFont(font);
		//cartBnt.setForeground(new Color(255, 255, 255));
		bottomSet.add(cartBnt);
		bottomSet.add(sellBtn);

		cartBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (size.getSelectedItem().equals("size")) {
					JOptionPane.showMessageDialog(null, "사이즈를 고르세요.");
				}

				else if (!countField.getText().equals("")) {
					if (c.registCart(m.getId(),
							new Items(ItemDAO.itemList.get(itemId).getId(), ItemDAO.itemList.get(itemId).getName(),
									ItemDAO.itemList.get(itemId).getPrice(), ItemDAO.itemList.get(itemId).getItemUrl(),
									ItemDAO.itemList.get(itemId).getItemInfo(),
									ItemDAO.itemList.get(itemId).getKind()))) {

						CartDAO.cartMap.get(m.getId()).add(new Items(ItemDAO.itemList.get(itemId).getId(),
								ItemDAO.itemList.get(itemId).getName(), ItemDAO.itemList.get(itemId).getPrice(),
								ItemDAO.itemList.get(itemId).getItemUrl(), Integer.parseInt(countField.getText()),
								ItemDAO.itemList.get(itemId).getItemInfo(), ItemDAO.itemList.get(itemId).getKind(),
								size.getSelectedItem()));

					} else {

						for (int i = 0; i < CartDAO.cartMap.get(m.getId()).size(); i++) {

							CartDAO.cartMap.get(m.getId()).get(i).setCnt(CartDAO.cartMap.get(m.getId()).get(i).getCnt()
									+ Integer.parseInt(countField.getText()));
						}
					}
					JOptionPane.showMessageDialog(null, "장바구니 담기");
				} else {
					JOptionPane.showMessageDialog(null, "수량을 입력하시오");
				}

			}
		});
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
				mainFrame.getInstance(new Kinds(m, c, history));
				
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
				mainFrame.getInstance(new CartPanel(m,c,history));
				
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
				mainFrame.getInstance(new MyPage(m,c,history));
				
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

				Kinds.searchItem.clear();
				int d = 0;
				if (!(itemName == null)) {
					if (!itemName.equals("")) {

						for (int i = 0; i < ItemDAO.itemList.size(); i++) {
							
							if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
								Kinds.searchItem.add(ItemDAO.itemList.get(i));
								mainFrame.getInstance(new FindInfo(m, c, history, Kinds.searchItem));
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

		add(bottomSet);

	}

}
