package modulo2.view;

import java.awt.Dimension;

import javax.swing.ImageIcon;

import modulo2.util.KeyEnum;
import modulo2.util.VotingKey;

import resources.lib.controller.DefaultFiles;
import resources.lib.view.Display;

public final class ImageButton {
	private final ImageIcon light;
	private final ImageIcon shadow;
	private final ImageIcon none;
	
	ImageButton(KeyEnum key) {
		this.light = Display.pathToImageIcon(DefaultFiles.effectPath + VotingKey.getPrefix(key) + "_light.png");
		this.shadow = Display.pathToImageIcon(DefaultFiles.effectPath + VotingKey.getPrefix(key) + "_shadow.png");
		this.none = Display.pathToImageIcon(DefaultFiles.imagePath + VotingKey.getPrefix(key) + ".png");
	}
	
	Dimension getSize() {
		return new Dimension(none.getIconWidth(), none.getIconHeight());
	}
	
	ImageIcon getLight() {
		return light;
	}

	ImageIcon getShadow() {
		return shadow;
	}

	ImageIcon getNone() {
		return none;
	}
}