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
						
				if (copDAO.consultarCooperativa(cop)==false) {
				
				String iddado = vcho.getSocioC();	
				Socio soc = socDAO.buscarSocio(iddado);

				if (!choDAO.consultarChofer(cho)){
				
				 if (socDAO.consultarSocio(soc)) {
					 
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
			vcho.mostrarMensaje("El Chofer ya se ha eliminado");
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
		
		Chofer chofer = choDAO.buscarChofer(vcho.getTextCiC().getText());
		
		//if(choDAO.consultarChofer(chofer)){
					
			vcho.getTextNombreC().setText(chofer.getNombre());
			vcho.getTextCiC().setText(chofer.getCi());
			vcho.getTextApellidoC().setText(chofer.getApellido());
			vcho.getTextTelefonoC().setText(chofer.getTelefono());
			vcho.getTextSocioC().setText(chofer.getId_Jefe());
		//}
		vcho.mostrarMensaje("El Chofer no existe");
		
	}
}
/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */
