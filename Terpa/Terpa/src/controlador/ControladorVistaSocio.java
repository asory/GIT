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
	private SocioDAO socDAO;
	private CooperativaDAO copDAO;

	// SINGLETON
	private static ControladorVistaSocio instancia;

	public static ControladorVistaSocio getInstancia() {
		if (instancia == null) {
			instancia = new ControladorVistaSocio();
		}
		return instancia;
	}

	public void iniciar() {
		vsoc.blanquearCampos();
		vsoc.setVisible(true);
	}

	public ControladorVistaSocio() {

		socDAO = new SocioDAO();
		vsoc = VistaSocio.getInstancia();
		vsoc.setVisible(true);
		vsoc.activarListener(this);

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
				ControladorVistaChofer cv = ControladorVistaChofer
						.getInstancia();
				;

			} else if (e.getSource().equals(vsoc.getBtnAgregarUnidad())) {
				ControladorVistaUnidad cv = ControladorVistaUnidad
						.getInstancia();

			} else if (e.getSource().equals(vsoc.getBtnBuscar())) {
				Buscar();
			} else if (e.getSource().equals(vsoc.getBtnEliminar())) {
				eliminar();
			} else if (e.getSource().equals(vsoc.getBtnModificar())) {
				modificar();
			} else if (e.getSource().equals(vsoc.getBtnSalir())) {
				vsoc.dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// ///************* Boton Guardar Socio ***************************///
	private void agregarSocio() {

		Socio soc = new Socio(vsoc.getNombreS(), vsoc.getApellidoS(),
				vsoc.getTelefonoS(), vsoc.getCiS(), vsoc.getIndiceCombo(),
				vsoc.getID());

		if (vsoc.getNombreS() == "" || vsoc.getCiS() == ""
				|| vsoc.getIndiceCombo() == 0 || vsoc.getTelefonoS() == ""
				|| vsoc.getID() == "" || vsoc.getApellidoS() == ""
				|| vsoc.getRifCoop() == "")
			JOptionPane.showMessageDialog(null,
					"Debe rellenar todos los campos");

		else {

			String rifdado = vsoc.getRifCoop();
			Cooperativa cop = copDAO.buscarCooperativa(rifdado);

			if (copDAO.consultarCooperativa(cop))
				;
			{

				if (!socDAO.consultarSocio(soc, rifdado)) {

					socDAO.registrarSocio(soc, rifdado);
					vsoc.mostrarMensaje("El Socio ha sido guardado con exito");
					vsoc.blanquearCampos();
				} else
					vsoc.mostrarMensaje("El Socio ya existe");
			}
			vsoc.mostrarMensaje("La Cooperativa no existe");

		}
	}

	public void eliminar() {

		Socio soc = new Socio(vsoc.getNombreS(), vsoc.getApellidoS(),
				vsoc.getTelefonoS(), vsoc.getCiS(), vsoc.getIndiceCombo(),
				vsoc.getID());

		String rifcoop = vsoc.getRifCoop();

		if (socDAO.consultarSocio(soc, rifcoop)) {

			socDAO.eliminarSocio(soc, rifcoop);
			vsoc.mostrarMensaje("El Socio ha sido eliminado");
			vsoc.blanquearCampos();
		} else
			vsoc.mostrarMensaje("El Socio no existe");
	}

	public void modificar() {

		Socio soc = new Socio(vsoc.getNombreS(), vsoc.getApellidoS(),
				vsoc.getTelefonoS(), vsoc.getCiS(), vsoc.getIndiceCombo(),
				vsoc.getID());

		String rifcoop = vsoc.getRifCoop();

		if (vsoc.getNombreS() == "" || vsoc.getCiS() == ""
				|| vsoc.getIndiceCombo() == 0 || vsoc.getTelefonoS() == ""
				|| vsoc.getID() == "" || vsoc.getApellidoS() == ""
				|| vsoc.getRifCoop() == "")
			JOptionPane.showMessageDialog(null,
					"Debe rellenar todos los campos");

		else {
			if (socDAO.consultarSocio(soc, rifcoop)) {

				socDAO.actualizarSocio(soc, rifcoop);
				vsoc.mostrarMensaje("El Socio ha sido actualizado");
				vsoc.blanquearCampos();
			} else
				vsoc.mostrarMensaje("El Socio no existe");
		}
	}

	private void Buscar() {

		Socio soc = socDAO.buscarSocio(vsoc.getID(), vsoc.getRifCoop());

		String nombre = soc.getNombre();
		String apellido = soc.getApellido();
		int cargo = soc.getCargo();
		String ced = soc.getCi();
		String telef = soc.getTelefono();

		vsoc.getTextNombreS().setText(nombre);
		vsoc.getTextApellidoS().setText(apellido);
		vsoc.getTextCiS().setText(ced);
		vsoc.getTextTelefonoS().setText(telef);
		vsoc.getcomboCargo().setSelectedIndex(cargo);

	}

}

/*
 * Integrantes: Rosa Piña C.I. 24.166.902 Edwin Lucena C.I. 21.256.626 Norielsy
 * Freitez C.I. 20.668.899 Ana Ruiz C.I. 21.296.217
 */

