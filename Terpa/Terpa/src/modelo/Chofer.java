package modelo;

public class Chofer extends Persona {

	private String id_chofer;
	private boolean status;// true = multado , false = no multado
	private String id_Jefe;

	public Chofer() {
		super();
	}

	public Chofer(String nombre, String apellido, String telefono, String ci,
			String id_chofer, boolean status, String id_Jefe) {
		super(nombre, apellido, telefono, ci);
		this.id_chofer = id_chofer;
		this.status = status;
		this.id_Jefe = id_Jefe;
	}

	public String getId_chofer() {
		return id_chofer;
	}

	public boolean getStatus() {
		return status;
	}

	public String getId_Jefe() {
		return id_Jefe;
	}

	public void setId_chofer(String id_chofer) {
		this.id_chofer = id_chofer;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setId_Jefe(String id_Jefe) {
		this.id_Jefe = id_Jefe;
	}
}



/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */