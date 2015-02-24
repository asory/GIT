package modelo;

public abstract class Persona {

	private String nombre;
	private String apellido;
	private String telefono;
	private String ci;

	public Persona() {
		super();// TODO - implement Persona.Persona

	}

	public Persona(String nombre, String apellido, String telefono, String ci) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.ci = ci;
	}

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	/**
	 * 
	 * @param apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return this.telefono;
	}

	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCi() {
		return this.ci;
	}

	/**
	 * 
	 * @param ci
	 */
	public void setCi(String ci) {
		this.ci = ci;
	}

}

/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */