package model;

import java.util.ArrayList;

public class Salado {

	private Feriado dia_Feriado;
	private int año;
	private ArrayList<Unidad>salado;
	
	/**
	 * 
	 * @param Dia_Feriado
	 */
	public void setdia_Feriado(Feriado Dia_Feriado) {
		this.dia_Feriado = Dia_Feriado;
	}
	public Feriado getdia_Feriado() {
		return this.dia_Feriado;
	}
	public int getaño() {
		return this.año;
	}
		public void setaño(int Año) {
		this.año = Año;
	}
	public Salado() {
		// TODO - implement Salado.Salado
		
	}

}