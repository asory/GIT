package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import modelo.Chofer;
import modelo.Ruta;
import modelo.Socio;

public class Cooperativa {

	private String nombre;
	private String rif;
	private ArrayList<Socio> lSocio;
	private ArrayList<Chofer> lChofer;
	private ArrayList<Multa>lMulta;
	 private ArrayList<Ruta> lRuta;
	private ArrayList<Viaje> lViaje;
	 
	
	public Cooperativa() {
		this.lSocio = new ArrayList<Socio>();
		this.lRuta = new ArrayList<Ruta>();
		this.lViaje = new ArrayList<Viaje>();
		this.lChofer = new ArrayList<Chofer>();
	
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRif() {
		return rif;
	}

	public ArrayList<Socio> getlSocio() {
		return lSocio;
	}

	public ArrayList<Chofer> getlChofer() {
		return lChofer;
	}

	

	public void setlSocio(ArrayList<Socio> lSocio) {
		this.lSocio = lSocio;
	}

	public void setlChofer(ArrayList<Chofer> lChofer) {
		this.lChofer = lChofer;
	}

	// *************AGREGAR A LISTAS *****************
	public void agregarSocio(Socio socio) {
		this.lSocio.add(socio);
	}
	public void agregarChofer(Chofer chofer) {
		this.lChofer.add(chofer);
	}

	// *************RETIRAR de LISTAS *****************
	public Socio retirarSocio(int ptr) {
		if (this.lSocio.size() > ptr) {
			Socio socio = (Socio) this.lSocio.remove(ptr);
			return socio;
		} else
			return null;
	}

	public Chofer retirarChofer(int ptr) {
		if (this.lChofer.size() > ptr) {
			Chofer chofer = (Chofer) this.lChofer.remove(ptr);
			return chofer;
		} else
			return null;
	}

	
	// *******************RANDOM **************************
	// / retorna un objecto aleatorio
	public Socio ramdomSocio() {
		int random = 0;

		random = (int) Math.floor(Math.random() * getlSocio().size());
		Socio socio = getlSocio().get(random);
		return socio;

	}



	public Chofer randomChofer() {

		int random = 0;

		random = (int) Math.floor(Math.random() * getlChofer().size());
		Chofer cho = getlChofer().get(random);
		return cho;
	}
	
	
	
 public ArrayList<Ruta> getlRuta() { return lRuta; }
 public void setlRuta(ArrayList<Ruta> lRuta) { this.lRuta = lRuta; }



	  // Agrega una ruta a la Cooperativa , public void agregarRuta(Ruta ruta)
	 public void agregarRuta (Ruta ruta)
 { this.lRuta.add(ruta); }
	  
	  public Viaje retirarViaje(int ptr) {
		if (this.lViaje.size() > ptr) {
			Viaje viaje = (Viaje) this.lViaje.remove(ptr);
			return viaje;
		} else
			return null;

	}
	public ArrayList<Viaje> getlViaje() {
		return lViaje;
	}

 public void agregarViaje(Viaje viaje) {
		this.lViaje.add(viaje);
		
		
	}
	
public void setlViaje(ArrayList<Viaje> lViaje) {
		this.lViaje = lViaje;
	}
	 

		
		
public String randomStatusVi(){
			int random = 0;
			random = (int) Math.floor(Math.random() * 2);
			String ran= Integer.toString(random);//// CONVIERTE DE ENTERO  A STRING
			return ran;

		}


}
