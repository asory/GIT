package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vista.VistaViaje;
import modelo.*;

public class ControladorVistaViaje implements ActionListener {

	private VistaViaje vviaje;
	private Cooperativa coop;
	private Terminal ter;
	Viaje viaje = new Viaje();
	String[] columna = { "ID Viaje", "Destino", "Unidad", "Chofer", "Salida",
			"Retorno", "Pasaje", "Seguro", "Status" };
	DefaultTableModel model = new DefaultTableModel(null, columna);

	public ControladorVistaViaje(Terminal terminal) {

		vviaje = new VistaViaje();
		vviaje.setVisible(true);
		vviaje.activarListener(this);
		this.ter = terminal;
		vviaje.getTable().setModel(model);
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

				String rif = vviaje.getRif();
				if (ter.VerificarCoop(rif) == false) {
					JOptionPane.showMessageDialog(null,
							"La Cooperativa no esta registrada");
					vviaje.Limpiar();

				} else if (vviaje.getFechaI().before(new Date())) {
					JOptionPane.showMessageDialog(null, "fecha invalida  ");

				} else {
					int i = 0;
					do {
						// obtenemos condiciones del viaje

						coop = ter.BuscarCoop(rif);

						Date fs = randomSalida(vviaje.getFechaI());
						Ruta ruta = coop.randomRuta();
						Date fr = asignarRetorno(ruta, fs);
						Unidad uni = coop.ramdomSocio().randomUnidad();// asigna
																		// unidad
																		// aleatoria
						uni = VerificarUnidad(uni);// / verifica la unidad y
													// retorna
													// una
													// q
													// este disponible
						Chofer cho = coop.randomChofer();
						cho = VerificarChofer(cho);
						float costo = asignarCosto();//
						// decide si el viaje salio o no
						String Stats = coop.randomStatusVi();

						// se asignan las variables al viaje

						String codv = "v" + "" + i + ""
								+ rif.substring(rif.length() - 3, rif.length());
						// codigo esta compuesto por el numero de viaje y los 3
						// ultimos
						// digitos del rif de la cooperativa a la q pertenece
						Viaje viaje = new Viaje();
						viaje.setIdviaje(codv);
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
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void llenarTabla() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");

			ArrayList<Viaje> lViaje = coop.getlViaje();
			model.setNumRows(lViaje.size());

			for (int i = 0; i < lViaje.size(); i++) {
				Viaje viaje = lViaje.get(i);

				model.setValueAt(viaje.getIdviaje(), i, 0);
				String Destino = viaje.getRuta().getDestino();
				model.setValueAt(Destino, i, 1);
				model.setValueAt(viaje.getVehiculo().getId(), i, 2);
				model.setValueAt(viaje.getChofer().getId_chofer(), i, 3);
				model.setValueAt(sdf.format(viaje.getFecha_salida()), i, 4);
				model.setValueAt(sdf.format(viaje.getFecha_retorno()), i, 5);
				model.setValueAt(viaje.getCosto(), i, 6);
				model.setValueAt(viaje.CalSeguro(viaje.getCosto()), i, 7);
				model.setValueAt(viaje.getStatus(), i, 8);

			}

			vviaje.getTable().setModel(model);
			vviaje.getTable().setVisible(true);

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
					viaje.setStatus("3");

				}
			}
		}

	}

	// *******************Quitar Multa *************
	public void quitarmulta() {
		Multa multa = new Multa();
		int i = 0;
		if (coop.getlMulta().isEmpty() == false) {
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

	public Date modificarHoras(Date fecha, int hora) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.HOUR, hora); //
		return calendar.getTime(); // Devuelve el objeto Date con la nueva hora

	}

	// **********************Random Salida***************

	public Date randomSalida(Date fecha) {

		int random = 0;

		random = (int) Math.floor(Math.random() * 8 + 2);

		Date salida = modificarDias(fecha, random);

		random = (int) Math.floor(Math.random() * 23 + 0);
		
		salida = modificarHoras(salida, random);

		return salida;
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
