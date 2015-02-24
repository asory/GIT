package controlador;

import modelo.Chofer;
import modelo.Ruta;
import modelo.Cooperativa;
import modeloDAO.CooperativaDAO;
import modeloDAO.RutaDAO;
import vista.VistaCargarRuta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorVistaCargarRuta implements ActionListener {

	
	private VistaCargarRuta vistaCargarRuta;

	private RutaDAO rutDAO;
	
	public ControladorVistaCargarRuta() {
		
		rutDAO = new RutaDAO();

		vistaCargarRuta = VistaCargarRuta.getInstancia();
		vistaCargarRuta.setLocation(480, 210);
		vistaCargarRuta.setVisible(true);
		vistaCargarRuta.activarListener(this);
		
	}
	//SINGLETON
		private static ControladorVistaCargarRuta instancia;
		
		
		public static  ControladorVistaCargarRuta getInstancia(){
				if (instancia == null){
					instancia = new ControladorVistaCargarRuta() ;
				}
				return instancia;
			}
			
		public void iniciar(){
			vistaCargarRuta.blanquearCampos();
			vistaCargarRuta.setVisible(true);
		}
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource().equals(vistaCargarRuta.getBtnGuardar())) {
			agregarRuta();
		} else if (e.getSource().equals(vistaCargarRuta.getBtnSalir())) {
			vistaCargarRuta.dispose();
		} else if (e.getSource().equals(vistaCargarRuta.getBtnEliminar())) {
			eliminar();
		} else if (e.getSource().equals(vistaCargarRuta.getBtnModificar())) {
			 modificar(); 			
		} else if (e.getSource().equals(vistaCargarRuta.getBtnBuscar())){
			Buscar();	
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
	
public void eliminar(){
		
	Ruta rut = new Ruta(vistaCargarRuta.getCod(), vistaCargarRuta.getDesc(), vistaCargarRuta.getIndiceCombo());
	
	if (rutDAO.consultarRuta(rut)) {
		rutDAO.eliminarRuta(rut);
		JOptionPane.showMessageDialog(null, "Ruta Eliminada ");
		vistaCargarRuta.blanquearCampos();
	} else
		JOptionPane.showMessageDialog(null,
				"La Ruta no existe");
}

	
	public void modificar(){
		
		Ruta rut = new Ruta(vistaCargarRuta.getCod(), vistaCargarRuta.getDesc(), vistaCargarRuta.getIndiceCombo());
		
		
		if (vistaCargarRuta.getCod().equals("")
				|| vistaCargarRuta.getDesc().equals("")
				|| vistaCargarRuta.getIndiceCombo()==0) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			if (rutDAO.consultarRuta(rut)) {
				rutDAO.actualizarRuta(rut);
				JOptionPane.showMessageDialog(null, "Ruta Actualizada ");
				vistaCargarRuta.blanquearCampos();
			} else
				JOptionPane.showMessageDialog(null,
						"La Ruta no existe");
		}
	}	
	
	private void Buscar() {
		
		Ruta rut= rutDAO.buscarRuta(vistaCargarRuta.getCod());
		
		int tipo = rut.getTipo();
		String desc = rut.getDestino();
		
		vistaCargarRuta.getcomboTipo().setSelectedIndex(tipo);
		vistaCargarRuta.getTextDesc().setText(desc);		
		
	}
}
	




/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */


