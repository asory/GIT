package controlador; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import modeloDAO.CooperativaDAO;
import modeloDAO.SocioDAO;
import vista.*;

public class ControladorVistaSocio implements ActionListener {

	private VistaSocio vsoc;
	private Socio soc;
	private Cooperativa coop;
	private Terminal term;
	private SocioDAO socDAO;
	private CooperativaDAO copDAO;

	public ControladorVistaSocio(Terminal terminal) {
		
		socDAO = new SocioDAO();
		vsoc = new VistaSocio();
		vsoc.setVisible(true);
		vsoc.activarListener(this);
		term = terminal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		try {
			if (actionCommand.equals("Guardar")) {
				agregarSocio();
				vsoc.getBtnAgregarCho().setVisible(true);
				vsoc.getBtnAgregarUnidad().setVisible(true);

			} else if (e.getSource().equals(vsoc.getBtnAgregarCho())) {
				new ControladorVistaChofer(term);
				
			} else if (e.getSource().equals(vsoc.getBtnAgregarUnidad())) {
				new ControladorVistaUnidad(term);
				
			} else if (e.getSource().equals(vsoc.getBtnBuscar())) {
				
			}

			else if (e.getSource().equals(vsoc.getBtnSalir())) {
				vsoc.dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// ///************* Boton Guardar Socio ***************************///
	private void agregarSocio() {
		
		Socio soc = new Socio(vsoc.getNombreS(), vsoc.getTextApellidoS(), vsoc.getTelefonoS(), vsoc.getCiS(),
				vsoc.getIndiceCombo(), vsoc.getTextID());
		
		
		
		if (vsoc.getNombreS() == ""
					|| vsoc.getCiS() == "" || vsoc.getIndiceCombo() == 0
					|| vsoc.getTelefonoS() == ""
					|| vsoc.getTextID() == ""
					|| vsoc.getTextApellidoS() == ""
					|| vsoc.getRifCoop() == "")
				JOptionPane.showMessageDialog(null,
						"Debe rellenar todos los campos");

			else {
				
				String rifdado = vsoc.getRifCoop();
				Cooperativa cop = copDAO.buscarCooperativa(rifdado);
						
				if (copDAO.consultarCooperativa(cop)); {
				
				 if (!socDAO.consultarSocio(soc)) {
					 
					socDAO.registrarSocio(soc);
					vsoc.mostrarMensaje("El Socio ha sido guardado con exito");
					vsoc.blanquearCampos();
					} else
						vsoc.mostrarMensaje("El Socio ya existe");
				}
					vsoc.mostrarMensaje("La Cooperativa no existe");
									
			}
	}


}



/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */

