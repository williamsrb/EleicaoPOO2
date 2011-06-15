package resources.lib.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Governador extends Candidato {
	private String vice_nome;
	private String vice_foto;
	
	private static Map<Integer, Governador> all;
	
	//Construtor que usa gerador de id automático da classe mãe
	public Governador(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String vice_nome, String vice_foto) {
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
		this(new Integer(-4), new Integer(23), "Maria de Testes e Silva", new Partido("PT", "Partido do Teste", 23), new Cargo(new Integer(2), "Governador"), new Date(), 'F', "teste2.jpg", "http://www.mariateste.com.br", "Joana Vice dos Testes", "vice_teste2.jpg");
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
	
	private static Map<Integer, Governador> getAll() {
		tryAndCreate();
		return all;
	}
	
	public static boolean conflicts(Governador g) {
		boolean returnValue = false;
		tryAndCreate();
		if(exists(g)) {
			returnValue = !(all.get(g.id).numero == g.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Governador g) {
		tryAndCreate();
		return getAll().containsKey(g.id);
	}
	
	public static boolean exists(Integer id) {
		tryAndCreate();
		return getAll().containsKey(id);
	}
	
	//Retorna um governador de mesmo id que já esteja registrado
	public static Governador get(Governador g) {
		Governador returnValue = null;
		tryAndCreate();
		if(exists(g)) {
			returnValue = all.get(g.id);
		}
		return returnValue;
	}
	
	public static Governador get(Integer id) {
		Governador returnValue = null;
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
	
	public static void register(Governador g) {
		tryAndCreate();
		all.put(g.id, g);
	}
	
	public static void unregister(Governador g) {
		tryAndCreate();
		all.remove(g.id);
	}
	
	public static void tryAndCreate() {
		if(all == null) {
			all = new HashMap<Integer, Governador>();
		}
	}
}
 
