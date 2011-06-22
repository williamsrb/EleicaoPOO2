package modulo1.controller;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import resources.lib.domain.Partido;
import resources.lib.domain.persistence.*;
import resources.lib.persistence.ConfigManager;
import resources.lib.persistence.JdbcConnection;

public final class App1Worker {
	public static void insertPartido(HashMap<String, JTextField> inputs) {
		JOptionPane.showMessageDialog(null, "insertPartido!");
		//Verificar por campos vazios, obrigatórios
		Partido party = new Partido(inputs.get("sigla_input").getText(), inputs.get("nome_input").getText(), Integer.parseInt(inputs.get("numero_input").getText()));
	}

	public static void updatePartido(Map<String, JTextField> inputs) {
		JOptionPane.showMessageDialog(null, "updatePartido!");
		//Verificar por campos vazios, obrigatórios
	}
	
	public static void deletePartido(int id) {
		JOptionPane.showMessageDialog(null, "deletePartido!");
	}

	public static void insertCandidato(Map<String, JTextField> inputs) {
		JOptionPane.showMessageDialog(null, "insertCandidato!");
		//Verificar por campos vazios, obrigatórios
	}
	
	public static void updateCandidato(Map<String, JTextField> inputs) {
		JOptionPane.showMessageDialog(null, "insertCandidato!");
		//Verificar por campos vazios, obrigatórios
	}
	
	public static void deleteCandidato(int id) {
		JOptionPane.showMessageDialog(null, "deleteCandidato!");
	}
}