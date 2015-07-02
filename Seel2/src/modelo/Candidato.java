package modelo;

public class Candidato {
	
	private 
	String nombreCan;
	String apellidoCan;
	String Descripcion;
	String codigoElecc; // codigo de la eleccion a la q pertenece
	String Propuestaurl;// direccion en el servidor donde se aloja la propuesta 
	int votos;// contador de votos obtenidos 
	
	public Candidato() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nombreCan
	 */
	public String getNombreCan() {
		return nombreCan;
	}

	/**
	 * @return the apellidoCan
	 */
	public String getApellidoCan() {
		return apellidoCan;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return Descripcion;
	}

	/**
	 * @return the codigoElecc
	 */
	public String getCodigoElecc() {
		return codigoElecc;
	}

	/**
	 * @return the propuestaurl
	 */
	public String getPropuestaurl() {
		return Propuestaurl;
	}

	/**
	 * @return the votos
	 */
	public int getVotos() {
		return votos;
	}

	/**
	 * @param nombreCan the nombreCan to set
	 */
	public void setNombreCan(String nombreCan) {
		this.nombreCan = nombreCan;
	}

	/**
	 * @param apellidoCan the apellidoCan to set
	 */
	public void setApellidoCan(String apellidoCan) {
		this.apellidoCan = apellidoCan;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	/**
	 * @param codigoElecc the codigoElecc to set
	 */
	public void setCodigoElecc(String codigoElecc) {
		this.codigoElecc = codigoElecc;
	}

	/**
	 * @param propuestaurl the propuestaurl to set
	 */
	public void setPropuestaurl(String propuestaurl) {
		Propuestaurl = propuestaurl;
	}

	/**
	 * @param votos the votos to set
	 */
	public void setVotos(int votos) {
		this.votos = votos;
	}

}
