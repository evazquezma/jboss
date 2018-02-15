package es.sisifo.pruebas.jboss.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.sisifo.pruebas.jboss.forms.JndiForm;
import es.sisifo.pruebas.jboss.util.ExceptionUtil;

@WebServlet(name="jndiServlet", urlPatterns={"/jndi"})
public class JNDIServlet extends HttpServlet {

	private static final long serialVersionUID = 3501379156254765831L;

	@Resource
	private Context context;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/jndi/jndi.jsp");
		dispatcher.forward(request, response);
	}



	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String jndiKey = request.getParameter("jndiKey");

		final JndiForm form = new JndiForm();
		form.setJndiKey(jndiKey);

		try {
			final Object jndiValue = getJndiValue(jndiKey);
			form.setJndiValue(jndiValue);
			form.setJndiClass(jndiValue.getClass().getCanonicalName());
		}
		catch(final Exception e) {
			form.setError(ExceptionUtil.exceptionToHtmlString(e));
		}


		request.setAttribute("jndiForm", form);
		doGet(request, response);
	}


	private Object getJndiValue(final String jndiKey) {
		try {
			final InitialContext ic = new InitialContext();
			return ic.lookup(jndiKey);
		}
		catch (final NamingException e) {
			throw new RuntimeException("Error while looking for jndi key", e);
		}
	}

}
