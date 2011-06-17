package modulo2.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import resources.lib.controller.FileUpload;
import resources.lib.domain.Governador;
import resources.lib.view.Display;
import resources.lib.view.ImagePanel;

public final class GovernadorView extends CandidatoView {
	/* Display */
	public void setDisplay(Stack<Component> reverselist, Governador pessoa) {
		JLabel vicenameLabel, vicenameValue;
		ImagePanel vicePhoto;
		Dimension size;
		
		vicenameLabel = new JLabel("Vice-governador:");
		vicenameLabel.setBounds(10, 260, 130, 24);
		vicenameLabel.setVerticalAlignment(JLabel.TOP);
		vicenameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		vicenameValue = new JLabel(pessoa.getVice_nome());//Depende do Governador
		vicenameValue.setBounds(135, 260, 230, 24);
		vicenameValue.setVerticalAlignment(JLabel.TOP);
		vicenameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		vicePhoto = new ImagePanel(Display.pathToImageIcon(FileUpload.uploadPath + pessoa.getVice_foto()).getImage());//Depende do Governador
		size = vicePhoto.getSize();
		vicePhoto.setBounds(365, 175, size.width, size.height);
		vicePhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		super.setDisplay(reverselist, pessoa);
		
		reverselist.add(8, vicenameLabel);//8
		reverselist.add(9, vicenameValue);//9
		reverselist.add(15, vicePhoto);//15
	}
	
	public void setPreDisplay(Stack<Component> reverselist) {
		JLabel vicenameLabel, vicenameValue;
		ImagePanel vicePhoto;
		Dimension size;
		
		Governador pessoa = new Governador(); //Construtor de testes, já que nenhum dado pessoal será usado
		
		vicenameLabel = new JLabel(/*"Vice-governador:"*/);//Oculto
		vicenameLabel.setBounds(10, 260, 130, 24);
		vicenameLabel.setVerticalAlignment(JLabel.TOP);
		vicenameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
		
		vicenameValue = new JLabel();//Em branco
		vicenameValue.setBounds(130, 260, 230, 24);
		vicenameValue.setVerticalAlignment(JLabel.TOP);
		vicenameValue.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		
		vicePhoto = new ImagePanel(Display.pathToImageIcon(FileUpload.uploadPath + "mini_transparent.png").getImage());//Em branco
		size = vicePhoto.getSize();
		vicePhoto.setBounds(365, 175, size.width, size.height);
		vicePhoto.setBorder(BorderFactory.createLineBorder(Color.black));
		
		super.setPreDisplay(reverselist, pessoa);
		
		reverselist.add(8, vicenameLabel);//8
		reverselist.add(9, vicenameValue);//9
		reverselist.add(15, vicePhoto);//15
	}
}