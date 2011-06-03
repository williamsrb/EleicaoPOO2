package modulo2.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
