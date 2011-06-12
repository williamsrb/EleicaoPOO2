package resources.lib.domain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import resources.lib.controller.FileUpload;
import resources.lib.view.Display;
import resources.lib.view.ImagePanel;

public class Governador extends Candidato {
	private String vice_nome;
	private String vice_foto;
	
	private static Map<Integer, Governador> all;
	
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
	
	/* Display */
	public void setDisplay(Stack<Component> reverselist) {
		JLabel vicenameLabel, vicenameValue;
		ImagePanel vicePhoto;
		Dimension size;
		
		vicenameLabel = new JLabel("Vice-governador:");
		vicenameLabel.setBounds(10, 260, 130, 24);
		vicenameLabel.setVerticalAlignment(JLabel.TOP);
		vicenameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		vicenameValue = new JLabel(this.vice_nome);//Depende do Governador
		vicenameValue.setBounds(135, 260, 230, 24);
		vicenameValue.setVerticalAlignment(JLabel.TOP);
		vicenameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		vicePhoto = new ImagePanel(Display.pathToImageIcon(FileUpload.uploadPath + this.vice_foto).getImage());//Depende do Governador
		size = vicePhoto.getSize();
		vicePhoto.setBounds(365, 175, size.width, size.height);
		vicePhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		super.setDisplay(reverselist);
		
		reverselist.add(8, vicenameLabel);//8
		reverselist.add(9, vicenameValue);//9
		reverselist.add(15, vicePhoto);//15
	}
	
	//Métodos de controle da coleção de objetos para evitar recriação de objetos após consultas
	
	private static Map<Integer, Governador> getAll() {
		return all;
	}
	
	public static boolean conflicts(Governador g) {
		boolean returnValue = false;
		if(exists(g)) {
			returnValue = !(all.get(g.id).numero == g.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Governador g) {
		return getAll().containsKey(g.id);
	}
	
	public static boolean exists(Integer id) {
		return getAll().containsKey(id);
	}
	
	//Retorna um governador de mesmo id que já esteja registrado
	public static Governador get(Governador g) {
		Governador returnValue = null;
		if(exists(g)) {
			returnValue = all.get(g.id);
		}
		return returnValue;
	}
	
	public static Governador get(Integer id) {
		Governador returnValue = null;
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static boolean register(Governador g) {
		boolean success = false;
		if(!exists(g)) {
			all.put(g.id, g);
			success = true;
		}
		return success;
	}

	public static boolean override(Governador g) {
		boolean success = false;
		if(exists(g)) {
			all.put(g.id, g);
			success = true;
		}
		return success;
	}
}
