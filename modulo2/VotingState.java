package modulo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import modulo2.domain.Candidato;
import modulo2.domain.Deputado;
import modulo2.domain.Governador;
import modulo2.domain.Presidente;

public class VotingState {
	private JPanel screenPanel;
	private Stack<Component> displaylist;
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

	private void displayCandidate(Candidato person, Stack<Component> reverselist) {
		Dimension size;
		JLabel title, textTop, textBottom, greenInstruction, redInstruction;
		JLabel post, numLabel, nameLabel, nameValue, partyLabel, partyName;
		JLabel numDigit01, numDigit02, numDigit03, numDigit04, numDigit05;
		JSeparator horizLine;
		ImagePanel mainPhoto;
		
		title = new JLabel("ELEIÇÃO");
		title.setBounds(10, 10, 70, 24);
		title.setVerticalAlignment(JLabel.TOP);
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		textTop = new JLabel("SEU VOTO PARA");
		textTop.setBounds(15, 33, 170, 28);
		textTop.setVerticalAlignment(JLabel.TOP);
		textTop.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		post = new JLabel("DEPUTADO FEDERAL");
		post.setBounds(20, 75, 305, 42);
		post.setVerticalAlignment(JLabel.TOP);
		post.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		
		numLabel = new JLabel("Número:");
		numLabel.setBounds(10, 170, 70, 24);
		numLabel.setVerticalAlignment(JLabel.TOP);
		numLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		numDigit01 = new JLabel("" + person.getNumero().toString().charAt(0));//Depende do Deputado
		numDigit01.setBounds(80, 145, 40, 42);
		numDigit01.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit01.setVerticalAlignment(JLabel.CENTER);
		numDigit01.setHorizontalAlignment(JLabel.CENTER);
		numDigit01.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit02 = new JLabel("" + person.getNumero().toString().charAt(1));//Depende do Deputado
		numDigit02.setBounds(125, 145, 40, 42);
		numDigit02.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit02.setVerticalAlignment(JLabel.CENTER);
		numDigit02.setHorizontalAlignment(JLabel.CENTER);
		numDigit02.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		nameLabel = new JLabel("Nome:");
		nameLabel.setBounds(10, 200, 50, 24);
		nameLabel.setVerticalAlignment(JLabel.TOP);
		nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		nameValue = new JLabel(person.getNome());//Depende do Deputado
		nameValue.setBounds(65, 200, 230, 24);
		nameValue.setVerticalAlignment(JLabel.TOP);
		nameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		partyLabel = new JLabel("Partido:");
		partyLabel.setBounds(10, 230, 55, 24);
		partyLabel.setVerticalAlignment(JLabel.TOP);
		partyLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		partyName = new JLabel(person.getPartido().getSigla());//Depende do Deputado
		partyName.setBounds(70, 230, 230, 24);
		partyName.setVerticalAlignment(JLabel.TOP);
		partyName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		partyName.setBorder(BorderFactory.createLineBorder(Color.magenta));
		
		mainPhoto = new ImagePanel(View.pathToImageIcon(this.defaultPath + person.getFoto()).getImage());//Depende do Deputado
		size = mainPhoto.getSize();
		mainPhoto.setBounds(320, 10, size.width, size.height);
		mainPhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		horizLine = new JSeparator(JSeparator.HORIZONTAL);
		horizLine.setLocation(0, 320);
		horizLine.setSize(this.screenPanel.getSize());
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
		
		reverselist.push(title);
		reverselist.push(textTop);
		reverselist.push(post);
		reverselist.push(numLabel);
		reverselist.push(nameLabel);
		reverselist.push(nameValue);
		reverselist.push(partyLabel);
		reverselist.push(partyName);
		reverselist.push(horizLine);
		reverselist.push(textBottom);
		reverselist.push(greenInstruction);
		reverselist.push(redInstruction);
		reverselist.push(mainPhoto);
		reverselist.push(numDigit01);
		reverselist.push(numDigit02);
	}
	
