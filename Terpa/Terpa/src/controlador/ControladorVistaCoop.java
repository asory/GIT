package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorVistaCoop implements ActionListener {
	private VistaCoop vcoop;
	private Terminal ter;
	private Cooperativa coop;

	public ControladorVistaCoop() {
	
		VistaCoop vcoop= new VistaCoop();
		vcoop.setVisible(true);
		coop = new Cooperativa();
		ter = new Terminal();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(vcoop.getBtnAgregar())) {

			 vcoop.getBtnAgregar().getActionCommand().equals("Agregar");

			if (vcoop.getTexNombreC().getText() == ""
					|| vcoop.getTextRif().getText() == "")
				JOptionPane.showMessageDialog(vcoop,
						"Debe rellenar todos los campos");

			else {
				String rif = vcoop.getTextRif().getText();
				String nombre = vcoop.getTexNombreC().getText();
				coop.setNombre(nombre);
				coop.setRif(rif);
				ter.agregarCooperativa(coop);
				vcoop.getBtnAgregarSocio().setVisible(true);
			}

			if (e.getSource().equals(vcoop.getBtnAgregarSocio())) {
				JOptionPane.showInternalConfirmDialog(vcoop, "Agregar Socio",
						null, JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				/*
				 * vcoop.getBtnAgregarSocio().
				 * addActionListener((ActionListener) e); { String actionC =
				 * e.getActionCommand(); if (actionC.equals("SOCIO")) { {
				 * VistaCargarSocio v = new VistaCargarSocio();
				 * v.setVisible(true); v.setLocationRelativeTo(vcoop); } } }; }
				 */
				vcoop.Limpiar();
			}

			if (e.getSource().equals(vcoop.getBtnSalir())) {
				vcoop.dispose();
			}

		}
	}
}
