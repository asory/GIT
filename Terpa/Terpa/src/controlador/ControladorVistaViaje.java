package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;

import org.omg.CORBA.SystemException;

import vista.VistaViaje;
import modelo.*;

public class ControladorVistaViaje implements ActionListener {

	private VistaViaje vviaje;
	private Cooperativa coop;
	private static ControladorVistaViaje instancia;
	Viaje viaje = new Viaje();
	Terminal ter = new Terminal();

	public ControladorVistaViaje() {

	}

	public void iniciar() {

		this.vviaje = new VistaViaje();
		this.vviaje.setLocation(480, 210);
		this.vviaje.setVisible(true);
		this.vviaje.addComponentListener((ComponentListener) this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(
				vviaje.getBtnAsignar().getActionListeners().equals("Asignar")))

			asignarViajes();

	}

	private void asignarViajes() {

		int i = 0;
		do {
			// obtenemos condiciones del viaje
			coop = ter.BuscarCoop(vviaje.getRif());
			Date fs = vviaje.getFechaI();
			Ruta ruta = coop.randomRuta();
			Date fr = asignarRetorno(ruta, fs);
			Unidad uni = coop.ramdomSocio().randomUnidad();// asigana unidad
															// aleatoria
			uni = VerificarUnidad(uni);// / verifica la unidad y retorna una q
										// este disponible
			Chofer cho = coop.randomChofer();
			cho = VerificarChofer(cho);
			float costo = (float) Math.random();// buscar max y min

			String Stats = coop.randomStatusVi();// decide si el viaje salio o
													// no

			// // se asignan las variables al viaje

			Viaje viaje = new Viaje();
			viaje.setFecha_salida(fs);
			viaje.setFecha_retorno(fr);
			viaje.setVehiculo(uni);
			viaje.setChofer(cho);
			viaje.setCosto(costo);
			viaje.setRuta(ruta);
			viaje.setStatus(Stats);
			coop.agregarViaje(viaje);
			multar(fs);

			i++;
		} while (i < 10);

		quitarmulta();
		cancelarViaje();
		llenarTabla();
	}

	public void llenarTabla()

	{
		for (int i = 0; i < coop.getlViaje().size(); i++) {
			viaje = coop.getlViaje().get(i);
			JTable model = vviaje.getTable();
			model.setValueAt(viaje.getIdviaje(), i, 0);
			model.setValueAt(viaje.getRuta().getDestino(), i, 1);
			model.setValueAt(viaje.getVehiculo(), i, 2);
			model.setValueAt(viaje.getChofer(), i, 3);
			model.setValueAt(viaje.getFecha_salida(), i, 4);
			model.setValueAt(viaje.getFecha_retorno(), i, 5);
			model.setValueAt(viaje.getCosto(), i, 6);
			model.setValueAt(viaje.CalSeguro(viaje.getCosto()), i, 7);
			model.setValueAt(viaje.getStatus(), i, 8);

			vviaje.setTable(model);

		}
	}

	// ///**********cambia el estatus del chofer y la unidad a multado
	public void multar(Date pferiado) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pferiado);
		for (int i = 0; i < viaje.getlFeriado().size(); i++) {
			Feriado feriado = viaje.getlFeriado().get(i);
			int df = feriado.getDia();
			int mf = feriado.getMes();
			if ((df == calendar.get(Calendar.DAY_OF_MONTH))
					&& (mf == calendar.get(Calendar.MONTH))) {
				if (viaje.getStatus() == "2") {
					viaje.getChofer().setStatus("2");
					viaje.getVehiculo().setStatus("2");

				}
			}
		}

	}

	// *******************Quitar Multa *************
	public void quitarmulta() {

		for (int j = 0; j < coop.getlViaje().size(); j++) {
			viaje = coop.getlViaje().get(j);
			for (int i = 0; i < coop.getlMulta().size(); i++) {
				Multa multa = coop.getlMulta().get(i);

				if (viaje.getFecha_salida().before(multa.getFecha_in())
						|| viaje.getFecha_salida().after(multa.getFecha_fin())) {
					viaje.getChofer().setStatus("1");
					viaje.getVehiculo().setStatus("2");
				}
			}

		}
	}

	// **********************Cancelar viaje por Multa ************************
	public void cancelarViaje() {

		for (int j = 0; j < coop.getlViaje().size(); j++) {
			viaje = coop.getlViaje().get(j);
			if (viaje.getChofer().getStatus() == "2"
					|| viaje.getVehiculo().getstatus() == "2") {
				viaje.setStatus("3");
			}
		}

	}

	// ****************** Suma/resta los días/horas recibidos a la
	// fecha***********
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

	// ******************Asignar Retorno ****************//
	public Date asignarRetorno(Ruta ruta, Date f_salida) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(f_salida);
		Date f_retorno;
		if (ruta.getTipo() == 1) // 1 nacional
			f_retorno = modificarHoras(f_salida, 42);
		else
			// 2 regional
			f_retorno = modificarHoras(f_salida, 2); // en 2 horas return
														// f_retorno;
		return f_retorno;
	}

	// *********************Verificar ********************************

	// **************Verifican si ya han retornado*********************
	public Unidad VerificarUnidad(Unidad uni) {

		boolean v;
		do {
			for (int i = 0; i < coop.getlViaje().size(); i++) {
				Viaje viaje = coop.getlViaje().get(i);
				Date fechai = vviaje.getFechaI();

				if ((viaje.getVehiculo().equals(uni))
						&& (viaje.getFecha_retorno().after(fechai))) {
					uni = coop.ramdomSocio().randomUnidad();
					v = false;
				}
			}
			v = true;
		} while (v = false);
		return uni;
	}

	public Chofer VerificarChofer(Chofer cho) {
		boolean v = false;
		do {
			for (int i = 0; i < coop.getlViaje().size(); i++) {
				Viaje viaje = coop.getlViaje().get(i);
				Date fechai = vviaje.getFechaI();

				if ((viaje.getChofer().equals(cho))
						&& (viaje.getFecha_retorno().after(fechai))) {
					cho = coop.randomChofer();
					v = false;
				}
			}
			v = true;

		} while (v = false);
		return cho;

		// ************************************
	}
}
