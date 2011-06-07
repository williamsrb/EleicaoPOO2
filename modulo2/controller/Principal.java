package modulo2.controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import modulo2.view.ViewMaster;

public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1000L;
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Principal();
			}
		});
	}

	private Principal() {
		super("Urna Eletrônica");
		JOptionPane.showMessageDialog(null, "Intruções:\n     \u2190  Branco\n     \u2193  Cancela\n     \u2192  Confirma", "Ajuda", JOptionPane.INFORMATION_MESSAGE);
		start();
	}

	public void start() {
		Insets frameInsets;
		Dimension size;
		Container pane;
		
		pane = getContentPane();
		pane.setFocusable(true);
		pane.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				keyPressedEvent(e);
			}
			public void keyReleased(KeyEvent e) {
				//keyReleasedEvent(e);
			}
			public void keyTyped(KeyEvent e) {
				//keyTypedEvent(e);
			}
		});
		setResizable(false);
		setVisible(true);
		frameInsets = getInsets();
		setVisible(false);
		size = new Dimension(800 + frameInsets.left, 500 + frameInsets.top);
		
		pane.setSize(size);
		pane.setLayout(null);
		
		ViewMaster.buildInterface(this);
		
		setSize(pane.getWidth(), pane.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void keyReleasedEvent(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_1:
		case KeyEvent.VK_NUMPAD1:
			//Fazer algo com dígito 1
			JOptionPane.showMessageDialog(null, "1");
			break;
		case KeyEvent.VK_2:
		case KeyEvent.VK_NUMPAD2:
			//Fazer algo com dígito 2
			JOptionPane.showMessageDialog(null, "2");
			break;
		case KeyEvent.VK_3:
		case KeyEvent.VK_NUMPAD3:
			//Fazer algo com dígito 3
			JOptionPane.showMessageDialog(null, "3");
			break;
		case KeyEvent.VK_4:
		case KeyEvent.VK_NUMPAD4:
			//Fazer algo com dígito 4
			JOptionPane.showMessageDialog(null, "4");
			break;
		case KeyEvent.VK_5:
		case KeyEvent.VK_NUMPAD5:
			//Fazer algo com dígito 5
			JOptionPane.showMessageDialog(null, "5");
			break;
		case KeyEvent.VK_6:
		case KeyEvent.VK_NUMPAD6:
			//Fazer algo com dígito 6
			JOptionPane.showMessageDialog(null, "6");
			break;
		case KeyEvent.VK_7:
		case KeyEvent.VK_NUMPAD7:
			//Fazer algo com dígito 7
			JOptionPane.showMessageDialog(null, "7");
			break;
		case KeyEvent.VK_8:
		case KeyEvent.VK_NUMPAD8:
			//Fazer algo com dígito 8
			JOptionPane.showMessageDialog(null, "8");
			break;
		case KeyEvent.VK_9:
		case KeyEvent.VK_NUMPAD9:
			//Fazer algo com dígito 9
			JOptionPane.showMessageDialog(null, "9");
			break;
		case KeyEvent.VK_0:
		case KeyEvent.VK_NUMPAD0:
			//Fazer algo com dígito 0
			JOptionPane.showMessageDialog(null, "0");
			break;
		case KeyEvent.VK_LEFT:
			//Fazer algo com tecla "Branco"
			JOptionPane.showMessageDialog(null, "Branco");
			break;
		case KeyEvent.VK_DOWN:
			//Fazer algo com tecla "Cancela"
			JOptionPane.showMessageDialog(null, "Cancela");
			break;
		case KeyEvent.VK_RIGHT:
			//Fazer algo com tecla "Confirma"
			JOptionPane.showMessageDialog(null, "Confirma");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Entrou com: " + e.getKeyChar());
		}
		
	}
	
	public void keyPressedEvent(KeyEvent e) {}

	public void keyTypedEvent(KeyEvent e) {}
}
