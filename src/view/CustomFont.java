package view;

import java.awt.*;
import java.io.*;

public class CustomFont {

	public CustomFont() {}
	
	public Font getCreateFont() {
		Font customFont = null;
		try {
		    //create the font to use. Specify the size!
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("NanumGothic-Bold.ttf")).deriveFont(20f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
	
		return customFont;
		
		
	}
	
	public Font TitleFont() {
		Font customFont = null;
		try {
		    //create the font to use. Specify the size!
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("NanumGothic-Bold.ttf")).deriveFont(35f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
	
		return customFont;
		
		
	}
	
	
	

}
