package modulo2.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Stack;

import javax.swing.JLabel;
import javax.swing.JSeparator;

import resources.lib.domain.Candidato;
import resources.lib.domain.Deputado;
import resources.lib.domain.Governador;
import resources.lib.domain.Presidente;
import resources.lib.view.Display;
import resources.lib.view.ScreenPanel;

public final class VotingState {
	private static JLabel numDigit01;
	private static JLabel numDigit02;
	private static JLabel numDigit03;
	private static JLabel numDigit04;
	private static JLabel numDigit05;
	
	public static void displayCandidate(Deputado person, ScreenPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		DeputadoView dv = new DeputadoView();
		dv.setDisplay(reverselist, person);
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayCandidate(Governador person, ScreenPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		GovernadorView gv = new GovernadorView();
		gv.setDisplay(reverselist, person);
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayCandidate(Presidente person, ScreenPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		PresidenteView pv = new PresidenteView();
		pv.setDisplay(reverselist, person);
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void preDisplayCandidate(Deputado person, ScreenPanel screenPanel) {
		Stack<Component> reverselist;
		DeputadoView dv;
		person = null;
		reverselist = new Stack<Component>();
		dv = new DeputadoView();
		dv.setPreDisplay(reverselist);
		numDigit01 = dv.getNumDigit01();
		numDigit02 = dv.getNumDigit02();
		numDigit03 = dv.getNumDigit03();
		numDigit04 = dv.getNumDigit04();
		numDigit05 = dv.getNumDigit05();
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void preDisplayCandidate(Governador person, ScreenPanel screenPanel) {
		Stack<Component> reverselist;
		GovernadorView gv;
		person = null;
		reverselist = new Stack<Component>();
		gv = new GovernadorView();
		gv.setPreDisplay(reverselist);
		numDigit01 = gv.getNumDigit01();
		numDigit02 = gv.getNumDigit02();
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void preDisplayCandidate(Presidente person, ScreenPanel screenPanel) {
		Stack<Component> reverselist;
		PresidenteView pv;
		person = null;
		reverselist = new Stack<Component>();
		pv = new PresidenteView();
		pv.setPreDisplay(reverselist);
		numDigit01 = pv.getNumDigit01();
		numDigit02 = pv.getNumDigit02();
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayStart(ScreenPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		JLabel msg1, msg2;
		
		msg1 = new JLabel("Pressione qualquer");
		msg1.setBounds(75, 170, 305, 42);
		msg1.setVerticalAlignment(JLabel.TOP);
		msg1.setHorizontalAlignment(JLabel.CENTER);
		msg1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		
		msg2 = new JLabel("tecla para iniciar");
		msg2.setBounds(75, 200, 305, 42);
		msg2.setVerticalAlignment(JLabel.TOP);
		msg2.setHorizontalAlignment(JLabel.CENTER);
		msg2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		
		//Setando elementos no panel pela ordem de camadas
		reverselist.push(msg1);
		reverselist.push(msg2);
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	//Serve para todos os cargos, exceto Deputado
	public static void displayNull(Candidato pessoa, ScreenPanel screenPanel) {
		Stack<Component> reverselist;
		CandidatoView cv;
		reverselist = new Stack<Component>();
		cv = new CandidatoView();
		cv.setDisplayNull(reverselist, pessoa);
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayNull(Deputado pessoa, ScreenPanel screenPanel) {
		Stack<Component> reverselist;
		DeputadoView cv;
		reverselist = new Stack<Component>();
		cv = new DeputadoView();
		cv.setDisplayNull(reverselist, pessoa);
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayBlank(Candidato pessoa, ScreenPanel screenPanel) {
		JLabel title, textTop, textBottom, greenInstruction, redInstruction;
		JLabel post, msg1;
		JSeparator horizLine;
		Stack<Component> reverselist = new Stack<Component>();
		
		title = new JLabel("ELEIÇÃO");
		title.setBounds(10, 10, 70, 24);
		title.setVerticalAlignment(JLabel.TOP);
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		textTop = new JLabel("SEU VOTO PARA");
		textTop.setBounds(15, 33, 170, 28);
		textTop.setVerticalAlignment(JLabel.TOP);
		textTop.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		post = new JLabel(pessoa.getCargo().getNome().toUpperCase());
		post.setBounds(20, 75, 305, 42);
		post.setVerticalAlignment(JLabel.TOP);
		post.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		
		msg1 = new JLabel("VOTO EM BRANCO");
		msg1.setBounds(40, 150, 370, 70);
		msg1.setVerticalAlignment(JLabel.TOP);
		msg1.setHorizontalAlignment(JLabel.CENTER);
		msg1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
		
		horizLine = new JSeparator(JSeparator.HORIZONTAL);
		horizLine.setLocation(0, 320);
		//horizLine.setSize(pane.getSize());
		horizLine.setSize(new Dimension(450, 4));
		horizLine.setBackground(new Color(120, 120, 120));
		horizLine.setForeground(new Color(220, 220, 220));
		
		textBottom = new JLabel("Aperte a tecla:");
		textBottom.setBounds(10, 330, 120, 24);
		textBottom.setVerticalAlignment(JLabel.TOP);
		textBottom.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		
		greenInstruction = new JLabel("VERDE para CONFIRMAR este voto");
		greenInstruction.setBounds(20, 350, 220, 24);
		greenInstruction.setVerticalAlignment(JLabel.TOP);
		greenInstruction.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		
		redInstruction = new JLabel("VERMELHO para REINICIAR este voto");
		redInstruction.setBounds(20, 370, 230, 24);
		redInstruction.setVerticalAlignment(JLabel.TOP);
		redInstruction.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		
		reverselist.push(title);//0
		reverselist.push(textTop);//1
		reverselist.push(post);//2
		reverselist.push(msg1);//3
		reverselist.push(horizLine);//4
		reverselist.push(textBottom);//5
		reverselist.push(greenInstruction);//6
		reverselist.push(redInstruction);//7
		
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}
	
	public static void displayEnd(ScreenPanel screenPanel) {
		Stack<Component> reverselist = new Stack<Component>();
		JLabel title, msg1, msg2;
		
		title = new JLabel("VOTOU");
		title.setBounds(10, 10, 70, 24);
		title.setVerticalAlignment(JLabel.TOP);
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		title.setForeground(Color.GRAY);
		
		msg1 = new JLabel("FIM");
		msg1.setBounds(65, 160, 305, 70);
		msg1.setVerticalAlignment(JLabel.TOP);
		msg1.setHorizontalAlignment(JLabel.CENTER);
		msg1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 70));
		
		msg2 = new JLabel("Pressione qualquer tecla para terminar");
		msg2.setBounds(150, 370, 305, 42);
		msg2.setVerticalAlignment(JLabel.TOP);
		msg2.setHorizontalAlignment(JLabel.CENTER);
		msg2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		//Setando elementos no panel pela ordem de camadas
		reverselist.push(title);
		reverselist.push(msg1);
		reverselist.push(msg2);
		screenPanel.clear();
		Display.preparePanel(screenPanel, reverselist);
		screenPanel.refresh();
	}

	public static JLabel getNumDigit01() {
		return numDigit01;
	}

	public static JLabel getNumDigit02() {
		return numDigit02;
	}

	public static JLabel getNumDigit03() {
		return numDigit03;
	}

	public static JLabel getNumDigit04() {
		return numDigit04;
	}

	public static JLabel getNumDigit05() {
		return numDigit05;
	}
	
	public static void cleanNumDigits() {
		if(numDigit01 != null) numDigit01.setText(null);
		if(numDigit02 != null) numDigit02.setText(null);
		if(numDigit03 != null) numDigit03.setText(null);
		if(numDigit04 != null) numDigit04.setText(null);
		if(numDigit05 != null) numDigit05.setText(null);
	}
}