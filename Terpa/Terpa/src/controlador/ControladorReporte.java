package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import vista.*;
import modelo.*;

public class ControladorReporte implements ActionListener {
	private VistaReporte vreport;
	private TableRowSorter<TableModel> trsfiltro;
	private Terminal ter;
	String[] columna = { "ID Viaje", "Destino", "Unidad", "Chofer", "Salida",
			"Retorno", "Pasaje", "Seguro", "Status" };
	DefaultTableModel model = new DefaultTableModel(null, columna);

	public ControladorReporte(Terminal terminal) {

		VistaReporte vreport = new VistaReporte();
		vreport.setVisible(true);
		vreport.activarListener(this);
		ter = terminal;
	}

	public void llenarTabla() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			
            Cooperativa coop=ter.BuscarCoop(vreport.getRif);
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

			vreport.getTable().setModel(model);
			vreport.getTable().setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void filtro() {

		int opc = vreport.getComboFiltro().getSelectedIndex();
		switch (opc) {

		case 0:
			System.out.print("Debe seleccionar una opcion");
		case 1:
			trsfiltro.setRowFilter(RowFilter.regexFilter(vreport
					.getTextFiltrar().getText(), 1));
		case 2:
			trsfiltro.setRowFilter(RowFilter.regexFilter(vreport
					.getTextFiltrar().getText(), 2));
		case 3:
			trsfiltro.setRowFilter(RowFilter.regexFilter(vreport
					.getTextFiltrar().getText(), 3));
		case 4:
			trsfiltro.setRowFilter(RowFilter.regexFilter(vreport
					.getTextFiltrar().getText(), 4));
		case 5:
			trsfiltro.setRowFilter(RowFilter.regexFilter(vreport
					.getTextFiltrar().getText(), 5));
		case 6:
			trsfiltro.setRowFilter(RowFilter.regexFilter(vreport
					.getTextFiltrar().getText(), 6));

		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		vreport.getTextFiltrar().addKeyListener(new KeyAdapter() {
			public void keyReleased(final KeyEvent e) {
				String cadena = (vreport.getTextFiltrar().getText())
				vreport.getTextFiltrar().setText(cadena);
				vreport.getTextFiltrar().repaint();
				filtro();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(vreport.getTable()
				.getModel());
		vreport.getTable().setRowSorter(trsfiltro);

	};
}
