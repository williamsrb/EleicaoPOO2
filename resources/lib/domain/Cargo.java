package resources.lib.domain;

import java.util.HashMap;
import java.util.Map;

public final class Cargo {
	private Integer id;
	private Integer digitos;
	private String nome;
	
	public static final int NEW = -3;
	private Integer lastId;
	private static Map<Integer, Cargo> all; //By ID
	
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
	
	//Métodos de controle da coleção de objetos paa evitar recriação de objetos após consultas
	public static boolean conflicts(Cargo obj) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(obj)) {
			returnValue = !(all.get(obj.id).nome.equals(obj.nome));
		}
		return returnValue;
	}
	
	public static boolean exists(Cargo obj) {
		tryAndCreate();
		return all.containsKey(obj.id);
	}
	
	public static boolean exists(Integer id) {
		tryAndCreate();
		return all.containsKey(id);
	}
	
	//Retorna um cargo de mesmo id que já esteja registrado
	public static Cargo get(Cargo obj) {
		Cargo returnValue = null;
		tryAndCreate();
		if(exists(obj)) {
			returnValue = all.get(obj.id);
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
	
	public static void register(Cargo obj) {
		tryAndCreate();
		all.put(obj.id, obj);
	}
	
	public static void unregister(Cargo obj) {
		tryAndCreate();
		all.remove(obj.id);
	}
	
	private static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Cargo>();
		}
	}
	
	public static boolean equals(Cargo obj1, Cargo obj2) {
		boolean returnValue = false;
		if((obj1.id == obj2.id) && (obj1.nome.equals(obj2.nome))) {
			returnValue = true;
		}
		return returnValue;
	}
	
	public final boolean equals(Object obj) {
		boolean returnValue = false;
		if(obj instanceof Cargo) {
			Cargo cobj = (Cargo) obj;
			if((this.id == cobj.id) && (this.nome.equals(cobj.nome))) {
				returnValue = true;
			}
		}
		return returnValue;
	}
}