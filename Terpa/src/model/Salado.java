package model;

import java.util.ArrayList;

public class Salado {

	private Feriado dia_Feriado;
	private int a�o;
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
	public int geta�o() {
		return this.a�o;
	}
		public void seta�o(int A�o) {
		this.a�o = A�o;
	}
	public Salado() {
		// TODO - implement Salado.Salado
		
	}

}