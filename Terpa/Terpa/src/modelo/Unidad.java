package modelo;

public class Unidad {

	private String placa;
	private int tipo;//1-carro 2-ranchera 3-van 4-encava/busetaP(25p) 5-busetaP(32)
	//6-BusP (60) 7-BusG/Buscama(80) 
	private boolean status; // true = multado , false = no multado
	private String id_socio;
	private int id;

	public Unidad() {
		
	}

	public Unidad(String placa, int tipo,  boolean status, String id_socio, int id) {
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

	public  boolean getstatus() {
		return status;
	}

	public void setStatus( boolean status) {
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

/*Integrantes:
 * Rosa Pi�a C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */