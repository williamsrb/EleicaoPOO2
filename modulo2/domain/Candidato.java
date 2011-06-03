package modulo2.domain;

import java.util.Date;

import modulo2.util.Sequence;

public class Candidato {
	protected Integer id;
	protected Integer numero;
	protected String nome;
	protected Partido partido;
	protected Cargo cargo;
	protected Date nascimento;
	protected Character sexo;
	protected String foto;
	protected String site;
	
	protected Candidato(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, boolean novo) {
		if(novo) {
			this.id = Sequence.getNextId(this.getClass().getName());
		}
		this.numero = number;
		this.nome = name;
		this.partido = partido;
		this.cargo = cargo;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.foto = foto;
		this.site = site;
	}
	
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
}