package resources.lib.other;

import java.awt.Dimension;

import javax.swing.JComponent;

public class Util {
	public static String toTitleCase(String string){
		String result = "";
		for (int i = 0; i < string.length(); i++){
			String next = string.substring(i, i + 1);
			if (i == 0){
				result += next.toUpperCase();
			} else {
				result += next.toLowerCase();
			}
		}
		return result;
	}
}
