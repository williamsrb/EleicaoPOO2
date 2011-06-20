package modulo1.testes;

/*
 * SimpleTableDemo.java requires no other files.
 */

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import modulo1.view.PartidoView;
import resources.lib.controller.FileUpload;
import resources.lib.domain.Candidato;
import resources.lib.domain.Partido;
import resources.lib.domain.persistence.CargoDAOjdbc;
import resources.lib.domain.persistence.DeputadoDAOjdbc;
import resources.lib.domain.persistence.GovernadorDAOjdbc;
import resources.lib.domain.persistence.PartidoDAOjdbc;
import resources.lib.domain.persistence.PresidenteDAOjdbc;
import resources.lib.view.Display;

@SuppressWarnings("serial")
public class SimpleTableDemo extends JPanel {
	
	public SimpleTableDemo() {
		super(null);
		CargoDAOjdbc.getInstance().obter();
		PartidoDAOjdbc.getInstance().obter();
		DeputadoDAOjdbc.getInstance().obter();
		GovernadorDAOjdbc.getInstance().obter();
		PresidenteDAOjdbc.getInstance().obter();
		
		Dimension size;
		int lastWidth = 0, lastX = 270;
		JButton insert, update, delete;
		JTable table = null;//PartidoView.createTable();
		
		table.setPreferredScrollableViewportSize(new Dimension(800, 180));
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		insert = new JButton("Insert", Display.pathToImageIcon(FileUpload.imagePath + "insert.png"));
		insert.setBorderPainted(false);
		size = insert.getPreferredSize();
		lastX = lastWidth + lastX;
		insert.setBounds(lastX, 240, size.width, size.height);
		lastWidth = size.width;
		
		update = new JButton("Update", Display.pathToImageIcon(FileUpload.imagePath + "update.png"));
		update.setBorderPainted(false);
		size = update.getPreferredSize();
		lastX = lastWidth + lastX + 20;
		update.setBounds(lastX, 240, size.width, size.height);
		lastWidth = size.width;
		
		delete = new JButton("Delete", Display.pathToImageIcon(FileUpload.imagePath + "delete.png"));
		delete.setBorderPainted(false);
		size = delete.getPreferredSize();
		lastX = lastWidth + lastX + 20;
		delete.setBounds(lastX, 240, size.width, size.height);
		lastWidth = size.width;
		
		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);
		size = scrollPane.getPreferredSize();
		scrollPane.setBounds(40, 30, size.width, size.height);

		//Add the scroll pane to this panel.
		add(insert);
		add(update);
		add(delete);
		add(scrollPane);
		
		size = new Dimension(900, 300);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}
	
	public static void reloadTable(JTable table, List<Partido> list, Partido flag) {
		clearTable(table);
		//((DefaultTableModel)table.getModel()).removeRow(1);
	}
	
	public static void reloadTable(JTable table, List<Candidato> list, Candidato flag) {
		int size = list.size(), i;
		clearTable(table);
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		for(i = 0; i < size; i++) {
			model.addRow(list.get(i).toString().split("\t"));
		}
	}
	
	public static void clearTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		int size = model.getRowCount(), i;
		for(i = 0; i < size; i++) {
			model.removeRow(i);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("SimpleTableDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Create and set up the content pane.
		SimpleTableDemo newContentPane = new SimpleTableDemo();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		Dimension size = new Dimension(900, 300);
		frame.setPreferredSize(size);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
