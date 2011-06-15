package modulo2.controller;

import java.util.HashMap;
import java.util.Map;

import modulo2.util.KeyEnum;
import resources.lib.domain.Deputado;
import resources.lib.domain.Governador;
import resources.lib.domain.Presidente;
import resources.lib.other.Singleton;
import resources.lib.view.ScreenPanel;

public final class App2Worker implements Singleton {
	private static App2Worker singleton;
	private int state;
	private int previousState;
	private String enteredNums;
	private ScreenPanel screen;
	private Map<String, String> votes;
	
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

	private App2Worker() {
		//this.estado = DIGITANDO_DEPUTADO;
		votes = new HashMap<String, String>();
		Deputado d = new Deputado();
		Governador g = new Governador();
		Presidente p = new Presidente();
		votes.put("deputado", "" + d.getNumero());
		votes.put("governdor", "" + g.getNumero());
		votes.put("presidente", "" + p.getNumero());
	}	public static synchronized App2Worker getInstance() {
		if(singleton == null) {
			singleton = new App2Worker();
		}
		return singleton;
	}
	
	public int getState() {
		return this.state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getPreviousState() {
		return this.previousState;
	}

	public void setPreviousState(int previousState) {
		this.previousState = previousState;
	}

	public String getEnteredNums() {
		return this.enteredNums;
	}
	
	public void setEnteredNums(String enteredNums) {
		this.enteredNums = enteredNums;
	}
	
	public ScreenPanel getScreen() {
		return this.screen;
	}

	public void setScreen(ScreenPanel screen) {
		this.screen = screen;
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
	
	public void actionNULO(KeyEnum key) {
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
	
	public void actionBRANCO(KeyEnum key) {
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
	
	public void actionFIM(KeyEnum key) {
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
	
	public void actionDIGITANDO_DEPUTADO(KeyEnum key) {
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
	
	public void actionEXIBINDO_DEPUTADO(KeyEnum key) {
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
	
	public void actionDIGITANDO_GOVERNADOR(KeyEnum key) {
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
	
	public void actionEXIBINDO_GOVERNADOR(KeyEnum key) {
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
	
	public void actionDIGITANDO_PRESIDENTE(KeyEnum key) {
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
	
	public void actionEXIBINDO_PRESIDENTE(KeyEnum key) {
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