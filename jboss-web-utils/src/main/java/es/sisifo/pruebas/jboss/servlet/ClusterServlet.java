package es.sisifo.pruebas.jboss.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.infinispan.Cache;
import org.jboss.as.clustering.infinispan.CacheContainer;

import es.sisifo.pruebas.jboss.forms.ClusterInfo;

@WebServlet(name = "clusterServlet", urlPatterns = { "/cluster" })
public class ClusterServlet extends HttpServlet {

	private static final long serialVersionUID = 3501379156254765831L;

//	 @Resource(lookup="java:jboss/infinispan/container/web")
//	 private CacheContainer container;
//
//	@Resource
//	private Context context;

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/pages/cluster/clusterInfo.jsp");
		dispatcher.forward(request, response);
	}


	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		final String cacheContainerName = request.getParameter("cacheContainer");

		final CacheContainer cacheContainer = getCacheContainer(cacheContainerName);
		final org.infinispan.Cache cache = cacheContainer.getCache();
		final List<String> members = getMembers(cache);
		final List<String> keys = new ArrayList<>(cache.keySet());

		final ClusterInfo clusterInfo = new ClusterInfo();
		clusterInfo.setMembers(members);
		clusterInfo.setKeys(keys);


		request.setAttribute("clusterInfo", clusterInfo);
		doGet(request, response);
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


	private List<String> getMembers(final Cache cache) {
		final List<String> membersList = new ArrayList<>();

		final List<org.infinispan.remoting.transport.Address> members = cache.getCacheManager().getMembers();
		for (final org.infinispan.remoting.transport.Address member: members) {
			membersList.add(member.toString());
		}
		return membersList;
	}

}
