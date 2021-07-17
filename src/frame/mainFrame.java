package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame {

	private static mainFrame instance = new mainFrame();
	private static Font  customFont;
	public mainFrame() {

		setTitle("Store");
		setSize(600, 800);

		setBackground(Color.BLUE);

		setVisible(true);

		setLocationRelativeTo(null); // 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void getInstance(JPanel panel) {
		
		
		instance.getContentPane().removeAll();
		instance.getContentPane().add(panel);
		//instance.add(panel);

		instance.revalidate(); // 레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
		instance.repaint(); // 레이아웃을 새로 그린다
	}// getInstance()
	
}
