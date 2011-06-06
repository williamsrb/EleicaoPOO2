package modulo2.view;

import java.awt.Component;
import java.util.Stack;

import javax.swing.JPanel;

import modulo2.domain.Deputado;
import modulo2.domain.Governador;
import modulo2.domain.Presidente;
import modulo2.util.Display;

public class VotingState {
	
	public static void displayCandidate(Deputado person, JPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		person.setDisplay(reverselist);
		Display.preparePanel(screenPanel, reverselist);
	}
	
	public static void displayCandidate(Governador person, JPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		person.setDisplay(reverselist);
		Display.preparePanel(screenPanel, reverselist);
	}
	
	public static void displayCandidate(Presidente person, JPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		person.setDisplay(reverselist);
		Display.preparePanel(screenPanel, reverselist);
	}
	
	public static void displayStateBlocked() {
	/*	Stack<Component> reverselist = new Stack<Component>();
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
	
	public static void displayStateVoting() {
	/*	Stack<Component> reverselist = new Stack<Component>();
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
	
	public static void displayStateEnd() {
	/*	Stack<Component> reverselist = new Stack<Component>();
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
