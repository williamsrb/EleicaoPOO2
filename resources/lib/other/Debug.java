package resources.lib.other;

public final class Debug {
	public static String getTrace(String msg) {
		String trace = "";
		if(msg.length() > 0) {
			trace = msg;
		}
		trace = trace + ("\nfile: " + new Throwable().getStackTrace()[1].getFileName() +
		" class: " + new Throwable().getStackTrace()[1].getClassName() +
		" method: " + new Throwable().getStackTrace()[1].getMethodName() +
		" line: " + new Throwable().getStackTrace()[1].getLineNumber()
		) + "\n";
		return trace;
	}
}