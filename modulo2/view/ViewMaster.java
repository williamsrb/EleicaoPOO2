package modulo2.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import modulo2.controller.App2Worker;
import modulo2.util.KeyEnum;

import resources.lib.controller.FileUpload;
import resources.lib.view.Display;
import resources.lib.view.ImagePanel;
import resources.lib.view.ScreenPanel;

public final class ViewMaster {
	//Retorna o "container" da tela da urna
	public static ScreenPanel buildInterface(Container pane, ButtonElements buttonList) {
		Dimension size;
		Stack<Component> reverselist = new Stack<Component>();
		
		//Todos elementos visuais
		JButton btnD0, btnD1, btnD2, btnD3, btnD4, btnD5, btnD6, btnD7, btnD8, btnD9, btnCGREEN, btnCRED, btnCWHITE;
		ImagePanel bg, glass, logo, digits;
		ScreenPanel screen;
		
		//Imagens dos botões
		ImageButton imgD0, imgD1, imgD2, imgD3, imgD4, imgD5, imgD6, imgD7, imgD8, imgD9, imgCGREEN, imgCRED, imgCWHITE;
		imgD0 = new ImageButton(KeyEnum.D0);
		imgD1 = new ImageButton(KeyEnum.D1);
		imgD2 = new ImageButton(KeyEnum.D2);
		imgD3 = new ImageButton(KeyEnum.D3);
		imgD4 = new ImageButton(KeyEnum.D4);
		imgD5 = new ImageButton(KeyEnum.D5);
		imgD6 = new ImageButton(KeyEnum.D6);
		imgD7 = new ImageButton(KeyEnum.D7);
		imgD8 = new ImageButton(KeyEnum.D8);
		imgD9 = new ImageButton(KeyEnum.D9);
		imgCGREEN = new ImageButton(KeyEnum.CGREEN);
		imgCRED = new ImageButton(KeyEnum.CRED);
		imgCWHITE = new ImageButton(KeyEnum.CWHITE);
		
		//Imagens dos painéis
		bg = new ImagePanel(Display.pathToImageIcon(FileUpload.imagePath + "caixa.png").getImage());
		glass = new ImagePanel(Display.pathToImageIcon(FileUpload.imagePath + "tela.png").getImage());
		logo = new ImagePanel(Display.pathToImageIcon(FileUpload.imagePath + "rotulo.png").getImage());
		digits = new ImagePanel(Display.pathToImageIcon(FileUpload.imagePath + "painel.png").getImage());
		
		//Painel de exibição do conteúdo da tela da urna
		screen = new ScreenPanel();
		
		//Dimensões e posicionamento
		size = bg.getSize();
		bg.setBounds(0, 0, size.width, size.height);
		
		size = glass.getSize();
		glass.setBounds(40, 50, size.width, size.height);
		glass.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, new Color(120, 120, 120), new Color(120, 120, 120), new Color(220, 220, 220), new Color(220, 220, 220)));
		
		screen.setBackground(Color.white);
		screen.setBounds(glass.getBounds());
		screen.setLayout(null);
		
		size = logo.getSize();
		logo.setBounds(510, 50, size.width, size.height);
		
		size = digits.getSize();
		digits.setBounds(510, 130, size.width, size.height);
		
		size = imgD1.getSize();
		btnD1 = new JButton(imgD1.getNone());
		btnD1.setBorderPainted(false);
		btnD1.setSize(size);
		btnD1.setPreferredSize(size);
		btnD1.setPressedIcon(imgD1.getShadow());
		btnD1.setRolloverIcon(imgD1.getLight());
		btnD1.setBounds(535, 162, size.width, size.height);
		
		size = imgD2.getSize();
		btnD2 = new JButton(imgD2.getNone());
		btnD2.setBorderPainted(false);
		btnD2.setSize(size);
		btnD2.setPreferredSize(size);
		btnD2.setPressedIcon(imgD2.getShadow());
		btnD2.setRolloverIcon(imgD2.getLight());
		btnD2.setBounds(615, 162, size.width, size.height);
		
		size = imgD3.getSize();
		btnD3 = new JButton(imgD3.getNone());
		btnD3.setBorderPainted(false);
		btnD3.setSize(size);
		btnD3.setPreferredSize(size);
		btnD3.setPressedIcon(imgD3.getShadow());
		btnD3.setRolloverIcon(imgD3.getLight());
		btnD3.setBounds(695, 162, size.width, size.height);
		
		size = imgD4.getSize();
		btnD4 = new JButton(imgD4.getNone());
		btnD4.setBorderPainted(false);
		btnD4.setSize(size);
		btnD4.setPreferredSize(size);
		btnD4.setPressedIcon(imgD4.getShadow());
		btnD4.setRolloverIcon(imgD4.getLight());
		btnD4.setBounds(535, 216, size.width, size.height);
		
		size = imgD5.getSize();
		btnD5 = new JButton(imgD5.getNone());
		btnD5.setBorderPainted(false);
		btnD5.setSize(size);
		btnD5.setPreferredSize(size);
		btnD5.setPressedIcon(imgD5.getShadow());
		btnD5.setRolloverIcon(imgD5.getLight());
		btnD5.setBounds(615, 216, size.width, size.height);
		
		size = imgD6.getSize();
		btnD6 = new JButton(imgD6.getNone());
		btnD6.setBorderPainted(false);
		btnD6.setSize(size);
		btnD6.setPreferredSize(size);
		btnD6.setPressedIcon(imgD6.getShadow());
		btnD6.setRolloverIcon(imgD6.getLight());
		btnD6.setBounds(695, 216, size.width, size.height);
		
		size = imgD7.getSize();
		btnD7 = new JButton(imgD7.getNone());
		btnD7.setBorderPainted(false);
		btnD7.setSize(size);
		btnD7.setPreferredSize(size);
		btnD7.setPressedIcon(imgD7.getShadow());
		btnD7.setRolloverIcon(imgD7.getLight());
		btnD7.setBounds(535, 270, size.width, size.height);
		
		size = imgD8.getSize();
		btnD8 = new JButton(imgD8.getNone());
		btnD8.setBorderPainted(false);
		btnD8.setSize(size);
		btnD8.setPreferredSize(size);
		btnD8.setPressedIcon(imgD8.getShadow());
		btnD8.setRolloverIcon(imgD8.getLight());
		btnD8.setBounds(615, 270, size.width, size.height);
		
		size = imgD9.getSize();
		btnD9 = new JButton(imgD9.getNone());
		btnD9.setBorderPainted(false);
		btnD9.setSize(size);
		btnD9.setPreferredSize(size);
		btnD9.setPressedIcon(imgD9.getShadow());
		btnD9.setRolloverIcon(imgD9.getLight());
		btnD9.setBounds(695, 270, size.width, size.height);
		
		size = imgD0.getSize();
		btnD0 = new JButton(imgD0.getNone());
		btnD0.setBorderPainted(false);
		btnD0.setSize(size);
		btnD0.setPreferredSize(size);
		btnD0.setPressedIcon(imgD0.getShadow());
		btnD0.setRolloverIcon(imgD0.getLight());
		btnD0.setBounds(615, 324, size.width, size.height);
		
		size = imgCWHITE.getSize();
		btnCWHITE = new JButton(imgCWHITE.getNone());
		btnCWHITE.setBorderPainted(false);
		btnCWHITE.setSize(size);
		btnCWHITE.setPreferredSize(size);
		btnCWHITE.setPressedIcon(imgCWHITE.getShadow());
		btnCWHITE.setRolloverIcon(imgCWHITE.getLight());
		btnCWHITE.setBounds(535, 378, size.width, size.height);
		
		size = imgCRED.getSize();
		btnCRED = new JButton(imgCRED.getNone());
		btnCRED.setBorderPainted(false);
		btnCRED.setSize(size);
		btnCRED.setPreferredSize(size);
		btnCRED.setPressedIcon(imgCRED.getShadow());
		btnCRED.setRolloverIcon(imgCRED.getLight());
		btnCRED.setBounds(615, 378, size.width, size.height);
		
		size = imgCGREEN.getSize();
		btnCGREEN = new JButton(imgCGREEN.getNone());
		btnCGREEN.setBorderPainted(false);
		btnCGREEN.setSize(size);
		btnCGREEN.setPreferredSize(size);
		btnCGREEN.setPressedIcon(imgCGREEN.getShadow());
		btnCGREEN.setRolloverIcon(imgCGREEN.getLight());
		btnCGREEN.setBounds(695, 378, size.width, size.height);
		
		//Simulando camadas. Inferiores vêm primeiro
		reverselist.push(buttonList);
		reverselist.push(bg);
		reverselist.push(screen);
		reverselist.push(glass);
		reverselist.push(logo);
		reverselist.push(digits);
		reverselist.push(buttonList.setBtnD1(btnD1));
		reverselist.push(buttonList.setBtnD2(btnD2));
		reverselist.push(buttonList.setBtnD3(btnD3));
		reverselist.push(buttonList.setBtnD4(btnD4));
		reverselist.push(buttonList.setBtnD5(btnD5));
		reverselist.push(buttonList.setBtnD6(btnD6));
		reverselist.push(buttonList.setBtnD7(btnD7));
		reverselist.push(buttonList.setBtnD8(btnD8));
		reverselist.push(buttonList.setBtnD9(btnD9));
		reverselist.push(buttonList.setBtnD0(btnD0));
		reverselist.push(buttonList.setBtnCWHITE(btnCWHITE));
		reverselist.push(buttonList.setBtnCRED(btnCRED));
		reverselist.push(buttonList.setBtnCGREEN(btnCGREEN));
		
		//Setando elementos no panel pela ordem de camadas
		Display.preparePanel(pane, reverselist);
		return screen;
	}
	
	public static void buildListeners(ButtonElements buttonList) {
		final Container parent = buttonList.getParent();
		buttonList.getBtnD1().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D1);
			}
		});
		buttonList.getBtnD2().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D2);
			}
		});
		buttonList.getBtnD3().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D3);
			}
		});
		buttonList.getBtnD4().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D4);
			}
		});
		buttonList.getBtnD5().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D5);
			}
		});
		buttonList.getBtnD6().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D6);
			}
		});
		buttonList.getBtnD7().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D7);
			}
		});
		buttonList.getBtnD8().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D8);
			}
		});
		buttonList.getBtnD9().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D9);
			}
		});
		buttonList.getBtnD0().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.D0);
			}
		});
		buttonList.getBtnCWHITE().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.CWHITE);
			}
		});
		buttonList.getBtnCRED().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.CRED);
			}
		});
		buttonList.getBtnCGREEN().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.requestFocus();
				App2Worker.getInstance().doButtonAction(KeyEnum.CGREEN);
			}
		});
	}
}