package resources.lib.view;

import javax.swing.JPanel;

public final class ScreenPanel extends JPanel {
	private static final long serialVersionUID = 1003L;

	public void clear() {
		this.removeAll();
		this.refresh();
	}
	
	public void refresh() {
		this.setVisible(false);
		this.setVisible(true);
	}
}