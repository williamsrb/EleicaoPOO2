package resources.lib.other;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateString {
	public static Date stringToDate(String str) {
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = dateformat.parse(str);
		} catch (ParseException pe) {
			System.err.println(pe.getLocalizedMessage());
		}
		return date;
	}
	
	public static String dateToString(Date dt) {
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder DDMMYY = new StringBuilder(dateformat.format(dt));
		return DDMMYY.toString();
	}
}
