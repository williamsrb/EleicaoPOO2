package modulo2.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import resources.lib.persistence.FileManager;

public class FileOperations {
	public static void writeVotingResults(List<Map<String, String>> votes) {
		File f;
		FileManager fm;
		BufferedWriter bw;
		int count = -1, size, i;
		String filename = "";
		Map<String, String> map;
		do {
			count++;
			filename = "urna" + String.format("%03d", count) + ".txt";
			f = new File(filename);
		} while(f.exists());
		fm = new FileManager(filename);
		bw = fm.getWriter();
		size = votes.size();
		for(i = 0; i < size; i++) {
			map = votes.get(i);
			try {
				bw.write(map.get("presidente") + "\t" + map.get("governador") + "\t" + map.get("deputado"));
				bw.newLine();
			} catch (IOException ioe) {
				System.err.println(ioe.getLocalizedMessage());
			}
		}
		try {
			bw.close();
		} catch (IOException ioe) {
			System.err.println(ioe.getLocalizedMessage());
		}
	}
}
