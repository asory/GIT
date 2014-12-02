package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import vista.VentanaMenuP;

public class ControladorMenuP implements ActionListener {

	private VentanaMenuP ventanaMenuP;
	
	public ControladorMenuP() {
		super();
		this.ventanaMenuP = new VentanaMenuP();
		this.ventanaMenuP.setLocationRelativeTo(null);
		this.ventanaMenuP.setVisible(true);	
		this.ventanaMenuP.addListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionC = e.getActionCommand();
		if (actionC.equals("Salir")) {
			System.exit(0);
		}		
		else if (actionC.equals("COOPERATIVA")) 
		{		new ControladorVentanaCoop();}
		else if (actionC.equals("VIAJES"))
			new ControladorVentanaViaje();
			}
		
	}


