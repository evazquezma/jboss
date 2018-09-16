package es.sisifo.pruebas.jboss.forms;

import java.util.List;

public class ClusterInfo {
	private String cacheContainer;
	private List<String> members;
	private List<String> keys;

	public String getCacheContainer() {
		return cacheContainer;
	}

	public void setCacheContainer(final String cacheContainer) {
		this.cacheContainer = cacheContainer;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(final List<String> members) {
		this.members = members;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(final List<String> keys) {
		this.keys = keys;
	}

}
