package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.Calendar;
import java.util.Date;

import org.omg.CORBA.SystemException;

import vista.VistaViaje;
import modelo.*;

public class ControladorVistaViaje implements ActionListener {

	private VistaViaje vviaje;
	private Cooperativa coop;
	Viaje viaje = new Viaje();

	public ControladorVistaViaje() {
		super();
		this.vviaje = new VistaViaje();
		this.vviaje.setLocation(480, 210);
		this.vviaje.setVisible(true);
		this.vviaje.addComponentListener((ComponentListener) this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private void AsignarViajes() {
		
		coop= term.BuscarCoop(vviaje.g)
		vviaje.
		int Fila;
		

		for (Fila = 0; Fila < coop.getlViaje().size(); Fila++)

		{
			Viaje viaje = coop.getlViaje().get(Fila);

			viaje.getjTableViajes().setValueAt(
					viaje.agregarFeriado(feriado);getCi(), Fila, 0);
			ConsultaPaciente.getjTablePacientes().setValueAt(
					chofer.getNombre(), Fila, 1);
		}

	}

	// ///**********cambia el estatus del chofer y la unidad a multado
	public void multar(Calendar pferiado) {

		for (int i = 0; i < viaje.getlFeriado().size(); i++) {
			Feriado feriado = viaje.getlFeriado().get(i);
			int df = feriado.getDia();
			int mf = feriado.getMes();
			if ((df == pferiado.get(Calendar.DAY_OF_MONTH))
					&& (mf == pferiado.get(Calendar.MONTH))) {
				if (viaje.getStatus() == "2") {
					viaje.getChofer().setStatus("2");
					viaje.getVehiculo().setStatus("2");

				}
			}
		}

	}

	// ****************** Suma/resta los días/horas recibidos a la fecha
	public Date modificarDias(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o
													// restar en caso de días<0

		return calendar.getTime();
		// Devuelve el objeto Date con los nuevos días añadidos
	}

	public Date modificarHoras(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); //
		return calendar.getTime(); // Devuelve el objeto Date con la nueva hora

	}

	// *********************Verificar Status********************************
	
}

