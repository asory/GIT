package modelo;

import java.util.ArrayList;

import modelo.Unidad;
public class Socio extends Persona {

	private int cargo;
	//private ArrayList<Chofer> ListaChofer;
	private ArrayList<Unidad> ListaUnidad;
	private String id_socio;

public Socio() {super();
		
	}
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
	

	public ArrayList<Unidad> getListaUnidad() {
		return ListaUnidad;
	}

	public void setListaUnidad(ArrayList<Unidad> listaUnidad) {
		ListaUnidad = listaUnidad;
		
	}
	
	//*************** retorna una UNIDAD de la lista de unidades
	public Unidad randomUnidad() {
				int random = 0;

		random = (int) Math
				.floor(Math.random() * getListaUnidad().size());
		Unidad uni = getListaUnidad().get(random);
		
		return uni;

	}

}