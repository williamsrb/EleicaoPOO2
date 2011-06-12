package resources.lib.domain;

import java.util.Map;

public class Cargo {
	private Integer id;
	private Integer digitos;
	private String nome;
	
	public static final int NEW = -3;
	private static Map<Integer, Cargo> all;
	
	public Cargo(Integer digitos, String nome) {
		this.id = Cargo.NEW;
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
	
	//Métodos de controle da coleção de objetos para evitar recriação de objetos após consultas
	
	private static Map<Integer, Cargo> getAll() {
		return all;
	}
	
	public static boolean conflicts(Cargo c) {
		boolean returnValue = false;
		if(exists(c)) {
			returnValue = !(all.get(c.id).nome.equals(c.nome));
		}
		return returnValue;
	}
	
	public static boolean exists(Cargo c) {
		return getAll().containsKey(c.id);
	}
	
	public static boolean exists(Integer id) {
		return getAll().containsKey(id);
	}
	
	//Retorna um presidente de mesmo id que já esteja registrado
	public static Cargo get(Cargo c) {
		Cargo returnValue = null;
		if(exists(c)) {
			returnValue = all.get(c.id);
		}
		return returnValue;
	}
	
	public static Cargo get(Integer id) {
		Cargo returnValue = null;
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static boolean register(Cargo c) {
		boolean success = false;
		if(!exists(c)) {
			all.put(c.id, c);
			success = true;
		}
		return success;
	}
	
}
