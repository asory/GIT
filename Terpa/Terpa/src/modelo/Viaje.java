package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import modelo.Chofer;
import modelo.Unidad;
import modelo.Multa;

public class Viaje {

	private Date fecha_salida;
	private Date fecha_retorno;
	private Unidad vehiculo;
	private Chofer chofer;
	private Float costo ;
	private String Destino;
	private String Status ;// 1-Salio, 2-No salio 3- Multado(viaje en los no salio por estar multado)
	private ArrayList<Feriado> lFeriado;
	
	public Viaje(){
		
	}

	public Viaje(Date fecha_salida, Date fecha_retorno, Unidad vehiculo,
			Chofer chofer, ArrayList<Feriado> lFeriado, ArrayList<Multa> lMulta) {
		super();
		this.fecha_salida = fecha_salida;
		this.fecha_retorno = fecha_retorno;
		this.vehiculo = vehiculo;
		this.chofer = chofer;
		this.lFeriado = lFeriado;
	
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public Date getFecha_retorno() {
		return fecha_retorno;
	}

	public Unidad getVehiculo() {
		return vehiculo;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public ArrayList<Feriado> getlFeriado() {
		return lFeriado;
	}



	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public void setFecha_retorno(Date fecha_retorno) {
		this.fecha_retorno = fecha_retorno;
	}

	public void setVehiculo(Unidad vehiculo) {
		this.vehiculo = vehiculo;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public void setlFeriado(ArrayList<Feriado> lFeriado) {
		this.lFeriado = lFeriado;
	}

	public void agregarFeriado(Feriado feriado) {
		this.lFeriado.add(feriado);
	}

	public Feriado eliminarferiado(int ptr) {
		if (this.lFeriado.size() > ptr) {
			Feriado feriado = (Feriado) this.lFeriado.remove(ptr);
			return feriado;
		} else
			return null;
	}

	// ///**********verifica  si el viaje debe ser multado  ***************
 public boolean multar(Calendar pferiado){

	for (int i = 0; i < lFeriado.size(); i++) {
		Feriado feriado = lFeriado.get(i) ;
		int df= feriado.getDia();
		int mf= feriado.getMes();
		if((df==pferiado.get(Calendar.DAY_OF_MONTH)) && (mf==pferiado.get(Calendar.MONTH)))
		{
			if( Status=="2") {
				return true;
			}
					}
				}
	return false ;
 }
/// *************	Decide aleatoriamente si el viaje salio o no **********
 public void randomStatusV() {
		int random = 0;

		random = (int) Math.floor(Math.random() *2);
		String ran = Integer.toString(random);
        
		Status=ran;

	}

}