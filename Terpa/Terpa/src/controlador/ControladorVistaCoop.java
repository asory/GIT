package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import vista.VistaCoop;

public class ControladorVistaCoop implements ActionListener {
	private VistaCoop vcoop;
	private Terminal ter;
	private Cooperativa coop;

	public ControladorVistaCoop(Terminal terminal) {

		vcoop = new VistaCoop();
		vcoop.setVisible(true);
		vcoop.setLocationRelativeTo(null);
		vcoop.activarListener(this);
		coop = new Cooperativa();
		this.ter = terminal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionC = e.getActionCommand();
		try {
			// if (e.getSource().equals(vcoop.getBtnAgregar()))
			if (actionC.equals("AGREGAR"))
				agregarCoop();

			else if  (e.getSource().equals(vcoop.getBtnAgregarSocio())) {
				JOptionPane.showInternalConfirmDialog(vcoop,
						"Agregar Socio", null,
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				/*
				  ControladorCargarSocio v = new
				  ControladorCargarSocio(); v.setVisible(true);
				  v.setLocationRelativeTo(vcoop); }
				 */
				vcoop.Limpiar();
			}
			
			else if(e.getSource().equals(vcoop.getBtnSalir())) {
				
				vcoop.Limpiar();
			
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public void agregarCoop() {

		if (vcoop.getTexNombreC().getText() ==" "
				|| vcoop.getTextRif().getText()==" ")
			vcoop.mostrarMensaje("Debe rellenar todos los campos");

		else {
			String rif = vcoop.getTextRif().getText();
			String nombre = vcoop.getTexNombreC().getText();
			coop.setNombre(nombre);
			coop.setRif(rif);
			if (ter.VerificarCoop(rif)==false) {
				ter.agregarCooperativa(coop);
				vcoop.getBtnAgregarSocio().setVisible(true);
			} else
				JOptionPane.showMessageDialog(this.vcoop,
						"La Cooperativa ya esta registrada");

		}
	}

}
