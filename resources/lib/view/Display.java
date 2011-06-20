package resources.lib.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class Display {
	public static void preparePanel(Container pane, Stack<Component> reverselist) {
		int listsize = reverselist.size();
		for(int i = 0; i < listsize; i++) {
			pane.add(reverselist.pop());
		}
	}
	
	public static ImageIcon pathToImageIcon(String path) {
		URL resource = Display.class.getResource(path);
		if(resource != null) {
			return new ImageIcon(resource);
		} else {
			System.err.println("Arquivo de imagem não encontrado: " + path);
			return null;
		}
	}
	
	private static Image urlToImage(URL img) {
		return new ImageIcon(img).getImage();
	}
	
	public static void setSize(JComponent elem, int width, int height) {
		Dimension size = new Dimension(width, height);
		elem.setPreferredSize(size);
		elem.setMaximumSize(size);
		elem.setMinimumSize(size);
		elem.setSize(size);
	}
	
	public static void setInactiveInputBorder(JComponent elem) {
		elem.setBorder(new JTextField().getBorder());
	}
	
	public static void setActiveInputBorder(JComponent elem) {
		elem.setBorder(BorderFactory.createLineBorder(new Color(32, 138, 244)));
	}

	public static void setErrorInputBorder(JComponent elem) {
		elem.setBorder(BorderFactory.createLineBorder(new Color(244, 32, 32)));
	}

	public static void setSuccessInputBorder(JComponent elem) {
		elem.setBorder(BorderFactory.createLineBorder(new Color(32, 214, 90)));
	}
	
	public static Container getWhitespace(int width, int height) {
		JPanel whitespace = new JPanel();
		setSize(whitespace, width, height);
		return whitespace;
	}
}