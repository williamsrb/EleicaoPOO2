package modulo1.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modulo1.controller.App1Worker;
import resources.lib.domain.Partido;
import resources.lib.other.ArrayCaster;
import resources.lib.view.Display;
import resources.lib.view.JTextFieldLimit;

public class PartidoView extends ViewMaster {
	
	public PartidoView() {
		this.table = new JTable();
		this.insert = new JButton();
		this.update = new JButton();
		this.delete = new JButton();
	}
	
	public TableModel createTableModel() {
		TableModel tablemodel;
		String[] columnNames = {"Id", "Sigla", "Nome", "Número"};
		Partido array[] = ArrayCaster.objectCastPartido(Partido.getAll().toArray());
		int i, size = array.length;
		String[][] dataTable = new String[size][];
		for(i = 0; i < size; i++) {
			dataTable[i] = array[i].toString(true).split("\t");
		}
		tablemodel = new DefaultTableModel(dataTable, columnNames);
		return tablemodel;
	}
	
	public Container display(Container pane) {
		Dimension size;
		this.table = new JTable(this.createTableModel());
		
		this.table.setPreferredScrollableViewportSize(new Dimension(800, 180));
		this.table.setFillsViewportHeight(true);
		this.table.setAutoCreateRowSorter(true);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane = new JScrollPane(this.table);
		size = scrollPane.getPreferredSize();
		scrollPane.setBounds(40, 30, size.width, size.height);
		
		super.display(pane).add(scrollPane); //Adiciona depois
		return pane;
	}
	
	public void insertScreen() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		Map<String, Component> inputs = new HashMap<String, Component>();
		int width = 250, height = 1;
		//Elementos - Inicio
		final JTextField id_input, sigla_input, nome_input, numero_input;
		JLabel id_label, sigla_label, nome_label, numero_label;
		
		id_label = new JLabel("Id", JLabel.RIGHT);
		
		id_input = new JTextField();
		Display.setSize(id_input, 80, 20);
		id_input.setEnabled(false);
		id_input.setBackground(new Color(244, 246, 248));
		
		sigla_label = new JLabel("Sigla", JLabel.RIGHT);
		
