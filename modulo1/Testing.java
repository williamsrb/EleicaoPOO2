package modulo1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Testing extends JFrame implements KeyListener{

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				new Testing();
			}
		});
	}

	private Testing(){
		super("test");
		launch();
	}

	private void launch(){
		addKeyListener(this);
		setBounds(100,100,300,300);

		//add(new JButton("hi")); //here is the perp

		setVisible(true);
		setVisible(false);
		setVisible(true);
	}

	public void keyPressed(KeyEvent evt) {}
	public void keyReleased(KeyEvent evt) {
		int num = evt.getKeyCode();
		switch(num){
			case KeyEvent.VK_0: System.out.println("Zero"); break;
			case KeyEvent.VK_1: System.out.println("Um"); break;
		}
	}
	public void keyTyped(KeyEvent evt) {}
}
