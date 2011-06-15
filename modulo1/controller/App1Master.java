package modulo1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import resources.lib.domain.*;
import resources.lib.domain.persistence.*;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

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
		//if(!this.isStorageReady()) {
		//	JOptionPane.showMessageDialog(null, "Impossível usar o recurso de persistência.\nVerifique as configurações.", "Erro", JOptionPane.ERROR_MESSAGE);
		//	System.exit(1);
		//} else {
		//	this.makeDAOs(); //dao factory
		//	this.updateResources(); //recupera todos os objetos do banco de dados
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
		//}
	}	

	private void startCandidateReg() {
		//JOptionPane.showMessageDialog(null, "Candidate!!!");
		//System.exit(0);
		JPanel pane = new JPanel();
		JTextField partyField = new JTextField(10);
		String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
		this.setContentPane(pane);
		//Create some labels for the fields.
        JLabel partyFieldLabel = new JLabel("Partido: ");
        partyFieldLabel.setLabelFor(partyField);
        
		//Create the combo box, select the item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox petList = new JComboBox(petStrings);
		petList.setSelectedIndex(4);
		petList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ((JComboBox)e.getSource()).getSelectedItem(), "Selector", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		pane.add(partyFieldLabel);
		pane.add(partyField);
		pane.add(petList);
		
		pane.setSize(800, 600);
		this.setSize(800, 600);
		this.setVisible(true);
	}

	private void startPartyReg() {
		JOptionPane.showMessageDialog(null, "Party!!!");
		System.exit(0);
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
			this.deputadoDAO = DeputadoDAOjdbc.getInstance();
			this.governadorDAO = GovernadorDAOjdbc.getInstance();
			this.partidoDAO = PartidoDAOjdbc.getInstance();
			this.presidenteDAO = PresidenteDAOjdbc.getInstance();
		}
	}
	
	//Atualiza a lista global de objetos
	public void updateResources() {
		this.cargoDAO.obter();
		this.deputadoDAO.obter();
		this.governadorDAO.obter();
		this.partidoDAO.obter();
		this.presidenteDAO.obter();
	}
	
	public boolean isStorageReady() {
		String stgmtd = ConfigManager.getStorageMethod();
		boolean result = false;
		if(stgmtd.equals("File")) {
			//De acordo com as especificações, não será implementado.
		} else {
			result = JdbcConnection.isConnectionWorking();
		}
		return result;
	}
	
	public CargoDAO getCargoDAO() {
		return this.cargoDAO;
	}
	
	public DeputadoDAO getDeputadoDAO() {
		return this.deputadoDAO;
	}
	
	public GovernadorDAO getGovernadorDAO() {
		return this.governadorDAO;
	}
	
	public PartidoDAO getPartidoDAO() {
		return this.partidoDAO;
	}
	
	public PresidenteDAO getPresidenteDAO() {
		return this.presidenteDAO;
	}
}