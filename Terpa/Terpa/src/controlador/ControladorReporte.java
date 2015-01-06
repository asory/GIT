package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import vista.*;
import modelo.*;

public class ControladorReporte implements ActionListener {
	private VistaReporte vreport;
	private Terminal ter;
	private Cooperativa coop;
	private int opc;
	private DefaultTableModel model;

	public ControladorReporte(Terminal terminal) {

		vreport = new VistaReporte();
		vreport.setVisible(true);
		vreport.activarListener(this);
		ter = terminal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getSource().equals(vreport.getBtnGenerar())) {

				opc = vreport.getindex();
				String rif = vreport.getTextvrif().getText();

				if (rif == "" || !ter.VerificarCoop(rif))
					JOptionPane.showMessageDialog(null,
							" Introduzca RIF VALIDO");

				else {
					if (opc == 0)
						JOptionPane.showMessageDialog(null,
								" Seleccione una opcion ");
					if (opc == 3) {
						vreport.desactivar();
						llenarTablaMulta();
					} else if (vreport.getTextFiltrar() == " ")
						JOptionPane.showMessageDialog(null, " Introduzca ID ");
					else
						llenarTablaViajes(opc);
				}
				vreport.getTable().setModel(asignarcolumna(opc));

			} else if (e.getSource().equals(vreport.getBtnCancelar())) {
				vreport.limpiar();
				vreport.activar();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	};

	public DefaultTableModel asignarcolumna(int tipo) {

		// int tipo = vreport.getindex();// (int)combo.getSelectedIndex();
		String[] columna = null;

		coop = ter.BuscarCoop(vreport.getTextvrif().getText());
		ArrayList<Viaje> lViaje = coop.getlViaje();
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
			String[] c = { "Multa", "Cooperativa", "Inicio ", "Fina", "Unidad",
					"Chofer" };
			vreport.desactivar();
			columna = c;
			break;

		}
		DefaultTableModel model = new DefaultTableModel(null, columna);
		 model.setNumRows(size);
		return model;

	}

	public void llenarTablaViajes(int opc) {

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			String buscar = vreport.getTextFiltrar();

			coop = ter.BuscarCoop(vreport.getTextvrif().getText());
			ArrayList<Viaje> lViaje = coop.getlViaje();

			for (int i = 0; i < lViaje.size(); i++) {
				Viaje viaje = lViaje.get(i);
				switch (opc) {

				case 1: {
					if (viaje.getChofer().getId_chofer() == buscar)
						vreport.setLblTitulo("LISTADO DE ASIGNACIONES CHOFER:"
								+ buscar);
					model.setValueAt(buscar, i, 0);
					model.setValueAt(viaje.getChofer().getId_Jefe(), i, 2);
					model.setValueAt(viaje.getVehiculo().getId(), i, 5);

					break;
				}
				case 2: {
					if (viaje.getVehiculo().getId() == Integer
							.parseInt((buscar)))
						;
					vreport.setLblTitulo("LISTADO DE ASIGNACIONES UNIDAD:"
							+ buscar);
					model.setValueAt(buscar, i, 0);
					model.setValueAt(viaje.getVehiculo().getId_socio(), i, 2);
					model.setValueAt(viaje.getChofer().getId_chofer(), i, 5);
					break;
				}
				}

				model.setValueAt(coop.getNombre(), i, 1);
				model.setValueAt(viaje.getIdviaje(), i, 3);
				String Destino = viaje.getRuta().getDestino();
				model.setValueAt(Destino, i, 4);
				model.setValueAt(sdf.format(viaje.getFecha_salida()), i, 6);
				model.setValueAt(sdf.format(viaje.getFecha_retorno()), i, 7);
				model.setValueAt(viaje.getStatus(), i, 8);

			}
          
			vreport.getTable().setModel(model);
			vreport.getTable().setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void llenarTablaMulta() {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			ArrayList<Multa> lMulta = coop.getlMulta();
			for (int i = 0; i < lMulta.size(); i++) {
				Multa multa = lMulta.get(i);

				coop = ter.BuscarCoop(vreport.getTextvrif().getText());
				vreport.setLblTitulo("LISTADO DE MULTAS " + coop);

				model.setValueAt(multa.getNro(), i, 0);
				model.setValueAt(coop, i, 1);
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
}
