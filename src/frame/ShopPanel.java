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
import view.CustomFont;
import view.RoundedButton;

public class ShopPanel extends JPanel {
	
	
	
	public ShopPanel() {
		
		setBackground(new Color(232, 232, 232));
		setLayout(null);
		setSize(600, 800);
		setBackground(Color.WHITE);
		
		CustomFont baemin = new CustomFont();
		Font font = baemin.getCreateFont2();
		
		JPanel topLogo = new JPanel();
		topLogo.setBounds(0,0,600,70);
		topLogo.setBackground(new Color(219,206,190));
		topLogo.setLayout(null);
		add(topLogo);
		
		JLabel sName = new JLabel("marchen");
		sName.setBounds(0,0,365,70);
		sName.setFont(font.deriveFont(38f));
		sName.setHorizontalAlignment(JLabel.RIGHT);
		topLogo.add(sName);
		
			
		ImageIcon icon5 = new ImageIcon("logo.jpg");
		
		Image image5 = icon5.getImage();
		Image newImg5 = image5.getScaledInstance(200, 180, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon5 = new ImageIcon(newImg5);
		JLabel img5 = new JLabel(newIcon5);
		img5.setBounds(197, 250, 200, 180);
		add(img5);
		
		//topLogo.add(myPageImgBtn);
		
		RoundedButton enterBtn = new RoundedButton("SHOP");

		enterBtn.setBackground(new Color(219,206,190));
		enterBtn.setFont(font);
		enterBtn.setBounds(200, 460, 200, 70);
		
		enterBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.getInstance(new BeginPanel());
				
			}
		});
		
		
		add(enterBtn);

		
		
		
	}

}
