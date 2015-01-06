package controlador;

import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Cooperativa;
import modelo.Terminal;
import modelo.Viaje;

public class ControladorVistaCalendario implements ActionListener {
	
	private VistaCalendario vistaCalendario;
	private Cooperativa coop = new Cooperativa();
	private Viaje viaje = new Viaje();
	private Terminal terminal;
	String[] columna = { "ID Viaje", "Destino", "Unidad", "Chofer", "Salida",
			"Retorno", "Pasaje", "Seguro", "Status" };
	DefaultTableModel model = new DefaultTableModel(null, columna);
	public ControladorVistaCalendario(Terminal terminal) {
		
		vistaCalendario = new VistaCalendario();
		vistaCalendario.setLocation(480,210);
		vistaCalendario.setVisible(true);
		vistaCalendario.activarListener(this);
		this.terminal = terminal;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		try {
		if (actionCommand.equals("Consultar Otro")) {
			vistaCalendario.blanquearCampos();
		} else if (actionCommand.equals("Salir")) {
			vistaCalendario.dispose();
		} else if (actionCommand.equals("Generar Calendario")){
			GenerarCalendario();
			
		}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public void llenarTabla(Cooperativa coop,int i) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");

			ArrayList<Viaje> lViaje = coop.getlViaje();
			model.setNumRows(lViaje.size());

			
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

			

			vistaCalendario.getTable().setModel(model);
			
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void GenerarCalendario() {
	
		Terminal terminal = new Terminal();
		Date desde = vistaCalendario.getFechaDesde();
		Date hasta = vistaCalendario.getFechaHasta();
	
		for (int i = 0; i < terminal.getlCoop().size(); i++) {
			coop = terminal.getlCoop().get(i);
			for (int j = 0; j < coop.getlViaje().size(); j++) {
				viaje = coop.getlViaje().get(j);
				if (viaje.getFecha_salida().equals(desde)||viaje.getFecha_salida().after(desde));
					 { if (viaje.getFecha_salida().equals(hasta)||viaje.getFecha_salida().after(hasta));
					
					llenarTabla(coop, j);
			
				} 
					 
					vistaCalendario.mostrarMensaje("No existen viajes en esas fechas");
					vistaCalendario.blanquearCampos();		
				
			}
			
		}
		vistaCalendario.getTable().setVisible(true);  
	}
}
