package modulo2.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import resources.lib.controller.FileUpload;
import resources.lib.domain.Candidato;
import resources.lib.view.Display;
import resources.lib.view.ImagePanel;

public class CandidatoView {
	protected void setDisplay(Stack<Component> reverselist, Candidato pessoa) {
		Dimension size;
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
		
		post = new JLabel(pessoa.getCargo().getNome().toUpperCase());
		post.setBounds(20, 75, 305, 42);
		post.setVerticalAlignment(JLabel.TOP);
		post.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		
		numLabel = new JLabel("Número:");
		numLabel.setBounds(10, 170, 70, 24);
		numLabel.setVerticalAlignment(JLabel.TOP);
		numLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		numDigit01 = new JLabel(String.format("%c", pessoa.getNumero().toString().charAt(0)));//Depende do Candidato
		numDigit01.setBounds(80, 145, 40, 42);
		numDigit01.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit01.setVerticalAlignment(JLabel.CENTER);
		numDigit01.setHorizontalAlignment(JLabel.CENTER);
		numDigit01.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit02 = new JLabel(String.format("%c", pessoa.getNumero().toString().charAt(1)));//Depende do Candidato
		numDigit02.setBounds(125, 145, 40, 42);
		numDigit02.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit02.setVerticalAlignment(JLabel.CENTER);
		numDigit02.setHorizontalAlignment(JLabel.CENTER);
		numDigit02.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		nameLabel = new JLabel("Nome:");
		nameLabel.setBounds(10, 200, 50, 24);
		nameLabel.setVerticalAlignment(JLabel.TOP);
		nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		nameValue = new JLabel(pessoa.getNome());//Depende do Candidato
		nameValue.setBounds(65, 200, 230, 24);
		nameValue.setVerticalAlignment(JLabel.TOP);
		nameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		partyLabel = new JLabel("Partido:");
		partyLabel.setBounds(10, 230, 55, 24);
		partyLabel.setVerticalAlignment(JLabel.TOP);
		partyLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		partyName = new JLabel(pessoa.getPartido().getSigla());//Depende do Candidato
		partyName.setBounds(70, 230, 230, 24);
		partyName.setVerticalAlignment(JLabel.TOP);
		partyName.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		mainPhoto = new ImagePanel(Display.pathToImageIcon(FileUpload.uploadPath + pessoa.getFoto()).getImage());//Depende do Candidato
		size = mainPhoto.getSize();
		mainPhoto.setBounds(320, 10, size.width, size.height);
		mainPhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
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
		reverselist.push(numLabel);//3
		reverselist.push(nameLabel);//4
		reverselist.push(nameValue);//5
		reverselist.push(partyLabel);//6
		reverselist.push(partyName);//7
		reverselist.push(horizLine);//8
		reverselist.push(textBottom);//9
		reverselist.push(greenInstruction);//10
		reverselist.push(redInstruction);//11
		reverselist.push(mainPhoto);//12
		reverselist.push(numDigit01);//13
		reverselist.push(numDigit02);//14
	}
}
 
