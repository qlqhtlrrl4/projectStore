package frame;

import java.awt.*;
import javax.swing.*;

public class mainFrame extends JFrame {

	private static mainFrame instance = new mainFrame();

	public mainFrame() {

		/*
		 * Toolkit tk = Toolkit.getDefaultToolkit();// 해상도 setBounds(((int)
		 * tk.getScreenSize().getWidth()) / 2 - 300, ((int)
		 * tk.getScreenSize().getHeight()) / 2 - 400, 600, 800);
		 */

		setTitle("Store");
		setSize(600, 800);

		setBackground(Color.BLUE);

		setVisible(true);

		setLocationRelativeTo(null); // 가운데 정렬
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void getInstance(JPanel e) {

		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);
		//instance.add(e);

		instance.revalidate(); // 레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
		instance.repaint(); // 레이아웃을 새로 그린다
	}// getInstance()

}
