package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
import frame.Bottom.BottomPanel;
import frame.Shoes.ShoesPanel;
import frame.Top.TopPanel;
import view.CustomFont;
import view.RoundedButton;

public class Kinds extends JPanel {

	public static List<Items> searchItem = new ArrayList<>();

	public Kinds() {
	}

	public Kinds(MyInfo m, CartDAO cart, SellDAO history) {

		setBackground(new Color(232, 232, 232));
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		JLabel shopBtn = new JLabel("CATEGORY");
		shopBtn.setBackground(Color.WHITE);
		shopBtn.setSize(200, 70);
		shopBtn.setLocation(230, 120);
		shopBtn.setFont(font);

		RoundedButton topBtn = new RoundedButton("TOP");

		topBtn.setBackground(Color.WHITE);
		topBtn.setSize(200, 70);
		topBtn.setLocation(190, 280);
		topBtn.setFont(font);

		topBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new TopPanel(m, cart, history));
			}
		});

		RoundedButton bottomBtn = new RoundedButton("BOTTOM");

		bottomBtn.setBackground(Color.WHITE);
		bottomBtn.setSize(200, 70);
		bottomBtn.setLocation(190, 360);
		bottomBtn.setFont(font);

		bottomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomPanel(m, cart, history));
			}
		});

		RoundedButton shoesBtn = new RoundedButton("SHOES");

		shoesBtn.setBackground(Color.WHITE);
		shoesBtn.setSize(200, 70);
		shoesBtn.setLocation(190, 440);

		shoesBtn.setFont(font);

		shoesBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShoesPanel(m, cart, history));
			}
		});

		RoundedButton todayBtn = new RoundedButton("당일발송");

		todayBtn.setBackground(Color.WHITE);
		todayBtn.setSize(200, 70);
		todayBtn.setLocation(190, 200);

		todayBtn.setFont(font);

		RoundedButton accBtn = new RoundedButton("ACC");

		accBtn.setBackground(Color.WHITE);
		accBtn.setSize(200, 70);
		accBtn.setLocation(190, 520);

		accBtn.setFont(font);

		JPanel topLogo = new JPanel();
		topLogo.setBounds(0, 0, 600, 70);
		topLogo.setBackground(new Color(219, 206, 190));
		topLogo.setLayout(null);
		add(topLogo);

		RoundedButton sName = new RoundedButton("marchen");
		sName.setBackground(new Color(219, 206, 190));
		sName.setBorderPainted(false);
		sName.setBounds(204, 0, 180, 70);
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
		cartImgBtn.setBackground(new Color(219, 206, 190));
		cartImgBtn.setBorderPainted(false);
		cartImgBtn.setBounds(520, 17, 40, 40);

		topLogo.add(cartImgBtn);

		cartImgBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new CartPanel(m, cart, history));

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

				String itemName = JOptionPane.showInputDialog("찾으실 상품을 입력하시오");
				Kinds.searchItem.clear();
				boolean flag = true;
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

		ImageIcon icon2 = new ImageIcon("mypageIcon2.png");
		Image image2 = icon2.getImage();
		Image newImg2 = image2.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		ImageIcon myIcon = new ImageIcon(newImg2);

		JButton myPageImgBtn = new JButton(myIcon);
		myPageImgBtn.setBackground(new Color(219, 206, 190));
		myPageImgBtn.setBorderPainted(false);
		myPageImgBtn.setBounds(485, 22, 30, 30);

		myPageImgBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MyPage(m, cart, history));

			}
		});

		topLogo.add(myPageImgBtn);
		add(shopBtn);
		add(todayBtn);
		add(topBtn);
		add(bottomBtn);
		add(shoesBtn);
		add(accBtn);

	}

}
