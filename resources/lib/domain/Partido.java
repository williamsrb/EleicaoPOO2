package resources.lib.domain;

import java.util.HashMap;
import java.util.Map;

public class Partido {
	private Integer id;
	private String sigla;
	private String nome;
	private Integer numero;
	
	public static final int NEW = -3;
	private Integer lastId;
	private static Map<Integer, Partido> all;
	
	private Partido(String sigla, String nome, Integer numero, boolean novo) {
		if(novo) {
			this.id = Partido.NEW; //Não teve o id setado, pois é gerado no banco de dado
		}
		this.sigla = sigla;
		this.nome = nome;
		this.numero = numero;
		
		this.lastId = Partido.NEW;
	}
	
	//Construtor que usa gerador de id automático
	public Partido(String sigla, String nome, Integer numero) {
		this(sigla, nome, numero, true);
	}
	
	//Construtor que NÃO usa gerador de id automático
	public Partido(Integer id, String sigla, String nome, Integer numero) {
		this(sigla, nome, numero, false);
		this.id = id;
	}
	
	//Construtor usado para testes
	public Partido() {
		this(new Integer(-4), "PN", "Partido do Nada", 12);
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setLastId(Integer lastId) {
		this.lastId = lastId;
	}

	public Integer getLastId() {
		return lastId;
	}

	public String getSigla() {
		return sigla;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	// Métodos de controle da coleção de objetos para evitar recriação de objetos após consultas//
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	private static Map<Integer, Partido> getAll() {
		tryAndCreate();
		return all;
	}
	
	public static boolean conflicts(Partido p) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(p)) {
			returnValue = !(all.get(p.id).numero == p.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Partido p) {
		tryAndCreate();
		return getAll().containsKey(p.id);
	}
	
	public static boolean exists(Integer id) {
		tryAndCreate();
		return getAll().containsKey(id);
	}
	
	//Retorna um partido de mesmo id que já esteja registrado
	public static Partido get(Partido p) {
		Partido returnValue = null;
		tryAndCreate();
		if(exists(p)) {
			returnValue = all.get(p.id);
		}
		return returnValue;
	}
	
	public static Partido get(Integer id) {
		Partido returnValue = null;
		tryAndCreate();
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static boolean isEmpty() {
		tryAndCreate();
		return all.isEmpty();
	}
	
	public static void register(Partido p) {
		tryAndCreate();
		all.put(p.id, p);
	}
	
	public static void unregister(Partido p) {
		tryAndCreate();
		all.remove(p.id);
	}
	
	public static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Partido>();
		}
	}
}
 
