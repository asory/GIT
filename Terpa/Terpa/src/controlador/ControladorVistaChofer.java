package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorVistaChofer implements ActionListener {

	private VistaChofer vcho;
	private Chofer cho;
	// private Socio soc;
	private Cooperativa coop;
	private Terminal term;

	public ControladorVistaChofer(Terminal terminal) {
		vcho = new VistaChofer();
		vcho.setVisible(true);

		vcho.activarListener(this);
		term = terminal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		try {
			if (actionCommand.equals("Guardar"))
				agregarChofer();

			else if (e.getSource().equals(vcho.getBtnGuardarC())) {
				JOptionPane.showInternalConfirmDialog(vcho, "Agregar Chofer",
						null, JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				vcho.blanquearCampos();
			}

			else if (e.getSource().equals(vcho.getBtnBuscarCoop())) {
				BuscarCooperativa();
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
		// try{
		if (vcho.getRifCoop() == "" || vcho.getNombreC().getText() == ""
				|| vcho.getCiC() == "" || vcho.getApellidoC().getText() == ""
				|| vcho.getTelefonoC().getText() == ""
				|| vcho.getSocioC() == "")
			JOptionPane.showMessageDialog(vcho,
					"Debe rellenar todos los campos");

		else {
			// Chofer cho = new Chofer(); //
			// Chofer(vcho.getCiC(),null,vcho.getSocioC())

			if (true == term.VerificarCoop(vcho.getRifCoop())
					&& false == ValidarChofer() && false == ValidarSocio()) {

				String rifcoop = vcho.getRifCoop();
				coop = term.BuscarCoop(vcho.getRifCoop());
				String nombrec = vcho.getNombreC().getText();
				String apellidoc = vcho.getApellidoC().getText();
				String cedulac = vcho.getCiC();
				String telefonoc = vcho.getTelefonoC().getText();
				String socioc = vcho.getSocioC();

				coop.agregarChofer(cho);
				vcho.mostrarMensaje("El Chofer ha sido guardada con exito");
				vcho.blanquearCampos();
			} else
				vcho.mostrarMensaje("El chofer ya existe");
		}
		// }
		// catch (Exception e) {
		// vcho.mostrarMensaje("No se pudo guardar el chofer, verifique que los datos sean correctos");
		// vcho.blanquearCampos();
		// }
	}

	// ///************* Boton Buscar Cooperativa ***************************///
	public void BuscarCooperativa() {
		coop = term.BuscarCoop(vcho.getRifCoop());
		vcho.getCoop().setText(coop.getNombre());
	}

	// /**************** Validar que el Chofer no exista
	// ***********************///
	public boolean ValidarChofer() {
		boolean v = false;
		Cooperativa coop = new Cooperativa();

		for (int i = 0; i < coop.getlChofer().size(); i++) {

			if (vcho.getCiC() == coop.getlChofer().get(i).getCi())

				v = true; // lo encontro
		}
		return v; // no lo encontro
	}

	// /**************** Validar que el Socio exista ***********************///
	public boolean ValidarSocio() {
		boolean v = false;
		Cooperativa coop = new Cooperativa();

		for (int i = 0; i < coop.getlChofer().size(); i++) {

			if (vcho.getSocioC() == coop.getlSocio().get(i).getCi())
				v = true; // lo encontro
		}
		return v; // no lo encontro
	}

}
