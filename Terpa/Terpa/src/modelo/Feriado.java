package modelo;

import java.util.Date;

public class Feriado {

	private int dia;
	private int mes;
	private String Descripcion ; 

	public Feriado() {	}
	public Feriado(int dia, int mes, String descripcion) {
		super();
		this.dia = dia;
		this.mes = mes;
		Descripcion = descripcion;
	}
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}



}