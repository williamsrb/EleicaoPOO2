package modulo1.controller;

import java.awt.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import resources.lib.domain.Candidato;
import resources.lib.domain.Cargo;
import resources.lib.domain.Deputado;
import resources.lib.domain.Governador;
import resources.lib.domain.Partido;
import resources.lib.domain.Presidente;
import resources.lib.domain.persistence.*;
import resources.lib.other.DateString;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public final class App1Worker {
	public static void insertPartido(HashMap<String, JTextField> inputs) {
		JOptionPane.showMessageDialog(null, "insertPartido!");
		//Verificar por campos vazios, obrigatórios
		Partido party = new Partido(inputs.get("sigla_input").getText(), inputs.get("nome_input").getText(), Integer.parseInt(inputs.get("numero_input").getText()));
		App1Master.getPartidoDAO().salvar(party);
	}

	public static void updatePartido(Map<String, JTextField> inputs) {
		JOptionPane.showMessageDialog(null, "updatePartido!");
		//Verificar por campos vazios, obrigatórios
		Partido party = new Partido(Integer.parseInt(inputs.get("id_input").getText()), inputs.get("sigla_input").getText(), inputs.get("nome_input").getText(), Integer.parseInt(inputs.get("numero_input").getText()));
		App1Master.getPartidoDAO().salvar(party);
	}
	
	public static void deletePartido(int id) {
		JOptionPane.showMessageDialog(null, "deletePartido!");
		Partido party = Partido.get(id);
		App1Master.getPartidoDAO().excluir(party);
	}

	public static void insertCandidato(Map<String, JTextField> inputs) {
		JOptionPane.showMessageDialog(null, "insertCandidato!");
		//Verificar por campos vazios, obrigatórios
		Candidato person;
		int office = Integer.parseInt(inputs.get("cargo_input").getText());
		if(office == 1) { //Deputado
			person = new Deputado(Integer.parseInt(inputs.get("numero_input").getText()), inputs.get("nome_input").getText(), Partido.get(Integer.parseInt(inputs.get("partido_input").getText())), Cargo.get(Integer.parseInt(inputs.get("cargo_input").getText())), DateString.stringToDate(inputs.get("nascimento_input").getText()), inputs.get("sexo_input").getText().charAt(0), inputs.get("foto_input").getText(), inputs.get("site_input").getText(), inputs.get("apelido_input").getText());
			App1Master.getDeputadoDAO().salvar((Deputado) person);
		} else if(office == 2) { //Governador
			person = new Governador(Integer.parseInt(inputs.get("numero_input").getText()), inputs.get("nome_input").getText(), Partido.get(Integer.parseInt(inputs.get("partido_input").getText())), Cargo.get(Integer.parseInt(inputs.get("cargo_input").getText())), DateString.stringToDate(inputs.get("nascimento_input").getText()), inputs.get("sexo_input").getText().charAt(0), inputs.get("foto_input").getText(), inputs.get("site_input").getText(), inputs.get("vice_nome_input").getText(), inputs.get("vice_foto_input").getText());
			App1Master.getGovernadorDAO().salvar((Governador) person);
		} else { //Então, Presidente
			person = new Presidente(Integer.parseInt(inputs.get("numero_input").getText()), inputs.get("nome_input").getText(), Partido.get(Integer.parseInt(inputs.get("partido_input").getText())), Cargo.get(Integer.parseInt(inputs.get("cargo_input").getText())), DateString.stringToDate(inputs.get("nascimento_input").getText()), inputs.get("sexo_input").getText().charAt(0), inputs.get("foto_input").getText(), inputs.get("site_input").getText(), inputs.get("vice_nome_input").getText(), inputs.get("vice_foto_input").getText());
			App1Master.getPresidenteDAO().salvar((Presidente) person);
		}
	}
	
	public static void updateCandidato(Map<String, JTextField> inputs) {
		JOptionPane.showMessageDialog(null, "insertCandidato!");
		//Verificar por campos vazios, obrigatórios
		Candidato person;
		int office = Integer.parseInt(inputs.get("cargo_input").getText());
		if(office == 1) { //Deputado
			person = new Deputado(Integer.parseInt(inputs.get("id_input").getText()), Integer.parseInt(inputs.get("numero_input").getText()), inputs.get("nome_input").getText(), Partido.get(Integer.parseInt(inputs.get("partido_input").getText())), Cargo.get(Integer.parseInt(inputs.get("cargo_input").getText())), DateString.stringToDate(inputs.get("nascimento_input").getText()), inputs.get("sexo_input").getText().charAt(0), inputs.get("foto_input").getText(), inputs.get("site_input").getText(), inputs.get("apelido_input").getText());
			App1Master.getDeputadoDAO().salvar((Deputado) person);
		} else if(office == 2) { //Governador
			person = new Governador(Integer.parseInt(inputs.get("id_input").getText()), Integer.parseInt(inputs.get("numero_input").getText()), inputs.get("nome_input").getText(), Partido.get(Integer.parseInt(inputs.get("partido_input").getText())), Cargo.get(Integer.parseInt(inputs.get("cargo_input").getText())), DateString.stringToDate(inputs.get("nascimento_input").getText()), inputs.get("sexo_input").getText().charAt(0), inputs.get("foto_input").getText(), inputs.get("site_input").getText(), inputs.get("vice_nome_input").getText(), inputs.get("vice_foto_input").getText());
			App1Master.getGovernadorDAO().salvar((Governador) person);
		} else { //Então, Presidente
			person = new Presidente(Integer.parseInt(inputs.get("id_input").getText()), Integer.parseInt(inputs.get("numero_input").getText()), inputs.get("nome_input").getText(), Partido.get(Integer.parseInt(inputs.get("partido_input").getText())), Cargo.get(Integer.parseInt(inputs.get("cargo_input").getText())), DateString.stringToDate(inputs.get("nascimento_input").getText()), inputs.get("sexo_input").getText().charAt(0), inputs.get("foto_input").getText(), inputs.get("site_input").getText(), inputs.get("vice_nome_input").getText(), inputs.get("vice_foto_input").getText());
			App1Master.getPresidenteDAO().salvar((Presidente) person);
		}
	}
	
	public static void deleteCandidato(int id) {
		JOptionPane.showMessageDialog(null, "deleteCandidato!");
		Candidato person;
		if(Deputado.exists(id)) {
			person = Deputado.get(id);
			App1Master.getDeputadoDAO().excluir((Deputado) person);
		} else if(Governador.exists(id)) {
			person = Governador.get(id);
			App1Master.getGovernadorDAO().excluir((Governador) person);
		} else { //Então é presidente
			person = Presidente.get(id);
			App1Master.getPresidenteDAO().excluir((Presidente) person);
		}
	}
}