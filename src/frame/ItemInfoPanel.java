package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import customDAO.ItemDAO;
import customDAO.Items;
import customDAO.MyInfo;

public class ItemInfoPanel extends JPanel {
	
	int itemFlag = 0;

	public ItemInfoPanel(Items item, MyInfo m) {

		// JPanel 구조
		setBackground(new Color(250, 244, 192));
		setLayout(null);
		setSize(600, 800);

		final int itemNum = 4;
		

		String[] itemUrl = { // 사진 주소
				"라라랜드2.png", "말할수없는비밀2.jpg", "인사이드아웃2.png", "겨울왕국2.png" };

		ImageIcon itemImg[] = new ImageIcon[itemNum];

		for (int i = 0; i < itemNum; i++) {

			itemImg[i] = new ImageIcon(itemUrl[i]);

			if (item.getName().equals("a")) {
				itemFlag = 0;
			} else if (item.getName().equals("b")) {
				itemFlag = 1;
			} else if (item.getName().equals("c")) {
				itemFlag = 2;
			} else if (item.getName().equals("d")) {
				itemFlag = 3;

			}
		}

		// 이미지를 JLabel에 붙여서 출력
		JLabel img = new JLabel(itemImg[itemFlag]);
		img.setBounds(50, 13, 285, 350);
		add(img);
		
		
		//하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(0, 660, 600, 100);
		bottomSet.setLayout(null);
		bottomSet.setBackground(new Color(0xFFD700));

		JButton backBtn = new JButton("뒤로가기");
		backBtn.setBackground(new Color(0xA6A6A6));
		backBtn.setSize(183, 87);
		backBtn.setLocation(5, 0);
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(backBtn);
		

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new Kinds(m));
			}
		});
		//add(backBtn);
		
		
		
		JButton sellBtn = new JButton("구매하기");

		sellBtn.setBackground(new Color(0xA6A6A6));
		sellBtn.setSize(183, 87);
		sellBtn.setLocation(198, 0);
		sellBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(sellBtn);

		sellBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ItemDAO.itemList.get(itemFlag).getPrice()+"원을 결제");
				m.setTotal(ItemDAO.itemList.get(itemFlag).getPrice());
			}
		});
		
		JButton cartBnt = new JButton("장바구니");

		cartBnt.setBackground(new Color(0xA6A6A6));
		cartBnt.setSize(183, 87);
		cartBnt.setLocation(391, 0);
		cartBnt.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(cartBnt);

		cartBnt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "장바구니 담기");
			}
		});

		add(bottomSet);

	}
}
