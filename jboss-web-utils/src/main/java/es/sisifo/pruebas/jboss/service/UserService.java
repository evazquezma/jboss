package es.sisifo.pruebas.jboss.service;

import es.sisifo.pruebas.jboss.model.UserInfo;

public interface UserService {
	UserInfo checkUser(String username, String userpass, String realm);
}
