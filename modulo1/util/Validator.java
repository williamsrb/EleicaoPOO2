package modulo1.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

import resources.lib.other.DateString;
import resources.lib.other.Debug;

public class Validator {
	public static boolean isMature(String date) {
		String[] array = date.split("/");
		boolean result = false;
		int dateage;
		try {
			dateage = age(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
			if(dateage >= 18) {
				result = true;
			}
		} catch(NumberFormatException nfe) {
			System.err.println(Debug.getTrace(nfe.getLocalizedMessage()));
			result = false;
		} catch(IndexOutOfBoundsException iobe) {
			System.err.println(Debug.getTrace(iobe.getLocalizedMessage()));
			result = false;
		}
		return result;
	}
	
	public static boolean isURL(String url) {
		boolean result = true;
		try {
		    new URL(url);
		} catch (MalformedURLException e) {
		    result = false;
		}
		return result;
	}
	
	private static int age(int year, int month, int day) {
		Calendar born = new GregorianCalendar(year, month-1, day);
		Calendar now = new GregorianCalendar();
		System.out.println("\nNow: " + DateString.dateToString(now.getTime()));
		System.out.println("Born: " + DateString.dateToString(born.getTime()));
		int age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
		if(born.get(Calendar.MONTH) > now.get(Calendar.MONTH)) {
			age--;
		} else if( (now.get(Calendar.MONTH) == born.get(Calendar.MONTH))
				&& (now.get(Calendar.DAY_OF_MONTH) < born.get(Calendar.DAY_OF_MONTH)) ) {
			age--;
		}
		return age;
	}
}
