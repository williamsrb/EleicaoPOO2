package resources.lib.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.net.URL;
import java.util.Stack;

import javax.swing.ImageIcon;

public class Display {
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
			System.err.println("Arquivo não encontrado: " + path);
			return null;
		}
	}
	
	public static Image urlToImage(URL img) {
		return new ImageIcon(img).getImage();
	}
}
 
