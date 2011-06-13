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
	
	/* Display */
	public void setDisplay(Stack<Component> reverselist) {
		JLabel vicenameLabel, vicenameValue;
		ImagePanel vicePhoto;
		Dimension size;
		
		vicenameLabel = new JLabel("Vice-presidente:");
		vicenameLabel.setBounds(10, 260, 130, 24);
		vicenameLabel.setVerticalAlignment(JLabel.TOP);
		vicenameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		vicenameValue = new JLabel(this.vice_nome);//Depende do Presidente
		vicenameValue.setBounds(130, 260, 230, 24);
		vicenameValue.setVerticalAlignment(JLabel.TOP);
		vicenameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		vicePhoto = new ImagePanel(Display.pathToImageIcon(FileUpload.uploadPath + this.vice_foto).getImage());//Depende do Presidente
		size = vicePhoto.getSize();
		vicePhoto.setBounds(365, 175, size.width, size.height);
		vicePhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		super.setDisplay(reverselist);
		
		reverselist.add(8, vicenameLabel);//8
		reverselist.add(9, vicenameValue);//9
		reverselist.add(15, vicePhoto);//15
	}
	
	//Métodos de controle da coleção de objetos para evitar recriação de objetos após consultas
	
	private static Map<Integer, Presidente> getAll() {
		return all;
	}
	
	public static boolean conflicts(Presidente p) {
		boolean returnValue = false;
		if(exists(p)) {
			returnValue = !(all.get(p.id).numero == p.numero);
		}
		return returnValue;
	}
	
	public static boolean exists(Presidente p) {
		return getAll().containsKey(p.id);
	}
	
	public static boolean exists(Integer id) {
		return getAll().containsKey(id);
	}
	
	//Retorna um presidente de mesmo id que já esteja registrado
	public static Presidente get(Presidente p) {
		Presidente returnValue = null;
		if(exists(p)) {
			returnValue = all.get(p.id);
		}
		return returnValue;
	}
	
	public static Presidente get(Integer id) {
		Presidente returnValue = null;
		if(exists(id)) {
			returnValue = all.get(id);
		}
		return returnValue;
	}
	
	public static boolean register(Presidente p) {
		boolean success = false;
		if(!exists(p)) {
			all.put(p.id, p);
			success = true;
		}
		return success;
	}

	public static boolean override(Presidente p) {
		boolean success = false;
		if(exists(p)) {
			all.put(p.id, p);
			success = true;
		}
		return success;
	}
}
