package modelo;
public class Chofer extends Persona {

	private String id_chofer;
	private String status;
	private String id_Jefe;

	public Chofer() {
		// TODO - implement Chofer.Chofer
		super();
	
}

	public String getId_chofer() {
		return id_chofer;
	}

	public String getStatus() {
		return status;
	}

	public String getId_Jefe() {
		return id_Jefe;
	}

	public void setId_chofer(String id_chofer) {
		this.id_chofer = id_chofer;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setId_Jefe(String id_Jefe) {
		this.id_Jefe = id_Jefe;
	}
}