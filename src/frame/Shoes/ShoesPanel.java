package frame.Shoes;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customDAO.CartDAO;
import customDAO.MyInfo;
import customDAO.SellDAO;
import frame.Kinds;
import frame.mainFrame;
import view.CustomFont;
import view.RoundedButton;

public class ShoesPanel extends JPanel {
	CartDAO cart;

	public ShoesPanel() {
	}

	public ShoesPanel(MyInfo m, CartDAO cart, SellDAO history) {

		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();

		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(5, 660, 570, 75);
		bottomSet.setLayout(new GridLayout(1, 3, 5, 0));
		bottomSet.setBackground(Color.WHITE);

		/*ImageIcon item1 = new ImageIcon("구두5.png");
		Image ximg = item1.getImage();
		Image yimg = ximg.getScaledInstance(183, 183, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg = new ImageIcon(yimg);
		JLabel j1 = new JLabel(newimg);
		j1.setBounds(50, 50, 183, 183);
		add(j1);*/

		RoundedButton MensShoesBtn = new RoundedButton("SHOES");
		MensShoesBtn.setBackground(Color.WHITE);
		MensShoesBtn.setSize(200, 70);
		MensShoesBtn.setLocation(190, 120);
		//TBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		MensShoesBtn.setFont(font);

		add(MensShoesBtn);

		/*ImageIcon item2 = new ImageIcon("슬리퍼5.jpg");
		Image ximg2 = item2.getImage();
		Image yimg2 = ximg2.getScaledInstance(183, 183, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg2 = new ImageIcon(yimg2);
		JLabel j2 = new JLabel(newimg2);
		j2.setBounds(350, 50, 183, 183);
		add(j2);*/

		RoundedButton SlipperBtn = new RoundedButton("SLIPPER");

		SlipperBtn.setBackground(Color.WHITE);
		SlipperBtn.setSize(200, 70);
		SlipperBtn.setLocation(190, 240);
		//TBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		SlipperBtn.setFont(font);
		add(SlipperBtn);

		/*ImageIcon item3 = new ImageIcon("운동화.jpg");
		Image ximg3 = item3.getImage();
		Image yimg3 = ximg3.getScaledInstance(183, 183, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg3 = new ImageIcon(yimg3);
		JLabel j3 = new JLabel(newimg3);
		j3.setBounds(50, 350, 183, 183);
		add(j3);*/

		RoundedButton rnBtn = new RoundedButton("SPORTS SHOES");
		rnBtn.setBackground(Color.WHITE);
		rnBtn.setSize(200, 70);
		rnBtn.setLocation(190, 360);
		//TBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		rnBtn.setFont(font);
		add(rnBtn);

		/*ImageIcon item4 = new ImageIcon("샌들.jpg");
		Image ximg4 = item4.getImage();
		Image yimg4 = ximg4.getScaledInstance(183, 183, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newimg4 = new ImageIcon(yimg4);
		JLabel j4 = new JLabel(newimg4);
		j4.setBounds(350, 350, 183, 183);
		add(j4);*/

		RoundedButton sandleBtn = new RoundedButton("SANDAL");

		sandleBtn.setBackground(Color.WHITE);
		sandleBtn.setSize(200, 70);
		sandleBtn.setLocation(190, 480);
		//BlouseBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		sandleBtn.setFont(font);
		add(sandleBtn);

		// 이전페이지
		RoundedButton backBtn = new RoundedButton("BACK");

		backBtn.setBackground(new Color(32, 32, 32));
		//backBtn.setFont(new Font("나눔고딕코딩", Font.BOLD, 18));
		backBtn.setFont(font);
		backBtn.setForeground(new Color(255, 255, 255));
		bottomSet.add(backBtn);

		add(bottomSet);

		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getInstance(new Kinds(m, cart, history));
			}
		});

		// 구두페이지로 이동
		MensShoesBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new MensShoesPanel(m, cart, history));

			}
		});

		// 슬리퍼 페이지로 이동
		SlipperBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new SlipperPanel(m, cart, history));

			}
		});

		rnBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new rnShoesPanel(m, cart, history));

			}
		});
		
		sandleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new SandlePanel(m, cart, history));

			}
		});

	}

}
