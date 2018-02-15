package es.sisifo.pruebas.jboss.forms;

import java.util.List;

public class UserForm {
	private String username;
	private String userpass;
	private String realm;
	private List<String> roles;
	private String error;

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(final String userpass) {
		this.userpass = userpass;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(final String realm) {
		this.realm = realm;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(final List<String> roles) {
		this.roles = roles;
	}

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}

}