		sigla_input = new JTextField(); //inputError code: 2
		Display.setSize(sigla_input, 80, 20);
		sigla_input.setDocument(new JTextFieldLimit(10));
		sigla_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(sigla_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = sigla_input.getText();
				if(inputText.isEmpty() || Partido.existsByAcronym(inputText)) {
					Display.setErrorInputBorder(sigla_input);
					sigla_input.setToolTipText("Essa sigla já existe ou está vazia.");
					//JOptionPane.showMessageDialog(null, "Essa sigla já existe ou está vazia.", "Erro no campo \"Sigla\"", JOptionPane.ERROR_MESSAGE);
					setInputError(2);
				} else {
					Display.setSuccessInputBorder(sigla_input);
					unsetInputError(2);
				}
			}
		});
		
		nome_label = new JLabel("Nome", JLabel.RIGHT);
		
		nome_input = new JTextField(); //inputError code: 4
		Display.setSize(nome_input, 80, 20);
		nome_input.setDocument(new JTextFieldLimit(50));
		nome_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(nome_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = nome_input.getText();
				if(inputText.isEmpty() || Partido.existsByName(inputText)) {
					Display.setErrorInputBorder(nome_input);
					nome_input.setToolTipText("Esse nome já existe ou está vazio.");
					//JOptionPane.showMessageDialog(null, "Esse nome já existe ou está vazio.", "Erro no campo \"Nome\"", JOptionPane.ERROR_MESSAGE);
					setInputError(4);
				} else {
					Display.setSuccessInputBorder(nome_input);
					unsetInputError(4);
				}
			}
		});
		
		numero_label = new JLabel("Número", JLabel.RIGHT);
		
		numero_input = new JTextField(); //inputError code: 8
		Display.setSize(numero_input, 80, 20);
		numero_input.setDocument(new JTextFieldLimit(2, JTextFieldLimit.DIGITS_ONLY));
		numero_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(numero_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = numero_input.getText();
				if(inputText.isEmpty() || Partido.existsByNumber(Integer.parseInt(inputText))) {
					Display.setErrorInputBorder(numero_input);
					numero_input.setToolTipText("Esse número já existe ou está vazio.");
					//JOptionPane.showMessageDialog(null, "Esse número já existe ou está vazio.", "Erro no campo \"Número\"", JOptionPane.ERROR_MESSAGE);
					setInputError(8);
				} else {
					Display.setSuccessInputBorder(numero_input);
					unsetInputError(8);
				}
			}
		});
		
		panel.add(id_label);
		panel.add(id_input);
		inputs.put("id_input", id_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(sigla_label);
		panel.add(sigla_input);
		inputs.put("sigla_input", sigla_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(nome_label);
		panel.add(nome_input);
		inputs.put("nome_input", nome_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(numero_label);
		panel.add(numero_input);
		inputs.put("numero_input", numero_input);
		panel.add(Display.getWhitespace(width, height));
		
		Display.setSize(panel, 100, 130);
		
		//Elementos - Fim
		int result;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Inserindo Partido", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		} while((result == JOptionPane.OK_OPTION) && (this.inputError != 0));
		if(result == JOptionPane.OK_OPTION) {
			App1Worker.insertPartido(inputs);
			this.table.setModel(this.createTableModel());
		} else {
			this.inputError = 0; //resetando
		}
	}
	
	public void updateScreen(int id) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		Map<String, Component> inputs = new HashMap<String, Component>();
		int width = 250, height = 1;
		final Partido party = Partido.get(id);
		Partido.unregister(party); //Temporário
		//Elementos - Inicio
		final JTextField id_input, sigla_input, nome_input, numero_input;
		JLabel id_label, sigla_label, nome_label, numero_label;
		
		id_label = new JLabel("Id", JLabel.RIGHT);
		
		id_input = new JTextField(party.getId().toString());
		Display.setSize(id_input, 80, 20);
		id_input.setEnabled(false);
		id_input.setBackground(new Color(244, 246, 248));
		
		sigla_label = new JLabel("Sigla", JLabel.RIGHT);
		
		sigla_input = new JTextField(party.getSigla()); //inputError code: 2
		Display.setSize(sigla_input, 80, 20);
		sigla_input.setDocument(new JTextFieldLimit(10));
		sigla_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(sigla_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = sigla_input.getText();
				if(party.getSigla().equals(inputText)) {
					Display.setInactiveInputBorder(sigla_input);
				} else if(inputText.isEmpty() || Partido.existsByAcronym(inputText)) {
					Display.setErrorInputBorder(sigla_input);
					sigla_input.setToolTipText("Essa sigla já existe ou está vazia.");
					//JOptionPane.showMessageDialog(null, "Essa sigla já existe ou está vazia.", "Erro no campo \"Sigla\"", JOptionPane.ERROR_MESSAGE);
					setInputError(2);
				} else {
					Display.setSuccessInputBorder(sigla_input);
					unsetInputError(2);
				}
			}
		});
		
		nome_label = new JLabel("Nome", JLabel.RIGHT);
		
		nome_input = new JTextField(party.getNome()); //inputError code: 4
		Display.setSize(nome_input, 80, 20);
		nome_input.setDocument(new JTextFieldLimit(50));
		nome_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(nome_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = nome_input.getText();
				if(party.getNome().equals(inputText)) {
					Display.setInactiveInputBorder(nome_input);
				} else if(inputText.isEmpty() || Partido.existsByName(inputText)) {
					Display.setErrorInputBorder(nome_input);
					nome_input.setToolTipText("Esse nome já existe ou está vazio.");
					//JOptionPane.showMessageDialog(null, "Esse nome já existe ou está vazio.", "Erro no campo \"Nome\"", JOptionPane.ERROR_MESSAGE);
					setInputError(4);
				} else {
					Display.setSuccessInputBorder(nome_input);
					unsetInputError(4);
				}
			}
		});
		
		numero_label = new JLabel("Número", JLabel.RIGHT);
		
		numero_input = new JTextField(party.getNumero().toString()); //inputError code: 8
		Display.setSize(numero_input, 80, 20);
		numero_input.setDocument(new JTextFieldLimit(2, JTextFieldLimit.DIGITS_ONLY));
		numero_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(numero_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = numero_input.getText();
				if(party.getNumero().toString().equals(inputText)) {
					Display.setInactiveInputBorder(numero_input);
				} else if(inputText.isEmpty() || Partido.existsByNumber(Integer.parseInt(inputText))) {
					Display.setErrorInputBorder(numero_input);
					numero_input.setToolTipText("Esse número já existe ou está vazio.");
					//JOptionPane.showMessageDialog(null, "Esse número já existe ou está vazio.", "Erro no campo \"Número\"", JOptionPane.ERROR_MESSAGE);
					setInputError(8);
				} else {
					Display.setSuccessInputBorder(numero_input);
					unsetInputError(8);
				}
			}
		});
		
		panel.add(id_label);
		panel.add(id_input);
		inputs.put("id_input", id_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(sigla_label);
		panel.add(sigla_input);
		inputs.put("sigla_input", sigla_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(nome_label);
		panel.add(nome_input);
		inputs.put("nome_input", nome_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(numero_label);
		panel.add(numero_input);
		inputs.put("numero_input", numero_input);
		panel.add(Display.getWhitespace(width, height));
		
		Display.setSize(panel, 100, 130);
		
		//Elementos - Fim
		int result;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Inserindo Partido", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		} while((result == JOptionPane.OK_OPTION) && (this.inputError != 0));
		Partido.register(party); //Recolocando
		if((result == JOptionPane.OK_OPTION)) {
			App1Worker.updatePartido(inputs);
			this.table.setModel(this.createTableModel());
		} else {
			this.inputError = 0;
		}
	}
	
	public void deleteScreen(int id) {
		Partido party = Partido.get(id);
		String mes = "Deseja realmente apagar este partido?\nSigla: " + party.getSigla() + "\nNome: " + party.getNome() + "\nNúmero: " + party.getNumero().toString();
		int result = JOptionPane.showConfirmDialog(null, mes, "Confirmação de exclusão: Partido", JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			App1Worker.deletePartido(id);
			this.table.setModel(this.createTableModel());
		}
	}
}
