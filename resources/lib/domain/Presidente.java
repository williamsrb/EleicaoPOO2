package resources.lib.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Presidente extends Candidato {
	private String vice_nome;
	private String vice_foto;
	
	private static Map<Integer, Presidente> all; //By ID
	private static Map<Integer, Presidente> allByNumber; //by Number
	
	//Construtor que usa gerador de id automático da classe mãe
	public Presidente(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String vice_nome, String vice_foto) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, true);
		this.vice_nome = vice_nome;
		this.vice_foto = vice_foto;
	}
	
	//Construtor que NÃO usa gerador de id automático da classe mãe
	public Presidente(Integer id, Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String vice_nome, String vice_foto) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, false);
		this.vice_nome = vice_nome;
		this.vice_foto = vice_foto;
		this.id = id;
	}
	
	//Construtor usado para testes
	public Presidente() {
		this(new Integer(-4), new Integer(45), "Silvia Teste e Testes", new Partido("PDT", "Partido dos Testes", 45), new Cargo(new Integer(2), "Presidente"), new Date(), 'F', "teste3.jpg", "http://www.silvia.pdt.com.br", "Testatina Testicolina", "vice_teste3.jpg");
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
	public static boolean conflicts(Presidente obj) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(obj)) {
			returnValue = !(all.get(obj.id).numero == obj.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Presidente obj) {
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
	public static Presidente get(Presidente obj) {
		Presidente returnValue1 = null;
		Presidente returnValue2 = null;
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
	
	public static Presidente get(Integer id) {
		Presidente returnValue = null;
		tryAndCreate();
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static Presidente getByNumber(Integer number) {
		Presidente returnValue = null;
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
	
	public static void register(Presidente obj) {
		tryAndCreate();
		all.put(obj.id, obj);
		allByNumber.put(obj.numero, obj);
	}
	
	public static void unregister(Presidente obj) {
		tryAndCreate();
		all.remove(obj.id);
		allByNumber.remove(obj.numero);
	}
	
	private static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Presidente>();
		}
		if(allByNumber == null) {
			allByNumber = new HashMap<Integer, Presidente>();
		}
	}
	
	public static boolean equals(Presidente obj1, Presidente obj2) {
		boolean returnValue = false;
		if((obj1.id == obj2.id) && (obj1.numero == obj2.numero)) {
			returnValue = true;
		}
		return returnValue;
	}
	
	public final boolean equals(Object obj) {
		boolean returnValue = false;
		if(obj instanceof Presidente) {
			Presidente pobj = (Presidente) obj;
			if((this.id == pobj.id) && (this.numero == pobj.numero)) {
				returnValue = true;
			}
		}
		return returnValue;
	}
}