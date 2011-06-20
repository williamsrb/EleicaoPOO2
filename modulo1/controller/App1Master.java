package modulo1.controller;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import modulo1.view.CandidatoView;
import modulo1.view.PartidoView;
import resources.lib.domain.Partido;
import resources.lib.domain.persistence.*;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;
import resources.lib.view.ScreenPanel;

public final class App1Master extends JFrame {
	private static final long serialVersionUID = 1000L;
	private CargoDAO cargoDAO;
	private DeputadoDAO deputadoDAO;
	private GovernadorDAO governadorDAO;
	private PartidoDAO partidoDAO;
	private PresidenteDAO presidenteDAO;
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new App1Master();
			}
		});
	}
//Cargo - Partido - Nome - Número
	private App1Master() {
		Object[] options = {"Relatórios", "Cadastro de Partido", "Cadastro de Candidato"};
		int opt;
		//
		boolean teste = true;
		if(!this.isStorageReady()) {
			JOptionPane.showMessageDialog(null, "Impossível usar o recurso de persistência.\nVerifique as configurações.", "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} else {
			this.makeDAOs(); //dao factory
			this.updateResources(); //recupera todos os objetos do banco de dados
			opt = JOptionPane.showOptionDialog(null, "Escolha uma opção abaixo:", "Bem-vindo!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			switch(opt) {
			case 0:
				//Relatórios
				this.startReport();
				break;
			case 1:
				//Cadastro de partido
				this.startPartyReg();
				break;
			default:
				//Cadastro de candidato
				if(Partido.isEmpty() && !teste) {
					JOptionPane.showMessageDialog(null, "Antes de cadastrar candidatos, cadastre partidos!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					this.startCandidateReg();
				}
			}
		}
	}

	private void startCandidateReg() {
		ScreenPanel pane = new ScreenPanel(null);
		CandidatoView cv = new CandidatoView();
		pane.setOpaque(true);
		this.setContentPane(pane);
		this.setTitle("Cadastro de Candidatos");
		cv.display(pane);
		
		Dimension size = new Dimension(900, 300);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void startPartyReg() {
		ScreenPanel pane = new ScreenPanel(null);
		PartidoView pv = new PartidoView();
		pane.setOpaque(true);
		this.setContentPane(pane);
		this.setTitle("Cadastro de Partidos");
		pv.display(pane);
		
		Dimension size = new Dimension(900, 300);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void startReport() {
		JOptionPane.showMessageDialog(null, "Reports!!!");
		System.exit(0);
	}
	
	private void makeDAOs() {
		String stgmtd = ConfigManager.getStorageMethod();
		if(stgmtd.equals("File")) {
			//De acordo com as especificações, não será implementado.
		} else {
			//Database
			this.cargoDAO = CargoDAOjdbc.getInstance();
			this.partidoDAO = PartidoDAOjdbc.getInstance();
			this.deputadoDAO = DeputadoDAOjdbc.getInstance();
			this.governadorDAO = GovernadorDAOjdbc.getInstance();
			this.presidenteDAO = PresidenteDAOjdbc.getInstance();
		}
	}
	
	//Atualiza a lista global de objetos
	private void updateResources() {
		this.cargoDAO.obter();
		this.partidoDAO.obter();
		
		this.deputadoDAO.obter();
		this.governadorDAO.obter();
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
}