package modelo;

import java.util.Date;

public class Viaje {
    private String idviaje;
	private Date fecha_salida;
	private Date fecha_retorno;
	private Unidad vehiculo;
	private Chofer chofer;
	private Float costo;
	private Ruta ruta;
	private String Status;// 1-Salio, 2-No salio 3- Multado(viaje en los no
							// salio por estar multado)
	

	public Viaje() {

	}
	
	public Viaje(String id, Date fechasalida, Date fecharetorno, String ruta2,
			Unidad vehiculo, Chofer chofer, String status) {
		// TODO Auto-generated constructor stub
	}

	public Unidad getVehiculo() {
		return vehiculo;
	}

	public Chofer getChofer() {
		return chofer;
	}


	public Float getCosto() {
		return costo;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public Date getFecha_retorno() {
		return fecha_retorno;
	}

	public String getIdviaje() {
		return idviaje;
	}

	public void setIdviaje(String idviaje) {
		this.idviaje = idviaje;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public void setFecha_retorno(Date fecha_retorno) {
		this.fecha_retorno = fecha_retorno;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public String getStatus() {
		return Status;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	public void setVehiculo(Unidad vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	// *************************************************************************


	public float CalSeguro(float monto) {
		float seguro = 0;
		int tipo = vehiculo.getTipo();
		switch (tipo) {
		case 1:
			seguro = monto * 5;
			break;
		case 2:
			seguro = monto * 7;
			break;
		case 3:
			seguro = monto * 10;
			break;
		case 4:
			seguro = monto * 25;
			break;
		case 5:
			seguro = monto * 32;
			break;
		case 6:
			seguro = monto * 60;
			break;
		case 7:
			seguro = monto * 80;
			break;
		}

		return seguro;

	}

	
}