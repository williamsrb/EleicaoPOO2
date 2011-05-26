package modulo2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JToolBar.Separator;

import modulo2.domain.Congressman;

public class VotingState {
	private JPanel screenPanel;
	private String defaultPath;

	VotingState(JPanel screenPanel) {
		this.setScreenPanel(screenPanel);
		this.setDefaultPath("/resources/upload/");
	}
	
	public static VotingState getVotingState(JPanel screenPanel) {
		return new VotingState(screenPanel);
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
	
	public void displayCongressman(Congressman person) {
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
		//title.setBorder(BorderFactory.createLineBorder(Color.magenta));
		title.setVerticalAlignment(JLabel.TOP);
		title.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		textTop = new JLabel("SEU VOTO PARA");
		textTop.setBounds(15, 33, 170, 28);
		//textTop.setBorder(BorderFactory.createLineBorder(Color.magenta));
		textTop.setVerticalAlignment(JLabel.TOP);
		textTop.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		
		post = new JLabel("DEPUTADO FEDERAL");
		post.setBounds(20, 75, 305, 42);
		//post.setBorder(BorderFactory.createLineBorder(Color.magenta));
		post.setVerticalAlignment(JLabel.TOP);
		post.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		
		numLabel = new JLabel("Número:");
		numLabel.setBounds(10, 170, 70, 24);
		//numLabel.setBorder(BorderFactory.createLineBorder(Color.magenta));
		numLabel.setVerticalAlignment(JLabel.TOP);
		numLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		numDigit01 = new JLabel("1");//Depende do Deputado
		numDigit01.setBounds(80, 145, 40, 42);
		numDigit01.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit01.setVerticalAlignment(JLabel.CENTER);
		numDigit01.setHorizontalAlignment(JLabel.CENTER);
		numDigit01.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit02 = new JLabel("2");//Depende do Deputado
		numDigit02.setBounds(125, 145, 40, 42);
		numDigit02.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit02.setVerticalAlignment(JLabel.CENTER);
		numDigit02.setHorizontalAlignment(JLabel.CENTER);
		numDigit02.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit03 = new JLabel("3");//Depende do Deputado
		numDigit03.setBounds(170, 145, 40, 42);
		numDigit03.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit03.setVerticalAlignment(JLabel.CENTER);
		numDigit03.setHorizontalAlignment(JLabel.CENTER);
		numDigit03.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit04 = new JLabel("4");//Depende do Deputado
		numDigit04.setBounds(215, 145, 40, 42);
		numDigit04.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit04.setVerticalAlignment(JLabel.CENTER);
		numDigit04.setHorizontalAlignment(JLabel.CENTER);
		numDigit04.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit05 = new JLabel("5");//Depende do Deputado
		numDigit05.setBounds(260, 145, 40, 42);
		numDigit05.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit05.setVerticalAlignment(JLabel.CENTER);
		numDigit05.setHorizontalAlignment(JLabel.CENTER);
		numDigit05.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		nameLabel = new JLabel("Nome:");
		nameLabel.setBounds(10, 200, 50, 24);
		//nameLabel.setBorder(BorderFactory.createLineBorder(Color.magenta));
		nameLabel.setVerticalAlignment(JLabel.TOP);
		nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		nameValue = new JLabel("Maria da Silva dos Testes");//Depende do Deputado
		nameValue.setBounds(65, 200, 230, 24);
		//nameValue.setBorder(BorderFactory.createLineBorder(Color.magenta));
		nameValue.setVerticalAlignment(JLabel.TOP);
		nameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		partyLabel = new JLabel("Partido:");
		partyLabel.setBounds(10, 230, 55, 24);
		//partyLabel.setBorder(BorderFactory.createLineBorder(Color.magenta));
		partyLabel.setVerticalAlignment(JLabel.TOP);
		partyLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		partyName = new JLabel("PN");//Depende do Deputado
		partyName.setBounds(70, 230, 28, 24);
		//partyName.setBorder(BorderFactory.createLineBorder(Color.magenta));
		partyName.setVerticalAlignment(JLabel.TOP);
		partyName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		mainPhoto = new ImagePanel(View.pathToImageIcon(this.defaultPath + "teste1.jpg").getImage());
		size = mainPhoto.getSize();
		mainPhoto.setBounds(320, 10, size.width, size.height);
		mainPhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		horizLine = new JSeparator(JSeparator.HORIZONTAL);
		horizLine.setLocation(0, 320);
		horizLine.setSize(pane.getSize());
		horizLine.setBackground(new Color(120, 120, 120));
		horizLine.setForeground(new Color(220, 220, 220));
		
		textBottom = new JLabel("Partido:");
		textBottom.setBounds(10, 230, 55, 24);
		textBottom.setBorder(BorderFactory.createLineBorder(Color.magenta));
		textBottom.setVerticalAlignment(JLabel.TOP);
		textBottom.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
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
		reverselist.push(post);
		reverselist.push(numLabel);
		reverselist.push(nameLabel);
		reverselist.push(nameValue);
		reverselist.push(partyLabel);
		reverselist.push(partyName);
		reverselist.push(horizLine);
		reverselist.push(textBottom);
		reverselist.push(mainPhoto);
		reverselist.push(numDigit01);
		reverselist.push(numDigit02);
		reverselist.push(numDigit03);
		reverselist.push(numDigit04);
		reverselist.push(numDigit05);
		View.preparePanel(pane, reverselist);
	}
}