	public void displayCandidate(Deputado person) {
		this.displaylist = new Stack<Component>();
		JLabel numDigit03, numDigit04, numDigit05;
		displayCandidate(person, this.displaylist);
		
		numDigit03 = new JLabel(String.format("%c", person.getNumero().toString().charAt(2)));//Depende do Deputado
		numDigit03.setBounds(170, 145, 40, 42);
		numDigit03.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit03.setVerticalAlignment(JLabel.CENTER);
		numDigit03.setHorizontalAlignment(JLabel.CENTER);
		numDigit03.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit04 = new JLabel(String.format("%c", person.getNumero().toString().charAt(3)));//Depende do Deputado
		numDigit04.setBounds(215, 145, 40, 42);
		numDigit04.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit04.setVerticalAlignment(JLabel.CENTER);
		numDigit04.setHorizontalAlignment(JLabel.CENTER);
		numDigit04.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit05 = new JLabel(String.format("%c", person.getNumero().toString().charAt(4)));//Depende do Deputado
		numDigit05.setBounds(260, 145, 40, 42);
		numDigit05.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit05.setVerticalAlignment(JLabel.CENTER);
		numDigit05.setHorizontalAlignment(JLabel.CENTER);
		numDigit05.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		reverselist.push(numDigit03);
		reverselist.push(numDigit04);
		reverselist.push(numDigit05);
		View.preparePanel(this.screenPanel, reverselist);
		/*
		Stack<Component> reverselist = new Stack<Component>();
		Dimension size;
		JPanel pane = this.getScreenPanel();
		JLabel title, textTop, textBottom, greenInstruction, redInstruction;
		JLabel post, numLabel, nameLabel, nameValue, partyLabel, partyName;
		JLabel numDigit01, numDigit02, numDigit03, numDigit04, numDigit05;
		JSeparator horizLine;
		ImagePanel mainPhoto;
		
		title = new JLabel("ELEIÇÃO");
		title.setBounds(10, 10, 70, 24);
		title.setVerticalAlignment(JLabel.TOP);
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		textTop = new JLabel("SEU VOTO PARA");
		textTop.setBounds(15, 33, 170, 28);
		textTop.setVerticalAlignment(JLabel.TOP);
		textTop.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		post = new JLabel("DEPUTADO FEDERAL");
		post.setBounds(20, 75, 305, 42);
		post.setVerticalAlignment(JLabel.TOP);
		post.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		
		numLabel = new JLabel("Número:");
		numLabel.setBounds(10, 170, 70, 24);
		numLabel.setVerticalAlignment(JLabel.TOP);
		numLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		numDigit01 = new JLabel("" + person.getNumero().toString().charAt(0));//Depende do Deputado
		numDigit01.setBounds(80, 145, 40, 42);
		numDigit01.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit01.setVerticalAlignment(JLabel.CENTER);
		numDigit01.setHorizontalAlignment(JLabel.CENTER);
		numDigit01.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit02 = new JLabel("" + person.getNumero().toString().charAt(1));//Depende do Deputado
		numDigit02.setBounds(125, 145, 40, 42);
		numDigit02.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit02.setVerticalAlignment(JLabel.CENTER);
		numDigit02.setHorizontalAlignment(JLabel.CENTER);
		numDigit02.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit03 = new JLabel("" + person.getNumero().toString().charAt(2));//Depende do Deputado
		numDigit03.setBounds(170, 145, 40, 42);
		numDigit03.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit03.setVerticalAlignment(JLabel.CENTER);
		numDigit03.setHorizontalAlignment(JLabel.CENTER);
		numDigit03.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit04 = new JLabel("" + person.getNumero().toString().charAt(3));//Depende do Deputado
		numDigit04.setBounds(215, 145, 40, 42);
		numDigit04.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit04.setVerticalAlignment(JLabel.CENTER);
		numDigit04.setHorizontalAlignment(JLabel.CENTER);
		numDigit04.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit05 = new JLabel("" + person.getNumero().toString().charAt(4));//Depende do Deputado
		numDigit05.setBounds(260, 145, 40, 42);
		numDigit05.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit05.setVerticalAlignment(JLabel.CENTER);
		numDigit05.setHorizontalAlignment(JLabel.CENTER);
		numDigit05.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		nameLabel = new JLabel("Nome:");
		nameLabel.setBounds(10, 200, 50, 24);
		nameLabel.setVerticalAlignment(JLabel.TOP);
		nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		nameValue = new JLabel(person.getNome());//Depende do Deputado
		nameValue.setBounds(65, 200, 230, 24);
		nameValue.setVerticalAlignment(JLabel.TOP);
		nameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		partyLabel = new JLabel("Partido:");
		partyLabel.setBounds(10, 230, 55, 24);
		partyLabel.setVerticalAlignment(JLabel.TOP);
		partyLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		partyName = new JLabel(person.getPartido().getSigla());//Depende do Deputado
		partyName.setBounds(70, 230, 230, 24);
		partyName.setVerticalAlignment(JLabel.TOP);
		partyName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		partyName.setBorder(BorderFactory.createLineBorder(Color.magenta));
		
		mainPhoto = new ImagePanel(View.pathToImageIcon(this.defaultPath + person.getFoto()).getImage());//Depende do Deputado
		size = mainPhoto.getSize();
		mainPhoto.setBounds(320, 10, size.width, size.height);
		mainPhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		horizLine = new JSeparator(JSeparator.HORIZONTAL);
		horizLine.setLocation(0, 320);
		horizLine.setSize(pane.getSize());
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
		
		reverselist.push(title);
		reverselist.push(textTop);
		reverselist.push(post);
		reverselist.push(numLabel);
		reverselist.push(nameLabel);
		reverselist.push(nameValue);
		reverselist.push(partyLabel);
		reverselist.push(partyName);
		reverselist.push(horizLine);
		reverselist.push(textBottom);
		reverselist.push(greenInstruction);
		reverselist.push(redInstruction);
		reverselist.push(mainPhoto);
		reverselist.push(numDigit01);
		reverselist.push(numDigit02);
		reverselist.push(numDigit03);
		reverselist.push(numDigit04);
		reverselist.push(numDigit05);
		View.preparePanel(pane, reverselist);
	*/}
	
