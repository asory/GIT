package modelo;
import sun.util.calendar.BaseCalendar.Date;


public class Eleccion {
	
	private 
		String codigo;
		String tipo;
		String nombreElecc;
		String descripcion;
		Date fechaIni;// fecha de inicio de votaciones
		Date fechaFin; // fecha final para votar
		int limite; // cantidad de participantes en la votaciones 
		boolean status; //  para determinar si la campaña esta activa o inactiva 

	public Eleccion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @return the nombreElecElec
	 */
	public String getnombreElec() {
		return nombreElecc;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @return the fechaIni
	 */
	public Date getFechaIni() {
		return fechaIni;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @return the limite
	 */
	public int getLimite() {
		return limite;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @param nombreEleclec the nombreElecElec to set
	 */
	public void setnombreElecElec(String nombreElec) {
		this.nombreElecc = nombreElec;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param fechaIni the fechaIni to set
	 */
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @param limite the limite to set
	 */
	public void setLimite(int limite) {
		this.limite = limite;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

}
