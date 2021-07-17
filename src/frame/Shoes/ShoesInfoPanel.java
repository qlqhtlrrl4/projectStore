package frame.Shoes;

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
import frame.Kinds;
import frame.mainFrame;
import view.RoundedButton;

public class ShoesInfoPanel extends JPanel {

	int payMoney;

	MyInfo m;
	CartDAO c;
	int itemId;
	JTextField countField;
	List<ImageIcon> itemImg;

	public ShoesInfoPanel(Items item, MyInfo m, CartDAO c, SellDAO history) {
		this.m = m;
		this.c = c;
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

			// itemId =ItemDAO.itemList.get(i).getId();
		}

		Image image = itemImg.get(itemId).getImage();
		Image newImg = image.getScaledInstance(285, 350, java.awt.Image.SCALE_SMOOTH);

		ImageIcon newIcon = new ImageIcon(newImg);
		JLabel img = new JLabel(newIcon);
		img.setBounds(50, 13, 285, 350);
		add(img);

		TextArea info = new TextArea("\n◈ 상품 이름" + "\n" + "   " + item.getName() + "\n" + "\n◈ 상품 가격\n " + "   "
				+ item.getPrice() + "\n" + "\n◈ 상품 정보" + "\n" + "   " + item.getItemInfo(), 0, 0,
				TextArea.SCROLLBARS_VERTICAL_ONLY);
		info.setSize(580, 280);
		info.setLocation(0, 375);
		info.setBackground(new Color(0xFFD700));
		info.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		add(info);
		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("뒤로가기");
		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		// int btnNum = itemId;
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (12 <= item.getId() && item.getId() <= 15) {
					mainFrame.getInstance(new MensShoesPanel(m, c, history));
				} else if (16 <= item.getId() && item.getId() <= 19) {
					mainFrame.getInstance(new SlipperPanel(m, c, history));
				} else if (20 <= item.getId() && item.getId() <= 23) {
					mainFrame.getInstance(new rnShoesPanel(m, c, history));
				} else {
					mainFrame.getInstance(new SandlePanel(m, c, history));
				}
			}
		});
		// add(backBtn);

		JLabel countLabel = new JLabel("수량");
		countLabel.setSize(80, 20);
		countLabel.setLocation(350, 30);
		add(countLabel);

		countField = new JTextField(20);
		countField.setSize(80, 20);
		countField.setLocation(450, 30);
		add(countField);

		JLabel countLabel2 = new JLabel("사이즈");
		countLabel2.setSize(80, 20);
		countLabel2.setLocation(350, 60);
		add(countLabel2);

		Choice size = new Choice();
		size.add("size");
		size.add("240");
		size.add("250");
		size.add("260");
		size.add("270");
		size.add("280");

		size.setSize(125, 0);
		size.setLocation(450, 60);
		add(size);

		RoundedButton sellBtn = new RoundedButton("구매하기");

		sellBtn.setBackground(new Color(32, 32, 32));
		sellBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		sellBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(sellBtn);

		sellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 중복확인 후

				if (!countField.getText().equals("")) {
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
								ItemDAO.itemList.get(itemId).getItemUrl(), Integer.parseInt(countField.getText())));

						// 나중에 로그인 유저 결제금액 올려주는 method 추가
						JOptionPane.showMessageDialog(null, m.salePrice(grade, payMoney) + "원을 결제하셨습니다.");

						m.setTotal(m.salePrice(grade, m.salePrice(grade, payMoney)));
						mainFrame.getInstance(new Kinds(m, c, history));

					} else {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "수량을 적으세요.");
				}
			}
		});

		RoundedButton cartBnt = new RoundedButton("장바구니");

		cartBnt.setBackground(new Color(32, 32, 32));
		cartBnt.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		cartBnt.setForeground(new Color(255, 255, 255));

		bottomSet.add(cartBnt);

		cartBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!countField.getText().equals("")) {
					if (c.registCart(m.getId(),
							new Items(ItemDAO.itemList.get(itemId).getId(), ItemDAO.itemList.get(itemId).getName(),
									ItemDAO.itemList.get(itemId).getPrice(),
									ItemDAO.itemList.get(itemId).getItemUrl(),ItemDAO.itemList.get(itemId).getItemInfo(),ItemDAO.itemList.get(itemId).getKind()))) {

						CartDAO.cartMap.get(m.getId()).add(new Items(ItemDAO.itemList.get(itemId).getId(),
								ItemDAO.itemList.get(itemId).getName(), ItemDAO.itemList.get(itemId).getPrice(),
								ItemDAO.itemList.get(itemId).getItemUrl(), Integer.parseInt(countField.getText())));
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

				System.out.println(CartDAO.cartMap.get(m.getId()).size());
				for (int i = 0; i < CartDAO.cartMap.get(m.getId()).size(); i++) {
					System.out.println(CartDAO.cartMap.get(m.getId()).get(i).getCnt() + "    itemInfoPanel");
				}
				//

			}
		});

		add(bottomSet);

	}

}