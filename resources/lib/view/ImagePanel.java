package resources.lib.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public final class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1001L;
	private Image img;
	
	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	/* Sobrescrevendo */
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}