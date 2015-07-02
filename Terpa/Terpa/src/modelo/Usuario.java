package modelo;

public class Usuario {
	
	private String nombre;
	private String password;
	private int tipo;
	
	public Usuario() {
		
	}
	
	
	public Usuario(String nombre, String password, int tipo) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.tipo = tipo;
		
	}
	
	public Usuario(String nomb, String pass) {
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public int getTipo() {
		return tipo;
	}
	
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

};

/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */
