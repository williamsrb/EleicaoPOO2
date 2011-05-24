package modulo2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Principal extends JPanel implements KeyListener, MouseListener {
	
	private static final long serialVersionUID = 1000L;
	
	public static void main(String args[]) {
		Insets frameInsets;
		JFrame frame = new JFrame("Urna Eletrônica");
		Dimension size;
		Container pane = frame.getContentPane();
		frame.setVisible(true);
		frameInsets = frame.getInsets();
		frame.setVisible(false);
		size = new Dimension(800 + frameInsets.left, 500 + frameInsets.top);
		
		JOptionPane.showMessageDialog(null, "Vote consciente!", "Bem-vindo!", JOptionPane.INFORMATION_MESSAGE);
		
		pane.setSize(size);
		
		View.buildInterface(frame);
		View.prepareEvents(frame);
		
		frame.setSize(pane.getWidth(), pane.getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
