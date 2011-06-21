package modulo1.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modulo1.controller.App1Worker;
import modulo1.util.FileUpload;
import modulo1.util.Validator;

import resources.lib.controller.DefaultFiles;
import resources.lib.domain.Candidato;
import resources.lib.domain.Cargo;
import resources.lib.domain.Deputado;
import resources.lib.domain.Governador;
import resources.lib.domain.Partido;
import resources.lib.domain.Presidente;
import resources.lib.other.ArrayCaster;
import resources.lib.view.Display;
import resources.lib.view.JTextFieldLimit;

public class CandidatoView extends ViewMaster {
	File foto_file;
	File vice_foto_file;

	public CandidatoView() {
		this.table = new JTable();
		this.insert = new JButton();
		this.update = new JButton();
		this.delete = new JButton();
	}
	
	protected File getFoto_file() {
		return this.foto_file;
	}

	protected File getVice_foto_file() {
		return this.vice_foto_file;
	}

	protected void setFoto_file(File foto_file) {
		this.foto_file = foto_file;
	}

	protected void setVice_foto_file(File vice_foto_file) {
		this.vice_foto_file = vice_foto_file;
	}

	public TableModel createTableModel() {
		TableModel tablemodel;
		String[] columnNames = {"Id", "Número", "Nome", "Partido", "Cargo", "Nascimento", "Sexo", "Foto", "Site"};
		Candidato array[] = ArrayCaster.objectCastCandidato(Candidato.getAll(true).toArray());
		int i, size = array.length;
		Partido p = null;
		Cargo c = null;
		String[][] dataTable = new String[size][];
		for(i = 0; i < size; i++) {
			dataTable[i] = array[i].toString(p, c).split("\t");
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
		final JTextField id_input, numero_input, nome_input, nascimento_input, site_input, apelido_input, vice_nome_input;
		final JTextField foto_hidden, vice_foto_hidden, partido_hidden, cargo_hidden, sexo_hidden;
		final JButton foto_btn, vice_foto_btn;
		final JComboBox partido_comboBox, cargo_comboBox, sexo_comboBox;
		final JLabel id_label, numero_label, nome_label, nascimento_label, site_label, foto_label, partido_label, cargo_label, sexo_label, apelido_label, vice_nome_label, vice_foto_label;
		
		id_label = new JLabel("Id", JLabel.RIGHT);
		
		id_input = new JTextField();
		Display.setSize(id_input, 80, 20);
		id_input.setEnabled(false);
		id_input.setBackground(new Color(244, 246, 248));
		
		numero_label = new JLabel("Número", JLabel.RIGHT);
		
		numero_input = new JTextField(); //inputError code: 2
		Display.setSize(numero_input, 80, 20);
		numero_input.setEnabled(false);
		numero_input.setDocument(new JTextFieldLimit(2, JTextFieldLimit.DIGITS_ONLY));
		
		nome_label = new JLabel("Nome", JLabel.RIGHT);
		
		nome_input = new JTextField(); //inputError code: 4
		Display.setSize(nome_input, 80, 20);
		nome_input.setDocument(new JTextFieldLimit(50));
		
		nascimento_label = new JLabel("Nascimento", JLabel.RIGHT);
		
		nascimento_input = new JTextField(); //inputError code: 8
		Display.setSize(nascimento_input, 80, 20);
		nascimento_input.setDocument(new JTextFieldLimit(10));
		
		site_label = new JLabel("Site", JLabel.RIGHT);
		
		site_input = new JTextField(); //inputError code: 16
		Display.setSize(site_input, 80, 20);
		site_input.setDocument(new JTextFieldLimit(50));
		
		foto_label = new JLabel("Foto", JLabel.RIGHT);
		
		foto_hidden = new JTextField("empty.jpg");
		final ImageIcon defaultIco = Display.pathToImageIcon(DefaultFiles.uploadPath + foto_hidden.getText());
		foto_btn = new JButton(defaultIco);
		Display.setSize(foto_btn, defaultIco.getIconWidth(), defaultIco.getIconHeight());
		foto_btn.setEnabled(false);
		
		partido_label = new JLabel("Partido", JLabel.RIGHT);
		
		partido_hidden = new JTextField(); //inputError code: 32
		partido_comboBox = new JComboBox(Partido.getAll().toArray());
		partido_comboBox.setSelectedItem(null);
		
		cargo_label = new JLabel("Cargo", JLabel.RIGHT);
		
		cargo_hidden = new JTextField(); //inputError code: 64
		cargo_comboBox = new JComboBox(Cargo.getAll().toArray());
		cargo_comboBox.setSelectedItem(null);
		
		sexo_label = new JLabel("Sexo", JLabel.RIGHT);
		
		sexo_hidden = new JTextField(); //inputError code: 128
		String genders[] = {"M", "F"};
		sexo_comboBox = new JComboBox(genders);
		sexo_comboBox.setSelectedItem(null);
		
		apelido_label = new JLabel("Apelido", JLabel.RIGHT);
		
		apelido_input = new JTextField();
		Display.setSize(apelido_input, 80, 20);
		apelido_input.setDocument(new JTextFieldLimit(50));
		
		vice_nome_label = new JLabel("Nome do Vice", JLabel.RIGHT);
		
		vice_nome_input = new JTextField(); //inputError code: 256
		Display.setSize(vice_nome_input, 80, 20);
		vice_nome_input.setDocument(new JTextFieldLimit(50));
		
		vice_foto_label = new JLabel("Foto do Vice", JLabel.RIGHT);
		
		vice_foto_hidden = new JTextField("mini_empty.jpg");
		final ImageIcon defaultIcoVice = Display.pathToImageIcon(DefaultFiles.uploadPath + vice_foto_hidden.getText());
		vice_foto_btn = new JButton(defaultIcoVice);
		Display.setSize(vice_foto_btn, defaultIcoVice.getIconWidth(), defaultIcoVice.getIconHeight());
		vice_foto_btn.setEnabled(false);
		
		//Eventos
		numero_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(numero_input);
				if(sexo_comboBox.getSelectedIndex() == -1) {
					Display.setErrorInputBorder(sexo_comboBox);
					sexo_comboBox.setToolTipText("Nenhum sexo selecionado.");
					setInputError(128);
				}
			}
			public void focusLost(FocusEvent e) {
				String inputText = numero_input.getText();
				Partido party = (Partido) partido_comboBox.getSelectedItem();
				Cargo office = (Cargo) cargo_comboBox.getSelectedItem();
				String number = party.getNumero().toString();
				if(inputText.isEmpty() || Deputado.existsByNumber(Integer.parseInt(inputText)) || Governador.existsByNumber(Integer.parseInt(inputText)) || Presidente.existsByNumber(Integer.parseInt(inputText))) {
					Display.setErrorInputBorder(numero_input);
					numero_input.setToolTipText("Esse número já existe ou está vazio.");
					//JOptionPane.showMessageDialog(null, "Esse número já existe ou está vazio.", "Erro no campo \"Número\"", JOptionPane.ERROR_MESSAGE);
					setInputError(2);
				} else if((inputText.length() < office.getDigitos().intValue()) || (number.charAt(0) != inputText.charAt(0)) || (number.charAt(1) != inputText.charAt(1))) {
					Display.setErrorInputBorder(numero_input);
					numero_input.setToolTipText("Número não de acordo com o cargo ou partido.");
					//JOptionPane.showMessageDialog(null, "Número não de acordo com o cargo ou partido.", "Erro no campo \"Número\"", JOptionPane.ERROR_MESSAGE);
					setInputError(2);
				} else {
					Display.setSuccessInputBorder(numero_input);
					if(!foto_btn.isEnabled()) {
						foto_btn.setEnabled(true);
					}
					if(!vice_foto_btn.isEnabled() && vice_foto_btn.isVisible()) {
						vice_foto_btn.setEnabled(true);
					}
					unsetInputError(2);
				}
			}
		});
		
		nome_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(nome_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = nome_input.getText();
				if(inputText.isEmpty()) {
					Display.setErrorInputBorder(nome_input);
					nome_input.setToolTipText("Nome vazio.");
					//JOptionPane.showMessageDialog(null, "Nome vazio.", "Erro no campo \"Nome\"", JOptionPane.ERROR_MESSAGE);
					setInputError(4);
				} else {
					Display.setSuccessInputBorder(nome_input);
					unsetInputError(4);
				}
			}
		});
		
		nascimento_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(nascimento_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = nascimento_input.getText();
				if(inputText.isEmpty()) {
					Display.setErrorInputBorder(nascimento_input);
					nascimento_input.setToolTipText("Data vazia.");
					//JOptionPane.showMessageDialog(null, "Data vazia.", "Erro no campo \"Nascimento\"", JOptionPane.ERROR_MESSAGE);
					setInputError(8);
				} else if(!Validator.isMature(inputText)) {
					Display.setErrorInputBorder(nascimento_input);
					nascimento_input.setToolTipText("Menor de idade ou data mal formada.");
					//JOptionPane.showMessageDialog(null, "Menor de idade ou data mal formada.", "Erro no campo \"Nascimento\"", JOptionPane.ERROR_MESSAGE);
					setInputError(8);
				} else {
					Display.setSuccessInputBorder(nascimento_input);
					unsetInputError(8);
				}
			}
		});
		
		site_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(site_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = site_input.getText();
				if(!inputText.isEmpty() && !Validator.isURL(inputText)) {
					Display.setErrorInputBorder(site_input);
					site_input.setToolTipText("Url mal formada.");
					//JOptionPane.showMessageDialog(null, "Url mal formada.", "Erro no campo \"Site\"", JOptionPane.ERROR_MESSAGE);
					setInputError(16);
				} else {
					Display.setSuccessInputBorder(site_input);
					unsetInputError(16);
				}
			}
		});
		
		foto_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser foto_chooser;
				FileNameExtensionFilter filter;
				File outfile;
				if(hasInputError(2)) { //Código "inputError" de "numero_input"
					foto_btn.setToolTipText("Corrija o número do candidato, antes.");
					//JOptionPane.showMessageDialog(null, "Corrija o número do candidato, antes.", "Erro no campo \"Foto\"", JOptionPane.ERROR_MESSAGE);
					numero_input.requestFocus();
				} else {
					foto_chooser = new JFileChooser();
					filter = new FileNameExtensionFilter("Imagens", "jpg", "gif", "png");
					foto_chooser.setFileFilter(filter);
					int returnVal = foto_chooser.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File file = foto_chooser.getSelectedFile();
						outfile = FileUpload.copy(file, Integer.parseInt(numero_input.getText()));
						if(outfile != null) {
							foto_hidden.setText(outfile.getName());
							CandidatoView.this.setFoto_file(outfile);
							foto_btn.setIcon(new ImageIcon(outfile.getPath()));
						} else {
							foto_btn.setIcon(defaultIco);
						}
					}
				}
			}
		});
		
		sexo_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sexo_comboBox.getSelectedIndex() != -1) {
					Display.setSuccessInputBorder(sexo_comboBox);
					unsetInputError(128);
					sexo_hidden.setText((String) sexo_comboBox.getSelectedItem());
				}
			}
		});
		
		partido_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partido party;
				if(partido_comboBox.getSelectedIndex() != -1) {
					party = (Partido) partido_comboBox.getSelectedItem();
					if((cargo_comboBox.getSelectedIndex() != -1)) {
						if(!numero_input.isEnabled()) {
							numero_input.setEnabled(true);
							numero_input.setText(party.getNumero().toString());
						}
					}
					Display.setSuccessInputBorder(partido_comboBox);
					unsetInputError(32);
					partido_hidden.setText(party.getId().toString());
				}
				if(cargo_comboBox.getSelectedIndex() == -1) {
					Display.setErrorInputBorder(cargo_comboBox);
					cargo_comboBox.setToolTipText("Nenhum cargo selecionado.");
					setInputError(64);
				}
			}
		});
		
		cargo_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cargo office;
				if(cargo_comboBox.getSelectedIndex() != -1) {
					if((partido_comboBox.getSelectedIndex() != -1)) {
						if(!numero_input.isEnabled()) {
							numero_input.setEnabled(true);
						}
					}
					office = (Cargo) cargo_comboBox.getSelectedItem();
					numero_input.setDocument(new JTextFieldLimit(office.getDigitos().intValue(), JTextFieldLimit.DIGITS_ONLY)); //Setando um limite baseado no número de digitos do cargo
					if(office.getId() == 1) { //Deputado
						apelido_label.setVisible(true);
						apelido_input.setVisible(true);
					} else { //Governador e Presidente
						vice_nome_label.setVisible(true);
						vice_nome_input.setVisible(true);
						vice_foto_label.setVisible(true);
						vice_foto_btn.setVisible(true);
						vice_nome_input.requestFocus(); //Forçar validação do campo
					}
					Display.setSuccessInputBorder(cargo_comboBox);
					unsetInputError(64);
					cargo_hidden.setText(office.getId().toString());
				}
				
				if(partido_comboBox.getSelectedIndex() == -1) {
					Display.setErrorInputBorder(partido_comboBox);
					partido_comboBox.setToolTipText("Nenhum partido selecionado.");
					setInputError(32);
				}
			}
		});
		
		apelido_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(apelido_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = apelido_input.getText();
				if(inputText.isEmpty()) {
					Display.setInactiveInputBorder(apelido_input);
				} else {
					Display.setSuccessInputBorder(apelido_input);
				}
			}
		});
		
		vice_nome_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(vice_nome_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = vice_nome_input.getText();
				
				if(inputText.isEmpty()) {
					Display.setErrorInputBorder(vice_nome_input);
					vice_nome_input.setToolTipText("Nome do vice vazio.");
					//JOptionPane.showMessageDialog(null, "Nome do vice vazio.", "Erro no campo \"Nome do vice\"", JOptionPane.ERROR_MESSAGE);
					setInputError(256);
				} else {
					Display.setSuccessInputBorder(vice_nome_input);
					unsetInputError(256);
				}
			}
		});
		
		vice_foto_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser foto_chooser;
				FileNameExtensionFilter filter;
				File outfile;
				if(numero_input.getText().isEmpty()) {
					numero_input.requestFocus();
					return;
				}
				if(hasInputError(2)) { //Código "inputError" de "numero_input"
					vice_foto_btn.setToolTipText("Corrija o número do candidato, antes.");
					//JOptionPane.showMessageDialog(null, "Corrija o número do candidato, antes.", "Erro no campo \"Foto\"", JOptionPane.ERROR_MESSAGE);
				} else {
					foto_chooser = new JFileChooser();
					filter = new FileNameExtensionFilter("Imagens", "jpg", "gif", "png");
					foto_chooser.setFileFilter(filter);
					int returnVal = foto_chooser.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File file = foto_chooser.getSelectedFile();
						outfile = FileUpload.copy(file, "vice_", Integer.parseInt(numero_input.getText()));
						if(outfile != null) {
							vice_foto_hidden.setText(outfile.getName());
							CandidatoView.this.setVice_foto_file(outfile);
							vice_foto_btn.setIcon(new ImageIcon(outfile.getPath()));
						} else {
							vice_foto_btn.setIcon(defaultIcoVice);
						}
					}
				}
			}
		});
		
		
		panel.add(id_label);
		panel.add(id_input);
		inputs.put("id_input", id_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(cargo_label);
		panel.add(cargo_comboBox);
		inputs.put("cargo_input", cargo_hidden); //Mudar
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(partido_label);
		panel.add(partido_comboBox);
		inputs.put("partido_input", partido_hidden); //Mudar
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(numero_label);
		panel.add(numero_input);
		inputs.put("numero_input", numero_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(nome_label);
		panel.add(nome_input);
		inputs.put("nome_input", nome_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(apelido_label);
		panel.add(apelido_input);
		inputs.put("apelido_input", apelido_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(sexo_label);
		panel.add(sexo_comboBox);
		inputs.put("sexo_input", sexo_hidden); //Mudar
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(nascimento_label);
		panel.add(nascimento_input);
		inputs.put("nascimento_input", nascimento_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(site_label);
		panel.add(site_input);
		inputs.put("site_input", site_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(foto_label);
		panel.add(foto_btn);
		inputs.put("foto_input", foto_hidden);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(vice_nome_label);
		panel.add(vice_nome_input);
		inputs.put("vice_nome_input", vice_nome_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(vice_foto_label);
		panel.add(vice_foto_btn);
		inputs.put("vice_foto_input", vice_foto_hidden);
		panel.add(Display.getWhitespace(width, height));
		
		Display.setSize(panel, 100, 630);
		
		//Elementos - Fim
		int result;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Inserindo Candidato", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		} while((result == JOptionPane.OK_OPTION) && (this.inputError != 0));
		if(result == JOptionPane.OK_OPTION) {
			App1Worker.insertCandidato(inputs);
			this.table.setModel(this.createTableModel());
		} else {
			if(this.foto_file != null && this.foto_file.exists()) {
				this.foto_file.delete();
				this.foto_file = null;
			}
			if(this.vice_foto_file != null && this.vice_foto_file.exists()) {
				this.vice_foto_file.delete();
				this.vice_foto_file = null;
			}
			this.inputError = 0; //resetando
		}
	}
	
	public void updateScreen(int id) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		Map<String, Component> inputs = new HashMap<String, Component>();
		int width = 250, height = 1;
		//Elementos - Inicio
		final JTextField id_input, numero_input, nome_input, nascimento_input, site_input, apelido_input, vice_nome_input;
		final JTextField foto_hidden, vice_foto_hidden, partido_hidden, cargo_hidden, sexo_hidden;
		final JButton foto_btn, vice_foto_btn;
		final JComboBox partido_comboBox, cargo_comboBox, sexo_comboBox;
		final JLabel id_label, numero_label, nome_label, nascimento_label, site_label, foto_label, partido_label, cargo_label, sexo_label, apelido_label, vice_nome_label, vice_foto_label;
		
		id_label = new JLabel("Id", JLabel.RIGHT);
		
		id_input = new JTextField();
		Display.setSize(id_input, 80, 20);
		id_input.setEnabled(false);
		id_input.setBackground(new Color(244, 246, 248));
		
		numero_label = new JLabel("Número", JLabel.RIGHT);
		
		numero_input = new JTextField(); //inputError code: 2
		Display.setSize(numero_input, 80, 20);
		numero_input.setEnabled(false);
		numero_input.setDocument(new JTextFieldLimit(2, JTextFieldLimit.DIGITS_ONLY));
		
		nome_label = new JLabel("Nome", JLabel.RIGHT);
		
		nome_input = new JTextField(); //inputError code: 4
		Display.setSize(nome_input, 80, 20);
		nome_input.setDocument(new JTextFieldLimit(50));
		
		nascimento_label = new JLabel("Nascimento", JLabel.RIGHT);
		
		nascimento_input = new JTextField(); //inputError code: 8
		Display.setSize(nascimento_input, 80, 20);
		nascimento_input.setDocument(new JTextFieldLimit(10));
		
		site_label = new JLabel("Site", JLabel.RIGHT);
		
		site_input = new JTextField(); //inputError code: 16
		Display.setSize(site_input, 80, 20);
		site_input.setDocument(new JTextFieldLimit(50));
		
		foto_label = new JLabel("Foto", JLabel.RIGHT);
		
		foto_hidden = new JTextField("empty.jpg");
		final ImageIcon defaultIco = Display.pathToImageIcon(DefaultFiles.uploadPath + foto_hidden.getText());
		foto_btn = new JButton(defaultIco);
		Display.setSize(foto_btn, defaultIco.getIconWidth(), defaultIco.getIconHeight());
		foto_btn.setEnabled(false);
		
		partido_label = new JLabel("Partido", JLabel.RIGHT);
		
		partido_hidden = new JTextField(); //inputError code: 32
		partido_comboBox = new JComboBox(Partido.getAll().toArray());
		partido_comboBox.setSelectedItem(null);
		
		cargo_label = new JLabel("Cargo", JLabel.RIGHT);
		
		cargo_hidden = new JTextField(); //inputError code: 64
		cargo_comboBox = new JComboBox(Cargo.getAll().toArray());
		cargo_comboBox.setSelectedItem(null);
		
		sexo_label = new JLabel("Sexo", JLabel.RIGHT);
		
		sexo_hidden = new JTextField(); //inputError code: 128
		String genders[] = {"M", "F"};
		sexo_comboBox = new JComboBox(genders);
		sexo_comboBox.setSelectedItem(null);
		
		apelido_label = new JLabel("Apelido", JLabel.RIGHT);
		
		apelido_input = new JTextField();
		Display.setSize(apelido_input, 80, 20);
		apelido_input.setDocument(new JTextFieldLimit(50));
		
		vice_nome_label = new JLabel("Nome do Vice", JLabel.RIGHT);
		
		vice_nome_input = new JTextField(); //inputError code: 256
		Display.setSize(vice_nome_input, 80, 20);
		vice_nome_input.setDocument(new JTextFieldLimit(50));
		
		vice_foto_label = new JLabel("Foto do Vice", JLabel.RIGHT);
		
		vice_foto_hidden = new JTextField("mini_empty.jpg");
		final ImageIcon defaultIcoVice = Display.pathToImageIcon(DefaultFiles.uploadPath + vice_foto_hidden.getText());
		vice_foto_btn = new JButton(defaultIcoVice);
		Display.setSize(vice_foto_btn, defaultIcoVice.getIconWidth(), defaultIcoVice.getIconHeight());
		vice_foto_btn.setEnabled(false);
		
		//Eventos
		numero_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(numero_input);
				if(sexo_comboBox.getSelectedIndex() == -1) {
					Display.setErrorInputBorder(sexo_comboBox);
					sexo_comboBox.setToolTipText("Nenhum sexo selecionado.");
					setInputError(128);
				}
			}
			public void focusLost(FocusEvent e) {
				String inputText = numero_input.getText();
				Partido party = (Partido) partido_comboBox.getSelectedItem();
				Cargo office = (Cargo) cargo_comboBox.getSelectedItem();
				String number = party.getNumero().toString();
				if(inputText.isEmpty() || Deputado.existsByNumber(Integer.parseInt(inputText)) || Governador.existsByNumber(Integer.parseInt(inputText)) || Presidente.existsByNumber(Integer.parseInt(inputText))) {
					Display.setErrorInputBorder(numero_input);
					numero_input.setToolTipText("Esse número já existe ou está vazio.");
					//JOptionPane.showMessageDialog(null, "Esse número já existe ou está vazio.", "Erro no campo \"Número\"", JOptionPane.ERROR_MESSAGE);
					setInputError(2);
				} else if((inputText.length() < office.getDigitos().intValue()) || (number.charAt(0) != inputText.charAt(0)) || (number.charAt(1) != inputText.charAt(1))) {
					Display.setErrorInputBorder(numero_input);
					numero_input.setToolTipText("Número não de acordo com o cargo ou partido.");
					//JOptionPane.showMessageDialog(null, "Número não de acordo com o cargo ou partido.", "Erro no campo \"Número\"", JOptionPane.ERROR_MESSAGE);
					setInputError(2);
				} else {
					Display.setSuccessInputBorder(numero_input);
					if(!foto_btn.isEnabled()) {
						foto_btn.setEnabled(true);
					}
					if(!vice_foto_btn.isEnabled() && vice_foto_btn.isVisible()) {
						vice_foto_btn.setEnabled(true);
					}
					unsetInputError(2);
				}
			}
		});
		
		nome_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(nome_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = nome_input.getText();
				if(inputText.isEmpty()) {
					Display.setErrorInputBorder(nome_input);
					nome_input.setToolTipText("Nome vazio.");
					//JOptionPane.showMessageDialog(null, "Nome vazio.", "Erro no campo \"Nome\"", JOptionPane.ERROR_MESSAGE);
					setInputError(4);
				} else {
					Display.setSuccessInputBorder(nome_input);
					unsetInputError(4);
				}
			}
		});
		
		nascimento_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(nascimento_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = nascimento_input.getText();
				if(inputText.isEmpty()) {
					Display.setErrorInputBorder(nascimento_input);
					nascimento_input.setToolTipText("Data vazia.");
					//JOptionPane.showMessageDialog(null, "Data vazia.", "Erro no campo \"Nascimento\"", JOptionPane.ERROR_MESSAGE);
					setInputError(8);
				} else if(!Validator.isMature(inputText)) {
					Display.setErrorInputBorder(nascimento_input);
					nascimento_input.setToolTipText("Menor de idade ou data mal formada.");
					//JOptionPane.showMessageDialog(null, "Menor de idade ou data mal formada.", "Erro no campo \"Nascimento\"", JOptionPane.ERROR_MESSAGE);
					setInputError(8);
				} else {
					Display.setSuccessInputBorder(nascimento_input);
					unsetInputError(8);
				}
			}
		});
		
		site_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(site_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = site_input.getText();
				if(!inputText.isEmpty() && !Validator.isURL(inputText)) {
					Display.setErrorInputBorder(site_input);
					site_input.setToolTipText("Url mal formada.");
					//JOptionPane.showMessageDialog(null, "Url mal formada.", "Erro no campo \"Site\"", JOptionPane.ERROR_MESSAGE);
					setInputError(16);
				} else {
					Display.setSuccessInputBorder(site_input);
					unsetInputError(16);
				}
			}
		});
		
		foto_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser foto_chooser;
				FileNameExtensionFilter filter;
				File outfile;
				if(hasInputError(2)) { //Código "inputError" de "numero_input"
					foto_btn.setToolTipText("Corrija o número do candidato, antes.");
					//JOptionPane.showMessageDialog(null, "Corrija o número do candidato, antes.", "Erro no campo \"Foto\"", JOptionPane.ERROR_MESSAGE);
					numero_input.requestFocus();
				} else {
					foto_chooser = new JFileChooser();
					filter = new FileNameExtensionFilter("Imagens", "jpg", "gif", "png");
					foto_chooser.setFileFilter(filter);
					int returnVal = foto_chooser.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File file = foto_chooser.getSelectedFile();
						outfile = FileUpload.copy(file, Integer.parseInt(numero_input.getText()));
						if(outfile != null) {
							foto_hidden.setText(outfile.getName());
							CandidatoView.this.setFoto_file(outfile);
							foto_btn.setIcon(new ImageIcon(outfile.getPath()));
						} else {
							foto_btn.setIcon(defaultIco);
						}
					}
				}
			}
		});
		
		sexo_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sexo_comboBox.getSelectedIndex() != -1) {
					Display.setSuccessInputBorder(sexo_comboBox);
					unsetInputError(128);
					sexo_hidden.setText((String) sexo_comboBox.getSelectedItem());
				}
			}
		});
		
		partido_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partido party;
				if(partido_comboBox.getSelectedIndex() != -1) {
					party = (Partido) partido_comboBox.getSelectedItem();
					if((cargo_comboBox.getSelectedIndex() != -1)) {
						if(!numero_input.isEnabled()) {
							numero_input.setEnabled(true);
							numero_input.setText(party.getNumero().toString());
						}
					}
					Display.setSuccessInputBorder(partido_comboBox);
					unsetInputError(32);
					partido_hidden.setText(party.getId().toString());
				}
				if(cargo_comboBox.getSelectedIndex() == -1) {
					Display.setErrorInputBorder(cargo_comboBox);
					cargo_comboBox.setToolTipText("Nenhum cargo selecionado.");
					setInputError(64);
				}
			}
		});
		
		cargo_comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cargo office;
				if(cargo_comboBox.getSelectedIndex() != -1) {
					if((partido_comboBox.getSelectedIndex() != -1)) {
						if(!numero_input.isEnabled()) {
							numero_input.setEnabled(true);
						}
					}
					office = (Cargo) cargo_comboBox.getSelectedItem();
					numero_input.setDocument(new JTextFieldLimit(office.getDigitos().intValue(), JTextFieldLimit.DIGITS_ONLY)); //Setando um limite baseado no número de digitos do cargo
					if(office.getId() == 1) { //Deputado
						apelido_label.setVisible(true);
						apelido_input.setVisible(true);
					} else { //Governador e Presidente
						vice_nome_label.setVisible(true);
						vice_nome_input.setVisible(true);
						vice_foto_label.setVisible(true);
						vice_foto_btn.setVisible(true);
						vice_nome_input.requestFocus(); //Forçar validação do campo
					}
					Display.setSuccessInputBorder(cargo_comboBox);
					unsetInputError(64);
					cargo_hidden.setText(office.getId().toString());
				}
				
				if(partido_comboBox.getSelectedIndex() == -1) {
					Display.setErrorInputBorder(partido_comboBox);
					partido_comboBox.setToolTipText("Nenhum partido selecionado.");
					setInputError(32);
				}
			}
		});
		
		apelido_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(apelido_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = apelido_input.getText();
				if(inputText.isEmpty()) {
					Display.setInactiveInputBorder(apelido_input);
				} else {
					Display.setSuccessInputBorder(apelido_input);
				}
			}
		});
		
		vice_nome_input.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				Display.setActiveInputBorder(vice_nome_input);
			}
			public void focusLost(FocusEvent e) {
				String inputText = vice_nome_input.getText();
				
				if(inputText.isEmpty()) {
					Display.setErrorInputBorder(vice_nome_input);
					vice_nome_input.setToolTipText("Nome do vice vazio.");
					//JOptionPane.showMessageDialog(null, "Nome do vice vazio.", "Erro no campo \"Nome do vice\"", JOptionPane.ERROR_MESSAGE);
					setInputError(256);
				} else {
					Display.setSuccessInputBorder(vice_nome_input);
					unsetInputError(256);
				}
			}
		});
		
		vice_foto_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser foto_chooser;
				FileNameExtensionFilter filter;
				File outfile;
				if(numero_input.getText().isEmpty()) {
					numero_input.requestFocus();
					return;
				}
				if(hasInputError(2)) { //Código "inputError" de "numero_input"
					vice_foto_btn.setToolTipText("Corrija o número do candidato, antes.");
					//JOptionPane.showMessageDialog(null, "Corrija o número do candidato, antes.", "Erro no campo \"Foto\"", JOptionPane.ERROR_MESSAGE);
				} else {
					foto_chooser = new JFileChooser();
					filter = new FileNameExtensionFilter("Imagens", "jpg", "gif", "png");
					foto_chooser.setFileFilter(filter);
					int returnVal = foto_chooser.showOpenDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File file = foto_chooser.getSelectedFile();
						outfile = FileUpload.copy(file, "vice_", Integer.parseInt(numero_input.getText()));
						if(outfile != null) {
							vice_foto_hidden.setText(outfile.getName());
							CandidatoView.this.setVice_foto_file(outfile);
							vice_foto_btn.setIcon(new ImageIcon(outfile.getPath()));
						} else {
							vice_foto_btn.setIcon(defaultIcoVice);
						}
					}
				}
			}
		});
		
		
		panel.add(id_label);
		panel.add(id_input);
		inputs.put("id_input", id_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(cargo_label);
		panel.add(cargo_comboBox);
		inputs.put("cargo_input", cargo_hidden); //Mudar
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(partido_label);
		panel.add(partido_comboBox);
		inputs.put("partido_input", partido_hidden); //Mudar
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(numero_label);
		panel.add(numero_input);
		inputs.put("numero_input", numero_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(nome_label);
		panel.add(nome_input);
		inputs.put("nome_input", nome_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(apelido_label);
		panel.add(apelido_input);
		inputs.put("apelido_input", apelido_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(sexo_label);
		panel.add(sexo_comboBox);
		inputs.put("sexo_input", sexo_hidden); //Mudar
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(nascimento_label);
		panel.add(nascimento_input);
		inputs.put("nascimento_input", nascimento_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(site_label);
		panel.add(site_input);
		inputs.put("site_input", site_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(foto_label);
		panel.add(foto_btn);
		inputs.put("foto_input", foto_hidden);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(vice_nome_label);
		panel.add(vice_nome_input);
		inputs.put("vice_nome_input", vice_nome_input);
		panel.add(Display.getWhitespace(width, height));
		
		panel.add(vice_foto_label);
		panel.add(vice_foto_btn);
		inputs.put("vice_foto_input", vice_foto_hidden);
		panel.add(Display.getWhitespace(width, height));
		
		Display.setSize(panel, 100, 630);
		
		//Elementos - Fim
		int result;
		do {
			result = JOptionPane.showConfirmDialog(null, panel, "Inserindo Candidato", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		} while((result == JOptionPane.OK_OPTION) && (this.inputError != 0));
		if(result == JOptionPane.OK_OPTION) {
			App1Worker.insertCandidato(inputs);
			this.table.setModel(this.createTableModel());
		} else {
			if(this.foto_file != null && this.foto_file.exists()) {
				this.foto_file.delete();
				this.foto_file = null;
			}
			if(this.vice_foto_file != null && this.vice_foto_file.exists()) {
				this.vice_foto_file.delete();
				this.vice_foto_file = null;
			}
			this.inputError = 0; //resetando
		}
	}
	
	public void deleteScreen(int id) {
/*		Candidato party = Candidato.get(id);
		String mes = "Deseja realmente apagar este partido?\nSigla: " + party.getSigla() + "\nNome: " + party.getNome() + "\nNúmero: " + party.getNumero().toString();
		int result = JOptionPane.showConfirmDialog(null, mes, "Confirmação de exclusão: Candidato", JOptionPane.OK_CANCEL_OPTION);
		if(result == JOptionPane.OK_OPTION) {
			App1Worker.deleteCandidato(id);
			this.table.setModel(this.createTableModel());
		}
	*/}
}
