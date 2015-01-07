package modelo;

public class Unidad {

	private String placa;
	private int tipo;
	private String status;
	private String id_socio;
	private int id;//1-carro 2-ranchera 3-van 4-encava/busetaP(25p) 5-busetaP(32)
					//6-BusP (60) 7-BusG/Buscama(80) 

	public Unidad() {
		
	}

	public Unidad(String placa, int tipo, String status, String id_socio, int id) {
		super();
		this.placa = placa;
		this.tipo = tipo;
		this.status = status;
		this.id_socio = id_socio;
		this.id = id;
	}


	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getstatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId_socio() {
		return id_socio;
	}

	public void setId_socio(String id_socio) {
		this.id_socio = id_socio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}