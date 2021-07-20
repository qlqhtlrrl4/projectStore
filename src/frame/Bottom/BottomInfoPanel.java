package frame.Bottom;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
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
<<<<<<< HEAD
	
	CustomFont baemin = new CustomFont();
	Font font = baemin.getCreateFont2();

=======
	String str;
	
>>>>>>> 2bffac1cabdccadc0f23c5f78048d1905c537057
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

		JLabel img = new JLabel(itemImg.get(itemId));
		img.setBounds(20, 13, 345, 330);
		add(img);

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("BACK");
		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(font);
		backBtn.setForeground(new Color(255, 255, 255));
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
		countLabel.setSize(40, 20);
		countLabel.setLocation(350, 80);
		add(countLabel);

		countField = new JTextField(20);
		countField.setSize(80, 20);
		countField.setLocation(400, 80);
		add(countField);

		// 사이즈 선택
		JLabel countLabel2 = new JLabel("사이즈");
		countLabel2.setSize(40, 20);
		countLabel2.setLocation(350, 120);
		add(countLabel2);

		Choice size = new Choice();
		
		size.add("size");
		size.add("28");
		size.add("30");
		size.add("32");
		size.add("34");

		size.setSize(80, 0);
		size.setLocation(400, 120);
		add(size);

		TextArea info = new TextArea("\n  ◎브랜드명" + "\n" + "   " + item.getName() + "\n\n" + "  ◎상품가격" + "\n" + "   "
				+ item.getPrice() + "원" + "\n\n  ◎상품설명" + "\n" + "   " + item.getItemInfo(), 0, 0,
				TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		info.setFont(font);
		info.setSize(580, 280);
		info.setLocation(0, 345);
		info.setBackground(new Color(255, 255, 255));
		info.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		add(info);

		RoundedButton sellBtn = new RoundedButton("BUY NOW");

		sellBtn.setBackground(new Color(32, 32, 32));
		sellBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		sellBtn.setForeground(new Color(255, 255, 255));
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
						mainFrame.getInstance(new Kinds(m, c, history));

					} else {
						JOptionPane.showMessageDialog(null, "결제를 취소하셨습니다.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "수량을 적으세요.");
				}
			}
		});

		RoundedButton cartBnt = new RoundedButton("ADD TO CART");

		cartBnt.setBackground(new Color(32, 32, 32));
		cartBnt.setFont(font);
		cartBnt.setForeground(new Color(255, 255, 255));
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

}
