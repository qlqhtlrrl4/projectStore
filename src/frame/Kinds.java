package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import customDAO.ItemDAO;
import customDAO.Items;
import customDAO.MyInfo;


public class Kinds extends JPanel {
	
	public Kinds() {}
	
	public Kinds(MyInfo m) {
		
		setBackground(new Color(0xFFD700));
		setLayout(null);
		setSize(600, 2000);
		
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(0, 720, 600, 50);
		bottomSet.setLayout(new GridLayout(1,3));
		bottomSet.setBackground(new Color(0xFFD700));

		JButton topBtn = new JButton("상의");

		topBtn.setBackground(new Color(0xA6A6A6));
		topBtn.setSize(183, 87);
		//kindsBtn.setLocation(5, 0);
		topBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(topBtn);
		
		JButton bottomBtn = new JButton("하의");

		bottomBtn.setBackground(new Color(0xA6A6A6));
		bottomBtn.setSize(183, 87);
		//btnNext.setLocation(391, 0);
		bottomBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(bottomBtn);
		
		JButton shoesBtn = new JButton("신발");

		shoesBtn.setBackground(new Color(0xA6A6A6));
		shoesBtn.setSize(183, 87);
		//btnNext.setLocation(391, 0);
		shoesBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(shoesBtn);
		
		JButton backBtn = new JButton("이전 페이지");

		backBtn.setBackground(new Color(0xA6A6A6));
		backBtn.setSize(183, 87);
		//btnNext.setLocation(391, 0);
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(backBtn);
		
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.getInstance(new ShopPanel(m));
			}
		});

		ImageIcon item1 = new ImageIcon("라라랜드.png");
		JButton itemBtn1 = new JButton(item1);
		itemBtn1.setName("a");

		itemBtn1.setSize(185,250);
		itemBtn1.setLocation(72,30);
		add(itemBtn1);

		itemBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Items item1= new ItemDAO().searchItem("a");
				mainFrame.getInstance(new ItemInfoPanel(item1,m));
			}
		});

		//영화2의 정보
		ImageIcon item2 = new ImageIcon("말할수없는비밀.jpg");
		JButton itemBtn2 = new JButton(item2);
		itemBtn2.setName("말할수없는비밀");

		itemBtn2.setSize(185,250);
		itemBtn2.setLocation(320,30);
		add(itemBtn2);

		itemBtn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item2= new ItemDAO().searchItem("b");
				mainFrame.getInstance(new ItemInfoPanel(item2,m));
			}
		});

		//영화3의 정보
		ImageIcon item3 = new ImageIcon("인사이드아웃.png");
		JButton itemBtn3 = new JButton(item3);
		itemBtn3.setName("인사이드아웃");

		itemBtn3.setSize(185,250);
		itemBtn3.setLocation(72,340);
		add(itemBtn3);

		itemBtn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item3= new ItemDAO().searchItem("c");
				mainFrame.getInstance(new ItemInfoPanel(item3,m));
			}
		});

		//영화4의 정보
		ImageIcon item4 = new ImageIcon("겨울왕국.png");
		JButton itemBtn4 = new JButton(item4);
		itemBtn4.setName("겨울왕국");

		itemBtn4.setSize(185,250);
		itemBtn4.setLocation(320,340);
		add(itemBtn4);

		itemBtn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Items item4= new ItemDAO().searchItem("d");
				mainFrame.getInstance(new ItemInfoPanel(item4,m));			}
		});
		
		add(bottomSet);
	}

}
