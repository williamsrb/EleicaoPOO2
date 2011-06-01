package modulo2.domain;

import modulo2.util.Sequence;

public class Partido {
	private Integer id;
	private String sigla;
	private String nome;
	private Integer numero;

	public Partido(String sigla, String nome, Integer numero) {
		this.id = Sequence.getNextId(this.getClass().getName());
		this.sigla = sigla;
		this.nome = nome;
		this.numero = numero;
	}

	public Partido() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
