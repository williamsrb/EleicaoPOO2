package modulo2.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import modulo2.util.Sequence;

public class Deputado {
	private Integer id;
	private Integer numero;
	private String nome;
	private Partido partido;
	private Cargo cargo;
	private Date nascimento;
	private Character sexo;
	private String foto;
	private String site;
	private String apelido;
	
	public Deputado(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String apelido) {
		this.id = Sequence.getNextId(this.getClass().getName());
		this.numero = number;
		this.nome = name;
		this.partido = partido;
		this.cargo = cargo;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.foto = foto;
		this.site = site;
		this.apelido = apelido;
	}
	
	private Deputado(Integer id, Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String apelido) {
		this(number, name, partido, cargo, nascimento, sexo, foto, site, apelido);
		this.id = id;
	}
	
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
	public Integer getId() {
		return this.id;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public String getNome() {
		return this.nome;
	}

	public Partido getPartido() {
		return this.partido;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public Date getNascimento() {
		return this.nascimento;
	}

	public Character getSexo() {
		return this.sexo;
	}

	public String getFoto() {
		return this.foto;
	}

	public String getSite() {
		return this.site;
	}

	public String getApelido() {
		return this.apelido;
	}
}
