package resources.lib.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class Deputado extends Candidato {
	private String apelido;
	
	private static Map<Integer, Deputado> all; //By ID
	private static Map<Integer, Deputado> allByNumber; //by Number
	
	//Construtor que usa gerador de id automático da classe mãe. Usado pelo controller para criar objetos desse tipo, em o id, que só gerado no banco de dados
	private Deputado(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String apelido) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, true);
		this.apelido = apelido;
	}
	
	//Construtor que NÃO usa gerador de id automático da classe mãe. Usado pelo controller para criar objetos a partir de dados existentes no banco de dados
	public Deputado(Integer id, Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String apelido) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, false);
		this.apelido = apelido;
		this.id = id;
	}
	
	//Construtor usado para testes
	public Deputado() {
		this(new Integer(12345));
	}
	
	public Deputado(Integer number) {
		this(new Integer(-4), number, "Testentina dos Testes Testosos", new Partido("PN", "Partido do Nada", 12), new Cargo(new Integer(5), "Deputado"), new Date(), 'F', "teste1.jpg", "http://www.testezinha.com.br", "Testezinha");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.nascimento = formatador.parse("01/01/2001");
		} catch (ParseException e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Não foi possível obter a data a partir da entrada", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
			this.nascimento = null;
		}
	}

	/* Getters */
	public String getApelido() {
		return this.apelido;
	}
	
	//Métodos de controle da coleção de objetos paa evitar recriação de objetos após consultas
	public static boolean conflicts(Deputado d) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(d)) {
			returnValue = !(all.get(d.id).numero == d.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Deputado d) {
		tryAndCreate();
		return (all.containsKey(d.id) || allByNumber.containsKey(d.numero));
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
	public static Deputado get(Deputado d) {
		Deputado returnValue1 = null;
		Deputado returnValue2 = null;
		tryAndCreate();
		if(exists(d)) {
			returnValue1 = all.get(d.id);
			returnValue2 = allByNumber.get(d.numero);
			if((returnValue1.id != returnValue2.id) || (returnValue1.numero != returnValue2.numero)) {
				returnValue1 = returnValue2 = null;
			}
		}
		return returnValue1;
	}
	
	public static Deputado get(Integer id) {
		Deputado returnValue = null;
		tryAndCreate();
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static Deputado getByNumber(Integer number) {
		Deputado returnValue = null;
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
	
	public static void register(Deputado obj) {
		tryAndCreate();
		all.put(obj.id, obj);
		allByNumber.put(obj.numero, obj);
	}
	
	public static void unregister(Deputado obj) {
		tryAndCreate();
		all.remove(obj.id);
		allByNumber.remove(obj.numero);
	}
	
	private static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Deputado>();
		}
		if(allByNumber == null) {
			allByNumber = new HashMap<Integer, Deputado>();
		}
	}
	
	public static boolean equals(Deputado obj1, Deputado obj2) {
		boolean returnValue = false;
		if((obj1.id == obj2.id) && (obj1.numero == obj2.numero)) {
			returnValue = true;
		}
		return returnValue;
	}
	
	public final boolean equals(Object obj) {
		boolean returnValue = false;
		if(obj instanceof Deputado) {
			Deputado dobj = (Deputado) obj;
			if((this.id == dobj.id) && (this.numero == dobj.numero)) {
				returnValue = true;
			}
		}
		return returnValue;
	}
	
	public String toString() {
		//Integer id
		//Integer number
		//String name
		//Partido partido
		//Cargo cargo
		//Date nascimento
		//Character sexo
		//String foto
		//String site
		//String apelido
		return String.format("Id:%s Numero:%s Nome:%s Partido:%s Cargo:%s Nascimento:%s Sexo:%s Foto:%s Site:%s Apelido:%s", this.id.toString(), this.numero.toString(), this.nome, this.partido.getId().toString(), this.cargo.getId().toString(), this.nascimento.toString(), this.sexo.toString(), this.foto, this.site, this.apelido);
	}
}