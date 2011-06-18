package modulo2.controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
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
	private static JFrame window;
	private int state;
	private int previousState;
	private int nextState;
	private String enteredNums;
	private Integer numCandidato;
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
		this.numCandidato = Candidato.NONE;
		this.votes = new HashMap<String, String>();
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
	
	private void changeState() {
		this.doButtonAction(KeyEnum.ENTER);
	}
	
	private void changeState(int state) {
		this.previousState = this.state;
		this.state = state;
		this.changeState();
	}
	
	private void changeState(int state, int nextState) {
		this.changeState(state);
		this.nextState = nextState;
		this.changeState();
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
	
	private JFrame getWindow() {
		return App2Worker.window;
	}
	
	static void setWindow(JFrame window) {
		App2Worker.window = window;
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
	//Estados fora de sequecia
	private void actionNULO(KeyEnum key) {
		String title;
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível voltar de um estado posterior para este
			if(this.numCandidato != null) {
				title = this.getCurrentTitle(this.previousState);
				if(title.equals("Deputado")) {
					VotingState.displayNull(new Deputado(this.numCandidato), screen);
				} else if(title.equals("Governador")) {
					VotingState.displayNull(new Governador(this.numCandidato), screen);
				} else if(title.equals("Presidente")) {
					VotingState.displayNull(new Presidente(this.numCandidato), screen);
				}
				this.numCandidato = null;
			}
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
			title = this.getCurrentTitle(this.previousState);
			votes.put(title.toLowerCase(), this.enteredNums);
			this.enteredNums = "";
			this.changeState(this.nextState);
			break;
		case CRED:
			//Ação para "Cancela"
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
		String title;
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível voltar de um estado posterior para este
			title = this.getCurrentTitle(this.previousState);
			if(title.equals("Deputado")) {
				VotingState.displayBlank(new Deputado(), screen);
			} else if(title.equals("Governador")) {
				VotingState.displayBlank(new Governador(), screen);
			} else if(title.equals("Presidente")) {
				VotingState.displayBlank(new Presidente(), screen);
			}
			if(this.numCandidato != null) {
				this.numCandidato = null;
			}
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
			title = this.getCurrentTitle(this.previousState);
			votes.put(title.toLowerCase(), "0");
			this.enteredNums = "";
			this.changeState(this.nextState);
			break;
		case CRED:
			//Ação para "Cancela"
			this.rollback(KeyEnum.BACK);
			break;
		case CWHITE:
			//Ação para "Branco"
			//?
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	//Estados na sequecia
	private void actionINICIO(KeyEnum key) {
		//Deve-se pressionar qualquer tecla para iniciar a votação
		if(key == KeyEnum.ENTER) {
			VotingState.displayStart(screen);
		} else {
			this.changeState(DIGITANDO_DEPUTADO);
		}
	}
	
	private void actionDIGITANDO_DEPUTADO(KeyEnum key) {
		switch(key) {
		case ENTER:
			//Entrar
			this.enteredNums = "";
			Deputado person = null;
			VotingState.preDisplayCandidate(person, screen);
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
			JLabel digitBlock;
			int tam = this.enteredNums.length();
			if(tam < 5) {
				String part = VotingKey.getPrefix(key);
				this.enteredNums += part;
				if(tam < 1) {
					digitBlock = VotingState.getNumDigit01();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
				} else if(tam < 2) {
					digitBlock = VotingState.getNumDigit02();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
				} else if(tam < 3) {
					digitBlock = VotingState.getNumDigit03();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
				} else if(tam < 4) {
					digitBlock = VotingState.getNumDigit04();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
				} else {
					digitBlock = VotingState.getNumDigit05();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
					int num = Integer.parseInt(this.enteredNums);
					this.numCandidato = num;
					if(Deputado.existsByNumber(num)) {
						VotingState.cleanNumDigits();
						this.changeState(EXIBINDO_DEPUTADO);
					} else {
						VotingState.cleanNumDigits();
						this.changeState(NULO, DIGITANDO_GOVERNADOR);
					}
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
			this.rollback(KeyEnum.ENTER);
			break;
		case CWHITE:
			//Ação para "Branco"
			VotingState.cleanNumDigits();
			this.changeState(BRANCO, DIGITANDO_GOVERNADOR);
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_DEPUTADO(KeyEnum key) {
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível voltar de um estado posterior para este
			if(this.numCandidato != null) {
				VotingState.displayCandidate(Deputado.getByNumber(this.numCandidato), screen);
				this.numCandidato = null;
			}
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
			this.changeState(DIGITANDO_GOVERNADOR);
			break;
		case CRED:
			//Ação para "Cancela"
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
		switch(key) {
		case ENTER:
			//Entrar
			this.enteredNums = "";
			Governador person = null;
			VotingState.preDisplayCandidate(person, screen);
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
			JLabel digitBlock;
			int tam = this.enteredNums.length();
			if(tam < 2) {
				String part = VotingKey.getPrefix(key);
				this.enteredNums += part;
				if(tam < 1) {
					digitBlock = VotingState.getNumDigit01();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
				} else {
					digitBlock = VotingState.getNumDigit02();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
					int num = Integer.parseInt(this.enteredNums);
					this.numCandidato = num;
					if(Governador.existsByNumber(num)) {
						VotingState.cleanNumDigits();
						this.changeState(EXIBINDO_GOVERNADOR);
					} else {
						VotingState.cleanNumDigits();
						this.changeState(NULO, DIGITANDO_PRESIDENTE);
					}
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
			this.rollback(KeyEnum.ENTER);
			break;
		case CWHITE:
			//Ação para "Branco"
			VotingState.cleanNumDigits();
			this.changeState(BRANCO, DIGITANDO_PRESIDENTE);
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_GOVERNADOR(KeyEnum key) {
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível voltar de um estado posterior para este
			if(this.numCandidato != null) {
				VotingState.displayCandidate(Governador.getByNumber(this.numCandidato), screen);
				this.numCandidato = null;
			}
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
			this.changeState(DIGITANDO_PRESIDENTE);
			break;
		case CRED:
			//Ação para "Cancela"
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
		switch(key) {
		case ENTER:
			//Entrar
			this.enteredNums = "";
			Presidente person = null;
			VotingState.preDisplayCandidate(person, screen);
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
			JLabel digitBlock;
			int tam = this.enteredNums.length();
			if(tam < 2) {
				String part = VotingKey.getPrefix(key);
				this.enteredNums += part;
				if(tam < 1) {
					digitBlock = VotingState.getNumDigit01();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
				} else {
					digitBlock = VotingState.getNumDigit02();if(digitBlock != null) {digitBlock.setText(part);} else {System.err.println("preDisplay deve ser usado antes");}
					int num = Integer.parseInt(this.enteredNums);
					this.numCandidato = num;
					if(Presidente.existsByNumber(num)) {
						VotingState.cleanNumDigits();
						this.changeState(EXIBINDO_PRESIDENTE);
					} else {
						VotingState.cleanNumDigits();
						this.changeState(NULO, FIM);
					}
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
			this.rollback(KeyEnum.ENTER);
			break;
		case CWHITE:
			//Ação para "Branco"
			VotingState.cleanNumDigits();
			this.changeState(BRANCO, FIM);
			break;
		default:
			System.err.println("Unknown key: " + key);
		}
	}
	
	private void actionEXIBINDO_PRESIDENTE(KeyEnum key) {
		switch(key) {
		case ENTER:
			//Entrar
			//Impossível voltar de um estado posterior para este
			if(this.numCandidato != null) {
				VotingState.displayCandidate(Presidente.getByNumber(this.numCandidato), screen);
				this.numCandidato = null;
			}
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
			this.changeState(FIM);
			break;
		case CRED:
			//Ação para "Cancela"
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
	
	private void actionFIM(KeyEnum key) {
		//Deve-se pressionar qualquer tecla para finalizar a votação
		if(key == KeyEnum.ENTER) {
			//Persistir - inicio
			this.commit();
			VotingState.displayEnd(screen);
		} else {
			this.changeState(INICIO);
		}
	}
	
	private String getCurrentTitle(int state) {
		String returnValue;
		switch(state) {
		case DIGITANDO_DEPUTADO:
		case EXIBINDO_DEPUTADO:
			returnValue = "Deputado";
			break;
		case DIGITANDO_GOVERNADOR:
		case EXIBINDO_GOVERNADOR:
			returnValue = "Governador";
			break;
		case DIGITANDO_PRESIDENTE:
		case EXIBINDO_PRESIDENTE:
			returnValue = "Presidente";
			break;
		default:
			returnValue = "Candidato";
		}
		return returnValue;
	}
	
	private void commit() {
		((App2Master) window).getVotes().add(this.votes);
		this.votes = new HashMap<String, String>();
	}
	
	private void rollback(KeyEnum backORenter) {
		if(backORenter == KeyEnum.BACK) {
			this.changeState(this.previousState); //Voltar um estado
		} else {
			//backORenter == KeyEnum.ENTER
			this.changeState(); //Forçar reiniciar o estado atual
		}
	}
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}