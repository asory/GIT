package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import modeloDAO.ChoferDAO;
import modeloDAO.CooperativaDAO;
import modeloDAO.SocioDAO;
import vista.*;

public class ControladorVistaChofer implements ActionListener {

	private VistaChofer vcho;
	private Cooperativa coop;
	private Terminal term;
	private ChoferDAO choDAO;
	private CooperativaDAO copDAO;
	private SocioDAO socDAO;

	public ControladorVistaChofer(Terminal ter) {
		choDAO = new ChoferDAO();
		copDAO = new CooperativaDAO();
		socDAO = new SocioDAO();
		vcho = new VistaChofer();
		vcho.setVisible(true);
		vcho.activarListener(this);
		term = ter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		try {
			if (actionCommand.equals("Guardar"))
				agregarChofer();
			
			else if (e.getSource().equals(vcho.getBtnEliminar())) {
				eliminar();
			} else if (e.getSource().equals(vcho.getBtnModificar())) {
			 	modificar();
			} else if (e.getSource().equals(vcho.getBtnBuscarCho())) {
				Buscar();
			}

			else if (e.getSource().equals(vcho.getBtnSalir())) {
				vcho.blanquearCampos();
				vcho.dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// ///************* Boton Guardar Chofer ***************************///
	private void agregarChofer() {
		
		Chofer cho = new Chofer(vcho.getNombreC(), vcho.getApellidoC(), vcho.getTelefonoC(), vcho.getCiC(),
				vcho.getIdC(), false, vcho.getSocioC());
		
			if (vcho.getRifCoop().isEmpty()
					|| vcho.getCiC().isEmpty()
					|| vcho.getApellidoC().isEmpty()
					|| vcho.getTelefonoC().isEmpty()
					|| vcho.getSocioC().isEmpty() || vcho.getIdC().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
			} else {
				String rifdado = vcho.getRifCoop();
				Cooperativa cop = copDAO.buscarCooperativa(rifdado);
						
				if (!copDAO.consultarCooperativa(cop)); {
				
				String iddado = vcho.getSocioC();
				String rifcoop = vcho.getRifCoop();
				Socio soc = socDAO.buscarSocio(iddado, rifcoop);

				if (!choDAO.consultarChofer(cho)){
				
				 if (socDAO.consultarSocio(soc,rifcoop)) {
					 
					choDAO.registrarChofer(cho);
					vcho.mostrarMensaje("El Chofer ha sido guardado con exito");
					vcho.blanquearCampos();
					} else
						vcho.mostrarMensaje("El socio no existe");
				} else
					vcho.mostrarMensaje("El Chofer ya existe");
				} 
					vcho.mostrarMensaje("Cooperativa no existe");					
			}
	}

	public void eliminar(){
		
		Chofer cho = new Chofer(vcho.getNombreC(), vcho.getApellidoC(), vcho.getTelefonoC(), vcho.getCiC(),
				vcho.getIdC(), false, vcho.getSocioC());
		
		if(choDAO.consultarChofer(cho)){
			choDAO.eliminarChofer(cho);
			vcho.mostrarMensaje("El Chofer ha sido eliminado con exito");
			vcho.blanquearCampos();
		} else
			vcho.mostrarMensaje("El Chofer no existe");
	}
	
	public void modificar(){
		
		Chofer cho = new Chofer(vcho.getNombreC(), vcho.getApellidoC(), vcho.getTelefonoC(), vcho.getCiC(),
				vcho.getIdC(), false, vcho.getSocioC());
		
		if (vcho.getRifCoop().isEmpty()
				|| vcho.getCiC().isEmpty()
				|| vcho.getApellidoC().isEmpty()
				|| vcho.getTelefonoC().isEmpty()
				|| vcho.getSocioC().isEmpty() || vcho.getIdC().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			if(choDAO.consultarChofer(cho)){
				choDAO.actualizarChofer(cho);
				vcho.mostrarMensaje("El Chofer ha sido modificado con exito");
				vcho.blanquearCampos();
			} else
				vcho.mostrarMensaje("El Chofer no ha sido registrado");
		}
	}
	
	public void Buscar(){
	
			Chofer chofer = choDAO.buscarChofer(vcho.getIdC());
			
			String nombre = chofer.getNombre();
			String cedula = chofer.getCi();
			String apellido = chofer.getApellido();
			String telefono = chofer.getTelefono();
			String idjefe = chofer.getId_Jefe();
			
			vcho.getTextNombreC().setText(nombre);
			vcho.getTextCiC().setText(cedula);
			vcho.getTextApellidoC().setText(apellido);
			vcho.getTextTelefonoC().setText(telefono);
			vcho.getTextSocioC().setText(idjefe);
		
	}

}
/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */
