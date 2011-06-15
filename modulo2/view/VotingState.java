package modulo2.view;

import java.awt.Component;
import java.util.Stack;

import resources.lib.domain.Deputado;
import resources.lib.domain.Governador;
import resources.lib.domain.Presidente;
import resources.lib.view.Display;
import resources.lib.view.ScreenPanel;

public final class VotingState {
	
	public static void displayCandidate(Deputado person, ScreenPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		DeputadoView dv = new DeputadoView();
		dv.setDisplay(reverselist, person);
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayCandidate(Governador person, ScreenPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		GovernadorView gv = new GovernadorView();
		gv.setDisplay(reverselist, person);
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayCandidate(Presidente person, ScreenPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		PresidenteView pv = new PresidenteView();
		pv.setDisplay(reverselist, person);
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayNull() {
		/**
		
		Mesmo que candidato padrão, de acordo com o cargo
		
		- foto
		- nome
		- partido
		- vice-foto (se tiver)
		- vice-nome (se tiver)
		+ "NÚMERO ERRADO" (regular, 1.5 vezes o tamanho normal, abaixo do número, na esquerda)
		+ "VOTO NULO" (bold, mesmo tamanho do "Cargo", no centro horizontal da tela, logo acima da "horizontalline")
		(Substituir o número do candidato padrão pelo que o usuário inseriu)
		
		*/
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
	
	public static void displayBlank() {
		/**
		
		Mesmo que candidato padrão, de acordo com o cargo
		
		- foto
		- nome
		- número
		- partido
		- vice-foto (se tiver)
		- vice-nome (se tiver)
		+ "VOTO EM BRANCO" (bold, 1.5 vezes o tamanho do "cargo", no centro horizontal da tela, no meio vertical)
		
		*/
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
	
	public static void displayEnd() {
		/**
		
		Tela partindo do zero
		
		+ "Eleição" (mostrado da mesma forma que em "Candidato", canto superior esquerdo da tela)
		+ "FIM" (bold, 10 vezes o tamanho da fonte do "cargo" de "Candidato", meio centro da tela)
		+ "VOTOU" (bold, cinza, mesmo tamanho do "VOTO EM BRANCO", canto inferior direito da tela)
		
		*/
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