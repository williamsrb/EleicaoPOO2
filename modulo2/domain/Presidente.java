package modulo2.domain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modulo2.ImagePanel;
import modulo2.View;

public class Presidente extends Candidato {
	private String vice_nome;
	private String vice_foto;
	
	//Construtor que usa gerador de id automático da classe mãe
	private Presidente(Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String vice_nome, String vice_foto) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, true);
		this.vice_nome = vice_nome;
		this.vice_foto = vice_foto;
	}
	
	//Construtor que NÃO usa gerador de id automático da classe mãe
	private Presidente(Integer id, Integer number, String name, Partido partido, Cargo cargo, Date nascimento, Character sexo, String foto, String site, String vice_nome, String vice_foto) {
		super(number, name, partido, cargo, nascimento, sexo, foto, site, false);
		this.vice_nome = vice_nome;
		this.vice_foto = vice_foto;
		this.id = id;
	}
	
	//Construtor usado para testes
	public Presidente() {
		this(new Integer(-1), new Integer(12345), "Testentina dos Testes Testosos", new Partido("PN", "Partido do Nada", 12), new Cargo(new Integer(5), "Deputado"), new Date(), 'F', "teste1.jpg", "http://www.testezinha.com.br", "Joana Vice dos Testes", "vice_teste1.jpg");
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
	public void setDisplay(JPanel pane) {
		JLabel vicenameLabel, vicenameValue;
		ImagePanel vicePhoto;
		Dimension size;
		
		Stack<Component> reverselist = new Stack<Component>();
		
		this.displaylist = reverselist;
		displayCandidate((Candidato)person);
		
		vicenameLabel = new JLabel("Vice-governador:");
		vicenameLabel.setBounds(10+50, 200+50, 50, 24);
		vicenameLabel.setVerticalAlignment(JLabel.TOP);
		vicenameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		vicenameValue = new JLabel(person.getVice_nome());//Depende do Governador
		vicenameValue.setBounds(65+50, 200+50, 230, 24);
		vicenameValue.setVerticalAlignment(JLabel.TOP);
		vicenameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		vicePhoto = new ImagePanel(View.pathToImageIcon(this.defaultPath + person.getVice_foto()).getImage());//Depende do Governador
		size = vicePhoto.getSize();
		vicePhoto.setBounds(320-100, 10+100, size.width, size.height);
		vicePhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		reverselist.add(8, vicenameLabel);//8
		reverselist.add(9, vicenameValue);//9
		reverselist.add(15, vicePhoto);//15
		View.preparePanel(this.screenPanel, reverselist);
	}
}
