package frame.Bottom;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customDAO.CartDAO;
import customDAO.ItemDAO;
import customDAO.Items;
import customDAO.MyInfo;
import customDAO.SellDAO;
import frame.Kinds;
import frame.ShopPanel;
import frame.mainFrame;
import view.RoundedButton;

public class BottomPanel extends JPanel {

	public BottomPanel(MyInfo m, CartDAO cart,SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);

		// 청바지 버튼 위 이미지
		ImageIcon jean = new ImageIcon("청바지.jpg");
		JLabel lb1 = new JLabel(jean);

		add(lb1);
		lb1.setBounds(72, 100, 185, 250);

		// 반바지 버튼 위 이미지
		ImageIcon shorts = new ImageIcon("반바지.jpg");
		JLabel lb2 = new JLabel(shorts);

		add(lb2);
		lb2.setBounds(320, 100, 185, 250);

		// 청바지 버튼 설정
		RoundedButton btnJean = new RoundedButton("청바지");
		btnJean.setBounds(72, 400, 185, 100);
		btnJean.setLayout(null);
		btnJean.setBackground(new Color(0,0,0));
		btnJean.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		btnJean.setForeground(new Color(255, 255, 255));
		add(btnJean);

		btnJean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomJean(m, cart,history));
			} // BottomJean으로 연결
		});

		// 반바지 버튼 설정
		RoundedButton btnShorts = new RoundedButton("반바지");
		btnShorts.setBounds(320, 400, 185, 100);
		btnShorts.setLayout(null);
		btnShorts.setBackground(new Color(0, 0, 0));
		btnShorts.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		btnShorts.setForeground(new Color(255, 255, 255));
		add(btnShorts);

		btnShorts.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BottomShorts(m, cart,history));
			}// BottomShorts로 연결
		});

		// 하단의 버튼
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1,2,5,0));
		bottomSet.setBackground(Color.WHITE);

		RoundedButton backBtn = new RoundedButton("이전 페이지");

		backBtn.setBackground(new Color(32, 32, 32));
		backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new Kinds(m,cart,history));
			}
		});
		
		RoundedButton mainBtn = new RoundedButton("처음으로");

		mainBtn.setBackground(new Color(32, 32, 32));
		mainBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		mainBtn.setForeground(new Color(255, 255, 255));

		bottomSet.add(mainBtn);
		add(bottomSet);
		
		mainBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new ShopPanel(m));
				system.out.println("1");
			}
		});
	}
}
