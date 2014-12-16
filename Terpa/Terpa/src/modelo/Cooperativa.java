package modelo;

import java.util.ArrayList;
;

public class Cooperativa {

	private String nombre;
	private String rif;
	private ArrayList<Socio> lSocio;
	private ArrayList<Chofer> lChofer;
	private ArrayList<Ruta> lRuta;
	private ArrayList<Viaje> lViaje;
	private ArrayList<Multa> lMulta;

	public Cooperativa() {
		this.lSocio = new ArrayList<Socio>();
		this.lChofer = new ArrayList<Chofer>();
		this.lRuta = new ArrayList<Ruta>();
		this.lViaje = new ArrayList<Viaje>();
		this.lMulta = new ArrayList<Multa>();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}
	
	public String getRif() {
		return rif;
	}
	
	public void setlSocio(ArrayList<Socio> lSocio) {
		this.lSocio = lSocio;
	}
	
	public ArrayList<Socio> getlSocio() {
		return lSocio;
	}
	
	public void setlChofer(ArrayList<Chofer> lChofer) {
		this.lChofer = lChofer;
	}
	
	public ArrayList<Chofer> getlChofer() {
		return lChofer;
	}
	
	public void setlRuta(ArrayList<Ruta> lRuta) {
		this.lRuta = lRuta;
	}
	
	public ArrayList<Ruta> getlRuta() {
		return lRuta;
	}

	public void setlViaje(ArrayList<Viaje> lViaje) {
		this.lViaje = lViaje;
	}

	public ArrayList<Viaje> getlViaje() {
		return lViaje;
	}
	
	public void setlMulta(ArrayList<Multa> lMulta) {
		this.lMulta = lMulta;
	}

	public ArrayList<Multa> getlMulta() {
		return lMulta;
	}
	// *************AGREGAR A LISTAS *****************
	public void agregarChofer(Chofer chofer) {
		this.lChofer.add(chofer);
	}
	
	public void agregarSocio(Socio socio) {
		this.lSocio.add(socio);
	}
	            // Agrega una ruta a la Cooperativa , public void agregarRuta(Ruta ruta)
	public void agregarRuta(Ruta ruta) {
		this.lRuta.add(ruta);
	}

	public void agregarViaje(Viaje viaje) {
		this.lViaje.add(viaje);
	};

	public void agregarMulta(Multa multa) {
		this.lMulta.add(multa);
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
	
	public Ruta retirarRuta(int ptr) {
		if (this.lRuta.size() > ptr) {
			Ruta ruta = (Ruta) this.lRuta.remove(ptr);
			return ruta;
		} else
			return null;
	}
	
	public Viaje retirarViaje(int ptr) {
		if (this.lViaje.size() > ptr) {
			Viaje viaje = (Viaje) this.lViaje.remove(ptr);
			return viaje;
		} else
			return null;

	}
	
	public Multa retiraMulta(int ptr) {
		if (this.lMulta.size() > ptr) {
			Multa multa = (Multa) this.lMulta.remove(ptr);
			return multa;
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

	public String randomStatusVi() {
		int random = 0;

		random = (int) Math.floor(Math.random() * 2);
		String ran = Integer.toString(random);// // CONVIERTE DE ENTERO A STRING
		return ran;

	}

	public Chofer randomChofer() {

		int random = 0;

		random = (int) Math.floor(Math.random() * getlChofer().size());
		Chofer cho = getlChofer().get(random);
		return cho;
	}
	
	public Ruta randomRuta() {

		int random = 0;

		random = (int) Math.floor(Math.random() * getlRuta().size());
		Ruta ruta = getlRuta().get(random);
		return ruta;
	}
}
