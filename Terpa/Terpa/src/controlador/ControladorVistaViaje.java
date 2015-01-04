package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import vista.VistaViaje;
import modelo.*;

public class ControladorVistaViaje implements ActionListener {

	private VistaViaje vviaje;
	private Cooperativa coop;
	private Terminal ter;
	Viaje viaje = new Viaje();

	public ControladorVistaViaje(Terminal terminal) {

		vviaje = new VistaViaje();
		vviaje.setVisible(true);
		vviaje.activarListener(this);
		this.ter = terminal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getSource().equals(vviaje.getBtnGenerar()))

				asignarViajes(ter);

			else if (e.getActionCommand().equals("SALIR")) {

				vviaje.dispose();

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	private void asignarViajes(Terminal ter) {

		try {
			if (vviaje.getRif() == "")
				JOptionPane.showMessageDialog(null,
						"Debe llenar todos los campos");
			else {
				int i = 0;

				do {
					// obtenemos condiciones del viaje
					String rif = vviaje.getRif();
					coop = ter.BuscarCoop(rif);
					Date fs = vviaje.getFechaI();
					Ruta ruta = coop.randomRuta();
					Date fr = asignarRetorno(ruta, fs);
					Unidad uni = coop.ramdomSocio().randomUnidad();// asigna
																	// unidad
																	// aleatoria
					uni = VerificarUnidad(uni);// / verifica la unidad y retorna
												// una
												// q
												// este disponible
					Chofer cho = coop.randomChofer();
					cho = VerificarChofer(cho);
					float costo = asignarCosto();//

					String Stats = coop.randomStatusVi();// decide si el viaje
															// salio
															// o
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void llenarTabla()

	{
		try {
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ///**********cambia el estatus del chofer y la unidad a multado
	public void multar(Date pferiado) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pferiado);
		for (int i = 0; i < ter.getlFeriado().size(); i++) {
			Feriado feriado = ter.getlFeriado().get(i);
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
		Multa multa = new Multa();
		int i = 0;
		if (coop.getlMulta().isEmpty()== false) {
			for (int j = 0; j < coop.getlViaje().size(); j++) {
				do {
					// for (int i = 0; i < coop.getlMulta().size(); i++) {

					viaje = coop.getlViaje().get(j);
					multa = coop.getlMulta().get(i);

					if (viaje.getFecha_salida().before(multa.getFecha_in())
							|| viaje.getFecha_salida().after(
									multa.getFecha_fin())) {
						viaje.getChofer().setStatus("1");
						viaje.getVehiculo().setStatus("2");
					}
					i++;
				} while (i < coop.getlMulta().size());

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

	// *******************************Asignar Costo********************** //
	public float asignarCosto() {
		float max = 1200;
		float min = 520;

		float costo = min + new Random().nextFloat() * (max - min);// // genera
		// minimo
		BigDecimal precio = new BigDecimal(costo).setScale(2,
				BigDecimal.ROUND_HALF_UP);// / redondea el valor a 2 decimales
		costo = precio.floatValue();// / convierte el el bigdecimal (costo
									// redondeado ) en float
		return costo;
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
