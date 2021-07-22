package frame.Bottom;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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

public class BottomPanel extends JPanel {

	public BottomPanel(MyInfo m, CartDAO cart,SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		// 청바지 버튼 설정
		RoundedButton btnJean = new RoundedButton("DENIM");
		btnJean.setBackground(Color.WHITE);
		btnJean.setSize(200, 70);
		btnJean.setLocation(190, 120);
		btnJean.setFont(font);
		add(btnJean);

		btnJean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomJean(m, cart,history));
			} // BottomJean으로 연결
		});

		// 반바지 버튼 설정
		RoundedButton btnShorts = new RoundedButton("SHORTS");
		btnShorts.setBackground(Color.WHITE);
		btnShorts.setSize(200, 70);
		btnShorts.setLocation(190, 240);
		btnShorts.setFont(font);
		add(btnShorts);

		btnShorts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomShorts(m, cart,history));
			}// BottomShorts로 연결
		});
		
		RoundedButton skirtBtn = new RoundedButton("SKIRT");
		skirtBtn.setBackground(Color.WHITE);
		skirtBtn.setSize(200, 70);
		skirtBtn.setLocation(190, 360);
		//BlouseBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		skirtBtn.setFont(font);
		add(skirtBtn);
		
		RoundedButton slacksBtn = new RoundedButton("SLACKS");
		slacksBtn.setBackground(Color.WHITE);
		slacksBtn.setSize(200, 70);
		slacksBtn.setLocation(190, 480);
		//BlouseBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		slacksBtn.setFont(font);
		add(slacksBtn);
		

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,2,5,0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(219,206,190));
		//backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setFont(font);
		//backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new Kinds(m,cart,history));
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

				
				int d = 0;
				if (!(itemName == null)) {
					if (!itemName.equals("")) {

						for (int i = 0; i < ItemDAO.itemList.size(); i++) {
							
							if (ItemDAO.itemList.get(i).getName().toLowerCase().contains(itemName.toLowerCase())) {
								Kinds.searchItem.add(ItemDAO.itemList.get(i));
								mainFrame.getInstance(new FindInfo(m, cart, history, Kinds.searchItem));
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
		
	}
}