	public void displayCandidate(Governador person) {/*
		Stack<Component> reverselist = new Stack<Component>();
		Dimension size;
		JPanel pane = this.getScreenPanel();
		JLabel title, textTop, textBottom, greenInstruction, redInstruction;
		JLabel post, numLabel, nameLabel, nameValue, partyLabel, partyName;
		JLabel numDigit01, numDigit02;
		JSeparator horizLine;
		ImagePanel mainPhoto;
		
		title = new JLabel("ELEIÇÃO");
		title.setBounds(10, 10, 70, 24);
		title.setVerticalAlignment(JLabel.TOP);
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		textTop = new JLabel("SEU VOTO PARA");
		textTop.setBounds(15, 33, 170, 28);
		textTop.setVerticalAlignment(JLabel.TOP);
		textTop.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		post = new JLabel("GOVERNADOR");
		post.setBounds(20, 75, 305, 42);
		post.setVerticalAlignment(JLabel.TOP);
		post.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		
		numLabel = new JLabel("Número:");
		numLabel.setBounds(10, 170, 70, 24);
		numLabel.setVerticalAlignment(JLabel.TOP);
		numLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		numDigit01 = new JLabel("" + person.getNumero().toString().charAt(0));//Depende do Deputado
		numDigit01.setBounds(80, 145, 40, 42);
		numDigit01.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit01.setVerticalAlignment(JLabel.CENTER);
		numDigit01.setHorizontalAlignment(JLabel.CENTER);
		numDigit01.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit02 = new JLabel("" + person.getNumero().toString().charAt(1));//Depende do Deputado
		numDigit02.setBounds(125, 145, 40, 42);
		numDigit02.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit02.setVerticalAlignment(JLabel.CENTER);
		numDigit02.setHorizontalAlignment(JLabel.CENTER);
		numDigit02.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		nameLabel = new JLabel("Nome:");
		nameLabel.setBounds(10, 200, 50, 24);
		nameLabel.setVerticalAlignment(JLabel.TOP);
		nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		nameValue = new JLabel(person.getNome());//Depende do Deputado
		nameValue.setBounds(65, 200, 230, 24);
		nameValue.setVerticalAlignment(JLabel.TOP);
		nameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		partyLabel = new JLabel("Partido:");
		partyLabel.setBounds(10, 230, 55, 24);
		partyLabel.setVerticalAlignment(JLabel.TOP);
		partyLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		partyName = new JLabel(person.getPartido().getSigla());//Depende do Deputado
		partyName.setBounds(70, 230, 230, 24);
		partyName.setVerticalAlignment(JLabel.TOP);
		partyName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		partyName.setBorder(BorderFactory.createLineBorder(Color.magenta));
		
		mainPhoto = new ImagePanel(View.pathToImageIcon(this.defaultPath + person.getFoto()).getImage());//Depende do Deputado
		size = mainPhoto.getSize();
		mainPhoto.setBounds(320, 10, size.width, size.height);
		mainPhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		horizLine = new JSeparator(JSeparator.HORIZONTAL);
		horizLine.setLocation(0, 320);
		horizLine.setSize(pane.getSize());
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
		
		reverselist.push(title);
		reverselist.push(textTop);
		reverselist.push(post);
		reverselist.push(numLabel);
		reverselist.push(nameLabel);
		reverselist.push(nameValue);
		reverselist.push(partyLabel);
		reverselist.push(partyName);
		reverselist.push(horizLine);
		reverselist.push(textBottom);
		reverselist.push(greenInstruction);
		reverselist.push(redInstruction);
		reverselist.push(mainPhoto);
		reverselist.push(numDigit01);
		reverselist.push(numDigit02);
		View.preparePanel(pane, reverselist);
	*/}
	
