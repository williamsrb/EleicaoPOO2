package modulo1.controller;

import java.awt.Component;
import java.util.Map;

import javax.swing.JOptionPane;

public final class App1Worker {
	
	public static void insertPartido(Map<String, Component> inputs) {
		JOptionPane.showMessageDialog(null, "insertPartido!");
	}

	public static void updatePartido(Map<String, Component> inputs) {
		JOptionPane.showMessageDialog(null, "updatePartido!");
	}
	
	public static void deletePartido(int id) {
		JOptionPane.showMessageDialog(null, "deletePartido!");
	}
}