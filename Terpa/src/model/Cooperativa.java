package model;

import java.util.ArrayList;
import model.Socio;
import model.Ruta;

public class Cooperativa {

	private String nombre;
	private ArrayList<Socio> lSocio;
	private ArrayList<Ruta> lRuta;
	private String rif;

	public Cooperativa() {
		this.lSocio = new ArrayList<Socio>();
		this.lRuta = new ArrayList<Ruta>();
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

	// Agrega un Socio
	public void agregarSocio(Socio socio) {
		this.lSocio.add(socio);
	}

	// Agrega una ruta a la Cooperativa ,
	public void agregarRuta(Ruta ruta) {
		this.lRuta.add(ruta);
	}

	// Retirar RUTA ---- Que hace (RUTA) ???
	public Ruta retirarRuta(int ptr) {
		if (this.lRuta.size() > ptr) {
			Ruta ruta = (Ruta) this.lRuta.remove(ptr);
			return ruta;
		} else
			return null;
	}

	// Retirar Socio
	public Socio retirarSocio(int ptr) {
		if (this.lSocio.size() > ptr) {
			Socio socio = (Socio) this.lSocio.remove(ptr);
			return socio;
		} else
			return null;
	}
}
