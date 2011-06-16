package modulo2.controller;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import modulo2.persistence.DatabaseOperations;
import modulo2.view.ButtonElements;
import modulo2.view.ViewMaster;
import resources.lib.domain.persistence.*;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public final class App2Master extends JFrame {
	private static final long serialVersionUID = 1000L;
	private boolean eventMonitor;
	private ButtonElements buttonList;
	private CargoDAO cargoDAO;
	private DeputadoDAO deputadoDAO;
	private GovernadorDAO governadorDAO;
	private PartidoDAO partidoDAO;
	private PresidenteDAO presidenteDAO;
	
	public static void main(String[] args){
		//Deve estar bloqueado e pedir senha
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new App2Master();
			}
		});
	}

	private App2Master() {
		Object[] options = {"Relatórios", "Votar"};
		int opt, errorCounter = 0;
		boolean valid;
		if(!this.isStorageReady()) {
			JOptionPane.showMessageDialog(null, "Impossível usar o recurso de persistência.\nVerifique as configurações.", "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} else {
			this.makeDAOs(); //dao factory
			this.updateResources(); //recupera todos os objetos do "storage" padrão
			do {
				valid = validatePassword();
				if(!valid) {
					errorCounter++;
				}
			} while(errorCounter < 3 && !valid);
			if(valid) {
				opt = JOptionPane.showOptionDialog(null, "Escolha uma opção abaixo:", "Bem-vindo!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				if(opt == 1) {
					super.setTitle("Urna Eletrônica");
					this.eventMonitor = false; //Monitor de eventos, usado para controlar as teclas
					App2Worker.getInstance(); //Para inicializar internamente
					startVoting();
				} else {
					super.setTitle("Relatórios de votação");
					startReport();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Acesso proibido.\nSenha incorreta, três tentativas.", "Erro", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
	}

	private void startReport() {
		JOptionPane.showMessageDialog(null, "Reports!!!");
		System.exit(0);
	}

	private void startVoting() {
		Insets frameInsets;
		Dimension size;
		Container pane;
		ButtonElements btnLst;
		
		JOptionPane.showMessageDialog(null, "Intruções:\n     \u2190  Branco\n     \u2193  Cancela\n     \u2192  Confirma", "Ajuda", JOptionPane.INFORMATION_MESSAGE);
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
		
		App2Worker.setScreen(ViewMaster.buildInterface(pane, btnLst));
		App2Worker.getInstance(); //Rodando o construtor pela primeira vez
		ViewMaster.buildListeners(btnLst);
		
		setSize(pane.getWidth(), pane.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private synchronized void eventSwitch() {
		this.eventMonitor = !this.eventMonitor;
	}
	
	private void keyUseEvent(KeyEvent e) {
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
	
	private static boolean validatePassword() {
		JPasswordField passwdfield = new JPasswordField(10);
		JLabel passwdlabel = new JLabel("Entre com a senha:");
		JPanel panel = new JPanel();
		boolean returnValue = false;
		String passwd;
		
		passwdfield.setEchoChar('*');
		panel.add(passwdlabel);
		panel.add(passwdfield);
		
		JOptionPane.showMessageDialog(null, panel, "Desbloquear", JOptionPane.PLAIN_MESSAGE);
		passwd = new String(passwdfield.getPassword());
		
		if(passwd.equals(DatabaseOperations.getUrnaPassword())) {
			returnValue = true;
		}
		return returnValue;
	}
	
	private void makeDAOs() {
		String stgmtd = ConfigManager.getStorageMethod();
		if(stgmtd.equals("File")) {
			//De acordo com as especificações, não será implementado.
		} else {
			//Database
			this.cargoDAO = CargoDAOjdbc.getInstance();
			this.deputadoDAO = DeputadoDAOjdbc.getInstance();
			this.governadorDAO = GovernadorDAOjdbc.getInstance();
			this.partidoDAO = PartidoDAOjdbc.getInstance();
			this.presidenteDAO = PresidenteDAOjdbc.getInstance();
		}
	}
	
	//Atualiza a lista global de objetos
	private void updateResources() {
		this.cargoDAO.obter();
		this.deputadoDAO.obter();
		this.governadorDAO.obter();
		this.partidoDAO.obter();
		this.presidenteDAO.obter();
	}
	
	private boolean isStorageReady() {
		String stgmtd = ConfigManager.getStorageMethod();
		boolean result = false;
		if(stgmtd.equals("File")) {
			//De acordo com as especificações, não será implementado.
		} else {
			result = JdbcConnection.isConnectionWorking();
		}
		return result;
	}
	
	private synchronized boolean getEventMonitor() {
		return this.eventMonitor;
	}

	private ButtonElements getButtonList() {
		return this.buttonList;
	}

	private CargoDAO getCargoDAO() {
		return this.cargoDAO;
	}

	private DeputadoDAO getDeputadoDAO() {
		return this.deputadoDAO;
	}

	private GovernadorDAO getGovernadorDAO() {
		return this.governadorDAO;
	}

	private PartidoDAO getPartidoDAO() {
		return this.partidoDAO;
	}

	private PresidenteDAO getPresidenteDAO() {
		return this.presidenteDAO;
	}
}