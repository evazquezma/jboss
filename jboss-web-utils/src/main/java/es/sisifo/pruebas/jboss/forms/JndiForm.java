package es.sisifo.pruebas.jboss.forms;

public class JndiForm {
	private String jndiKey;
	private Object jndiValue;
	private String jndiClass;
	private String error;

	public String getJndiKey() {
		return jndiKey;
	}

	public void setJndiKey(final String jndiKey) {
		this.jndiKey = jndiKey;
	}

	public Object getJndiValue() {
		return jndiValue;
	}

	public void setJndiValue(final Object jndiValue) {
		this.jndiValue = jndiValue;
	}

	public String getJndiClass() {
		return jndiClass;
	}

	public void setJndiClass(final String jndiClass) {
		this.jndiClass = jndiClass;
	}

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}
}
