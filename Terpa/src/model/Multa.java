package model;

import java.util.Date;


public class Multa {

	private Date fecha_in;
	private int numero;
	private int id_unidad;
	private Chofer chofer_Asignado;
	private Cooperativa coop;




	public Multa() {
		// TODO - implement Multa.Multa
		
	}
	public int getId_unidad() {
		return this.id_unidad;
	}

	public void setId_unidad(int id_unidad) {
		this.id_unidad = id_unidad;
	}
	public Date getFecha_in() {
		return fecha_in;
	}
	public void setFecha_in(Date fecha_in) {
		this.fecha_in = fecha_in;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}