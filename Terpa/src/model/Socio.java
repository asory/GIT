package model;

import java.util.ArrayList;
public class Socio extends Persona {

	private int cargo;
	private ArrayList<Chofer> ListaChofer;
	private ArrayList<Unidad> ListaUnidad;
	private String id_socio;


	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public String getId_socio() {
		return id_socio;
	}

	public void setId_socio(String id_socio) {
		this.id_socio = id_socio;
	}

	public int getCargo() {
		return this.cargo;
	}
	public Socio() {
		// TODO - implement Socio.Socio
		throw new UnsupportedOperationException();
	}
}