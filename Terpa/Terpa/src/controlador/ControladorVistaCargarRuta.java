package controlador;

import modelo.Ruta;
import modelo.Terminal;
import modelo.Cooperativa;
import modeloDAO.CooperativaDAO;
import modeloDAO.RutaDAO;
import vista.VistaCargarRuta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorVistaCargarRuta implements ActionListener {

	
	private VistaCargarRuta vistaCargarRuta;
	private Terminal terminal;
	private RutaDAO rutDAO;
	
	public ControladorVistaCargarRuta(Terminal terminal) {
		
		rutDAO = new RutaDAO();
		vistaCargarRuta = new VistaCargarRuta();
		vistaCargarRuta.setLocation(480, 210);
		vistaCargarRuta.setVisible(true);
		vistaCargarRuta.activarListener(this);
		this.terminal = terminal;

	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource().equals(vistaCargarRuta.getBtnGuardar())) {
			agregarRuta();
		} else if (e.getSource().equals(vistaCargarRuta.getBtnSalir())) {
			vistaCargarRuta.dispose();

		} else if (e.getSource().equals(vistaCargarRuta.getBtnBuscar())){
			//Buscar();	
		}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void agregarRuta() {
		
		Ruta rut = new Ruta(vistaCargarRuta.getCod(), vistaCargarRuta.getDesc(), vistaCargarRuta.getIndiceCombo());
		
		
		if (vistaCargarRuta.getCod().equals("")
				|| vistaCargarRuta.getDesc().equals("")
				|| vistaCargarRuta.getIndiceCombo()==0) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			
			if (!rutDAO.consultarRuta(rut)) {
				rutDAO.registrarRuta(rut);
				JOptionPane.showMessageDialog(null, "Ruta Registrada ");
				vistaCargarRuta.blanquearCampos();
			} else
				JOptionPane.showMessageDialog(null,
						"La Ruta ya existe");
		}

	}

}
	




/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */


