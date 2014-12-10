package modelo;
public class Chofer extends Persona {

	private String id_Chofer;
 private String Status;
	public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

	public Chofer() {
		// TODO - implement Chofer.Chofer
		super();
	
}

	public String getId_Chofer() {
		return id_Chofer;
	}

	public void setId_Chofer(String id_Chofer) {
		this.id_Chofer = id_Chofer;
	}
}