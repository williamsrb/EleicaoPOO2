package modulo2.domain;

import modulo2.util.Sequence;

public class Cargo {
	private Integer id;
	private Integer digitos;
	private String nome;
	
	public Cargo(Integer digitos, String nome) {
		this.id = Sequence.getNextId(this.getClass().getName());
		this.digitos = digitos;
		this.nome = nome;
	}
	
	public Cargo() {
		
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getDigitos() {
		return digitos;
	}
	
	public void setDigitos(Integer digitos) {
		this.digitos = digitos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
