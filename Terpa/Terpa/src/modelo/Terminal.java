package modelo;

import java.util.ArrayList;

public class Terminal {

	private ArrayList<Ruta> lRutat;
	private ArrayList<Viaje> lviaje;

	public ArrayList<Ruta> getlRutat() {
		return lRutat;
	}

	public ArrayList<Viaje> getLviaje() {
		return lviaje;
	}

	public void setlRutat(ArrayList<Ruta> lRutat) {
		this.lRutat = lRutat;
	}

	public void setLviaje(ArrayList<Viaje> lviaje) {
		this.lviaje = lviaje;
	}

	public void agregarRuta(Ruta ruta) {
		this.lRutat.add(ruta);
	}

	public Ruta retirarRuta(int ptr) {
		if (this.lRutat.size() > ptr) {
			Ruta ruta = (Ruta) this.lRutat.remove(ptr);
			return ruta;
		} else
			return null;
	}

	public void agregarViaje(Viaje viaje) {
		this.lviaje.add(viaje);
	}

	public Viaje retirarViaje(int ptr) {
		if (this.lviaje.size() > ptr) {
			Viaje viaje = (Viaje) this.lviaje.remove(ptr);
			return viaje;
		} else
			return null;
	}
	
	public String randomStatusVi() {
		int random = 0;

		random = (int) Math.floor(Math.random() * 2);
		String ran= Integer.toString(random);//// CONVIERTE DE ENTERO  A STRING
		return ran;}

}
