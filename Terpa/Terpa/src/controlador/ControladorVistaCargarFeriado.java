package controlador;

import modelo.Feriado;
import modelo.Terminal;
import modeloDAO.FeriadoDAO;
import vista.VistaCargarFeriado;
import vista.VistaCargarRuta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class ControladorVistaCargarFeriado implements ActionListener {
	
	private VistaCargarFeriado vistaCargarFeriado;
	private Terminal terminal;
	private FeriadoDAO ferDAO;
	

	public ControladorVistaCargarFeriado(Terminal terminal) {
		
		ferDAO = new FeriadoDAO();
		vistaCargarFeriado= new VistaCargarFeriado();
		vistaCargarFeriado.setLocation(480,210);
		vistaCargarFeriado.setVisible(true);
		vistaCargarFeriado.activarListener(this);
		this.terminal = terminal;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		try {
			if (actionCommand.equals("Guardar")) {
				agregarFeriado();
			} else if (actionCommand.equals("Salir")) {
				vistaCargarFeriado.dispose();
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
		
		
		
		if(vistaCargarFeriado.getFecha().equals(null) || 
				vistaCargarFeriado.getDesc().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			
			//if (!ferDAO.consultarFeriado(fer)) {
				ferDAO.registrarFeriado(fer);
				
				JOptionPane.showMessageDialog(null, "Dia Feriado Registrado ");
				vistaCargarFeriado.blanquearCampos();
			//} else
				JOptionPane.showMessageDialog(null,
						"El Dia Feriado ya existe");
		}

	}
	

}





/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */