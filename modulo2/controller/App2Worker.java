package modulo2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import modulo2.util.KeyEnum;
import modulo2.util.VotingKey;
import modulo2.view.VotingState;
import resources.lib.domain.*;
import resources.lib.other.Singleton;
import resources.lib.view.ScreenPanel;

public final class App2Worker implements Singleton {
	private static App2Worker singleton;
	private static ScreenPanel screen;
	private int state;
	private int previousState;
	private int nextState;
	private String enteredNums;
	private Map<String, String> votes;
	
	private static final int INICIO = -3;
	private static final int NULO = -2;
	private static final int BRANCO = -1;
	private static final int FIM = 0;
	private static final int DIGITANDO_DEPUTADO = 1;
	private static final int EXIBINDO_DEPUTADO = 2;
	private static final int DIGITANDO_GOVERNADOR = 3;
	private static final int EXIBINDO_GOVERNADOR = 4;
	private static final int DIGITANDO_PRESIDENTE = 5;
	private static final int EXIBINDO_PRESIDENTE = 6;

	private App2Worker() {
		VotingState.displayStart(screen);
		this.state = INICIO;
		this.previousState = this.state;
		this.enteredNums = "";
		this.votes = new HashMap<String, String>();
		/*
		Deputado d = new Deputado();
		Governador g = new Governador();
		Presidente p = new Presidente();
		
		 * Votação funciona assim:
		votes.put("deputado", "" + d.getNumero());
		votes.put("governdor", "" + g.getNumero());
		votes.put("presidente", "" + p.getNumero());
		
		Não esquecer de persistir no final, para o banco e para arquivo
		*/
	}
	
	//Só funciona se a "screen" estiver setada
	public static synchronized App2Worker getInstance() {
		if(singleton == null && screen != null) {
			singleton = new App2Worker();
		}
		return singleton;
	}
	
	private int getState() {
		return this.state;
	}
	
	private void changeState(int state) {
		//this.enteredNums = "";
		this.previousState = this.state;
		this.state = state;
	}
	
	private void changeState(int state, int nextState) {
		this.changeState(state);
		this.nextState = nextState;
	}
	
	private int getPreviousState() {
		return this.previousState;
	}

	private void setPreviousState(int previousState) {
		this.previousState = previousState;
	}

	private String getEnteredNums() {
		return this.enteredNums;
	}
	
	private void setEnteredNums(String enteredNums) {
		this.enteredNums = enteredNums;
	}
	
	private ScreenPanel getScreen() {
		return App2Worker.screen;
	}

	static void setScreen(ScreenPanel screen) {
		App2Worker.screen = screen;
	}
	
	public void doButtonAction(KeyEnum key) {
		switch(this.state) {
		case INICIO:
			this.actionINICIO(key);
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
	
	private void actionINICIO(KeyEnum key) {
		JOptionPane.showMessageDialog(null, "action INICIO - key " + key.toString());
		//Deve-se pressionar qualquer tecla para iniciar a votação
		if(key != KeyEnum.BACK) {
			Deputado person = null;
			VotingState.preDisplayCandidate(person, screen);
			this.changeState(DIGITANDO_DEPUTADO);
		} else {
			VotingState.displayStart(screen);
		}
	}
	
	private void actionDIGITANDO_DEPUTADO(KeyEnum key) {
		JOptionPane.showMessageDialog(null, "action DIGITANDO_DEPUTADO - key " + key.toString());
		switch(key) {
		case ENTER:
			//Entrar
			Deputado person = null;
			VotingState.preDisplayCandidate(person, screen);
			break;
		case BACK:
			//Voltar
			this.rollback(KeyEnum.ENTER);
			break;
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
			int tam = this.enteredNums.length();
			JLabel digitBlock;
			if(tam < 5) {
				String part = VotingKey.getPrefix(key);
				this.enteredNums += part;
				if(tam < 1) {
					digitBlock = VotingState.getNumDigit01();
					if(digitBlock != null) {
						digitBlock.setText(part);
					} else {
						System.err.println("preDisplay deve ser usado antes");
					}
				} else if(tam < 2) {
					digitBlock = VotingState.getNumDigit02();
					if(digitBlock != null) {
						digitBlock.setText(part);
					} else {
						System.err.println("preDisplay deve ser usado antes");
					}
				} else if(tam < 3) {
					digitBlock = VotingState.getNumDigit03();
					if(digitBlock != null) {
						digitBlock.setText(part);
					} else {
						System.err.println("preDisplay deve ser usado antes");
					}
				} else if(tam < 4) {
					digitBlock = VotingState.getNumDigit04();
					if(digitBlock != null) {
						digitBlock.setText(part);
					} else {
						System.err.println("preDisplay deve ser usado antes");
					}
				} else {
					digitBlock = VotingState.getNumDigit05();
					if(digitBlock != null) {
						digitBlock.setText(part);
					} else {
						System.err.println("preDisplay deve ser usado antes");
					}
					int num = Integer.parseInt(this.enteredNums);
					if(Deputado.existsByNumber(num)) {
						VotingState.displayCandidate(Deputado.getByNumber(num), screen);
						//this.changeState(EXIBINDO_DEPUTADO);
					} else {
						VotingState.displayNull(new Deputado(num), screen);
						//this.changeState(NULO, DIGITANDO_GOVERNADOR);
					}
					this.changeState(EXIBINDO_DEPUTADO);
				}
				screen.refresh();
			}
			break;
		case CGREEN:
			//Ação para "Confirma"
			//Nada, ainda está digitando os números
			break;
		case CRED:
			//Ação para "Cancela"
			VotingState.cleanNumDigits();
			this.rollback(KeyEnum.ENTER);
			break;
		case CWHITE:
			//Ação para "Branco"
			VotingState.displayBlank(new Deputado(), screen);
			//this.changeState(BRANCO, DIGITANDO_GOVERNADOR);
			this.changeState(EXIBINDO_DEPUTADO);
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_DEPUTADO(KeyEnum key) {	
		JOptionPane.showMessageDialog(null, "action EXIBINDO_DEPUTADO - key " + key.toString());
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível reentrar
			break;
		case BACK:
			//Voltar
			//Impossível voltar
			break;
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
			//Nada
			break;
		case CGREEN:
			//Ação para "Confirma"
			votes.put("deputado", this.enteredNums);
			Governador person = null;
			VotingState.preDisplayCandidate(person, screen);
			this.changeState(DIGITANDO_GOVERNADOR);
			this.enteredNums = "";
			break;
		case CRED:
			//Ação para "Cancela"
			VotingState.cleanNumDigits();
			this.rollback(KeyEnum.BACK);
			break;
		case CWHITE:
			//Ação para "Branco"
			//É necessáro "Cancela"r para votar em branco
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionDIGITANDO_GOVERNADOR(KeyEnum key) {
		JOptionPane.showMessageDialog(null, "action DIGITANDO_GOVERNADOR - key " + key.toString());
		switch(key) {
		case ENTER:
			//Entrar
			Governador person = null;
			VotingState.preDisplayCandidate(person, screen);
			break;
		case BACK:
			//Voltar
			this.rollback(KeyEnum.ENTER);
			break;
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
			int tam = this.enteredNums.length();
			if(tam < 2) {
				String part = VotingKey.getPrefix(key);
				this.enteredNums += part;
				if(tam < 1) {
					VotingState.getNumDigit01().setText(part);
				} else {
					VotingState.getNumDigit02().setText(part);
					int num = Integer.parseInt(this.enteredNums);
					if(Deputado.existsByNumber(num)) {
						VotingState.displayCandidate(Governador.getByNumber(num), screen);
						//this.changeState(EXIBINDO_GOVERNADOR);
					} else {
						VotingState.displayNull(new Governador(num), screen);
						//this.changeState(NULO, DIGITANDO_PRESIDENTE);
					}
					this.changeState(EXIBINDO_GOVERNADOR);
				}
				screen.refresh();
			}
			break;
		case CGREEN:
			//Ação para "Confirma"
			//Nada, ainda está digitando os números
			break;
		case CRED:
			//Ação para "Cancela"
			VotingState.cleanNumDigits();
			this.rollback(KeyEnum.ENTER);
			break;
		case CWHITE:
			//Ação para "Branco"
			VotingState.displayBlank(new Governador(), screen);
			//this.changeState(BRANCO, DIGITANDO_PRESIDENTE);
			this.changeState(EXIBINDO_GOVERNADOR);
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_GOVERNADOR(KeyEnum key) {
		JOptionPane.showMessageDialog(null, "action EXIBINDO_GOVERNADOR - key " + key.toString());
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível reentrar
			break;
		case BACK:
			//Voltar
			//Impossível voltar
			break;
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
			//Nada
			break;
		case CGREEN:
			//Ação para "Confirma"
			votes.put("governador", this.enteredNums);
			Presidente person = null;
			VotingState.preDisplayCandidate(person, screen);
			this.changeState(DIGITANDO_PRESIDENTE);
			break;
		case CRED:
			//Ação para "Cancela"
			VotingState.cleanNumDigits();
			this.rollback(KeyEnum.BACK);
			break;
		case CWHITE:
			//Ação para "Branco"
			//É necessáro "Cancela"r para votar em branco
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionDIGITANDO_PRESIDENTE(KeyEnum key) {
		JOptionPane.showMessageDialog(null, "action DIGITANDO_PRESIDENTE - key " + key.toString());
		switch(key) {
		case ENTER:
			//Entrar
			Presidente person = null;
			VotingState.preDisplayCandidate(person, screen);
			break;
		case BACK:
			//Voltar
			this.rollback(KeyEnum.ENTER);
			break;
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
			int tam = this.enteredNums.length();
			if(tam < 2) {
				String part = VotingKey.getPrefix(key);
				this.enteredNums += part;
				if(tam < 1) {
					VotingState.getNumDigit01().setText(part);
				} else {
					VotingState.getNumDigit02().setText(part);
					int num = Integer.parseInt(this.enteredNums);
					if(Deputado.existsByNumber(num)) {
						VotingState.displayCandidate(Presidente.getByNumber(num), screen);
						//this.changeState(EXIBINDO_PRESIDENTE);
					} else {
						VotingState.displayNull(new Presidente(num), screen);
						//this.changeState(NULO, FIM);
					}
					this.changeState(EXIBINDO_PRESIDENTE);
				}
				screen.refresh();
			}
			break;
		case CGREEN:
			//Ação para "Confirma"
			//Nada, ainda está digitando os números
			break;
		case CRED:
			//Ação para "Cancela"
			VotingState.cleanNumDigits();
			this.rollback(KeyEnum.ENTER);
			break;
		case CWHITE:
			//Ação para "Branco"
			VotingState.displayBlank(new Presidente(), screen);
			//this.changeState(BRANCO, FIM);
			this.changeState(EXIBINDO_PRESIDENTE);
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_PRESIDENTE(KeyEnum key) {
		JOptionPane.showMessageDialog(null, "action EXIBINDO_PRESIDENTE - key " + key.toString());
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível reentrar
			break;
		case BACK:
			//Voltar
			//Impossível voltar
			break;
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
			//Nada
			break;
		case CGREEN:
			//Ação para "Confirma"
			votes.put("presidente", this.enteredNums);
			VotingState.displayEnd(screen);
			//Commitar no banco ################################################################
			JOptionPane.showMessageDialog(null, "Commitando: deputado=" + votes.get("deputado") + " governador=" + votes.get("governador") + " presidente=" + votes.get("presidente"));
			this.changeState(FIM);
			break;
		case CRED:
			//Ação para "Cancela"
			VotingState.cleanNumDigits();
			this.rollback(KeyEnum.BACK);
			break;
		case CWHITE:
			//Ação para "Branco"
			//É necessáro "Cancela"r para votar em branco
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionNULO(KeyEnum key) {
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível reentrar
			break;
		case BACK:
			//Voltar
			//Impossível voltar
			break;
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
			//Nada
			break;
		case CGREEN:
			//Ação para "Confirma"
			String statename = getStateName(this.previousState);
			String pieces[];
			pieces = statename.split("_"); //O previousState de um "NULO" é sempre um estado com "_" no meio
			votes.put(pieces[1].toLowerCase(), this.enteredNums);
			switch(this.nextState) {
			case DIGITANDO_GOVERNADOR:
				
				break;
			case DIGITANDO_PRESIDENTE:
				break;
			case FIM:
				VotingState.displayEnd(screen);
				//Commitar no banco ################################################################
				this.changeState(FIM);
				break;
			}
			break;
		case CRED:
			//Ação para "Cancela"
			VotingState.cleanNumDigits();
			this.rollback(KeyEnum.BACK);
			break;
		case CWHITE:
			//Ação para "Branco"
			//É necessáro "Cancela"r para votar em branco
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionBRANCO(KeyEnum key) {
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action BRANCO", JOptionPane.INFORMATION_MESSAGE);
		//this.state = FIM;
		switch(key) {
		case BACK:
			//Voltar
			break;
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
		JOptionPane.showMessageDialog(null, "action EXIBINDO_PRESIDENTE - key " + key.toString());
		//JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "action FIM", JOptionPane.INFORMATION_MESSAGE);
		//this.state = DIGITANDO_DEPUTADO;
		////Teste %%%%%%%%%%%%%%%%
		//screen.clear();
		
		VotingState.displayStart(screen);
		this.previousState = this.state;
		this.state = INICIO;
		
		/*switch(key) {
		case BACK:
			//Voltar
			break;
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
		}*/
	}
	
	private String getStateName(int state) {
		switch(state) {
		case INICIO:
			return "INICIO";
		case NULO:
			return "NULO";
		case BRANCO:
			return "BRANCO";
		case FIM:
			return "FIM";
		case DIGITANDO_DEPUTADO:
			return "DIGITANDO_DEPUTADO";
		case EXIBINDO_DEPUTADO:
			return "EXIBINDO_DEPUTADO";
		case DIGITANDO_GOVERNADOR:
			return "DIGITANDO_GOVERNADOR";
		case EXIBINDO_GOVERNADOR:
			return "EXIBINDO_GOVERNADOR";
		case DIGITANDO_PRESIDENTE:
			return "DIGITANDO_PRESIDENTE";
		case EXIBINDO_PRESIDENTE:
			return "EXIBINDO_PRESIDENTE";
		default:
			return "";
		}
	}
	
	private void rollback(KeyEnum backORenter) {
		changeState(this.previousState);
		if(backORenter != KeyEnum.BACK) {
			doButtonAction(KeyEnum.ENTER);
		} else {
			doButtonAction(KeyEnum.BACK);
		}
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}