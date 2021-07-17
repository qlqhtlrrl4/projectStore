package frame.Top;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
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

public class TopInfoPanel extends JPanel {

	MyInfo m;
	CartDAO c;
	int payMoney;

	JTextField countField;
	List<ImageIcon> itemImg;
	int itemId;
	String size;

	public TopInfoPanel(Items item, MyInfo m, CartDAO c, SellDAO history) {
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
		}

		// 이미지를 JLabel에 붙여서 출력
		JLabel img = new JLabel(itemImg.get(itemId));
		img.setBounds(50, 13, 285, 350);
		add(img);

		// 하단의 버튼
		JPanel oSet = new JPanel();

		// 사이즈 가이드
		JButton opBtn = new JButton("VIEW SIZE GUIDE");
		opBtn.setBackground(new Color(255, 255, 255));
		opBtn.setSize(150, 30);
		opBtn.setLocation(370, 250);
		opBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 13));
		oSet.add(opBtn);
		add(oSet);

		opBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame("SIZE GUIDE");
				f.setLayout(null);
				f.setBounds(370, 230, 875, 280);
				// 이미지
				ImageIcon img = new ImageIcon("사이즈가이드.jpg");
				JLabel jI = new JLabel(img);
				jI.setBounds(0, 0, 861, 241);
				f.add(jI);
				f.setVisible(true);

				// 이미지 닫을 때 현재의 창만 닫히게 하기
				f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
			}
		});

		add(opBtn);

		JPanel p = new JPanel();
		p.setBounds(335, 300, 160, 80);
		//p.setBackground(new Color(232, 232, 232));

		Choice day = new Choice();
		day.add(" Select size ");
		day.add("S");
		day.add("M");
		day.add("L");

		p.add(day);
		p.setVisible(true);
		add(p);

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,3,5,0));
		bottomSet.setBackground(Color.WHITE); 

		RoundedButton backBtn = new RoundedButton("BACK");
		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new TopPanel(m, c, history));
			}
		});

		RoundedButton sellBtn = new RoundedButton("BUY NOW");

		sellBtn.setBackground(new Color(32, 32, 32));
		sellBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		sellBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(sellBtn);

		sellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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
						System.out.println(day.getSelectedItem());

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
		cartBnt.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		cartBnt.setForeground(new Color(255, 255, 255));

		cartBnt.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		cartBnt.setForeground(new Color(255, 255, 255));
		bottomSet.add(cartBnt);

		add(bottomSet);

		JLabel countLabel = new JLabel("수량");
		countLabel.setSize(80, 20);
		countLabel.setLocation(350, 30);
		add(countLabel);

		countField = new JTextField(20);
		countField.setSize(80, 20);
		countField.setLocation(400, 30);
		add(countField);

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
			}
		});
		add(bottomSet);

	}
}