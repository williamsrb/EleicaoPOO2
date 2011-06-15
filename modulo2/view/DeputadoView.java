package modulo2.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import resources.lib.domain.Deputado;

public final class DeputadoView extends CandidatoView {
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
}