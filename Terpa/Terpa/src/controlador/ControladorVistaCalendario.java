package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.Cooperativa;
import modelo.Terminal;
import modelo.Viaje;
import vista.VistaCalendario;
import vista.VistaViaje;

public class ControladorVistaCalendario implements ActionListener {

	private VistaCalendario vistaCalendario;
	private Cooperativa coop;
	private Viaje viaje;
	private Terminal terminal;
	String[] columna = { "ID Viaje", "Destino", "Unidad", "Chofer", "Salida",
			"Retorno", "Pasaje", "Seguro", "Status" };
	DefaultTableModel model = new DefaultTableModel(null, columna);

	public ControladorVistaCalendario(Terminal terminal) {

		vistaCalendario = new VistaCalendario();
		vistaCalendario.setLocation(480, 210);
		vistaCalendario.setVisible(true);
		vistaCalendario.activarListener(this);
		this.terminal = terminal;
		vistaCalendario.getTable().setModel(model);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		try {
			if (actionCommand.equals("Consultar Otro")) {
				vistaCalendario.blanquearCampos();
			} else if (actionCommand.equals("Salir")) {
				vistaCalendario.dispose();
			} else if (actionCommand.equals("Generar Calendario")) {
				GenerarCalendario(terminal);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void llenarTabla(Cooperativa coop, int i) {

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");

			VistaCalendario vistaCalendario = new VistaCalendario();

			JTable model = vistaCalendario.getTable();
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

			vistaCalendario.setTable(model);

			vistaCalendario.getTable().setModel((TableModel) model);
			vistaCalendario.getTable().setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void GenerarCalendario(Terminal terminal) {

		Date desde = vistaCalendario.getFechaDesde();
		Date hasta = vistaCalendario.getFechaHasta();

		for (int i = 0; i < terminal.getlCoop().size(); i++) {
			coop = terminal.getlCoop().get(i);
			for (int j = 1; j < coop.getlViaje().size(); j++) {
				viaje = coop.getlViaje().get(j);
				if (viaje.getFecha_salida().equals(desde)
						|| viaje.getFecha_salida().after(desde)) {
					if (viaje.getFecha_salida().equals(hasta)
							|| viaje.getFecha_salida().after(hasta))

						llenarTabla(coop, j);
					vistaCalendario.getTable().setVisible(true);

				}
			}

		}
		vistaCalendario.mostrarMensaje("No existen viajes en esas fechas");
		vistaCalendario.blanquearCampos();

	}

}
