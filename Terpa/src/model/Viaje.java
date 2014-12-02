package model;

import java.util.Date;

public class Viaje {

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public Date getFecha_retorno() {
		return fecha_retorno;
	}

	public void setFecha_retorno(Date fecha_retorno) {
		this.fecha_retorno = fecha_retorno;
	}

	public Unidad getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Unidad vehiculo) {
		this.vehiculo = vehiculo;
	}

	private Date fecha_salida;
	private Date fecha_retorno;
	private Unidad vehiculo;

	public Viaje() {
		// TODO - implement Viaje.Viaje
		throw new UnsupportedOperationException();
	}

	
}