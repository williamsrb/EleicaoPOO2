package modulo1.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import resources.lib.controller.DefaultFiles;
import resources.lib.other.Debug;

public class FileUpload {
	public static File copy(File infile, String prefix, Integer number) {
		File outfile = new File(DefaultFiles.uploadPath + ".default");
		boolean error = false;
		String pieces[];
		pieces = infile.getName().split("\\.");
		try {
			outfile = new File(DefaultFiles.relUploadPath + prefix + number.toString() + "." + pieces[1]);
			if(outfile.exists()) {
				int result = JOptionPane.showConfirmDialog(null, "Deseja sobre escrever o arquivo: \"" + outfile.getName() + "\"?", "O arquivo já existe", JOptionPane.YES_NO_OPTION);
				if(result != JOptionPane.YES_OPTION) {
					return outfile;
				}
				if(!outfile.canWrite()) {
					error = true;
				}
			}
		} catch(IndexOutOfBoundsException iobe) {
			System.err.println("Arquivo sem extensão");
			error = true;
		}
		if(!error && infile.exists()) {
			try {
				BufferedInputStream input = new BufferedInputStream(new FileInputStream(infile));
				BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(outfile));
				int bytes;
				while((bytes = input.read()) != -1) {
					output.write(bytes);
				}
				input.close();
				output.close();
			} catch (FileNotFoundException fnfe) {
				System.err.println(Debug.getTrace(fnfe.getLocalizedMessage()));
			} catch (IOException ioe) {
				System.err.println(Debug.getTrace(ioe.getLocalizedMessage()));
			}
		} else {
			System.err.println("Erro no upload de \"" + infile.getName() + "\"");
		}
		return (!error ? outfile : null);
	}
	
	public static File copy(File infile, Integer number) {
		return copy(infile, "", number);
	}
}
