package resources.lib.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resources.lib.other.ArrayCaster;

public final class Partido {
	private Integer id;
	private String sigla;
	private String nome;
	private Integer numero;
	
	public static final int NEW = -3;
	private Integer lastId;
	private static Map<Integer, Partido> all; //By ID
	private static Map<Integer, Partido> allByNumber; //by Number
	private static Map<String, Partido> allByAcronym; //by Acronym
	private static Map<String, Partido> allByName; //by Name
	
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
	
	//Métodos de controle da coleção de objetos paa evitar recriação de objetos após consultas
	public static List<Partido> getAll() {
		List<Partido> list = new ArrayList<Partido>();
		tryAndCreate();
		Integer index[] = ArrayCaster.objectCastInteger(all.keySet().toArray());
		int i, size = index.length;
		for(i = 0; i < size; i++) {
			list.add(all.get(index[i]));
		}
		return list;
	}
	
	public static boolean conflicts(Partido obj) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(obj)) {
			returnValue = !(all.get(obj.id).numero == obj.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Partido obj) {
		tryAndCreate();
		return (all.containsKey(obj.id) || allByNumber.containsKey(obj.numero));
	}
	
	public static boolean exists(Integer id) {
		tryAndCreate();
		return all.containsKey(id);
	}
	
	public static boolean existsByNumber(Integer number) {
		tryAndCreate();
		return allByNumber.containsKey(number);
	}
	
	public static boolean existsByAcronym(String acronym) {
		tryAndCreate();
		return allByAcronym.containsKey(acronym);
	}
	
	public static boolean existsByName(String name) {
		tryAndCreate();
		return allByName.containsKey(name);
	}
	
	//Retorna um deputado de mesmo id que já esteja registrado
	public static Partido get(Partido obj) {
		Partido returnValue1 = null;
		Partido returnValue2 = null;
		tryAndCreate();
		if(exists(obj)) {
			returnValue1 = all.get(obj.id);
			returnValue2 = allByNumber.get(obj.numero);
			if((returnValue1.id != returnValue2.id) || (returnValue1.numero != returnValue2.numero)) {
				returnValue1 = returnValue2 = null;
			}
		}
		return returnValue1;
	}
	
	public static Partido get(Integer id) {
		Partido returnValue = null;
		tryAndCreate();
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static Partido getByNumber(Integer number) {
		Partido returnValue = null;
		tryAndCreate();
		if(existsByNumber(number)) {
			returnValue = allByNumber.get(number);
		}
		return returnValue;
	}
	
	public static Partido getByAcronym(String acronym) {
		Partido returnValue = null;
		tryAndCreate();
		if(existsByAcronym(acronym)) {
			returnValue = allByAcronym.get(acronym);
		}
		return returnValue;
	}
	
	public static Partido getByName(String name) {
		Partido returnValue = null;
		tryAndCreate();
		if(existsByName(name)) {
			returnValue = allByName.get(name);
		}
		return returnValue;
	}
	
	public static boolean isEmpty() {
		tryAndCreate();
		return all.isEmpty();
	}
	
	public static void register(Partido obj) {
		tryAndCreate();
		all.put(obj.id, obj);
		allByNumber.put(obj.numero, obj);
		allByAcronym.put(obj.sigla, obj);
		allByName.put(obj.nome, obj);
	}
	
	public static void unregister(Partido obj) {
		tryAndCreate();
		all.remove(obj.id);
		allByNumber.remove(obj.numero);
		allByAcronym.remove(obj.sigla);
		allByName.remove(obj.nome);
	}
	
	private static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Partido>();
		}
		
		if(allByNumber == null) {
			allByNumber = new HashMap<Integer, Partido>();
		}
		
		if(allByAcronym == null) {
			allByAcronym = new HashMap<String, Partido>();
		}
		
		if(allByName == null) {
			allByName = new HashMap<String, Partido>();
		}
	}
	
	public final boolean equals(Object obj) {
		boolean returnValue = false;
		if(obj instanceof Partido) {
			Partido pobj = (Partido) obj;
			if((this.id == pobj.id) && (this.numero == pobj.numero)) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	public String toString(boolean tabbed) {
		return String.format("%s\t%s\t%s\t%s", this.id.toString(), this.sigla, this.nome, this.numero.toString());
	}
	
	public String toString() {
		return String.format(this.sigla);
	}
}
