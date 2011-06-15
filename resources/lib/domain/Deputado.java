package resources.lib.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Deputado extends Candidato {
	private String apelido;
	
	private static Map<Integer, Deputado> all;
	
	//Construtor que usa gerador de id automático da classe mãe. Usado pelo controller para criar objetos desse tipo, em o id, que só gerado no banco de dados
	public Deputado(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String apelido) {
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
		this(new Integer(-4), new Integer(12345), "Testentina dos Testes Testosos", new Partido("PN", "Partido do Nada", 12), new Cargo(new Integer(5), "Deputado"), new Date(), 'F', "teste1.jpg", "http://www.testezinha.com.br", "Testezinha");
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
	
	private static Map<Integer, Deputado> getAll() {
		tryAndCreate();
		return all;
	}
	
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
		return getAll().containsKey(d.id);
	}
	
	public static boolean exists(Integer id) {
		tryAndCreate();
		return getAll().containsKey(id);
	}
	
	//Retorna um deputado de mesmo id que já esteja registrado
	public static Deputado get(Deputado d) {
		Deputado returnValue = null;
		tryAndCreate();
		if(exists(d)) {
			returnValue = all.get(d.id);
		}
		return returnValue;
	}
	
	public static Deputado get(Integer id) {
		Deputado returnValue = null;
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
	
	public static void register(Deputado d) {
		tryAndCreate();
		all.put(d.id, d);
	}
	
	public static void unregister(Deputado d) {
		tryAndCreate();
		all.remove(d.id);
	}
	
	public static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Deputado>();
		}
	}
}
 
