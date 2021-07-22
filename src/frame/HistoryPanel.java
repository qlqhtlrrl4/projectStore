package frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customDAO.CartDAO;
import customDAO.ItemDAO;
import customDAO.MyInfo;
import customDAO.SellDAO;
import view.CustomFont;
import view.RoundedButton;

public class HistoryPanel extends JPanel {

	int page = 0;
	ArrayList<JCheckBox> box = new ArrayList<>();
	int panelCount = 0;
	JPanel cartViewPanel;
	ArrayList<JPanel> pgNum = new ArrayList<>();
	JPanel pa;
	
	
	
	int itemId = 0;

	int partMoney = 0;
	int payMoney = 0;
	// int pageBtn = 0;
	int count = 0;
	int sel;
	static int bb = 0;
	JCheckBox select;
	MyInfo m;

	public HistoryPanel() {
	}

	public HistoryPanel(MyInfo m, CartDAO cart,SellDAO h) {

		this.m = m;

		//CustomFont font = new CustomFont();
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		box = new ArrayList<>();

		ArrayList<ImageIcon> itemImg = new ArrayList<>();

		pa = new JPanel();
		pa.setBounds(0, 570, 600, 40);
		pa.setBackground(Color.WHITE);
		pa.setLayout(new FlowLayout());

		itemImg.clear();

		for (int i = 0; i < SellDAO.historyMap.get(m.getId()).size(); i++) {

			itemImg.add(new ImageIcon(SellDAO.historyMap.get(m.getId()).get(i).getItemUrl()));

		}

		if ((SellDAO.historyMap.get(m.getId()).size() > 0)) {

			panelCount = (int) Math
					.ceil(Double.parseDouble(String.valueOf(SellDAO.historyMap.get(m.getId()).size())) / 4.0);

			for (int i = 0; i < panelCount; i++) {
				pgNum.add(new JPanel());
				
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
						mainFrame.getInstance(new Kinds(m, cart, h));
						
					}
				});
				
				
				ImageIcon icon = new ImageIcon("cartimg4.png");

				Image image = icon.getImage();
				Image newImg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
				ImageIcon newIcon = new ImageIcon(newImg);

				JButton cartImgBtn = new JButton(newIcon);
				cartImgBtn.setBackground(new Color(219,206,190));
				cartImgBtn.setBorderPainted(false);
				cartImgBtn.setBounds(520, 17, 40, 40);

				topLogo.add(cartImgBtn);
				
				cartImgBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						mainFrame.getInstance(new CartPanel(m,cart,h));
						
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
						Kinds.searchItem.clear();
						String itemName = JOptionPane.showInputDialog("찾으실 상품을 입력하시오");

