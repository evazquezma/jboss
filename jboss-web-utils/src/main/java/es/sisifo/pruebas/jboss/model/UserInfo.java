package es.sisifo.pruebas.jboss.model;

import java.util.List;

public class UserInfo {
	private String username;
	private String userpass;
	private String realm;
	private List<String> roles;

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

}
