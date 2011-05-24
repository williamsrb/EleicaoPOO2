package modulo2;

import java.awt.Dimension;
import javax.swing.ImageIcon;

public class ImageButton {
	private final ImageIcon light;
	private final ImageIcon shadow;
	private final ImageIcon none;
	
	public ImageButton(KeyEnum key) {
		this.light = View.pathToImageIcon("/resources/imageeffects/" + VotingKey.getImgPrefix(key) + "_light.png");
		this.shadow = View.pathToImageIcon("/resources/imageeffects/" + VotingKey.getImgPrefix(key) + "_shadow.png");
		this.none = View.pathToImageIcon("/resources/images/" + VotingKey.getImgPrefix(key) + ".png");
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
