package es.sisifo.pruebas.jboss.forms;

public class CacheForm {
	private String container;
	private String key;
	private Object value;
	private String valueClass;
	private String error;

	public String getContainer() {
		return container;
	}

	public void setContainer(final String container) {
		this.container = container;
	}

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(final Object value) {
		this.value = value;
	}

	public String getValueClass() {
		return valueClass;
	}

	public void setValueClass(final String valueClass) {
		this.valueClass = valueClass;
	}

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}

}
