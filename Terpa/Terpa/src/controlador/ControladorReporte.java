package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import vista.*;
import modelo.*;

public class ControladorReporte implements ActionListener {
	private VistaReporte vreport;
	private TableRowSorter<TableModel> trsfiltro;
	private Terminal ter;

	public ControladorReporte(Terminal terminal) {

		VistaReporte vreport = new VistaReporte();
		vreport.setVisible(true);
		vreport.activarListener(this);
		ter = terminal;
	}

	public void llenarTabla()

	{
		Cooperativa coop = new Cooperativa();
		Viaje viaje = new Viaje();

		for (int j = 0; j < ter.getlCoop().size(); j++) {

			for (int i = 0; i < coop.getlViaje().size(); i++) {
				viaje = coop.getlViaje().get(i);
				JTable model = vreport.getTable();
				model.setValueAt(viaje.getIdviaje(), i, 0);
				model.setValueAt(viaje.getRuta().getDestino(), i, 1);
				model.setValueAt(viaje.getVehiculo(), i, 2);
				model.setValueAt(viaje.getChofer(), i, 3);
				model.setValueAt(viaje.getFecha_salida(), i, 4);
				model.setValueAt(viaje.getFecha_retorno(), i, 5);
				model.setValueAt(viaje.getCosto(), i, 6);
				model.setValueAt(viaje.CalSeguro(viaje.getCosto()), i, 7);
				model.setValueAt(viaje.getStatus(), i, 8);

				vreport.setTable(model);
			}
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
						.toUpperCase();
				vreport.getTextFiltrar().setText(cadena);
				vreport.getTextFiltrar().repaint();
				filtro();
			}
		});
		trsfiltro = new TableRowSorter<TableModel>(vreport.getTable().getModel());
		vreport.getTable().setRowSorter(trsfiltro);

	};
}
