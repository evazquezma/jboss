package es.sisifo.pruebas.jboss.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.sisifo.pruebas.jboss.model.UserInfo;
import es.sisifo.pruebas.jboss.service.auth.AuthenticationCallbackHandler;

/**
 * @see https://github.com/hawtio/hawtio/blob/master/hawtio-system/src/main/java/io/hawt/system/Authenticator.java
 * @author Sisifo
 *
 */
@Named("userService")
@Stateless
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserInfo checkUser(final String username, final String userpass, final String realm) {
		try {
			final Subject subject = doLogin(username, userpass, realm);
			final List<String> roles = getSubjectRoles(subject);

			final UserInfo userInfo = new UserInfo();
			userInfo.setUsername(username);
			userInfo.setUserpass(userpass);
			userInfo.setRealm(realm);
			userInfo.setRoles(roles);
			return userInfo;
		}
		catch(final LoginException e) {
			throw new RuntimeException("User does not exists or password is invalid", e);
		}
	}



	private Subject doLogin(final String username, final String userpass, final String realm) throws LoginException {
		final Subject subject = new Subject();
		final CallbackHandler handler = new AuthenticationCallbackHandler(username, userpass);
		final LoginContext loginContext  = new LoginContext(realm, subject, handler);
		loginContext.login();
		return subject;
	}


	private List<String> getSubjectRoles(final Subject subject) {
		final List<String> roles = new ArrayList<>();

		for(final Principal principal : subject.getPrincipals()) {
			LOGGER.info("Checking {}", principal);

			if (principal instanceof SimpleGroup && "Roles".equals(principal.getName())) {
				final Enumeration<Principal> groups = ((SimpleGroup) principal).members();
				 if (groups != null) {
					 while (groups.hasMoreElements()) {
						 final Principal group = groups.nextElement();
						 roles.add(group.toString());
					 }
				 }
				 else {
					 LOGGER.debug("The Jboss EAP groups list is null");
				 }
			}
		}

		return roles;
	}

}
