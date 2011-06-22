package resources.lib.view;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
	private static final long serialVersionUID = 1L;
	public static final int DIGITS_ONLY = 0;
	public static final int LETTERS_ONLY = 1;
	public static final int DIGITS_AND_LETTERS = 2;
	public static final int DATE = 3;
	public int digitsOrLetters;
	private int limit;
	public JTextFieldLimit(int limit) {
		super();
		this.limit = limit;
		this.digitsOrLetters = DIGITS_AND_LETTERS;
	}
	
	public JTextFieldLimit(int limit, int digitsOrLetters) {
		this(limit);
		this.digitsOrLetters = digitsOrLetters;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
		if(str == null) {return;}
		boolean success;
		if((getLength() + str.length()) <= limit) {
			if(this.digitsOrLetters == DIGITS_ONLY) {
				success = isNumeric(str);
			} else if(this.digitsOrLetters == LETTERS_ONLY) {
				success = isAlphabetic(str);
			} else if(this.digitsOrLetters == DATE) {
				success = isDatePart(str);
			} else {
				success = true;
			}
			if(success) {
				super.insertString(offset, str, attr);
			}
		}
	}
	
	private static boolean isDatePart(String str) {
		if(str == null) {return false;}
		boolean letterFound = false;
		int size = str.length(), i;
		for(i = 0; (i < size) && !letterFound; i++) {
			if(!Character.isDigit(str.charAt(i)) && (str.charAt(i) != '/')) {
				letterFound = true;
			}
		}
		return !letterFound;
	}
	
	private static boolean isNumeric(String str) {
		if(str == null) {return false;}
		boolean letterFound = false;
		int size = str.length(), i;
		for(i = 0; (i < size) && !letterFound; i++) {
			if(!Character.isDigit(str.charAt(i))) {
				letterFound = true;
			}
		}
		return !letterFound;
	}
	
	private static boolean isAlphabetic(String str) {
		if(str == null) {return false;}
		boolean digitFound = false;
		int size = str.length(), i;
		for(i = 0; (i < size) && !digitFound; i++) {
			if(!Character.isLetter(str.charAt(i))) {
				digitFound = true;
			}
		}
		return !digitFound;
	}
}
