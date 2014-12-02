package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import model.*;
import vista.VentanaCoop;
 
public class ControladorVentanaCoop implements ActionListener {
private VentanaCoop vcoop;
private Cooperativa coop;
private ArrayList<Ruta> lruta;
private ArrayList<Socio>lsoc;
private static ControladorVentanaCoop instancia;

  private ControladorVentanaCoop(){
  coop =new Cooperativa();
  lruta= new ArrayList<Ruta>();
  lsoc= new ArrayList<Socio>();
 
	}
public void iniciar()
{
	vcoop= vcoop.getInstancia();
	
public static ControladorVentanaCoop getInstancia(){
	if (instancia == null){
		instancia = new ControladorVentanaCoop();
	}
	return instancia;
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
