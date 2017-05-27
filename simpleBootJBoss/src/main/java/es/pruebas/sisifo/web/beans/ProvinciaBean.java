package es.pruebas.sisifo.web.beans;

public class ProvinciaBean {
	private Long id;
	private String nombre;

	public ProvinciaBean() {
	}

	public ProvinciaBean(final Long id, final String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

}
