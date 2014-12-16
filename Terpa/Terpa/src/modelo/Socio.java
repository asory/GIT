package modelo;

import java.util.ArrayList;

import modelo.Unidad;
public class Socio extends Persona {

	private int cargo;
	//private ArrayList<Chofer> ListaChofer;
	private ArrayList<Unidad> lUnidad;
	private String id_socio;

public Socio() {super();

		
	}
	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
	
	public int getCargo() {
		return this.cargo;
	}

	public void setId_socio(String id_socio) {
		this.id_socio = id_socio;
	}
	public String getId_socio() {
		return id_socio;
	}

	public ArrayList<Unidad> getlUnidad() {
		return lUnidad;
	}

	public void setListaUnidad(ArrayList<Unidad> lUnidad) {
		this.lUnidad = lUnidad;
		
	}
	
	//*************** retorna una UNIDAD aleatoria de la lista de unidades
	public Unidad randomUnidad() {
				int random = 0;

		random = (int) Math
				.floor(Math.random() * getlUnidad().size());
		Unidad uni = getlUnidad().get(random);
		
		return uni;

	}
//************ Agregar una unidad ****************//
			public void agregarUnidad (Unidad unidad){
					this.lUnidad.add(unidad);
			}
////***************Remover unidad****************
			public Unidad retirarRuta(int ptr) {
				if (this.lUnidad.size() > ptr) {
					Unidad uni = (Unidad) this.lUnidad.remove(ptr);
					return uni;
				} else
					return null;
			}
}