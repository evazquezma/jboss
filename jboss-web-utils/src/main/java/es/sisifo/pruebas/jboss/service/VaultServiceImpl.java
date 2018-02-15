package es.sisifo.pruebas.jboss.service;

import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.security.vault.SecurityVaultException;
import org.jboss.security.vault.SecurityVaultUtil;

@Named("vaultService")
@Stateless
public class VaultServiceImpl implements VaultService {

	@Override
	public boolean isVault(final String text) {
		return SecurityVaultUtil.isVaultFormat(text);
	}

	@Override
	public String tetText(final String text) {
		try {
			return org.jboss.security.vault.SecurityVaultUtil.getValueAsString(text);
		} catch (final SecurityVaultException e) {
			throw new IllegalArgumentException("Error al descifrar la cadena '"+ text + "'", e);
		}
	}
}
