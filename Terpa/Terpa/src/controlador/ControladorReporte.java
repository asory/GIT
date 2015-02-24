package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Cooperativa;
import modelo.Multa;
import modelo.Viaje;
import modeloDAO.CooperativaDAO;
import modeloDAO.MultaDAO;
import modeloDAO.ViajeDAO;
import memento.*;
import vista.VistaReporte;

public class ControladorReporte implements ActionListener {
	private VistaReporte vreport;
	private Cooperativa coop;
	private int opc;
	private DefaultTableModel model;
	private CooperativaDAO coopDao;
	private ViajeDAO vDao;

	// Memento{
	private String state;
	private Caretaker care;

	public void set(String state) {

		this.state = state;
	}

	public Memento saveToMemento() {

		return new Memento(state);
	}

	public void restoreFromMemento(Memento m) {
		state = m.getSavedState();

	}

	// hace uso de la lista de memento en caretaker
	// para llenar el combobox con las coop usadas recientemente
	public void CargarRecientes() {

		ArrayList<String> rec = new ArrayList<String>();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();

		int i = 0;
		while (i < 5) {

			rec.add(care.getMemento(i).toString());
			// Añadir cada elemento del ArrayList en el modelo del combo
			model.addElement(rec.get(i));
		}

		vreport.getComboMeme().setModel(model);

	}

	public void backup() {
		state = vreport.getTextvrif().getText();

		care.addMemento(saveToMemento());
	}

//} Memento
	
	
	// SINGLETON
	private static ControladorReporte instancia;

	public static ControladorReporte getInstancia() {
		if (instancia == null) {
			instancia = new ControladorReporte();
		}
		return instancia;
	}

	public void iniciar() {
		vreport.limpiar();
		vreport.setVisible(true);
	}
	// SINGLETON
	
	
	public ControladorReporte() {

		vreport = VistaReporte.getInstancia();
		vreport.setVisible(true);
		vreport.activarListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource().equals(vreport.getBtnGenerar())) {

				opc = vreport.getindex();
				String rif = vreport.getTextvrif().getText();
				coopDao.buscarCooperativa(rif);

				if (rif == "" || coopDao.buscarCooperativa(rif) == null)
					JOptionPane.showMessageDialog(null,
							" Introduzca RIF VALIDO");

				else {
					backup();// // MEMENTO
					if (opc == 0)
						JOptionPane.showMessageDialog(null,
								" Seleccione una opcion ");
					if (opc == 3) {

						llenarTablaMulta(asignarcolumna(opc, rif));

					} else if (vreport.getTextFiltrar().equalsIgnoreCase(""))
						JOptionPane.showMessageDialog(null, " Introduzca ID ");
					else
						llenarTablaViajes(opc, asignarcolumna(opc, rif));
				}

			} else if (e.getSource().equals(vreport.getBtnCancelar())) {
				vreport.limpiar();
				vreport.getTable().setModel(new DefaultTableModel());
				vreport.activar();

			} else if (e.getSource().equals(vreport.getComboMeme())) {
				int index = vreport.getComboMeme().getSelectedIndex();
				restoreFromMemento(care.getMemento(index));///retorna el nombre de la coop seleccionada
				vreport.getTextvrif().setText(state);// setea 
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	};

	public DefaultTableModel asignarcolumna(int tipo, String rif) {

		String[] columna = null;
		ArrayList<Viaje> lViaje = vDao.Llenarlistviajes(rif);
		int size = 0;

		switch (tipo) {

		case 1:
			String[] a = { "Chofer", "Cooperativa", "Jefe ", "ID Viaje",
					"Destino", "Unidad", "Salida", "Retorno", "Status" };
			columna = a;
			size = lViaje.size();

			break;
		case 2:
			String[] b = { "Unidad", "Cooperativa", " Propietario", "ID Viaje",
					"Destino", "Chofer", "Salida", "Retorno", "Status" };
			columna = b;
			size = lViaje.size();

			break;
		case 3:

			size = coop.getlMulta().size();
			String[] c = { "Multa", "Cooperativa", "Inicio ", "Fin", "Unidad",
					"Chofer" };
			columna = c;
			break;

		}
		DefaultTableModel model = new DefaultTableModel(null, columna);
		model.setNumRows(size);
		return model;

	}

	public void llenarTablaViajes(int opc, DefaultTableModel model) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			String buscar = vreport.getTextFiltrar();
			boolean llenar = false;// evita q la tabla se llene sino cumple con
									// las condiciones del switch

			ArrayList<Viaje> lViaje = vDao.Llenarlistviajes(vreport
					.getTextvrif().getText());

			for (int i = 0; i < lViaje.size(); i++) {

				Viaje viaje = lViaje.get(i);
				switch (opc) {

				case 1: {
					if (viaje.getChofer().getId_chofer().equals(buscar)) {
						vreport.setLblTitulo("LISTADO DE ASIGNACIONES CHOFER:"
								+ viaje.getChofer().getNombre());
						llenar = true;
						model.setValueAt(buscar, i, 0);
						model.setValueAt(viaje.getChofer().getId_Jefe(), i, 2);
						model.setValueAt(viaje.getVehiculo().getId(), i, 5);

					}
					break;
				}
				case 2: {
					int a = Integer.parseInt((buscar));
					if (viaje.getVehiculo().getId() == a) {
						;
						llenar = true;
						vreport.setLblTitulo("LISTADO DE ASIGNACIONES UNIDAD:"
								+ viaje.getVehiculo().getId_socio()
								+ viaje.getVehiculo().getId());
						model.setValueAt(buscar, i, 0);
						model.setValueAt(viaje.getVehiculo().getId_socio(), i,
								2);
						model.setValueAt(viaje.getChofer().getId_chofer(), i, 5);
					}
					break;
				}
				}

				if (llenar) {
					model.setValueAt(coop.getNombre(), i, 1);
					model.setValueAt(viaje.getIdviaje(), i, 3);
					String Destino = viaje.getRuta().getDestino();
					model.setValueAt(Destino, i, 4);
					model.setValueAt(sdf.format(viaje.getFecha_salida()), i, 6);
					model.setValueAt(sdf.format(viaje.getFecha_retorno()), i, 7);
					model.setValueAt(Status(viaje.getStatus()), i, 8);
					llenar = false;

				}
			}

			vreport.getTable().setModel(model);
			vreport.getTable().setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void llenarTablaMulta(DefaultTableModel model) {
		try {
			String rif = vreport.getTextvrif().getText();
			MultaDAO mDao = new MultaDAO();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			ArrayList<Multa> lMulta = mDao.Llenarlistmult(rif);

			for (int i = 0; i < lMulta.size(); i++) {
				Multa multa = lMulta.get(i);

				coop = coopDao.buscarCooperativa(rif);
				vreport.setLblTitulo("LISTADO DE MULTAS " + coop.getNombre());

				model.setValueAt(multa.getNro(), i, 0);
				model.setValueAt(coop.getNombre(), i, 1);
				model.setValueAt(sdf.format(multa.getFecha_in()), i, 2);
				model.setValueAt(sdf.format(multa.getFecha_fin()), i, 3);
				model.setValueAt(multa.getUnidad().getId(), i, 4);
				model.setValueAt(multa.getC_Asignado().getId_chofer(), i, 5);

				vreport.getTable().setModel(model);
				vreport.getTable().setVisible(true);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
