package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import modelo.*;
import vista.*;
 
public class ControladorVistaCoop implements ActionListener 
{
private VistaCoop vcoop;
private Cooperativa coop;
private ArrayList<Ruta> lruta;
private ArrayList<Socio>lsoc;
private static ControladorVistaCoop instancia;

  ControladorVistaCoop(){
  coop =new Cooperativa();
  lruta= new ArrayList<Ruta>();
  lsoc= new ArrayList<Socio>();
 
	}
public void iniciar(){}

	//vcoop= vcoop.g;

public static ControladorVistaCoop getInstancia(){
	if (instancia == null){
		instancia = new ControladorVistaCoop();
	}
	return instancia;
}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
