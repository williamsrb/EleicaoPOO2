package modulo2.view;

import java.awt.Dimension;
import javax.swing.ImageIcon;

import modulo2.util.Display;
import modulo2.util.FileUpload;

public class ImageButton {
	private final ImageIcon light;
	private final ImageIcon shadow;
	private final ImageIcon none;
	
	public ImageButton(KeyEnum key) {
		this.light = Display.pathToImageIcon(FileUpload.effectPath + VotingKey.getImgPrefix(key) + "_light.png");
		this.shadow = Display.pathToImageIcon(FileUpload.effectPath + VotingKey.getImgPrefix(key) + "_shadow.png");
		this.none = Display.pathToImageIcon(FileUpload.imagePath + VotingKey.getImgPrefix(key) + ".png");
	}
	
	public Dimension getSize() {
		return new Dimension(none.getIconWidth(), none.getIconHeight());
	}
	
	public ImageIcon getLight() {
		return light;
	}

	public ImageIcon getShadow() {
		return shadow;
	}

	public ImageIcon getNone() {
		return none;
	}
}
