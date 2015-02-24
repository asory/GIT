package modelo;

public class Ruta {

	private String codigo;
	private String destino;
	private int tipo;
	

	public Ruta() {
		super();
	}

	public Ruta(String codigo, String destino, int tipo) {
		super();
		this.codigo = codigo;
		this.destino = destino;
		this.tipo = tipo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getDestino() {
		return destino;
	}

	public int getTipo() {
		return tipo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}


/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */
