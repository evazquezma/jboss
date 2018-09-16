package es.sisifo.pruebas.jboss.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.as.clustering.infinispan.CacheContainer;

import es.sisifo.pruebas.jboss.forms.CacheForm;

@WebServlet(name = "cacheServlet", urlPatterns = { "/cache" })
public class CacheServlet extends HttpServlet {

	private static final long serialVersionUID = 3501379156254765831L;


	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String container = request.getParameter("container");
		final String key = request.getParameter("key");

		final CacheContainer cacheContainer = getCacheContainer(container);
		final Object cacheValue = getCacheValue(cacheContainer, key);

		final CacheForm cacheForm = new CacheForm();
		cacheForm.setContainer(container);
		cacheForm.setKey(key);
		cacheForm.setValue(cacheValue);
		cacheForm.setValueClass(cacheValue != null ? cacheValue.getClass().getName() : null);
		cacheForm.setError("");


		request.setAttribute("cacheForm", cacheForm);
		final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/cache/cache.jsp");
		dispatcher.forward(request, response);
	}


	private CacheContainer getCacheContainer(final String container) {
		try {
			final CacheContainer cacheContainer = (CacheContainer) new InitialContext().lookup("java:jboss/infinispan/container/" + container);
			return cacheContainer;
		}
		catch (final Exception e) {
			throw new RuntimeException("Cache container java:jboss/infinispan/container/" + container + " not found", e);
		}
	}


	private Object getCacheValue(final CacheContainer cacheContainer, final String key) {
		return cacheContainer.getCache().get(key);
	}





}
