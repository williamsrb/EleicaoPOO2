package modulo2.controller;

import javax.swing.JOptionPane;

import modulo2.domain.Deputado;
import modulo2.domain.Governador;
import modulo2.domain.Presidente;

import modulo2.util.KeyEnum;
import modulo2.util.VotingKey;
import modulo2.view.ScreenPanel;
import modulo2.view.VotingState;

public class AppWorker {
	private static AppWorker singleton;
	private int state;
	private ScreenPanel screen;
	
	public static final int BLOQUEADO = -3;
	public static final int NULO = -2;
	public static final int BRANCO = -1;
	public static final int FIM = 0;
	public static final int DIGITANDO_DEPUTADO = 1;
	public static final int EXIBINDO_DEPUTADO = 2;
	public static final int DIGITANDO_GOVERNADOR = 3;
	public static final int EXIBINDO_GOVERNADOR = 4;
	public static final int DIGITANDO_PRESIDENTE = 5;
	public static final int EXIBINDO_PRESIDENTE = 6;

	private AppWorker() {
		//this.estado = DIGITANDO_DEPUTADO;
	}
 
	public static synchronized AppWorker getInstance() {
		if(singleton == null) {
			singleton = new AppWorker();
		}
		return singleton;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getState() {
		return this.state;
	}
	
	public void setScreen(ScreenPanel screen) {
		this.screen = screen;
	}
	
	public ScreenPanel getScreen() {
		return this.screen;
	}
	
	public void doButtonAction(KeyEnum key) {
		switch(this.state) {
		case BLOQUEADO:
			this.actionBLOQUEADO(key);
			break;
		case NULO:
			this.actionNULO(key);
			break;
		case BRANCO:
			this.actionBRANCO(key);
			break;
		case FIM:
			this.actionFIM(key);
			break;
		case DIGITANDO_DEPUTADO:
			this.actionDIGITANDO_DEPUTADO(key);
			break;
		case EXIBINDO_DEPUTADO:
			this.actionEXIBINDO_DEPUTADO(key);
			break;
		case DIGITANDO_GOVERNADOR:
			this.actionDIGITANDO_GOVERNADOR(key);
			break;
		case EXIBINDO_GOVERNADOR:
			this.actionEXIBINDO_GOVERNADOR(key);
			break;
		case DIGITANDO_PRESIDENTE:
			this.actionDIGITANDO_PRESIDENTE(key);
			break;
		case EXIBINDO_PRESIDENTE:
			this.actionEXIBINDO_PRESIDENTE(key);
			break;
		default:
			System.err.println("Unknown state: " + this.state);
		}
	}
	
	public void actionBLOQUEADO(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action BLOQUEADO", JOptionPane.INFORMATION_MESSAGE);
		this.state = NULO;
	}
	
	public void actionNULO(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action NULO", JOptionPane.INFORMATION_MESSAGE);
		this.state = BRANCO;
		//Teste %%%%%%%%%%%%%%%%
		VotingState.displayCandidate(new Governador(), screen);
	}
	
	public void actionBRANCO(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action BRANCO", JOptionPane.INFORMATION_MESSAGE);
		this.state = FIM;
	}
	
	public void actionFIM(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action FIM", JOptionPane.INFORMATION_MESSAGE);
		this.state = DIGITANDO_DEPUTADO;
		//Teste %%%%%%%%%%%%%%%%
		screen.clear();
	}
	
	public void actionDIGITANDO_DEPUTADO(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action DIGITANDO_DEPUTADO", JOptionPane.INFORMATION_MESSAGE);
		this.state = EXIBINDO_DEPUTADO;
		//Teste %%%%%%%%%%%%%%%%
		VotingState.displayCandidate(new Presidente(), screen);
	}
	
	public void actionEXIBINDO_DEPUTADO(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action EXIBINDO_DEPUTADO", JOptionPane.INFORMATION_MESSAGE);
		this.state = DIGITANDO_GOVERNADOR;
	}
	
	public void actionDIGITANDO_GOVERNADOR(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action DIGITANDO_GOVERNADOR", JOptionPane.INFORMATION_MESSAGE);
		this.state = EXIBINDO_GOVERNADOR;
		//Teste %%%%%%%%%%%%%%%%
		screen.clear();
	}
	
	public void actionEXIBINDO_GOVERNADOR(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action EXIBINDO_GOVERNADOR", JOptionPane.INFORMATION_MESSAGE);
		this.state = DIGITANDO_PRESIDENTE;
		//Teste %%%%%%%%%%%%%%%%
		VotingState.displayCandidate(new Deputado(), screen);
	}
	
	public void actionDIGITANDO_PRESIDENTE(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action DIGITANDO_PRESIDENTE", JOptionPane.INFORMATION_MESSAGE);
		this.state = EXIBINDO_PRESIDENTE;
	}
	
	public void actionEXIBINDO_PRESIDENTE(KeyEnum key) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action EXIBINDO_PRESIDENTE", JOptionPane.INFORMATION_MESSAGE);
		this.state = BLOQUEADO;
		//Teste %%%%%%%%%%%%%%%%
		screen.clear();
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}