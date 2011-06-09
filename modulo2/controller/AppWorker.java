package modulo2.controller;

import java.awt.Container;

import javax.swing.JOptionPane;

import modulo2.util.KeyEnum;
import modulo2.util.VotingKey;

public class AppWorker {
	public AppWorker() {
		//this.requestFocus();
	}
	
	public static void doButtonAction(KeyEnum key, Container parent) {
		JOptionPane.showMessageDialog(null, VotingKey.getPrefix(key), "Button Action", JOptionPane.INFORMATION_MESSAGE);
		parent.requestFocus();
	}
}
