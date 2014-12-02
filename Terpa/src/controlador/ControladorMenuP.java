package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import vista.VentanaMenuP;

public class ControladorMenuP implements ActionListener {

	private VentanaMenuP ventanaMenuP;
	
	public ControladorMenuP() {
		super();
		this.ventanaMenuP = new VentanaMenuP();
		this.ventanaMenuP.setLocationRelativeTo(null);
		this.ventanaMenuP.setVisible(true);	
		this.ventanaMenuP.addComponentListener(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Salir")) {
			System.exit(0);
		}		
		else if (actionCommand.equals("Cargar")) {
			new ControladorVentanaViaje();
		}
		
	}

}
