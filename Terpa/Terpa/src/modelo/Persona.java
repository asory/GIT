package modelo;
public abstract class Persona {

	private String nombre;
	private String apellido;
	private String telefono;
	private String ci;

	public Persona() {
		super();// TODO - implement Persona.Persona
		
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