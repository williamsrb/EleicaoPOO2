package resources.lib.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resources.lib.other.ArrayCaster;

public final class Governador extends Candidato {
	private String vice_nome;
	private String vice_foto;
	
	private static Map<Integer, Governador> all; //By ID
	private static Map<Integer, Governador> allByNumber; //by Number
	
	//Construtor que usa gerador de id automático da classe mãe
	private Governador(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String vice_nome, String vice_foto) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, true);
		this.vice_nome = vice_nome;
		this.vice_foto = vice_foto;
	}
	
	//Construtor que NÃO usa gerador de id automático da classe mãe
	public Governador(Integer id, Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String vice_nome, String vice_foto) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, false);
		this.vice_nome = vice_nome;
		this.vice_foto = vice_foto;
		this.id = id;
	}
	
	//Construtor usado para testes
	public Governador() {
		this(new Integer(23));
	}
	
	public Governador(Integer number) {
		this(new Integer(-4), number, "Maria de Testes e Silva", new Partido("PT", "Partido do Teste", 23), new Cargo(new Integer(2), "Governador"), new Date(), 'F', "teste2.jpg", "http://www.mariateste.com.br", "Joana Vice dos Testes", "vice_teste2.jpg");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.nascimento = formatador.parse("01/01/2001");
		} catch (ParseException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Não foi possível obter a data a partir da entrada", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
			this.nascimento = null;
		}
	}

	/* Getters */
	public String getVice_nome() {
		return vice_nome;
	}
	
	public String getVice_foto() {
		return vice_foto;
	}
	
	//Métodos de controle da coleção de objetos paa evitar recriação de objetos após consultas
	public static List<Governador> getAll() {
		List<Governador> list = new ArrayList<Governador>();
		Integer index[] = ArrayCaster.objectCastInteger(all.keySet().toArray());
		int i, size = index.length;
		for(i = 0; i < size; i++) {
			list.add(all.get(index[i]));
		}
		return list;
	}
	
	public static boolean conflicts(Governador obj) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(obj)) {
			returnValue = !(all.get(obj.id).numero == obj.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Governador obj) {
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
	
	//Retorna um deputado de mesmo id que já esteja registrado
	public static Governador get(Governador obj) {
		Governador returnValue1 = null;
		Governador returnValue2 = null;
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
	
	public static Governador get(Integer id) {
		Governador returnValue = null;
		tryAndCreate();
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static Governador getByNumber(Integer number) {
		Governador returnValue = null;
		tryAndCreate();
		if(existsByNumber(number)) {
			returnValue = allByNumber.get(number);
		}
		return returnValue;
	}
	
	public static boolean isEmpty() {
		tryAndCreate();
		return all.isEmpty();
	}
	
	public static void register(Governador obj) {
		tryAndCreate();
		all.put(obj.id, obj);
		allByNumber.put(obj.numero, obj);
		Candidato.register(obj);
	}
	
	public static void unregister(Governador obj) {
		tryAndCreate();
		all.remove(obj.id);
		allByNumber.remove(obj.numero);
		Candidato.unregister(obj);
	}
	
	private static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Governador>();
		}
		if(allByNumber == null) {
			allByNumber = new HashMap<Integer, Governador>();
		}
	}
	
	public static boolean equals(Governador obj1, Governador obj2) {
		boolean returnValue = false;
		if((obj1.id == obj2.id) && (obj1.numero == obj2.numero)) {
			returnValue = true;
		}
		return returnValue;
	}
	
	public final boolean equals(Object obj) {
		boolean returnValue = false;
		if(obj instanceof Governador) {
			Governador gobj = (Governador) obj;
			if((this.id == gobj.id) && (this.numero == gobj.numero)) {
				returnValue = true;
			}
		}
		return returnValue;
	}
}