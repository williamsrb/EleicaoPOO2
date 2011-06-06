package modulo1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
 
/**
 *
 * @author
 */
 
 
public class KeyStrokeSample {
 
    public static void main(String[] args) {
 
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
 
        // set this panel's layout to null for absolute positioning of components
        panel.setLayout(null);
 
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        
        button1.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_HOME) {
					JOptionPane.showMessageDialog(null, "VK_HOME pressed");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_HOME) {
					JOptionPane.showMessageDialog(null, "VK_HOME released");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_HOME) {
					JOptionPane.showMessageDialog(null, "VK_HOME typed");
				}
			}
        	
        });
        
        button2.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_END) {
					JOptionPane.showMessageDialog(null, "VK_END pressed");
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_END) {
					JOptionPane.showMessageDialog(null, "VK_END released");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_END) {
					JOptionPane.showMessageDialog(null, "VK_END typed");
				}
			}
        	
        });
 
        button1.setText("Press The Home Key");
        button1.setBounds(0, 0, 200, 120);
        button2.setText("Press The End Key");
        button2.setBounds(200, 120, 200, 120);
        panel.add(button1);
        panel.add(button2);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setSize(400, 240);
    }
}