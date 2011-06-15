package resources.lib.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Presidente extends Candidato {
	private String vice_nome;
	private String vice_foto;
	
	private static Map<Integer, Presidente> all;
	
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
	
	//Métodos de controle da coleção de objetos para evitar recriação de objetos após consultas
	
	private static Map<Integer, Presidente> getAll() {
		tryAndCreate();
		return all;
	}
	
	public static boolean conflicts(Presidente p) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(p)) {
			returnValue = !(all.get(p.id).numero == p.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Presidente p) {
		tryAndCreate();
		return getAll().containsKey(p.id);
	}
	
	public static boolean exists(Integer id) {
		tryAndCreate();
		return getAll().containsKey(id);
	}
	
	//Retorna um presidente de mesmo id que já esteja registrado
	public static Presidente get(Presidente p) {
		Presidente returnValue = null;
		tryAndCreate();
		if(exists(p)) {
			returnValue = all.get(p.id);
		}
		return returnValue;
	}
	
	public static Presidente get(Integer id) {
		Presidente returnValue = null;
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
	
	public static void register(Presidente p) {
		tryAndCreate();
		all.put(p.id, p);
	}
	
	public static void unregister(Presidente p) {
		tryAndCreate();
		all.remove(p.id);
	}
	
	public static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Presidente>();
		}
	}
}
 
