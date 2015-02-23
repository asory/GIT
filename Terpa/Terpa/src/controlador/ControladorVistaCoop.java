package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import modelo.dao.*;
import vista.VistaCoop;

public class ControladorVistaCoop implements ActionListener {
	private VistaCoop vcoop;
	private Terminal ter;
	private CooperativaDAO copDAO;

	public ControladorVistaCoop(Terminal terminal) {

		vcoop = VistaCoop.getInstancia();
		vcoop.setVisible(true);
		vcoop.setLocationRelativeTo(null);
		vcoop.activarListener(this);
		this.ter = terminal;
	}

	// SINGLETON
	private static ControladorVistaCoop instancia;

	public static ControladorVistaCoop getInstancia(Terminal ter) {
		if (instancia == null) {
			instancia = new ControladorVistaCoop(ter);
		}
		return instancia;
	}

	public void iniciar() {
		vcoop.Limpiar();
		vcoop.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			if (e.getSource().equals(vcoop.getBtnAgregar()))
				agregarCoop();

			else if (e.getSource().equals(vcoop.getBtnAgregarSocio())) {
				ControladorVistaSocio.getInstancia(ter);
				vcoop.Limpiar();
			}

			else if (e.getSource().equals(vcoop.getBtnSalir())) {

				vcoop.Limpiar();

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public void agregarCoop() {

		if (vcoop.getTexNombreC().isEmpty() || vcoop.getTextRif().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			String rif = vcoop.getTextRif();
			String nombre = vcoop.getTexNombreC();
			Cooperativa coop = new Cooperativa(nombre, rif);
			if (copDAO.buscarCooperativa(rif) == null)
			// ter.VerificarCoop(rif) == false)
			{
				copDAO.registrarCooperativa(coop);
				vcoop.getBtnAgregarSocio().setVisible(true);
				JOptionPane.showMessageDialog(null, "Cooperativa Registrada ");
				vcoop.Limpiar();
			} else
				JOptionPane.showMessageDialog(null,
						"La Cooperativa ya esta registrada");

		}

	}

}
