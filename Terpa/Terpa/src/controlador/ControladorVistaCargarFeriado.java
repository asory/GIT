package controlador;

import modelo.Feriado;
import modeloDAO.FeriadoDAO;
import vista.VistaCargarFeriado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class ControladorVistaCargarFeriado implements ActionListener {

	private VistaCargarFeriado vistaCargarFeriado;

	private FeriadoDAO ferDAO;

	// SINGLETON
	private static ControladorVistaCargarFeriado instancia;

	public static ControladorVistaCargarFeriado getInstancia() {
		if (instancia == null) {
			instancia = new ControladorVistaCargarFeriado();
		}
		return instancia;
	}

	public ControladorVistaCargarFeriado() {

		ferDAO = new FeriadoDAO();
		vistaCargarFeriado = VistaCargarFeriado.getInstancia();
		vistaCargarFeriado.setLocation(480, 210);
		vistaCargarFeriado.setVisible(true);
		vistaCargarFeriado.activarListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		try {
			if (actionCommand.equals("Guardar")) {
				agregarFeriado();
			} else if (actionCommand.equals("Salir")) {
				vistaCargarFeriado.dispose();
			} else if (e.getSource()
					.equals(vistaCargarFeriado.getBtnEliminar())) {
				eliminar();
			} else if (e.getSource().equals(
					vistaCargarFeriado.getBtnModificar())) {
				modificar();
			} else if (e.getSource().equals(vistaCargarFeriado.getBtnBuscar())) {
				Buscar();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void agregarFeriado() {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(vistaCargarFeriado.getFecha());
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int mes = calendar.get(Calendar.MONTH);

		Feriado fer = new Feriado(dia, mes, vistaCargarFeriado.getDesc());

		if (vistaCargarFeriado.getFecha().equals(null)
				|| vistaCargarFeriado.getDesc().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {

			if (!ferDAO.consultarFeriado(fer)) {
				ferDAO.registrarFeriado(fer);

				JOptionPane.showMessageDialog(null, "Dia Feriado Registrado ");
				vistaCargarFeriado.blanquearCampos();
			} else
				JOptionPane.showMessageDialog(null, "El Dia Feriado ya existe");
		}

	}

	public void eliminar() {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(vistaCargarFeriado.getFecha());
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int mes = calendar.get(Calendar.MONTH);

		Feriado fer = new Feriado(dia, mes, vistaCargarFeriado.getDesc());

		if (ferDAO.consultarFeriado(fer)) {
			ferDAO.eliminarFeriado(fer);

			JOptionPane.showMessageDialog(null, "Dia Feriado Eliminado ");
			vistaCargarFeriado.blanquearCampos();
		} else
			JOptionPane.showMessageDialog(null, "El Dia Feriado no existe");
	}

	public void modificar() {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(vistaCargarFeriado.getFecha());
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int mes = calendar.get(Calendar.MONTH);

		Feriado fer = new Feriado(dia, mes, vistaCargarFeriado.getDesc());

		if (vistaCargarFeriado.getFecha().equals(null)
				|| vistaCargarFeriado.getDesc().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			if (ferDAO.consultarFeriado(fer)) {
				ferDAO.actualizarFeriado(fer);

				JOptionPane.showMessageDialog(null, "Dia Feriado Actualizado ");
				vistaCargarFeriado.blanquearCampos();
			} else
				JOptionPane.showMessageDialog(null, "El Dia Feriado no existe");
		}
	}

	private void Buscar() {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(vistaCargarFeriado.getFecha());
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int mes = calendar.get(Calendar.MONTH);

		Feriado fer = ferDAO.buscarFeriado(dia, mes);

		String descripcion = fer.getDescripcion();

		vistaCargarFeriado.getTextDesc().setText(descripcion);

	}

	public void iniciar() {
		vistaCargarFeriado.blanquearCampos();
		vistaCargarFeriado.setVisible(true);
	}
}

/*
 * Integrantes: Rosa Piña C.I. 24.166.902 Edwin Lucena C.I. 21.256.626 Norielsy
 * Freitez C.I. 20.668.899 Ana Ruiz C.I. 21.296.217
 */