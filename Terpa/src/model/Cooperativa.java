package model;

import java.util.ArrayList;

public class Cooperativa {
	
	private String nombre;
	private ArrayList<Ruta> ListaSocio;
	private ArrayList<Multa> ListaRuta;

	public Cooperativa() {
		// TODO - implement Cooperativa.Cooperativa
		throw new UnsupportedOperationException();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	private String rif;
}