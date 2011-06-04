package modulo2.domain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Deputado extends Candidato {
	private String apelido;
	
	//Construtor que usa gerador de id automático da classe mãe
	private Deputado(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String apelido) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, true);
		this.apelido = apelido;
	}
	
	//Construtor que NÃO usa gerador de id automático da classe mãe
	private Deputado(Integer id, Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String apelido) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, false);
		this.apelido = apelido;
		this.id = id;
	}
	
	//Construtor usado para testes
	public Deputado() {
		this(new Integer(-1), new Integer(12345), "Testentina dos Testes Testosos", new Partido("PN", "Partido do Nada", 12), new Cargo(new Integer(5), "Deputado"), new Date(), 'F', "teste1.jpg", "http://www.testezinha.com.br", "Testezinha");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.nascimento = formatador.parse("01/01/2001");
		} catch (ParseException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Não foi possível obter a data a partir da entrada", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
			this.nascimento = null;
		}
	}

	/* Getters */
	public String getApelido() {
		return this.apelido;
	}
	
	/* Display */
	public void setDisplay(Stack<Component> reverselist) {
		JLabel numDigit03, numDigit04, numDigit05;
		
		numDigit03 = new JLabel(String.format("%c", this.numero.toString().charAt(2)));
		numDigit03.setBounds(170, 145, 40, 42);
		numDigit03.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit03.setVerticalAlignment(JLabel.CENTER);
		numDigit03.setHorizontalAlignment(JLabel.CENTER);
		numDigit03.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit04 = new JLabel(String.format("%c", this.numero.toString().charAt(3)));
		numDigit04.setBounds(215, 145, 40, 42);
		numDigit04.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit04.setVerticalAlignment(JLabel.CENTER);
		numDigit04.setHorizontalAlignment(JLabel.CENTER);
		numDigit04.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		numDigit05 = new JLabel(String.format("%c", this.numero.toString().charAt(4)));
		numDigit05.setBounds(260, 145, 40, 42);
		numDigit05.setBorder(BorderFactory.createLineBorder(Color.black));
		numDigit05.setVerticalAlignment(JLabel.CENTER);
		numDigit05.setHorizontalAlignment(JLabel.CENTER);
		numDigit05.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
		
		super.setDisplay(reverselist);
		
		reverselist.push(numDigit03);//15
		reverselist.push(numDigit04);//16
		reverselist.push(numDigit05);//17
	}
}
