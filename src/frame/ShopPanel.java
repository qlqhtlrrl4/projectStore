package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import customDAO.MyInfo;

public class ShopPanel extends JPanel {

	public ShopPanel() {
		
	}
	
	// JPanel 구조
	public ShopPanel(MyInfo m) {
		
		setBackground(new Color(0xFFD700));
		setLayout(null);
		setSize(600, 2000);
		
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(0, 720, 600, 50);
		bottomSet.setLayout(new GridLayout(1,3));
		bottomSet.setBackground(new Color(0xFFD700));

		JButton kindsBtn = new JButton("종류");

		kindsBtn.setBackground(new Color(0xA6A6A6));
		kindsBtn.setSize(183, 87);
		//kindsBtn.setLocation(5, 0);
		kindsBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(kindsBtn);
		
		JButton cartBtn = new JButton("장바구니");

		cartBtn.setBackground(new Color(0xA6A6A6));
		cartBtn.setSize(183, 87);
		//btnNext.setLocation(391, 0);
		cartBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(cartBtn);
		
		JButton myInfoBtn = new JButton("My Page");

		myInfoBtn.setBackground(new Color(0xA6A6A6));
		myInfoBtn.setSize(183, 87);
		//btnNext.setLocation(391, 0);
		myInfoBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(myInfoBtn);

		add(bottomSet);
		
		kindsBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.getInstance(new Kinds(m));
				
			}
		});
		
		myInfoBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				mainFrame.getInstance(new MyPage(m));
				//System.out.println(m.getName());
			}
		});
		
	}

}
