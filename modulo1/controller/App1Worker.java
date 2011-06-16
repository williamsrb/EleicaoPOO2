package modulo1.controller;

import javax.swing.JOptionPane;

import modulo2.util.KeyEnum;
import modulo2.util.VotingKey;
import modulo2.view.VotingState;

import resources.lib.other.Singleton;
import resources.lib.view.ScreenPanel;

@SuppressWarnings("unused")
public final class App1Worker implements Singleton {
	private static App1Worker singleton;
	private int state;
	private int previousState;
	private ScreenPanel screen;
	
	private static final int BLOQUEADO = -3;
	private static final int NULO = -2;
	private static final int BRANCO = -1;
	private static final int FIM = 0;
	private static final int DIGITANDO_DEPUTADO = 1;
	private static final int EXIBINDO_DEPUTADO = 2;
	private static final int DIGITANDO_GOVERNADOR = 3;
	private static final int EXIBINDO_GOVERNADOR = 4;
	private static final int DIGITANDO_PRESIDENTE = 5;
	private static final int EXIBINDO_PRESIDENTE = 6;

	private App1Worker() {
		//this.estado = DIGITANDO_DEPUTADO;
	}	private static synchronized App1Worker getInstance() {
		if(singleton == null) {
			singleton = new App1Worker();
		}
		return singleton;
	}
	
	private void setState(int state) {
		this.state = state;
	}
	
	private int getState() {
		return this.state;
	}
	
	private int getPreviousState() {
		return this.previousState;
	}

	private void setPreviousState(int previousState) {
		this.previousState = previousState;
	}

	private void setScreen(ScreenPanel screen) {
		this.screen = screen;
	}
	
	private ScreenPanel getScreen() {
		return this.screen;
	}
	
	private void doButtonAction(KeyEnum key) {
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
	
	private void actionBLOQUEADO(KeyEnum key) {
		/*//Fazer nada
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
		 */
	}
	
	private void actionNULO(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action NULO", JOptionPane.INFORMATION_MESSAGE);
		//this.state = BRANCO;
		////Teste %%%%%%%%%%%%%%%%
		//VotingState.displayCandidate(new Governador(), screen);
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			//Fazer nada
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			rollback();
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionBRANCO(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action BRANCO", JOptionPane.INFORMATION_MESSAGE);
		//this.state = FIM;
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionFIM(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action FIM", JOptionPane.INFORMATION_MESSAGE);
		//this.state = DIGITANDO_DEPUTADO;
		////Teste %%%%%%%%%%%%%%%%
		//screen.clear();
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionDIGITANDO_DEPUTADO(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action DIGITANDO_DEPUTADO", JOptionPane.INFORMATION_MESSAGE);
		//this.state = EXIBINDO_DEPUTADO;
		//Teste %%%%%%%%%%%%%%%%
		//VotingState.displayCandidate(new Presidente(), screen);
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_DEPUTADO(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action EXIBINDO_DEPUTADO", JOptionPane.INFORMATION_MESSAGE);
		//this.state = DIGITANDO_GOVERNADOR;
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionDIGITANDO_GOVERNADOR(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action DIGITANDO_GOVERNADOR", JOptionPane.INFORMATION_MESSAGE);
		//this.state = EXIBINDO_GOVERNADOR;
		//Teste %%%%%%%%%%%%%%%%
		//screen.clear();
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_GOVERNADOR(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action EXIBINDO_GOVERNADOR", JOptionPane.INFORMATION_MESSAGE);
		//this.state = DIGITANDO_PRESIDENTE;
		//Teste %%%%%%%%%%%%%%%%
		//VotingState.displayCandidate(new Deputado(), screen);
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionDIGITANDO_PRESIDENTE(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action DIGITANDO_PRESIDENTE", JOptionPane.INFORMATION_MESSAGE);
		//this.state = EXIBINDO_PRESIDENTE;
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_PRESIDENTE(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action EXIBINDO_PRESIDENTE", JOptionPane.INFORMATION_MESSAGE);
		//this.state = BLOQUEADO;
		//Teste %%%%%%%%%%%%%%%%
		//screen.clear();
		switch(key) {
		case D1:
		case D2:
		case D3:
		case D4:
		case D5:
		case D6:
		case D7:
		case D8:
		case D9:
		case D0:
			//Ação para dígitos
			break;
		case CGREEN:
			//Ação para "Confirma"
			break;
		case CRED:
			//Ação para "Cancela"
			break;
		case CWHITE:
			//Ação para "Branco"
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void rollback() {
		this.state = this.previousState;
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}