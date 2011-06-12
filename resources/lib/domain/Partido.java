package resources.lib.domain;

import java.util.Map;

public class Partido {
	private Integer id;
	private String sigla;
	private String nome;
	private Integer numero;
	
	public static final int NEW = -3;
	private static Map<Integer, Partido> all;

	public Partido(String sigla, String nome, Integer numero) {
		this.id = Partido.NEW;
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
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	// Métodos de controle da coleção de objetos para evitar recriação de objetos após consultas//
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	private static Map<Integer, Partido> getAll() {
		return all;
	}
	
	public static boolean conflicts(Partido p) {
		boolean returnValue = false;
		if(exists(p)) {
			returnValue = !(all.get(p.id).numero == p.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Partido p) {
		return getAll().containsKey(p.id);
	}
	
	public static boolean exists(Integer id) {
		return getAll().containsKey(id);
	}
	
	//Retorna um partido de mesmo id que já esteja registrado
	public static Partido get(Partido p) {
		Partido returnValue = null;
		if(exists(p)) {
			returnValue = all.get(p.id);
		}
		return returnValue;
	}
	
	public static Partido get(Integer id) {
		Partido returnValue = null;
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static boolean register(Partido p) {
		boolean success = false;
		if(!exists(p)) {
			all.put(p.id, p);
			success = true;
		}
		return success;
	}
}
