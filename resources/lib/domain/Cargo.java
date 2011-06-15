package resources.lib.domain;

import java.util.HashMap;
import java.util.Map;

public class Cargo {
	private Integer id;
	private Integer digitos;
	private String nome;
	
	public static final int NEW = -3;
	private Integer lastId;
	private static Map<Integer, Cargo> all;
	
	//Apesar da existêcia de construtores para criar novos cargos, seria necessário remodelar o banco para aceitar os novos campos customizados
	//dos possíveis novos cargos, além de ser necessária a criação de classes de domínio e persistência.
	private Cargo(Integer digitos, String nome, boolean novo) {
		if(novo) {
			this.id = Cargo.NEW; //Não teve o id setado, pois é gerado no banco de dado
		}
		this.digitos = digitos;
		this.nome = nome;
		
		this.lastId = Cargo.NEW;
	}
	
	//Construtor que usa gerador de id automático
	public Cargo(Integer digitos, String nome) {
		this(digitos, nome, true);
	}
	
	//Construtor que NÃO usa gerador de id automático
	public Cargo(Integer id, Integer digitos, String nome) {
		this(digitos, nome, false);
		this.id = id;
	}
	
	//Construtor usado para testes
	public Cargo() {
		this(new Integer(-4), 5, "Deputado Estadual");
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

	public Integer getDigitos() {
		return digitos;
	}
	
	public String getNome() {
		return nome;
	}
	
	//Métodos de controle da coleção de objetos para evitar recriação de objetos após consultas
	
	private static Map<Integer, Cargo> getAll() {
		tryAndCreate();
		return all;
	}
	
	public static boolean conflicts(Cargo c) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(c)) {
			returnValue = !(all.get(c.id).nome.equals(c.nome));
		}
		return returnValue;
	}
	
	public static boolean exists(Cargo c) {
		tryAndCreate();
		return getAll().containsKey(c.id);
	}
	
	public static boolean exists(Integer id) {
		tryAndCreate();
		return getAll().containsKey(id);
	}
	
	//Retorna um presidente de mesmo id que já esteja registrado
	public static Cargo get(Cargo c) {
		Cargo returnValue = null;
		tryAndCreate();
		if(exists(c)) {
			returnValue = all.get(c.id);
		}
		return returnValue;
	}
	
	public static Cargo get(Integer id) {
		Cargo returnValue = null;
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
	
	public static void register(Cargo c) {
		tryAndCreate();
		all.put(c.id, c);
	}
	
	public static void unregister(Cargo c) {
		tryAndCreate();
		all.remove(c.id);
	}
	
	public static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Cargo>();
		}
	}
}
 
