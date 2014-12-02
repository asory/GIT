package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import vista.VentanaViaje;

public class ControladorVentanaViaje implements ActionListener{

private VentanaViaje ventanaviaje;
public  ControladorVentanaViaje () {
	super();
	this.ventanaviaje = new VentanaViaje();
	this.ventanaviaje.setLocation(480, 210);
	this.ventanaviaje.setVisible(true);
	this.ventanaviaje.addComponentListener((ComponentListener) this);
	
}
@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
	
}
