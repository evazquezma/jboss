package es.sisifo.pruebas.jboss.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.sisifo.pruebas.jboss.forms.VaultForm;
import es.sisifo.pruebas.jboss.service.VaultService;
import es.sisifo.pruebas.jboss.util.ExceptionUtil;

@WebServlet(name="vaultServlet", urlPatterns={"/vault"})
public class VaultServlet extends HttpServlet {

	private static final long serialVersionUID = 3501379156254765832L;

	@EJB @Named("vaultService")
	private VaultService vaultService;


	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/vault/vault.jsp");
		dispatcher.forward(request, response);
	}



	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String text = request.getParameter("secret");

		final VaultForm form = new VaultForm();
		form.setCypher(text);
		if (vaultService.isVault(text)) {
			form.setCypher(text);
			try {
				form.setClear(vaultService.tetText(text));
			}
			catch(final Exception e) {
				form.setError(ExceptionUtil.exceptionToHtmlString(e));
			}
		}
		else {
			form.setClear(text);
			form.setError("Not in vault format. Vault format is 'VAULT::'");
		}

		request.setAttribute("vaultForm", form);
		doGet(request, response);
	}

}
