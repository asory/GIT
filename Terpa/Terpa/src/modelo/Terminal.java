package modelo;

import java.util.ArrayList;


public class Terminal {

	private ArrayList<Ruta> lRutat;
	private ArrayList<Cooperativa> lCoop;

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
//******************* Retirar  ********************//
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
//******************* Agregar  ********************//
	public void agregarCooperativa(Cooperativa cooperativa){
			this.lCoop.add(cooperativa);
	}
	public void agregarRuta(Ruta ruta) {
		this.lRutat.add(ruta);
	}
				
//***********   Buscar   **************//
	public Cooperativa BuscarCoop(String rif)
	{
				
		Cooperativa v = new Cooperativa();
			
		for(int i=0; i<lCoop.size(); i++)
		if(rif == lCoop.get(i).getRif() )
			v = lCoop.get(i);
			return v;		
	}
}