package main;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import frame.BeginPanel;
import frame.mainFrame;

public class StroeMain {

	public static void main(String[] args) {

		mainFrame.getInstance(new BeginPanel());

	}

}
