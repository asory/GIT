package modelo;

import java.util.Date;


public class Multa {

	private Date fecha_in;
	private Date fecha_fin;
	private int nro;
	private Unidad unidad;
	private Chofer c_asignado;
	
	public Multa() {
		// TODO - implement Multa.Multa
	}

	public Date getFecha_in() {
		return fecha_in;
	}
	
	public void setFecha_in(Date fecha_in) {
		this.fecha_in = fecha_in;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}
	
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}
	
	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
	
	public Chofer getC_Asignado() {
		return c_asignado;
	}

	public void setC_Asignado(Chofer c_asignado) {
		this.c_asignado = c_asignado;
	}
};