						int c = 0;
						if (!(itemName == null)) {
							if (!itemName.equals("")) {

								for (int i = 0; i < ItemDAO.itemList.size(); i++) {
									
									if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
										Kinds.searchItem.add(ItemDAO.itemList.get(i));
										mainFrame.getInstance(new FindInfo(m, cart, h, Kinds.searchItem));
										c++;
									}
									
								}
								if(c ==0) {
									JOptionPane.showMessageDialog(null, "상품이 존재하지 않습니다.");
								}
								
							}
						}
					}
				});

				topLogo.add(searchBtn);

			
				
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
						mainFrame.getInstance(new MyPage(m,cart,h));
						
					}
				});
				
				topLogo.add(myPageImgBtn);
				pgNum.get(i).add(topLogo);
			}

			pgNum.get(0).setVisible(true);

			for (int j = 0; j < panelCount; j++) {
				RoundedButton pageBtn = new RoundedButton(String.valueOf(j + 1));
				pageBtn.setFont(font);

				if (Integer.parseInt(pageBtn.getText()) == panelCount) {

					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setBounds(0, 0, 600, 560);
					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setBackground(Color.WHITE);
					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setLayout(null);

					for (int i = (Integer.parseInt(pageBtn.getText()) - 1) * 4; i < (SellDAO.historyMap.get(m.getId())
							.size()); i++) {

						Image image = itemImg.get(i).getImage();
						Image newImg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						// 이미지
						ImageIcon newIcon = new ImageIcon(newImg);
						JLabel img = new JLabel(newIcon);
						img.setBounds(50, 90 + (((i) % 4) * 110), 200, 100);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(img);

						JLabel nameInfo = new JLabel("상품명 : " + SellDAO.historyMap.get(m.getId()).get(i).getName()); // 상품명
						JLabel itemInfo = new JLabel("상품 가격 : " + SellDAO.historyMap.get(m.getId()).get(i).getPrice());
						JLabel cntInfo = new JLabel("수량 : " + SellDAO.historyMap.get(m.getId()).get(i).getCnt());
						JLabel sizeInfo = new JLabel("사이즈 : " + SellDAO.historyMap.get(m.getId()).get(i).getSize());

						nameInfo.setBounds(300, 90 + ((i % 4) * 110), 200, 15);
						itemInfo.setBounds(300, 115 + ((i % 4) * 110), 200, 15);
						cntInfo.setBounds(300, 140 + ((i % 4) * 110), 100, 15);
						sizeInfo.setBounds(300, 165 + ((i % 4) * 110), 100, 15);
						

						itemInfo.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());

						

						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(nameInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(itemInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(sizeInfo);


						RoundedButton detailBtn = new RoundedButton("상세보기");
						detailBtn.setBounds(430, 102 + ((i % 4) * 115), 130, 70);
						detailBtn.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(detailBtn);
						
						detailBtn.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								
								JFrame detailPage = new JFrame();
								detailPage.setLayout(null);
								detailPage.setSize(600,800);
								detailPage.setBackground(Color.blue);
								int id = Integer.parseInt(String.valueOf((detailBtn.getClientProperty("id"))));
								Container c = detailPage.getContentPane();
								c.setBackground(Color.WHITE);
								
								
								ImageIcon icon = new ImageIcon(ItemDAO.itemList.get(id).getItemUrl());
								
								Image image = icon.getImage();
								Image newImg = image.getScaledInstance(350, 340, java.awt.Image.SCALE_SMOOTH);
								ImageIcon newIcon = new ImageIcon(newImg);
								JLabel img = new JLabel(newIcon);
								img.setBounds(20, 0, 500, 370);
								detailPage.add(img);
															
								
								TextArea info = new TextArea("\n◈ 상품 이름" + "\n" + "   " + ItemDAO.itemList.get(id).getName() + "\n" + "\n◈ 상품 가격\n " + "   "
										+ ItemDAO.itemList.get(id).getPrice() + "\n" + "\n◈ 상품 정보" + "\n" + "   " + ItemDAO.itemList.get(id).getItemInfo(), 0, 0,
										TextArea.SCROLLBARS_VERTICAL_ONLY);

								info.setSize(580, 350);
								info.setLocation(0, 375);
								info.setBackground(Color.WHITE);
								info.setFont(font);
								detailPage.add(info);
								detailPage.setDefaultCloseOperation(detailPage.DISPOSE_ON_CLOSE);
								
								detailPage.setVisible(true);
								
							}
						});

					}
				}

				else {

					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setBounds(0, 0, 600, 560);
					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setBackground(Color.WHITE);
					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setLayout(null);

					for (int i = (Integer.parseInt(pageBtn.getText()) - 1) * 4; i < Integer.parseInt(pageBtn.getText())
							* 4; i++) {

						Image image = itemImg.get(i).getImage();
						Image newImg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						// 이미지
						ImageIcon newIcon = new ImageIcon(newImg);
						JLabel img = new JLabel(newIcon);
						img.setBounds(50, 90 + ((i % 4) * 110), 200, 100);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(img);

						JLabel nameInfo = new JLabel("상품명 : " + SellDAO.historyMap.get(m.getId()).get(i).getName()); // 상품명
						JLabel itemInfo = new JLabel("상품 가격 : " + SellDAO.historyMap.get(m.getId()).get(i).getPrice());
						JLabel cntInfo = new JLabel("수량 : " + SellDAO.historyMap.get(m.getId()).get(i).getCnt());
						JLabel sizeInfo = new JLabel("사이즈 : " + SellDAO.historyMap.get(m.getId()).get(i).getSize());

						nameInfo.setBounds(300, 90 + ((i % 4) * 110), 200, 15);
						itemInfo.setBounds(300, 115 + ((i % 4) * 110), 200, 15);
						cntInfo.setBounds(300, 140 + ((i % 4) * 110), 100, 15);
						sizeInfo.setBounds(300, 165 + ((i % 4) * 110), 100, 15);
						
						

						itemInfo.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());

						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(nameInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(itemInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(sizeInfo);
						
						
						RoundedButton detailBtn = new RoundedButton("상세보기");
						detailBtn.setBounds(430, 102 + ((i % 4) * 115), 130, 70);
						detailBtn.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(detailBtn);
						
						detailBtn.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								
								JFrame detailPage = new JFrame();
								detailPage.setLayout(null);
								detailPage.setSize(600,800);
								detailPage.setBackground(Color.WHITE);
								int id = Integer.parseInt(String.valueOf((detailBtn.getClientProperty("id"))));
								
								
								ImageIcon icon = new ImageIcon(ItemDAO.itemList.get(id).getItemUrl());
								
								Image image = icon.getImage();
								Image newImg = image.getScaledInstance(350, 340, java.awt.Image.SCALE_SMOOTH);
								ImageIcon newIcon = new ImageIcon(newImg);
								JLabel img = new JLabel(newIcon);
								img.setBounds(20, 0, 500, 370);
								detailPage.add(img);
															
								
								TextArea info = new TextArea("\n◈ 상품 이름" + "\n" + "   " + ItemDAO.itemList.get(id).getName() + "\n" + "\n◈ 상품 가격\n " + "   "
										+ ItemDAO.itemList.get(id).getPrice() + "\n" + "\n◈ 상품 정보" + "\n" + "   " + ItemDAO.itemList.get(id).getItemInfo(), 0, 0,
										TextArea.SCROLLBARS_VERTICAL_ONLY);

								info.setSize(580, 350);
								info.setLocation(0, 375);
								info.setBackground(Color.WHITE);
								info.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
								detailPage.add(info);
								detailPage.setDefaultCloseOperation(detailPage.DISPOSE_ON_CLOSE);
								
								detailPage.setVisible(true);
								
							}
						});
					}
				}

				pageBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						for (int j = 0; j < pgNum.size(); j++) {
							if (Integer.parseInt(pageBtn.getText()) - 1 == j) {
								pgNum.get(j).setVisible(true);

							} else {
								pgNum.get(j).setVisible(false);
							}
						}
					}

				});

				pa.add(pageBtn);
			}

		}
		for (int i = 0; i < pgNum.size(); i++) {
			add(pgNum.get(i));
		}

		add(pa);

		// 총 결제 금액
		payMoney = h.totalMoney(m.getId());

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 4, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(219,206,190));
		backBtn.setFont(font);
		//backBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MyPage(m,cart,h));
			}
		});

		RoundedButton mainBtn = new RoundedButton("MAIN");
		mainBtn.setBackground(new Color(219,206,190));
		mainBtn.setFont(font);
		//mainBtn.setForeground(new Color(255, 255, 255));

		mainBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m,cart,h));

			}
		});

		bottomSet.add(mainBtn);

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
				mainFrame.getInstance(new Kinds(m, cart, h));
				
			}
		});
		
		
		ImageIcon icon = new ImageIcon("cartimg4.png");

		Image image = icon.getImage();
		Image newImg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);

		JButton cartImgBtn = new JButton(newIcon);
		cartImgBtn.setBackground(new Color(219,206,190));
		cartImgBtn.setBorderPainted(false);
		cartImgBtn.setBounds(520, 17, 40, 40);

		topLogo.add(cartImgBtn);
		
		cartImgBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new CartPanel(m,cart,h));
				
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
				Kinds.searchItem.clear();
				String itemName = JOptionPane.showInputDialog("찾으실 상품을 입력하시오");
				int c = 0;
				if (!(itemName == null)) {
					if (!itemName.equals("")) {

						for (int i = 0; i < ItemDAO.itemList.size(); i++) {
							
							if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
								Kinds.searchItem.add(ItemDAO.itemList.get(i));
								mainFrame.getInstance(new FindInfo(m, cart, h, Kinds.searchItem));
								c++;
							}
							
						}
						if(c ==0) {
							JOptionPane.showMessageDialog(null, "상품이 존재하지 않습니다.");
						}
						
					}
				}

			}
		});

		topLogo.add(searchBtn);
		
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
				mainFrame.getInstance(new MyPage(m,cart,h));
				
			}
		});
		
		topLogo.add(myPageImgBtn);
		

	}

}
