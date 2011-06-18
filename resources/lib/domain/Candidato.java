package resources.lib.domain;

import java.util.Date;

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
	
	public static final int NONE = -4;
	public static final int NEW = -3;
	protected Integer lastId;
	
	protected Candidato(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, boolean novo) {
		if(novo) {
			this.id = Candidato.NEW; //Não teve o id setado, pois é gerado no banco de dado
		}		
		this.numero = number;
		this.nome = name;
		this.partido = partido;
		this.cargo = cargo;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.foto = foto;
		this.site = site;
		
		this.lastId = Candidato.NEW;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getLastId() {
		return lastId;
	}

	public void setLastId(int lastId) {
		this.lastId = lastId;
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