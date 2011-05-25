package modulo2;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class VotingStates {
	private JPanel screenPanel;
	
	VotingStates(JPanel screenPanel) {
		this.setScreenPanel(screenPanel);
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
		JPanel pane = this.getScreenPanel();
		JLabel title, textTop, textBottom, greenInstruction, redInstruction;
		JLabel post, numLabel, nameLabel, nameValue, partyLabel, partyName;
		JLabel numDigit01, numDigit02, numDigit03, numDigit04, numDigit05;
		JSeparator horizLine;
		ImagePanel mainPhoto;
		
		title = new JLabel("Eleição");
		title.setBounds(0, 0, 90, 90);
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
	}
}
