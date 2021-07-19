package frame;

import java.awt.Choice;
import java.awt.Color;
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

		CustomFont font = new CustomFont();

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		box = new ArrayList<>();

		ArrayList<ImageIcon> itemImg = new ArrayList<>();

		pa = new JPanel();
		pa.setBounds(0, 570, 600, 40);
		pa.setBackground(Color.gray);
		pa.setLayout(new FlowLayout());

		itemImg.clear();

		for (int i = 0; i < SellDAO.historyMap.get(m.getId()).size(); i++) {

			itemImg.add(new ImageIcon(SellDAO.historyMap.get(m.getId()).get(i).getItemUrl()));

		}

		if ((SellDAO.historyMap.get(m.getId()).size() > 0)) {

			panelCount = (int) Math
					.ceil(Double.parseDouble(String.valueOf(SellDAO.historyMap.get(m.getId()).size())) / 5.0);

			for (int i = 0; i < panelCount; i++) {
				pgNum.add(new JPanel());
			}

			pgNum.get(0).setVisible(true);

			for (int j = 0; j < panelCount; j++) {
				JButton pageBtn = new JButton(String.valueOf(j + 1));

				if (Integer.parseInt(pageBtn.getText()) == panelCount) {

					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setBounds(0, 0, 600, 560);
					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setBackground(Color.WHITE);
					pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).setLayout(null);

					for (int i = (Integer.parseInt(pageBtn.getText()) - 1) * 5; i < (SellDAO.historyMap.get(m.getId())
							.size()); i++) {

						Image image = itemImg.get(i).getImage();
						Image newImg = image.getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
						// 이미지
						ImageIcon newIcon = new ImageIcon(newImg);
						JLabel img = new JLabel(newIcon);
						img.setBounds(50, 13 + (((i) % 5) * 110), 200, 100);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(img);

						JLabel nameInfo = new JLabel("상품명 : " + SellDAO.historyMap.get(m.getId()).get(i).getName()); // 상품명
						JLabel itemInfo = new JLabel("상품 가격 : " + SellDAO.historyMap.get(m.getId()).get(i).getPrice());
						JLabel cntInfo = new JLabel("수량 : " + SellDAO.historyMap.get(m.getId()).get(i).getCnt());
						JTextField cntText = new JTextField();
						JLabel sizeInfo = new JLabel("사이즈 : " + SellDAO.historyMap.get(m.getId()).get(i).getSize());

						nameInfo.setBounds(300, 13 + ((i % 5) * 110), 100, 15);
						itemInfo.setBounds(300, 38 + ((i % 5) * 110), 200, 15);
						cntInfo.setBounds(300, 63 + ((i % 5) * 110), 200, 15);
						sizeInfo.setBounds(300, 88 + ((i % 5) * 110), 400, 15);

						itemInfo.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());

						cntText.setText(Integer.toString(SellDAO.historyMap.get(m.getId()).get(i).getCnt()));

						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(nameInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(itemInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntText);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(sizeInfo);


						RoundedButton detailBtn = new RoundedButton("상세보기");
						detailBtn.setBounds(430, 25 + ((i % 5) * 115), 130, 70);
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
								info.setBackground(new Color(0xFFD700));
								info.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
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

					for (int i = (Integer.parseInt(pageBtn.getText()) - 1) * 5; i < Integer.parseInt(pageBtn.getText())
							* 5; i++) {

						Image image = itemImg.get(i).getImage();
						Image newImg = image.getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
						// 이미지
						ImageIcon newIcon = new ImageIcon(newImg);
						JLabel img = new JLabel(newIcon);
						img.setBounds(50, 13 + ((i % 5) * 110), 200, 100);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(img);

						JLabel nameInfo = new JLabel("상품명 : " + SellDAO.historyMap.get(m.getId()).get(i).getName()); // 상품명
						JLabel itemInfo = new JLabel("상품 가격 : " + SellDAO.historyMap.get(m.getId()).get(i).getPrice());
						JLabel cntInfo = new JLabel("수량 " + SellDAO.historyMap.get(m.getId()).get(i).getCnt());
						JTextField cntText = new JTextField();
						JLabel sizeInfo = new JLabel("사이즈" + SellDAO.historyMap.get(m.getId()).get(i).getSize());

						Choice size = new Choice();

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

						nameInfo.setBounds(300, 13 + ((i % 5) * 110), 100, 15);
						itemInfo.setBounds(300, 38 + ((i % 5) * 110), 200, 15);
						cntInfo.setBounds(300, 63 + ((i % 5) * 110), 100, 15);
						cntText.setBounds(350, 58 + ((i % 5) * 110), 60, 20);
						sizeInfo.setBounds(300, 88 + ((i % 5) * 110), 400, 15);
						

						itemInfo.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());

						cntText.setText(Integer.toString(SellDAO.historyMap.get(m.getId()).get(i).getCnt()));

						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(nameInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(itemInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntInfo);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(cntText);
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(sizeInfo);
						
						
						RoundedButton detailBtn = new RoundedButton("변경");
						detailBtn.setBounds(430, 25 + ((i % 5) * 115), 130, 70);
						detailBtn.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());
						pgNum.get(Integer.parseInt(pageBtn.getText()) - 1).add(detailBtn);

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

		RoundedButton backBtn = new RoundedButton("뒤로가기");

		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShopPanel(m));
			}
		});

		RoundedButton mainBtn = new RoundedButton("메인으로");
		mainBtn.setBackground(new Color(32, 32, 32));
		mainBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		mainBtn.setForeground(new Color(255, 255, 255));

		mainBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m,cart,h));

			}
		});

		bottomSet.add(mainBtn);

		add(bottomSet);
	}

}
