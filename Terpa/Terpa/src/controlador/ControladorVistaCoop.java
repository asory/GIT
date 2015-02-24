package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import modeloDAO.CooperativaDAO;
import vista.VistaCoop;

public class ControladorVistaCoop implements ActionListener {
	private VistaCoop vcoop;
	private Terminal ter;
	private CooperativaDAO copDAO;

	public ControladorVistaCoop(Terminal terminal) {
		copDAO = new CooperativaDAO();
		vcoop = new VistaCoop();
		vcoop.setVisible(true);
		vcoop.setLocationRelativeTo(null);
		vcoop.activarListener(this);
		this.ter = terminal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if (e.getSource().equals(vcoop.getBtnAgregar()))
				agregarCoop();
			else if (e.getSource().equals(vcoop.getBtnEliminar())) {
				eliminar();
			} else if (e.getSource().equals(vcoop.getBtnModificar())) {
			 	modificar();
			} else if (e.getSource().equals(vcoop.getBtnBuscar())) {
				Buscar();
			} else if (e.getSource().equals(vcoop.getBtnAgregarSocio())) {
			 new ControladorVistaSocio(ter);
							vcoop.Limpiar();
			}

			else if (e.getSource().equals(vcoop.getBtnSalir())) {

				vcoop.dispose();

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public void agregarCoop() {

		Cooperativa cop =  new  Cooperativa(vcoop.getTexNombreC(),vcoop.getTextRif());
	
		if (vcoop.getTexNombreC().isEmpty() || vcoop.getTextRif().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			
			if (!copDAO.consultarCooperativa(cop)) {
				copDAO.registrarCooperativa(cop);
				vcoop.getBtnAgregarSocio().setVisible(true);
				JOptionPane.showMessageDialog(null, "Cooperativa Registrada ");
				vcoop.Limpiar();
			} else
				JOptionPane.showMessageDialog(null,
						"La Cooperativa ya esta registrada");
		}

	}
	
	public void eliminar(){
		
		Cooperativa cop =  new  Cooperativa(vcoop.getTexNombreC(),vcoop.getTextRif());
		
		if (copDAO.consultarCooperativa(cop)) {
			copDAO.eliminarCooperativa(cop);
			JOptionPane.showMessageDialog(null, "Cooperativa Eliminada ");
			vcoop.Limpiar();
		} else
			JOptionPane.showMessageDialog(null,
					"La Cooperativa no existe");
		}

	public void modificar(){
	
		Cooperativa cop =  new  Cooperativa(vcoop.getTexNombreC(),vcoop.getTextRif());
		
		if (vcoop.getTexNombreC().isEmpty() || vcoop.getTextRif().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			if (copDAO.consultarCooperativa(cop)) {
				copDAO.actualizarCooperativa(cop);
				JOptionPane.showMessageDialog(null, "Cooperativa Actualizada ");
				vcoop.Limpiar();
			} else
				JOptionPane.showMessageDialog(null,
						"La Cooperativa no se encuentra registrado");
			}
	}
	
	private void Buscar() {
		
		Cooperativa cop= copDAO.buscarCooperativa(vcoop.getTextRif());
		
		String nombre= cop.getNombre();
		vcoop.getTextNombreC().setText(nombre);
		
	}
}




/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */
