package modelo;

public class Feriado {

	private int dia;
	private int mes;
	private String descripcion ; 

	public Feriado() {	}
	public Feriado(int dia, int mes, String descripcion) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.descripcion = descripcion;
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
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}


/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */