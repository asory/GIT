package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorVistaSocio implements ActionListener {

	private VistaSocio vsoc;
	private Socio soc;
	private Cooperativa coop;
	private Terminal term;

	public ControladorVistaSocio(Terminal terminal) {
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
				
			} else if (e.getSource().equals(vsoc.getBtnBuscarCoop())) {
				BuscarCooperativa(term);
			}

			else if (e.getSource().equals(vsoc.getBtnSalir())) {
				vsoc.blanquearCampos();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// ///************* Boton Guardar Socio ***************************///
	private void agregarSocio() {
		try {
			if (vsoc.getRifCoop() == "" || vsoc.getNombreS().getText() == ""
					|| vsoc.getCiS() == "" || vsoc.getIndiceCombo() == 0
					|| vsoc.getTelefonoS().getText() == ""
					|| vsoc.getTextID().getText() == ""
					|| vsoc.getTextID().getText() == "")
				JOptionPane.showMessageDialog(null,
						"Debe rellenar todos los campos");

			else {

				String rif = vsoc.getRifCoop();
				String id = vsoc.getTextID().getText();
				
				if (term.VerificarCoop(rif) && !ValidarSocio(rif,id)) {

					coop = term.BuscarCoop(rif);
					String nombre = vsoc.getNombreS().getText();
					String apellido = vsoc.getTextApellidoS().getText();
					String cedula = vsoc.getCiS();
					int cargo = vsoc.getIndiceCombo();
					String telefono = vsoc.getTelefonoS().getText();
					
					soc = new Socio(nombre, apellido, telefono, cedula, cargo,
							id);
					coop.agregarSocio(soc);
					vsoc.mostrarMensaje("El Socio ha sido guardada con exito");
					vsoc.blanquearCampos();

				} else
					vsoc.mostrarMensaje("El Socio ya existe");
			}
		} catch (Exception e) {
			vsoc.mostrarMensaje("No se pudo guardar el Socio, verifique que los datos sean correctos");
			vsoc.blanquearCampos();
		}
	}

	// ///************* Boton Buscar Cooperativa ***************************///
	public void BuscarCooperativa(Terminal term) {
		coop = term.BuscarCoop(vsoc.getRifCoop());

		if (!term.getlCoop().contains(coop)) {

			vsoc.mostrarMensaje("La Cooperativa no existe");

		} else

			vsoc.getCoop().setText(coop.getNombre());
	}

	// /**************** Validar que el Socio exista ***********************///

	public boolean ValidarSocio(String rif,String id) {
		boolean v = false;
		coop = term.BuscarCoop(rif);

		if (coop.getlSocio() == null || coop.getlSocio().isEmpty())
			v = false;
		else
			for (int i = 0; i < coop.getlChofer().size(); i++) {
				if (id == coop.getlSocio().get(i)
						.getId_socio())
					
				v = true; // lo encontro
			}
		return v; // no lo encontro
	}

}
