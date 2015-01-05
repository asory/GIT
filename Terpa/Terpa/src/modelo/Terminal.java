package modelo;

import java.util.ArrayList;

public class Terminal {

	private ArrayList<Ruta> lRutat = new ArrayList<Ruta>();
	private ArrayList<Cooperativa> lCoop = new ArrayList<Cooperativa>();
	private ArrayList<Feriado> lFeriado = new ArrayList<Feriado>();

	public Terminal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Ruta> getlRutat() {
		return lRutat;
	}

	public void setlRutat(ArrayList<Ruta> lRutat) {
		this.lRutat = lRutat;
	}

	public ArrayList<Cooperativa> getlCoop() {
		return lCoop;
	}

	public void setlCoop(ArrayList<Cooperativa> lCoop) {
		this.lCoop = lCoop;
	}

	public ArrayList<Feriado> getlFeriado() {
		return lFeriado;
	}

	public void setlFeriado(ArrayList<Feriado> lFeriado) {
		this.lFeriado = lFeriado;
	}

	// ******************* Retirar ********************//
	public Ruta retirarRuta(int ptr) {
		if (this.lRutat.size() > ptr) {
			Ruta ruta = (Ruta) this.lRutat.remove(ptr);
			return ruta;
		} else
			return null;
	}

	public Cooperativa retirarCoop(int ptr) {
		if (this.lCoop.size() > ptr) {
			Cooperativa coop = (Cooperativa) this.lCoop.remove(ptr);
			return coop;
		} else
			return null;
	}

	public Feriado eliminarferiado(int ptr) {
		if (this.lFeriado.size() > ptr) {
			Feriado feriado = (Feriado) this.lFeriado.remove(ptr);
			return feriado;
		} else
			return null;
	}

	// ******************* Agregar ********************//
	public void agregarCooperativa(Cooperativa cooperativa) {
		this.lCoop.add(cooperativa);
	}

	public void agregarRuta(Ruta ruta) {
		this.lRutat.add(ruta);
	}

	public void agregarFeriado(Feriado feriado) {
		this.lFeriado.add(feriado);
	}

	// *********** Buscar **************//
	public Cooperativa BuscarCoop(String rif) {
		Cooperativa v = new Cooperativa();
		for (int i = 0; i < lCoop.size(); i++) {

			if (lCoop.get(i).getRif().equals(rif))

				v = lCoop.get(i);
			
		}
		return v;
	}

	public boolean VerificarCoop(String rif) {
		boolean v = false;
		if (lCoop == null || lCoop.isEmpty())
			v = false;
		else
			for (int i = 0; i < lCoop.size(); i++)

			{
				if (lCoop.get(i).getRif().equals(rif))
					v = true;
			}
		return v;
	}
}
