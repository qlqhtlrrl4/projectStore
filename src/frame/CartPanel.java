package frame;

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
import customDAO.MyInfo;
import customDAO.SellDAO;
import view.CustomFont;
import view.RoundedButton;

public class CartPanel extends JPanel {

	ArrayList<Integer> co = new ArrayList<>();
	ArrayList<JCheckBox> box = new ArrayList<>();
	int panelCount = 0;
	JPanel cartViewPanel;
	JPanel pa;
	// JPanel mainPanel;
	int partMoney = 0;
	int payMoney = 0;
	int page = 0;
	int count = 0;
	int sel;
	static int bb = 0;
	JCheckBox select;
	MyInfo m;

	public CartPanel() {
	}

	public CartPanel(MyInfo m, CartDAO cart, SellDAO history) {

		this.m = m;

		CustomFont font = new CustomFont();

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		box = new ArrayList<>();
		ArrayList<JPanel> view = new ArrayList<>();
		ArrayList<ImageIcon> itemImg = new ArrayList<>();

		if ((CartDAO.cartMap.get(m.getId()).size() > 0)) {
			System.out.println(CartDAO.cartMap.size());
			panelCount = CartDAO.cartMap.get(m.getId()).size() / 4;
			System.out.println(panelCount);
			
			for (int i = 0; i <= panelCount; i++) {
				view.add(new JPanel());
				view.get(i).setBounds(0, 0, 600, 550);
				view.get(i).setBackground(Color.MAGENTA);
				view.get(i).setLayout(null);
				System.out.println(i);
			}
		}

		// 버튼 넣을곳
		pa = new JPanel();
		pa.setBounds(0, 570, 600, 40);
		pa.setBackground(Color.gray);
		pa.setLayout(new FlowLayout());

		itemImg.clear();

		for (int i = 0; i < CartDAO.cartMap.get(m.getId()).size(); i++) {

			itemImg.add(new ImageIcon(CartDAO.cartMap.get(m.getId()).get(i).getItemUrl()));
			System.out.println(CartDAO.cartMap.get(m.getId()).get(i).getItemUrl());
		}

		int aa = 0;

		for (int j = 0; j < view.size(); j++) {

			for (int i = 0; i < CartDAO.cartMap.get(m.getId()).size(); i++) {
				if (i == 0) {
					RoundedButton pageNum = new RoundedButton(String.valueOf(aa));
					pa.add(pageNum);
				}
				if (i != 0 && i % 4 == 0) {
					RoundedButton pageNum = new RoundedButton(String.valueOf(++aa));
					pageNum.setSize(30, 50);
					pa.add(pageNum);
					pageNum.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
						}
					});
				}
				
				if(i!=0 && i%5 == 0) {
					
				}

				if (i >= 0 && i <= 4) {
					add(view.get(j));
					Image image = itemImg.get(i).getImage();
					Image newImg = image.getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
					// 이미지
					ImageIcon newIcon = new ImageIcon(newImg);
					JLabel img = new JLabel(newIcon);
					img.setBounds(50, 13 + (i * 110), 200, 100);
					view.get(j).add(img);

					box.add(new JCheckBox());
					box.get(i).setBounds(16, 50 + (i * 110), 20, 20);
					box.get(i).setBackground(Color.WHITE);
					view.get(j).add(box.get(i));
					// box.get(i).putClientProperty("id",
					// CartDAO.cartMap.get(m.getId()).get(i).getId());
					box.get(i).addItemListener(new ItemListener() {

						@Override
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								sel = 1;
							} else {
								sel = -1;
							}
							for (int i = 0; i < box.size(); i++) {
								if (e.getItem() == box.get(i)) {
									partMoney += sel * CartDAO.cartMap.get(m.getId()).get(i).getCnt()
											* CartDAO.cartMap.get(m.getId()).get(i).getPrice();
								}
							}
						}
					});

					JLabel nameInfo = new JLabel("상품명 : " + CartDAO.cartMap.get(m.getId()).get(i).getName()); // 상품명
					JLabel itemInfo = new JLabel("상품 가격 : " + CartDAO.cartMap.get(m.getId()).get(i).getPrice()
							* CartDAO.cartMap.get(m.getId()).get(i).getCnt());
					JLabel cntInfo = new JLabel("수량 ");

					JTextField cntText = new JTextField();

					nameInfo.setBounds(300, 13 + (i * 110), 100, 50);
					itemInfo.setBounds(300, 13 + (i * 110), 200, 100);
					cntInfo.setBounds(300, 13 + (i * 110), 100, 150);
					cntText.setBounds(350, cntInfo.getY() + 65, 40, 20);

					itemInfo.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());

					cntText.setText(Integer.toString(CartDAO.cartMap.get(m.getId()).get(i).getCnt()));

					view.get(j).add(nameInfo);
					view.get(j).add(itemInfo);
					view.get(j).add(cntInfo);
					view.get(j).add(cntText);

					RoundedButton removeBtn = new RoundedButton("삭제");
					removeBtn.setBounds(500, 25 + (i * 115), 65, 50);
					removeBtn.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());
					view.get(j).add(removeBtn);

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
					editBtn.setBounds(430, 25 + (i * 115), 65, 50);
					editBtn.putClientProperty("id", CartDAO.cartMap.get(m.getId()).get(i).getId());
					view.get(j).add(editBtn);

					editBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							int id = Integer.parseInt(String.valueOf((editBtn.getClientProperty("id"))));
							if (cart.change(id, Integer.parseInt(cntText.getText()), m.getId())) {
								mainFrame.getInstance(new CartPanel(m, cart, history));
							}
						}
					});

				}
			}

		}

		add(pa);
		// 총 결제 금액
		payMoney = cart.totalMoney(m.getId());

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 2, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("뒤로가기");

		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setForeground(new Color(255, 255, 255));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShopPanel(m));
			}
		});

		RoundedButton payBtn = new RoundedButton("결제하기");
		payBtn.setBackground(new Color(32, 32, 32));
		payBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		payBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(payBtn);

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

							System.out.println(SellDAO.historyMap.get(m.getId()).get(i).getItemUrl());
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

		RoundedButton partPayBtn = new RoundedButton("부분결제");
		partPayBtn.setBackground(new Color(32, 32, 32));
		partPayBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		partPayBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(partPayBtn);

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

	}

}