	public void displayCandidate(Presidente person) {/*
		Stack<Component> reverselist = new Stack<Component>();
		Dimension size;
		JPanel pane = this.getScreenPanel();
		JLabel title, textTop, textBottom, greenInstruction, redInstruction;
		JLabel post, numLabel, nameLabel, nameValue, partyLabel, partyName;
		JLabel numDigit01, numDigit02, numDigit03, numDigit04, numDigit05;
		JSeparator horizLine;
		ImagePanel mainPhoto;
		
		title = new JLabel("ELEIÇÃO");
		title.setBounds(10, 10, 70, 24);
		title.setVerticalAlignment(JLabel.TOP);
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		textTop = new JLabel("SEU VOTO PARA");
		textTop.setBounds(15, 33, 170, 28);
		textTop.setVerticalAlignment(JLabel.TOP);
		textTop.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		post = new JLabel("DEPUTADO FEDERAL");
		post.setBounds(20, 75, 305, 42);
		post.setVerticalAlignment(JLabel.TOP);
		post.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		
		numLabel = new JLabel("Número:");
		numLabel.setBounds(10, 170, 70, 24);
		numLabel.setVerticalAlignment(JLabel.TOP);
		numLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		numDigit01 = new JLabel("" + person.getNumero().toString().charAt(0));//Depende do Deputado
		numDigit01.setBounds(80, 145, 40, 42);
		numDigit01.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit01.setVerticalAlignment(JLabel.CENTER);
		numDigit01.setHorizontalAlignment(JLabel.CENTER);
		numDigit01.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit02 = new JLabel("" + person.getNumero().toString().charAt(1));//Depende do Deputado
		numDigit02.setBounds(125, 145, 40, 42);
		numDigit02.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit02.setVerticalAlignment(JLabel.CENTER);
		numDigit02.setHorizontalAlignment(JLabel.CENTER);
		numDigit02.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit03 = new JLabel("" + person.getNumero().toString().charAt(2));//Depende do Deputado
		numDigit03.setBounds(170, 145, 40, 42);
		numDigit03.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit03.setVerticalAlignment(JLabel.CENTER);
		numDigit03.setHorizontalAlignment(JLabel.CENTER);
		numDigit03.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit04 = new JLabel("" + person.getNumero().toString().charAt(3));//Depende do Deputado
		numDigit04.setBounds(215, 145, 40, 42);
		numDigit04.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit04.setVerticalAlignment(JLabel.CENTER);
		numDigit04.setHorizontalAlignment(JLabel.CENTER);
		numDigit04.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit05 = new JLabel("" + person.getNumero().toString().charAt(4));//Depende do Deputado
		numDigit05.setBounds(260, 145, 40, 42);
		numDigit05.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit05.setVerticalAlignment(JLabel.CENTER);
		numDigit05.setHorizontalAlignment(JLabel.CENTER);
		numDigit05.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		nameLabel = new JLabel("Nome:");
		nameLabel.setBounds(10, 200, 50, 24);
		nameLabel.setVerticalAlignment(JLabel.TOP);
		nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		nameValue = new JLabel(person.getNome());//Depende do Deputado
		nameValue.setBounds(65, 200, 230, 24);
		nameValue.setVerticalAlignment(JLabel.TOP);
		nameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		partyLabel = new JLabel("Partido:");
		partyLabel.setBounds(10, 230, 55, 24);
		partyLabel.setVerticalAlignment(JLabel.TOP);
		partyLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		partyName = new JLabel(person.getPartido().getSigla());//Depende do Deputado
		partyName.setBounds(70, 230, 230, 24);
		partyName.setVerticalAlignment(JLabel.TOP);
		partyName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		partyName.setBorder(BorderFactory.createLineBorder(Color.magenta));
		
		mainPhoto = new ImagePanel(View.pathToImageIcon(this.defaultPath + person.getFoto()).getImage());//Depende do Deputado
		size = mainPhoto.getSize();
		mainPhoto.setBounds(320, 10, size.width, size.height);
		mainPhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		horizLine = new JSeparator(JSeparator.HORIZONTAL);
		horizLine.setLocation(0, 320);
		horizLine.setSize(pane.getSize());
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
		
		reverselist.push(title);
		reverselist.push(textTop);
		reverselist.push(post);
		reverselist.push(numLabel);
		reverselist.push(nameLabel);
		reverselist.push(nameValue);
		reverselist.push(partyLabel);
		reverselist.push(partyName);
		reverselist.push(horizLine);
		reverselist.push(textBottom);
		reverselist.push(greenInstruction);
		reverselist.push(redInstruction);
		reverselist.push(mainPhoto);
		reverselist.push(numDigit01);
		reverselist.push(numDigit02);
		reverselist.push(numDigit03);
		reverselist.push(numDigit04);
		reverselist.push(numDigit05);
		View.preparePanel(pane, reverselist);
	*/}
}
