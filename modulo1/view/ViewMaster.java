package modulo1.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import resources.lib.controller.FileUpload;
import resources.lib.view.Display;

public abstract class ViewMaster {
	protected JTable table;
	protected JButton insert;
	protected JButton update;
	protected JButton delete;
	protected JFrame window;
	protected int inputError; // 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024
	protected boolean changed;
	
	public abstract TableModel createTableModel();
	
	public abstract void insertScreen();
	
	public abstract void updateScreen(int id);
	
	public abstract void deleteScreen(int id);
	
	protected JTable getTable() {
		return this.table;
	}
	
	protected JButton getInsertBtn() {
		return this.insert;
	}
	
	protected JButton getUpdateBtn() {
		return this.update;
	}
	
	protected JButton getDeleteBtn() {
		return this.delete;
	}
	
	protected JFrame getWindow() {
		return this.window;
	}
	
	protected int getInputError() {
		return this.inputError;
	}

	protected boolean isChanged() {
		return changed;
	}

	protected void setChanged(boolean changed) {
		this.changed = changed;
	}

	protected void unsetInputError(int inputError) {
		this.inputError ^= (this.inputError & inputError);
	}
	
	protected void setInputError(int inputError) {
		this.inputError |= inputError;
	}

	protected void setWindow(JFrame window) {
		this.window = window;
	}
	
	protected void setTable(JTable table) {
		this.table = table;
	}
	
	protected void setInsertBtn(JButton insert) {
		this.insert = insert;
	}
	
	protected void setUpdateBtn(JButton update) {
		this.update = update;
	}
	
	protected void setDeleteBtn(JButton delete) {
		this.delete = delete;
	}
	
	protected Container display(Container pane) {
		Dimension size;
		int lastWidth = 0, lastX = 270;
		JButton insert, update, delete;
		
		insert = new JButton("Inserir", Display.pathToImageIcon(FileUpload.imagePath + "insert.png"));
		insert.setBorderPainted(false);
		size = insert.getPreferredSize();
		lastX = lastWidth + lastX;
		insert.setBounds(lastX, 240, size.width, size.height);
		lastWidth = size.width;
		
		update = new JButton("Atualizar", Display.pathToImageIcon(FileUpload.imagePath + "update.png"));
		update.setBorderPainted(false);
		size = update.getPreferredSize();
		lastX = lastWidth + lastX + 20;
		update.setBounds(lastX, 240, size.width, size.height);
		lastWidth = size.width;
		
		delete = new JButton("Remover", Display.pathToImageIcon(FileUpload.imagePath + "delete.png"));
		delete.setBorderPainted(false);
		size = delete.getPreferredSize();
		lastX = lastWidth + lastX + 20;
		delete.setBounds(lastX, 240, size.width, size.height);
		lastWidth = size.width;
		
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertScreen();
			}
		});
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table = getTable();
				DefaultTableModel model = (DefaultTableModel) (table.getModel());
				int row = table.getSelectedRow();
				if(model.getRowCount() > 0 && row != -1) {
					updateScreen(Integer.parseInt((String) model.getValueAt(row, 0)));
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table = getTable();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row = table.getSelectedRow();
				if(model.getRowCount() > 0 && row != -1) {
					deleteScreen(Integer.parseInt((String) model.getValueAt(row, 0)));
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum item selecionado.", "Atenção", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		this.insert = insert;
		pane.add(insert);
		this.update = update;
		pane.add(update);
		this.delete = delete;
		pane.add(delete);
		
		size = new Dimension(900, 300);
		pane.setPreferredSize(size);
		pane.setMaximumSize(size);
		pane.setMinimumSize(size);
		return pane;
	}
}
