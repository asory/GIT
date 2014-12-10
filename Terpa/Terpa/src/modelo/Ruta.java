package modelo;

import java.util.ArrayList;

public class Ruta {

	private String codigo;
	private String descripcion;
	private int tipo;
	private ArrayList<Cooperativa> lCoop;

	public Ruta() {
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getTipo() {
		return tipo;
	}

	public ArrayList<Cooperativa> getlCoop() {
		return lCoop;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setlCoop(ArrayList<Cooperativa> lCoop) {
		this.lCoop = lCoop;
	}

	public void agregarCooperativa(Cooperativa coop) {
		this.lCoop.add(coop);
	}

	public Cooperativa retirarCoop(int ptr) {
		if (this.lCoop.size() > ptr) {
			Cooperativa coop = (Cooperativa) this.lCoop.remove(ptr);
			return coop;
		} else
			return null;
	}
}
