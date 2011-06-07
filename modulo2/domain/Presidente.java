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

import modulo2.util.Display;
import modulo2.util.FileUpload;
import modulo2.view.ImagePanel;

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
		this(new Integer(-1), new Integer(45), "Silvia Teste e Testes", new Partido("PDT", "Partido dos Testes", 45), new Cargo(new Integer(2), "Presidente"), new Date(), 'F', "teste3.jpg", "http://www.silvia.pdt.com.br", "Testatina Testicolina", "vice_teste3.jpg");
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
}
