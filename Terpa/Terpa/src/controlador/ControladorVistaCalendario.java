package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import modelo.Cooperativa;
import modelo.Viaje;
import modeloDAO.CooperativaDAO;
import modeloDAO.ViajeDAO;
import vista.VistaCalendario;

public class ControladorVistaCalendario implements ActionListener {

	private VistaCalendario vistaCalendario;
	private Cooperativa coop;
	private Viaje viaje;

	private Vector<String> vecv = new Vector<String>();

	String[] columna = { "ID Viaje", "Destino", "Unidad", "Chofer", "Salida",
			"Retorno", "Pasaje", "Seguro", "Status" };
	DefaultTableModel model = new DefaultTableModel(null, columna);

	// SINGLETON
	private static ControladorVistaCalendario instancia;

	public static ControladorVistaCalendario getInstancia() {
		if (instancia == null) {
			instancia = new ControladorVistaCalendario();
		}
		return instancia;
	}

	public void iniciar() {
		vistaCalendario.blanquearCampos();
		vistaCalendario.setVisible(true);
	}

	public ControladorVistaCalendario() {

		vistaCalendario = VistaCalendario.getInstancia();
		vistaCalendario.setLocation(480, 210);
		vistaCalendario.setVisible(true);
		vistaCalendario.activarListener(this);

		vistaCalendario.getTable().setModel(model);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		try {
			if (actionCommand.equals("Consultar Otro")) {
				vistaCalendario.blanquearCampos();
				vistaCalendario.getTable().setModel(
						new DefaultTableModel(null, columna));
				vecv.removeAllElements();
				vistaCalendario.getBtnGenerarCalendario().setEnabled(true);
			} else if (actionCommand.equals("Salir")) {
				vistaCalendario.dispose();
			} else if (actionCommand.equals("Generar Calendario")) {
				GenerarCalendario();
				vistaCalendario.getBtnGenerarCalendario().setEnabled(false);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void GenerarCalendario() {
		CooperativaDAO coopDao = new CooperativaDAO();
		ArrayList<Cooperativa> lCoop = coopDao.Llenarlistcoop();
		for (int i = 0; i < lCoop.size(); i++) {
			coop = lCoop.get(i);
			for (int j = 1; j < coop.getlViaje().size(); j++) {
				viaje = coop.getlViaje().get(j);
				if (verificarFecha(viaje.getFecha_salida()))
					llenarTabla(coop, j);

			}
		}

		vistaCalendario.getTable().setVisible(true);

	}

	public void llenarTabla(Cooperativa coop, int i) {

		ViajeDAO vDao = new ViajeDAO();
		ArrayList<Viaje> lViaje = vDao.Llenarlistviajes(coop.getRif());
		try {
			vecv.clear();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			viaje = lViaje.get(i);

			vecv.add(viaje.getIdviaje());
			String Destino = viaje.getRuta().getDestino();
			vecv.add(Destino);
			vecv.add(Integer.toString(viaje.getVehiculo().getId()));
			vecv.add(viaje.getChofer().getId_chofer());
			vecv.add(sdf.format(viaje.getFecha_salida()));
			vecv.add(sdf.format(viaje.getFecha_retorno()));
			vecv.add(viaje.getCosto().toString());

			int Seguro = (int) viaje.CalSeguro(viaje.getCosto());// /
			vecv.add(Integer.toString(Seguro));
			vecv.add(Status(viaje.getStatus()));

			model.addRow(vecv);

			vistaCalendario.getTable().setModel(model);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean verificarFecha(Date fverificar) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		boolean resp = false;
		Calendar fviaje = Calendar.getInstance();
		Calendar desde = Calendar.getInstance();
		Calendar hasta = Calendar.getInstance();

		desde.setTime(vistaCalendario.getFechaDesde());
		hasta.setTime(vistaCalendario.getFechaHasta());
		fviaje.setTime(fverificar);

		String a = sdf.format(fverificar);
		String b = sdf.format(vistaCalendario.getFechaDesde());
		String c = sdf.format(vistaCalendario.getFechaHasta());

		if (fviaje.after(desde) && fviaje.before(hasta))
			resp = true;
		if (a.equals(b) || a.equals(c))
			resp = true;

		return resp;
	}

	public String Status(int i) {
		String sts = "";
		switch (i) {
		case 1:
			sts = "SALIO";
			break;
		case 2:
			sts = "NO SALIO";
			break;
		case 3:
			sts = "Cancelado ";
			break;
		}
		return sts;

	}
}

/*
 * Integrantes: Rosa Piña C.I. 24.166.902 Edwin Lucena C.I. 21.256.626 Norielsy
 * Freitez C.I. 20.668.899 Ana Ruiz C.I. 21.296.217
 */
