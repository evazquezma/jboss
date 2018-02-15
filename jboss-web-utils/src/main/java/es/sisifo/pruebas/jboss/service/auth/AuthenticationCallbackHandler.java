package es.sisifo.pruebas.jboss.service.auth;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationCallbackHandler implements CallbackHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationCallbackHandler.class);

	private final String username;
	private final String password;

	public AuthenticationCallbackHandler(final String username, final String password) {
		this.username = username;
		this.password = password;
	}


	@Override
	public void handle(final Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (final Callback callback : callbacks) {
			LOGGER.info("Callback type {} -> {}", callback.getClass(), callback);

			if (callback instanceof NameCallback) {
				((NameCallback) callback).setName(username);
			}
			else if (callback instanceof PasswordCallback) {
				((PasswordCallback) callback).setPassword(password.toCharArray());
			}
			else {
				LOGGER.info("Unknown callback class [{}]",  callback.getClass().getName());
			}
		}
	}
}
