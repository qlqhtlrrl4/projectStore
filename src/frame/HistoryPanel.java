package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import customDAO.MyInfo;
import customDAO.SellDAO;
import view.CustomFont;
import view.RoundedButton;

public class HistoryPanel extends JPanel {

	int payMoney = 0;
	int page = 0;
	MyInfo m;

	public HistoryPanel() {
	}

	public HistoryPanel(MyInfo m, SellDAO h) {

		this.m = m;

		CustomFont font = new CustomFont();

		setBackground(new Color(232, 232, 232));
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		ArrayList<ImageIcon> itemImg = new ArrayList<>();

		for (int i = 0; i < SellDAO.historyMap.get(m.getId()).size(); i++) {
			itemImg.add(new ImageIcon(SellDAO.historyMap.get(m.getId()).get(i).getItemUrl()));
		}

		for (int i = 0; i < itemImg.size(); i++) {
			Image image = itemImg.get(i).getImage();
			Image newImg = image.getScaledInstance(200, 100, java.awt.Image.SCALE_SMOOTH);
			// 이미지

			ImageIcon newIcon = new ImageIcon(newImg);
			JLabel img = new JLabel(newIcon);
			img.setBounds(50, 13 + (i * 110), 200, 100);
			add(img);

			JLabel nameInfo = new JLabel("상품명 : " + SellDAO.historyMap.get(m.getId()).get(i).getName()); // 상품명
			JLabel itemInfo = new JLabel("상품 가격 : " + SellDAO.historyMap.get(m.getId()).get(i).getPrice()
					* SellDAO.historyMap.get(m.getId()).get(i).getCnt());
			JLabel cntInfo = new JLabel("수량 ");

			JTextField cntText = new JTextField();

			nameInfo.setBounds(300, 13 + (i * 110), 100, 50);
			itemInfo.setBounds(300, 13 + (i * 110), 200, 100);
			cntInfo.setBounds(300, 13 + (i * 110), 100, 150);
			cntText.setBounds(350, cntInfo.getY() + 65, 40, 20);

			itemInfo.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());

			cntText.setText(Integer.toString(SellDAO.historyMap.get(m.getId()).get(i).getCnt()));

			add(nameInfo);
			add(itemInfo);
			add(cntInfo);
			add(cntText);

			RoundedButton removeBtn = new RoundedButton("삭제");
			removeBtn.setBounds(500, 25 + (i * 115), 65, 50);
			removeBtn.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());
			add(removeBtn);

			RoundedButton editBtn = new RoundedButton("변경");
			editBtn.setBounds(430, 25 + (i * 115), 65, 50);
			editBtn.putClientProperty("id", SellDAO.historyMap.get(m.getId()).get(i).getId());
			add(editBtn);

			//System.out.println(SellDAO.historyMap.get(m.getId()).get(i).getItemUrl());

		}

		// 총 결제 금액
		payMoney = h.totalMoney(m.getId());

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,4,5,0));
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
		bottomSet.add(mainBtn);

		add(bottomSet);
	}

}
