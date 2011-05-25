package modulo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class VotingStates {
	private JPanel screenPanel;
	private String defaultPath;
	
	VotingStates(JPanel screenPanel) {
		this.setScreenPanel(screenPanel);
		this.setDefaultPath("/resources/upload/");
	}
	
	public void setDefaultPath(String defaultPath) {
		this.defaultPath = defaultPath;
	}

	public String getDefaultPath() {
		return this.defaultPath;
	}

	public void setScreenPanel(JPanel screenPanel) {
		this.screenPanel = screenPanel;
	}
	
	public JPanel getScreenPanel() {
		return this.screenPanel;
	}

	public void displayPresident() {
		JPanel pane = this.getScreenPanel();
	}
	
	public void displayGovernor() {
		JPanel pane = this.getScreenPanel();
	}
	
	public void displayCongressman() {
		Stack<Component> reverselist = new Stack<Component>();
		Dimension size;
		JPanel pane = this.getScreenPanel();
		JLabel title, textTop, textBottom, greenInstruction, redInstruction;
		JLabel post, numLabel, nameLabel, nameValue, partyLabel, partyName;
		JLabel numDigit01, numDigit02, numDigit03, numDigit04, numDigit05;
		JSeparator horizLine;
		ImagePanel mainPhoto;
		
		/**
		 *
			bg = new ImagePanel(pathToImageIcon(defaultPath + "caixa.png").getImage());
			size = bg.getSize();
			bg.setBounds(0, 0, size.width, size.height);
		 */
		
		title = new JLabel("ELEIÇÃO");
		title.setBounds(10, 10, 70, 24);
		title.setBorder(BorderFactory.createLineBorder(Color.magenta));
		title.setVerticalAlignment(JLabel.TOP);
		
		textTop = new JLabel("SEU VOTO PARA");
		textTop.setBounds(15, 33, 130, 28);
		textTop.setBorder(BorderFactory.createLineBorder(Color.magenta));
		textTop.setVerticalAlignment(JLabel.TOP);
		textTop.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		mainPhoto = new ImagePanel(View.pathToImageIcon(this.defaultPath + "teste1.jpg").getImage());
		size = mainPhoto.getSize();
		mainPhoto.setBounds(290, 10, size.width, size.height);
		mainPhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		/**
		 * Título
		 * Seu voto para
		 * deputado estadual
		 * foto
		 * número
		 * [X][X][X][X][X] * Cada quadrado será um jlabel
		 * nome
		 * "Xnome"
		 * partido
		 * "Xpartido"
		 * divisor
		 * Aperte a tecla:
		 * Verde para confirmar este voto
		 * Vermelho para reiniciar este voto
		 */
		reverselist.push(title);
		reverselist.push(textTop);
		reverselist.push(mainPhoto);
		View.preparePanel(pane, reverselist);
	}
}
