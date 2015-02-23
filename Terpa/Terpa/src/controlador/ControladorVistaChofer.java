package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorVistaChofer implements ActionListener {

	private VistaChofer vcho;
	private Cooperativa coop;
	private Terminal term;

	public ControladorVistaChofer(Terminal ter) {
		vcho = VistaChofer.getInstancia();
		vcho.setVisible(true);
		vcho.activarListener(this);
		term = ter;
	}
	//SINGLETON
	private static  ControladorVistaChofer instancia;
	
	
	public static  ControladorVistaChofer getInstancia(Terminal term){
			if (instancia == null){
				instancia = new ControladorVistaChofer (term) ;
			}
			
			return instancia;
		}
	public void iniciar(){
		vcho.blanquearCampos();;
		vcho.setVisible(true);
	}
		
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		try {
			if (actionCommand.equals("Guardar"))
				agregarChofer();


			else if (e.getSource().equals(vcho.getBtnBuscarCoop())) {
				BuscarCooperativa(term);
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
		try {
			if (vcho.getRifCoop() == "" || vcho.getNombreC().getText() == ""
					|| vcho.getCiC() == ""
					|| vcho.getApellidoC().getText() == ""
					|| vcho.getTelefonoC().getText() == ""
					|| vcho.getSocioC() == "" || vcho.getIdC() == "")
				JOptionPane.showMessageDialog(vcho,
						"Debe rellenar todos los campos");

			else {
				coop = term.BuscarCoop(vcho.getRifCoop());
				if (!term.VerificarCoop(vcho.getRifCoop()))
					vcho.mostrarMensaje("Cooperativa no existe");

				String nombrec = vcho.getNombreC().getText();
				String apellidoc = vcho.getApellidoC().getText();
				String cedulac = vcho.getCiC();
				String telefonoc = vcho.getTelefonoC().getText();
				String socioc = vcho.getSocioC();
				String idc = vcho.getIdC();

				Chofer cho = new Chofer(nombrec, apellidoc, telefonoc, cedulac,
						idc, false, socioc);

				if (!ValidarChofer() && !ValidarSocio()) {
					coop.agregarChofer(cho);
					vcho.mostrarMensaje("El Chofer ha sido guardada con exito");
				} else
					vcho.mostrarMensaje("El chofer ya existe");

				vcho.blanquearCampos();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ///************* Boton Buscar Cooperativa
	// ******************************///
	public void BuscarCooperativa(Terminal term) {
		coop = term.BuscarCoop(vcho.getRifCoop());

		if (!term.getlCoop().contains(coop)) {

			vcho.mostrarMensaje("La Cooperativa no existe");

		} else

			vcho.getCoop().setText(coop.getNombre());
	}

	// /**************** Validar que el Chofer no exista
	// ***********************///
	public boolean ValidarChofer() {
		boolean v = false;
		Cooperativa coop = new Cooperativa();

		if (coop.getlChofer() == null || coop.getlChofer().isEmpty())
			v = false;
		else
			for (int i = 0; i < coop.getlChofer().size(); i++) {
				if (vcho.getIdC() == coop.getlChofer().get(i).getId_chofer())
					;
				v = true; // lo encontro
			}
		return v; // no lo encontro
	}

	// /**************** Validar que el Socio exista
	// ***************************///
	public boolean ValidarSocio() {
		boolean v = false;
		Cooperativa coop = new Cooperativa();

		if (coop.getlChofer() == null || coop.getlChofer().isEmpty())
			v = false;
		else
			for (int i = 0; i < coop.getlChofer().size(); i++) {
				if (vcho.getSocioC() == coop.getlSocio().get(i).getId_socio())
					;
				v = true; // lo encontro
			}
		return v; // no lo encontro
	}

}
