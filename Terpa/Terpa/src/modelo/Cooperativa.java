package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
		super();
		lSocio = new ArrayList<Socio>();
		lChofer = new ArrayList<Chofer>();
		lRuta = new ArrayList<Ruta>();
		lViaje = new ArrayList<Viaje>();
		lMulta = new ArrayList<Multa>();
	}

	public Cooperativa(String nombre, String rif) {
		super();
		this.nombre = nombre;
		this.rif = rif;
		lSocio = new ArrayList<Socio>();
		lChofer = new ArrayList<Chofer>();
		lRuta = new ArrayList<Ruta>();
		lViaje = new ArrayList<Viaje>();
		lMulta = new ArrayList<Multa>();
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

	// **************Buscar
	public Socio BuscarSocio(String idSocio) {

		Socio v = new Socio();

		for (int i = 0; i < lSocio.size(); i++)
			if (lSocio.get(i).getId_socio().equals(idSocio))

				v = lSocio.get(i);

		return v;
	}

	// *****************

	// ** METODOS PARA Valores de VIAJE ***///
	// *******************RANDOM **************************
	// / retorna un objecto aleatorio
	public Socio ramdomSocio() {
		int random = 0;

		random = (int) Math.floor(Math.random() * getlSocio().size());
		Socio socio = getlSocio().get(random);
		return socio;

	}

	public int randomStatusVi() {
		int random = 0;

		random = (int) Math.floor(Math.random() * 2 + 1);
		
		return random;

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

	// ****************Ordenar
	public void Ordenar() {

		Collections.sort(lViaje, new Comparator<Viaje>() {

			@Override
			public int compare(Viaje o1, Viaje o2) {
				return o1.getFecha_salida().compareTo(o2.getFecha_salida());
			}

		});
	}

	// **********************Cancelar viaje por Multa ************************
	public void cancelarViaje() {

		Viaje viaje = new Viaje();
		for (int j = 0; j < lViaje.size(); j++) {
			viaje = lViaje.get(j);
			if (viaje.getChofer().getStatus()
					|| viaje.getVehiculo().getstatus()) {
				viaje.setStatus(3);
			}
		}

	}

	// *******************Quitar Multa *************
	public void quitarmulta() {
		Viaje viaje = new Viaje();
		Multa multa = new Multa();
		int i = 0;
		if (!lMulta.isEmpty()) {
			for (int j = 0; j < lViaje.size(); j++) {
				viaje = lViaje.get(j);
				while (i < lMulta.size()) {

					multa = lMulta.get(i);

					if (viaje.getFecha_salida().before(multa.getFecha_in())
							|| viaje.getFecha_salida().after(
									multa.getFecha_fin())) {
						viaje.getChofer().setStatus(false);
						viaje.getVehiculo().setStatus(false);
					}
					i++;
				}

			}
		}
	}

}