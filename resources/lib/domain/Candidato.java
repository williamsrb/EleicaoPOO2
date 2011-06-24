package resources.lib.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resources.lib.other.ArrayCaster;
import resources.lib.other.DateString;

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
	private static Map<Integer, Candidato> all; //By ID
	
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
	
	public String toString() {
		return this.nome;
	}
	
	public String toString(boolean tabbed) {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s", this.id.toString(), this.numero.toString(), this.nome, this.partido.getId().toString(), this.cargo.getId().toString(), DateString.dateToString(this.nascimento), this.sexo.toString(), this.foto, (this.site == null ? "-" : this.site));
	}
	
	public String toString(Partido flag) {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s", this.id.toString(), this.numero.toString(), this.nome, this.partido.getSigla(), this.cargo.getId().toString(), DateString.dateToString(this.nascimento), this.sexo.toString(), this.foto, (this.site == null ? "-" : this.site));
	}
	
	public String toString(Cargo flag) {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s", this.id.toString(), this.numero.toString(), this.nome, this.partido.getId().toString(), this.cargo.getNome(), DateString.dateToString(this.nascimento), this.sexo.toString(), this.foto, (this.site == null ? "-" : this.site));
	}
	
	public String toString(Partido flag1, Cargo flag2) {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s", this.id.toString(), this.numero.toString(), this.nome, this.partido.getSigla(), this.cargo.getNome(), DateString.dateToString(this.nascimento), this.sexo.toString(), this.foto, (this.site == null ? "-" : this.site));
	}
	
	//Métodos de controle da coleção de objetos paa evitar recriação de objetos após consultas
	
	public static List<Candidato> getAll(boolean parent) {
		List<Candidato> list = new ArrayList<Candidato>();
		tryAndCreate();
		Integer index[] = ArrayCaster.objectCastInteger(all.keySet().toArray());
		int i, size = index.length;
		for(i = 0; i < size; i++) {
			list.add(all.get(index[i]));
		}
		return list;
	}
	
	public static void register(Candidato c) {
		tryAndCreate();
		all.put(c.id, c);
	}
	
	public static void unregister(Candidato c) {
		tryAndCreate();
		all.remove(c.id);
	}
	
	private static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Candidato>();
		}
	}
}