package modulo2.domain;

import java.util.Date;

public class Governador {
	private Integer id;
	private Integer numero;
	private String nome;
	private Partido partido;
	private Cargo cargo;
	private Date nascimento;
	private Character sexo;
	private String foto;
	private String site;
	private String vice_nome;
	private String vice_foto;
	
	public Integer getId() {
		return id;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Partido getPartido() {
		return partido;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	
	public Character getSexo() {
		return sexo;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public String getSite() {
		return site;
	}
	
	public String getVice_nome() {
		return vice_nome;
	}
	
	public String getVice_foto() {
		return vice_foto;
	}
}
