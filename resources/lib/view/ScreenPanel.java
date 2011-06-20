package resources.lib.view;

import java.awt.LayoutManager;

import javax.swing.JPanel;

public final class ScreenPanel extends JPanel {
	private static final long serialVersionUID = 1003L;
	
	public ScreenPanel(LayoutManager lm) {
		super(lm);
	}
	
	public ScreenPanel() {
		super();
	}
	
	public void clear() {
		this.removeAll();
		this.refresh();
	}
	
	public void refresh() {
		this.setVisible(false);
		this.setVisible(true);
	}
}