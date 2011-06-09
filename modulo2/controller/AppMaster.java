package modulo2.controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import modulo2.view.ButtonElements;
import modulo2.view.ViewMaster;

public class AppMaster extends JFrame {
	
	private static final long serialVersionUID = 1000L;
	private boolean eventMonitor;
	private ButtonElements buttonList;
	
	public static void main(String[] args){
		JOptionPane.showMessageDialog(null, "Intruções:\n     \u2190  Branco\n     \u2193  Cancela\n     \u2192  Confirma", "Ajuda", JOptionPane.INFORMATION_MESSAGE);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new AppMaster();
			}
		});
	}

	private AppMaster() {
		super("Urna Eletrônica");
		this.eventMonitor = false;
		start();
	}
	
	public synchronized void eventSwitch() {
		this.eventMonitor = !this.eventMonitor;
	}
	
	public synchronized boolean getEventMonitor() {
		return this.eventMonitor;
	}

	public void start() {
		Insets frameInsets;
		Dimension size;
		Container pane;
		ButtonElements btnLst;
		
		pane = getContentPane();
		pane.setFocusable(true);
		pane.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if(getEventMonitor() == false) {
					eventSwitch();
					keyUseEvent(e);
					eventSwitch();
				}
			}
			public void keyReleased(KeyEvent e) {
				if(getEventMonitor() == false) {
					eventSwitch();
					keyUseEvent(e);
					eventSwitch();
				}
			}
			public void keyTyped(KeyEvent e) {
				if(getEventMonitor() == false) {
					eventSwitch();
					keyUseEvent(e);
					eventSwitch();
				}
			}
		});
		setResizable(false);
		setVisible(true);
		frameInsets = getInsets();
		setVisible(false);
		size = new Dimension(800 + frameInsets.left, 500 + frameInsets.top);
		
		pane.setSize(size);
		pane.setLayout(null);
		
		this.buttonList = new ButtonElements();
		btnLst = this.buttonList;
		
		ViewMaster.buildInterface(pane, btnLst);
		ViewMaster.buildListeners(btnLst);
		
		setSize(pane.getWidth(), pane.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void keyUseEvent(KeyEvent e) {
		ButtonElements buttonList = this.buttonList;
		switch(e.getKeyCode()) {
		case KeyEvent.VK_1:
		case KeyEvent.VK_NUMPAD1:
			//Fazer algo com dígito 1
			buttonList.getBtnD1().doClick();
			break;
		case KeyEvent.VK_2:
		case KeyEvent.VK_NUMPAD2:
			//Fazer algo com dígito 2
			buttonList.getBtnD2().doClick();
			break;
		case KeyEvent.VK_3:
		case KeyEvent.VK_NUMPAD3:
			//Fazer algo com dígito 3
			buttonList.getBtnD3().doClick();
			break;
		case KeyEvent.VK_4:
		case KeyEvent.VK_NUMPAD4:
			//Fazer algo com dígito 4
			buttonList.getBtnD4().doClick();
			break;
		case KeyEvent.VK_5:
		case KeyEvent.VK_NUMPAD5:
			//Fazer algo com dígito 5
			buttonList.getBtnD5().doClick();
			break;
		case KeyEvent.VK_6:
		case KeyEvent.VK_NUMPAD6:
			//Fazer algo com dígito 6
			buttonList.getBtnD6().doClick();
			break;
		case KeyEvent.VK_7:
		case KeyEvent.VK_NUMPAD7:
			//Fazer algo com dígito 7
			buttonList.getBtnD7().doClick();
			break;
		case KeyEvent.VK_8:
		case KeyEvent.VK_NUMPAD8:
			//Fazer algo com dígito 8
			buttonList.getBtnD8().doClick();
			break;
		case KeyEvent.VK_9:
		case KeyEvent.VK_NUMPAD9:
			//Fazer algo com dígito 9
			buttonList.getBtnD9().doClick();
			break;
		case KeyEvent.VK_0:
		case KeyEvent.VK_NUMPAD0:
			//Fazer algo com dígito 0
			buttonList.getBtnD0().doClick();
			break;
		case KeyEvent.VK_LEFT:
			//Fazer algo com tecla "Branco"
			buttonList.getBtnCWHITE().doClick();
			break;
		case KeyEvent.VK_DOWN:
			//Fazer algo com tecla "Cancela"
			buttonList.getBtnCRED().doClick();
			break;
		case KeyEvent.VK_RIGHT:
			//Fazer algo com tecla "Confirma"
			buttonList.getBtnCGREEN().doClick();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Entrou com: " + e.getKeyChar());
		}
	}
}
