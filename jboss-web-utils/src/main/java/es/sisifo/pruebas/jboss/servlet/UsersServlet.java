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

import es.sisifo.pruebas.jboss.forms.UserForm;
import es.sisifo.pruebas.jboss.model.UserInfo;
import es.sisifo.pruebas.jboss.service.UserService;
import es.sisifo.pruebas.jboss.util.ExceptionUtil;

@WebServlet(name="usersServlet", urlPatterns={"/users"})
public class UsersServlet extends HttpServlet {

	private static final long serialVersionUID = 3501379156254765830L;

	@EJB @Named("userService")
	private UserService userService;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/users/users.jsp");
		dispatcher.forward(request, response);
	}



	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String username = request.getParameter("username");
		final String userpass = request.getParameter("userpass");
		final String realm = request.getParameter("realm");

		final UserForm form = new UserForm();
		form.setUsername(username);
		form.setUserpass(userpass);
		form.setRealm(realm);

		try {
			final UserInfo userInfo = userService.checkUser(username, userpass, realm);
			form.setRoles(userInfo.getRoles());
		}
		catch(final Exception e) {
			form.setError(ExceptionUtil.exceptionToHtmlString(e));
		}

		request.setAttribute("userForm", form);
		doGet(request, response);
	}

}
