package es.sisifo.jboss.datasources.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import es.sisifo.jboss.datasources.entity.one.EntityOne;
import es.sisifo.jboss.datasources.entity.two.EntityTwo;
import es.sisifo.jboss.datasources.service.TestService;


@WebServlet(displayName = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TestServlet.class);

	private TestService testService;

	@Override
	public void init(final ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);

		final ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		testService = context.getBean(TestService.class);

	}

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		try {
			testService.testInsertOK();
		}
		catch(final Exception e) {
			LOGGER.error("Error in testInsertOK: ", e);
		}

		LOGGER.info("\n\n\n\n\n");

		try {
			testService.testInsertMiddleError();
		}
		catch(final Exception e) {
			LOGGER.error("Error in testInsertError: ", e);
		}

		LOGGER.info("\n\n\n\n\n");

		try {
			testService.testInsertFinalError();
		}
		catch(final Exception e) {
			LOGGER.error("Error in testInsertError: ", e);
		}

		LOGGER.info("\n\n\n\n\n");

		final List<EntityOne> ones = testService.getAllOne();
		final List<EntityTwo> twos = testService.getAllTwo();

		final StringBuilder sb = new StringBuilder();
		for (final EntityOne entityOne : ones) {
			LOGGER.info("Entity One: {}", entityOne);
			sb.append(entityOne).append("\n");
		}

		sb.append("\n");

		for (final EntityTwo entityTwo : twos) {
			LOGGER.info("Entity Two: {}", entityTwo);
			sb.append(entityTwo).append("\n");
		}


		response.getWriter().append("Result: \n").append(sb.toString());
	}

}
