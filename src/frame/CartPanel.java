package frame;

import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class CartPanel extends JPanel {

	ArrayList<JCheckBox> box = new ArrayList<>();
	int panelCount = 0;
	JPanel cartViewPanel;
	ArrayList<JPanel> pgNum = new ArrayList<>();
	JPanel pa;

	int partMoney = 0;
	int payMoney = 0;
	// int pageBtn = 0;
	int count = 0;
	int sel;
	static int bb = 0;
	JCheckBox select;
	MyInfo m;

	CustomFont baemin = new CustomFont();
	Font font = baemin.getCreateFont2();

	public CartPanel() {
	}

	public CartPanel(MyInfo m, CartDAO cart, SellDAO history) {

		this.m = m;

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

		for (int i = 0; i < CartDAO.cartMap.get(m.getId()).size(); i++) {

			itemImg.add(new ImageIcon(CartDAO.cartMap.get(m.getId()).get(i).getItemUrl()));

		}

		if ((CartDAO.cartMap.get(m.getId()).size() > 0)) {

			panelCount = (int) Math
					.ceil(Double.parseDouble(String.valueOf(CartDAO.cartMap.get(m.getId()).size())) / 4.0);

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
						mainFrame.getInstance(new Kinds(m, cart, history));
						
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
										mainFrame.getInstance(new FindInfo(m, cart, history, Kinds.searchItem));
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

					for (int i = (Integer.parseInt(pageBtn.getText()) - 1) * 4; i < (CartDAO.cartMap.get(m.getId())
							.size()); i++) {

						Image image = itemImg.get(i).getImage();
						Image newImg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
						// 이미지
						ImageIcon newIcon = new ImageIcon(newImg);
						JLabel img = new JLabel(newIcon);
						img.setBounds(50, 90 + ((i % 4) * 110), 200, 100);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(img);

						box.add(new JCheckBox());
						box.get(i).setBounds(16, 127 + ((i % 4) * 110), 20, 20);
						box.get(i).setBackground(Color.WHITE);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(box.get(i));

						box.get(i).addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									sel = 1;
								} else {
									sel = -1;
								}
								for (int k = 0; k < box.size(); k++) {
									if (e.getItem() == box.get(k)) {
										partMoney += sel * CartDAO.cartMap.get(m.getId()).get(k).getCnt()
												* CartDAO.cartMap.get(m.getId()).get(k).getPrice();
									}
								}
							}
						});

						JLabel nameInfo = new JLabel("상품명 : " + CartDAO.cartMap.get(m.getId()).get(i).getName()); // 상품명
						JLabel itemInfo = new JLabel("상품 가격 : " + CartDAO.cartMap.get(m.getId()).get(i).getPrice()
								* CartDAO.cartMap.get(m.getId()).get(i).getCnt());
						JLabel cntInfo = new JLabel("수량 ");

						JTextField cntText = new JTextField();
						JLabel sizeInfo = new JLabel("사이즈");
						Choice size = new Choice();

						nameInfo.setBounds(300, 90 + ((i % 4) * 110), 200, 15);
						itemInfo.setBounds(300, 115 + ((i % 4) * 110), 200, 15);
						cntInfo.setBounds(300, 140 + ((i % 4) * 110), 100, 15);
						cntText.setBounds(350, 135 + ((i % 4) * 110), 60, 20);
						sizeInfo.setBounds(300, 165 + ((i % 4) * 110), 40, 15);
						size.setBounds(350, 161 + ((i % 4) * 110), 70, 20);

						itemInfo.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());

						cntText.setText(Integer.toString(CartDAO.cartMap.get(m.getId()).get(i).getCnt()));

						if (CartDAO.cartMap.get(m.getId()).get(i).getKind().equals("상의")) {
							size.add(CartDAO.cartMap.get(m.getId()).get(i).getSize());
							size.add("size");
							size.add("S");
							size.add("M");
							size.add("L");
						} else if (CartDAO.cartMap.get(m.getId()).get(i).getKind().equals("하의")) {
							size.add(CartDAO.cartMap.get(m.getId()).get(i).getSize());
							size.add("size");
							size.add("28");
							size.add("30");
							size.add("32");
							size.add("34");
						} else if (CartDAO.cartMap.get(m.getId()).get(i).getKind().equals("신발")) {
							size.add(CartDAO.cartMap.get(m.getId()).get(i).getSize());
							size.add("size");
							size.add("240");
							size.add("250");
							size.add("260");
							size.add("270");
							size.add("280");
						}

						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(nameInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(itemInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntText);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(sizeInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(size);

						RoundedButton removeBtn = new RoundedButton("삭제");

						removeBtn.setBounds(500, 102 + ((i % 4) * 115), 65, 50);
						removeBtn.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(removeBtn);

						removeBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int id = Integer.parseInt(String.valueOf((removeBtn.getClientProperty("id"))));
								if (cart.remove(id, m.getId())) {
									mainFrame.getInstance(new CartPanel(m, cart, history));
								}
							}
						});

						RoundedButton editBtn = new RoundedButton("변경");
						editBtn.setBackground(new Color(245,245,245));

						editBtn.setBounds(430, 102 + ((i % 4) * 115), 65, 50);
						editBtn.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(editBtn);

						editBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								int id = Integer.parseInt(String.valueOf((editBtn.getClientProperty("id"))));
								if (cart.change(id, Integer.parseInt(cntText.getText()), m.getId(),
										size.getSelectedItem())) {
									mainFrame.getInstance(new CartPanel(m, cart, history));
								}
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

						box.add(new JCheckBox());
						box.get(i).setBounds(16, 127 + ((i % 4) * 110), 20, 20);
						box.get(i).setBackground(Color.WHITE);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(box.get(i));

						box.get(i).addItemListener(new ItemListener() {

							@Override
							public void itemStateChanged(ItemEvent e) {
								if (e.getStateChange() == ItemEvent.SELECTED) {
									sel = 1;
								} else {
									sel = -1;
								}
								for (int k = 0; k < box.size(); k++) {
									if (e.getItem() == box.get(k)) {
										partMoney += sel * CartDAO.cartMap.get(m.getId()).get(k).getCnt()
												* CartDAO.cartMap.get(m.getId()).get(k).getPrice();
									}
								}
							}
						});

						JLabel nameInfo = new JLabel("상품명 : " + CartDAO.cartMap.get(m.getId()).get(i).getName()); // 상품명
						JLabel itemInfo = new JLabel("상품 가격 : " + CartDAO.cartMap.get(m.getId()).get(i).getPrice()
								* CartDAO.cartMap.get(m.getId()).get(i).getCnt());
						JLabel cntInfo = new JLabel("수량 ");

						JTextField cntText = new JTextField();
						JLabel sizeInfo = new JLabel("사이즈");
						Choice size = new Choice();

						nameInfo.setBounds(300, 90 + ((i % 4) * 110), 200, 15);
						itemInfo.setBounds(300, 115 + ((i % 4) * 110), 200, 15);
						cntInfo.setBounds(300, 140 + ((i % 4) * 110), 100, 15);
						cntText.setBounds(350, 135 + ((i % 4) * 110), 60, 20);
						sizeInfo.setBounds(300, 165 + ((i % 4) * 110), 40, 15);
						size.setBounds(350, 161 + ((i % 4) * 110), 70, 20);

						itemInfo.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());

						cntText.setText(Integer.toString(CartDAO.cartMap.get(m.getId()).get(i).getCnt()));

						if (CartDAO.cartMap.get(m.getId()).get(i).getKind().equals("상의")) {
							size.add(CartDAO.cartMap.get(m.getId()).get(i).getSize());

							size.add("S");
							size.add("M");
							size.add("L");
						} else if (CartDAO.cartMap.get(m.getId()).get(i).getKind().equals("하의")) {
							size.add(CartDAO.cartMap.get(m.getId()).get(i).getSize());

							size.add("28");
							size.add("30");
							size.add("32");
							size.add("34");
						} else if (CartDAO.cartMap.get(m.getId()).get(i).getKind().equals("신발")) {
							size.add(CartDAO.cartMap.get(m.getId()).get(i).getSize());

							size.add("240");
							size.add("250");
							size.add("260");
							size.add("270");
							size.add("280");
						}

						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(nameInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(itemInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntText);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(sizeInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(size);

						RoundedButton removeBtn = new RoundedButton("삭제");

						removeBtn.setBounds(500, 102 + ((i % 4) * 115), 65, 50);
						removeBtn.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(removeBtn);

						removeBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								int id = Integer.parseInt(String.valueOf((removeBtn.getClientProperty("id"))));
								if (cart.remove(id, m.getId())) {
									mainFrame.getInstance(new CartPanel(m, cart, history));
								}
							}
						});

						RoundedButton editBtn = new RoundedButton("변경");
						editBtn.setBackground(new Color(245,245,245));
						editBtn.setBounds(430, 102 + ((i % 4) * 115), 65, 50);
						editBtn.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(editBtn);

						editBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								int id = Integer.parseInt(String.valueOf((editBtn.getClientProperty("id"))));
								if (cart.change(id, Integer.parseInt(cntText.getText()), m.getId(),
										size.getSelectedItem())) {
									mainFrame.getInstance(new CartPanel(m, cart, history));
								}
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
		payMoney = cart.totalMoney(m.getId());

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 2, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(219,206,190));
		//backBtn.setForeground(new Color(255, 255, 255));
		backBtn.setFont(font);
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m, cart, history));
			}
		});

		RoundedButton payBtn = new RoundedButton("PAY");
		payBtn.setFont(font);
		payBtn.setBackground(new Color(219,206,190));
		payBtn.setFont(font);
		//payBtn.setForeground(new Color(255, 255, 255));

		payBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String grade = m.gradeCheck(m.getTotal());

				if (payMoney == 0) {
					JOptionPane.showMessageDialog(null, "구매할 수 있는 상품이 없습니다.");
				} else {
					int result = JOptionPane.showConfirmDialog(null,
							"총 " + m.salePrice(grade, payMoney) + "원을 결제 하시겠습니까?", "Confirm",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					} else if (result == JOptionPane.YES_OPTION) {
						// 나중에 로그인 유저 결제금액 올려주는 method 추가
						JOptionPane.showMessageDialog(null, m.salePrice(grade, payMoney) + "원을 결제하셨습니다.");

						for (int i = 0; i < CartDAO.cartMap.get(m.getId()).size(); i++) {

							SellDAO.historyMap.get(m.getId()).add(CartDAO.cartMap.get(m.getId()).get(i));

							// System.out.println(SellDAO.historyMap.get(m.getId()).get(i).getItemUrl());
						}

						CartDAO.cartMap.get(m.getId()).clear();
						mainFrame.getInstance(new CartPanel(m, cart, history));

						m.setTotal(m.salePrice(grade, m.salePrice(grade, payMoney)));

					} else {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					}

				}

			}
		});

		RoundedButton partPayBtn = new RoundedButton("PARTIAL PAY");
		partPayBtn.setFont(font);
		partPayBtn.setBackground(new Color(219,206,190));
		partPayBtn.setFont(font);
		//partPayBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(partPayBtn);
		bottomSet.add(payBtn);

		partPayBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String grade = m.gradeCheck(m.getTotal());
				boolean flag = true;

				if (partMoney == 0) {
					flag = false;
					if (itemImg.size() == 0) {
						JOptionPane.showMessageDialog(null, "상품이 존재하지 않습니다.");
					}

				} else {
					flag = true;
				}

				if (flag) {
					int result = JOptionPane.showConfirmDialog(null,
							"총 " + m.salePrice(grade, partMoney) + "원을 결제 하시겠습니까?", "Confirm",
							JOptionPane.YES_NO_CANCEL_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					} else if (result == JOptionPane.YES_OPTION) {
						// 나중에 로그인 유저 결제금액 올려주는 method 추가
						JOptionPane.showMessageDialog(null, m.salePrice(grade, partMoney) + "원을 결제하셨습니다.");

						for (int i = CartDAO.cartMap.get(m.getId()).size() - 1; i >= 0; i--) {

							if (box.get(i).isSelected()) {
								SellDAO.historyMap.get(m.getId()).add(CartDAO.cartMap.get(m.getId()).get(i));
								CartDAO.cartMap.get(m.getId()).remove(i);
							}
						}

						mainFrame.getInstance(new CartPanel(m, cart, history));

						m.setTotal(m.salePrice(grade, m.salePrice(grade, partMoney)));

					} else {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					}

				} else {

					boolean check = true;
					for (int i = 0; i < CartDAO.cartMap.get(m.getId()).size(); i++) {
						if (box.get(i).isSelected()) {
							check = true;
						} else {
							check = false;
						}
					}
					if (!check) {
						JOptionPane.showMessageDialog(null, "선택한 상품이 없습니다.");
					}
				}
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
				int c = 0;
				if (!(itemName == null)) {
					if (!itemName.equals("")) {

						for (int i = 0; i < ItemDAO.itemList.size(); i++) {
							
							if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
								Kinds.searchItem.add(ItemDAO.itemList.get(i));
								mainFrame.getInstance(new FindInfo(m, cart, history, Kinds.searchItem));
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
		//pgNum.get(i).add(topLogo);

	}

}
