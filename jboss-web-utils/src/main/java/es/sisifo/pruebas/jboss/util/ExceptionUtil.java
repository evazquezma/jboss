package es.sisifo.pruebas.jboss.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {
	private ExceptionUtil() {}

	public static String exceptionToHtmlString(final Exception e) {
		final StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString().replaceAll("[\\r\\n]+", "<br>");
	}
}
