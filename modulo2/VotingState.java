package modulo2;

import java.awt.Component;
import java.util.Stack;

import javax.swing.JPanel;

import modulo2.domain.Deputado;
import modulo2.domain.Governador;
import modulo2.domain.Presidente;
import modulo2.util.Display;

public class VotingState {
	private JPanel screenPanel;
	private String defaultPath;

	VotingState(JPanel screenPanel) {
		this.screenPanel = screenPanel;
		this.defaultPath = "/resources/upload/";
	}

	public JPanel getScreenPanel() {
		return screenPanel;
	}

	public String getDefaultPath() {
		return defaultPath;
	}
	
	public void displayCandidate(Deputado person) {
		Stack<Component> reverselist = new Stack<Component>();
		person.setDisplay(reverselist);
		Display.preparePanel(this.screenPanel, reverselist);
	}
	
	public void displayCandidate(Governador person) {
		//View.preparePanel(this.screenPanel, reverselist);
	}
	
	public void displayCandidate(Presidente person) {
		//View.preparePanel(this.screenPanel, reverselist);
	}
	
	@SuppressWarnings("unused")
	private static void displayStateBlocked(JPanel screenPanel) {
	/*	Stack<Component> reverselist = new Stack<Component>();
		@SuppressWarnings("unused")
		JLabel title, bigMiddleMsg, bottomRightMsg;
		JSeparator separator;
		
		title = new JLabel("Eleições");
		title.setLocation(0, 0);
		title.setSize(90, 90);
		separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setLocation(0, 90);
		separator.setSize(screenPanel.getSize());
		//texto.setBorder(BorderFactory.createLineBorder(Color.red));
		
		//Setando elementos no panel pela ordem de camadas
		reverselist.push(title);
		reverselist.push(separator);
		preparePanel(screenPanel, reverselist);*/
	}
	
	@SuppressWarnings("unused")
	private static void displayStateVoting(JPanel pane) {
	/*	Stack<Component> reverselist = new Stack<Component>();
		@SuppressWarnings("unused")
		JLabel title, bigMiddleMsg, bottomRightMsg;
		JSeparator separator;
		
		title = new JLabel("Eleições");
		title.setLocation(0, 0);
		title.setSize(90, 90);
		separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setLocation(0, 90);
		separator.setSize(pane.getSize());
		//texto.setBorder(BorderFactory.createLineBorder(Color.red));
		
		//Setando elementos no panel pela ordem de camadas
		reverselist.push(title);
		reverselist.push(separator);
		preparePanel(pane, reverselist);*/
	}
	
	@SuppressWarnings("unused")
	private static void displayStateEnd(JPanel pane) {
	/*	Stack<Component> reverselist = new Stack<Component>();
		@SuppressWarnings("unused")
		JLabel title, bigMiddleMsg, bottomRightMsg;
		JSeparator separator;
		
		title = new JLabel("Eleições");
		title.setLocation(0, 0);
		title.setSize(90, 90);
		separator = new JSeparator(SwingConstants.HORIZONTAL);
		separator.setLocation(0, 90);
		separator.setSize(pane.getSize());
		//texto.setBorder(BorderFactory.createLineBorder(Color.red));
		
		//Setando elementos no panel pela ordem de camadas
		reverselist.push(title);
		reverselist.push(separator);
		preparePanel(pane, reverselist);*/
	}
}
