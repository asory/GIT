package modelo;
public class Chofer extends Persona {

	private String id_chofer;
	private String status;

	public Chofer() {
		// TODO - implement Chofer.Chofer
		super();
	
}

	public String getId_chofer() {
		return id_chofer;
	}

	public void setId_Chofer(String id_chofer) {
		this.id_chofer = id_chofer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}