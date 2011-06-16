package modulo2.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import resources.lib.domain.Deputado;

public final class DeputadoView extends CandidatoView {
	private JLabel numDigit03;
	private JLabel numDigit04;
	private JLabel numDigit05;
	
	/* Display */
	public void setDisplay(Stack<Component> reverselist, Deputado pessoa) {
		JLabel numDigit03, numDigit04, numDigit05;
		
		numDigit03 = new JLabel(String.format("%c", pessoa.getNumero().toString().charAt(2)));
		numDigit03.setBounds(170, 145, 40, 42);
		numDigit03.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit03.setVerticalAlignment(JLabel.CENTER);
		numDigit03.setHorizontalAlignment(JLabel.CENTER);
		numDigit03.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit04 = new JLabel(String.format("%c", pessoa.getNumero().toString().charAt(3)));
		numDigit04.setBounds(215, 145, 40, 42);
		numDigit04.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit04.setVerticalAlignment(JLabel.CENTER);
		numDigit04.setHorizontalAlignment(JLabel.CENTER);
		numDigit04.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit05 = new JLabel(String.format("%c", pessoa.getNumero().toString().charAt(4)));
		numDigit05.setBounds(260, 145, 40, 42);
		numDigit05.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit05.setVerticalAlignment(JLabel.CENTER);
		numDigit05.setHorizontalAlignment(JLabel.CENTER);
		numDigit05.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		super.setDisplay(reverselist, pessoa);
		
		reverselist.push(numDigit03);//15
		reverselist.push(numDigit04);//16
		reverselist.push(numDigit05);//17
	}
	
	public void setPreDisplay(Stack<Component> reverselist) {
		JLabel numDigit03, numDigit04, numDigit05;
		
		Deputado pessoa = new Deputado(); //Construtor de testes, já que nenhum dado pessoal será usado
		
		numDigit03 = new JLabel();
		numDigit03.setBounds(170, 145, 40, 42);
		numDigit03.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit03.setVerticalAlignment(JLabel.CENTER);
		numDigit03.setHorizontalAlignment(JLabel.CENTER);
		numDigit03.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		this.numDigit03 = numDigit03;
		
		numDigit04 = new JLabel();
		numDigit04.setBounds(215, 145, 40, 42);
		numDigit04.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit04.setVerticalAlignment(JLabel.CENTER);
		numDigit04.setHorizontalAlignment(JLabel.CENTER);
		numDigit04.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		this.numDigit04 = numDigit04;
		
		numDigit05 = new JLabel();
		numDigit05.setBounds(260, 145, 40, 42);
		numDigit05.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit05.setVerticalAlignment(JLabel.CENTER);
		numDigit05.setHorizontalAlignment(JLabel.CENTER);
		numDigit05.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		this.numDigit05 = numDigit05;
		
		super.setPreDisplay(reverselist, pessoa);
		
		reverselist.push(numDigit03);//15
		reverselist.push(numDigit04);//16
		reverselist.push(numDigit05);//17
	}
	
	public void setDisplayNull(Stack<Component> reverselist, Deputado pessoa) {
		JLabel numDigit03, numDigit04, numDigit05;
		
		numDigit03 = new JLabel(String.format("%c", pessoa.getNumero().toString().charAt(2)));
		numDigit03.setBounds(170, 145, 40, 42);
		numDigit03.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit03.setVerticalAlignment(JLabel.CENTER);
		numDigit03.setHorizontalAlignment(JLabel.CENTER);
		numDigit03.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit04 = new JLabel(String.format("%c", pessoa.getNumero().toString().charAt(3)));
		numDigit04.setBounds(215, 145, 40, 42);
		numDigit04.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit04.setVerticalAlignment(JLabel.CENTER);
		numDigit04.setHorizontalAlignment(JLabel.CENTER);
		numDigit04.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit05 = new JLabel(String.format("%c", pessoa.getNumero().toString().charAt(4)));
		numDigit05.setBounds(260, 145, 40, 42);
		numDigit05.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit05.setVerticalAlignment(JLabel.CENTER);
		numDigit05.setHorizontalAlignment(JLabel.CENTER);
		numDigit05.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		super.setDisplayNull(reverselist, pessoa);
		
		reverselist.push(numDigit03);//0
		reverselist.push(numDigit04);//1
		reverselist.push(numDigit05);//2
	}

	public JLabel getNumDigit03() {
		return this.numDigit03;
	}

	public JLabel getNumDigit04() {
		return this.numDigit04;
	}

	public JLabel getNumDigit05() {
		return this.numDigit05;
	}

	public void setNumDigit03(JLabel numDigit03) {
		this.numDigit03 = numDigit03;
	}

	public void setNumDigit04(JLabel numDigit04) {
		this.numDigit04 = numDigit04;
	}

	public void setNumDigit05(JLabel numDigit05) {
		this.numDigit05 = numDigit05;
	}
}