package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.*;
import vista.*;

public class ControladorVistaSocio implements ActionListener {

private VistaSocio vsoc;
private Socio soc;
private Cooperativa coop;
private Terminal term;

public ControladorVistaSocio(Terminal terminal) {
	vsoc = new VistaSocio();
	vsoc.setVisible(true);
	vsoc.activarListener(this);
	term= terminal;
}

@Override
public void actionPerformed(ActionEvent e) {
	String actionCommand = e.getActionCommand();
	try{
		if(actionCommand.equals("Guardar"))
		agregarSocio();
		
		else if (e.getSource().equals(vsoc.getBtnGuardarS())){
			JOptionPane.showInternalConfirmDialog(vsoc,
					"Agregar Socio", null,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			vsoc.blanquearCampos();
		}
		
		else if (e.getSource().equals(vsoc.getBtnBuscarCoop())){
			BuscarCooperativa();
			}
		
		else if (e.getSource().equals(vsoc.getBtnSalir())){
			vsoc.blanquearCampos();
			vsoc.dispose();
			}
	}
	catch (Exception ex){
		ex.printStackTrace();
	}
		
}
/////************* Boton  Guardar Socio ***************************///
private void agregarSocio() {
//	try{
		      if (vsoc.getRifCoop() == "" 
				||vsoc.getNombreS().getText() == "" 
				||vsoc.getCiS() == "" 
				||vsoc.getCargoS().getText() == "" 
				||vsoc.getTelefonoS().getText() == "")
			JOptionPane.showMessageDialog(vsoc,"Debe rellenar todos los campos");
		      
		      else {
		    	 //   
		    	  
		    	  if (true == term.VerificarCoop(vsoc.getRifCoop())
		    			  && false == ValidarSocio()){
		    		  
		    		  String rifcoop = vsoc.getRifCoop();
		    		  coop = term.BuscarCoop(vsoc.getRifCoop());
		    		  String nombre = vsoc.getNombreS().getText();
		    		  String cedula = vsoc.getCiS();
		    		  String cargo = vsoc.getCargoS().getText();
		    		  String telefono = vsoc.getTelefonoS().getText();
		    		  //String id= vsoc.get
		    		//  Socio socio = new Socio(nombre,cedula,cargo,telefono);
		    		  coop.agregarSocio(soc);
		    		  vsoc.mostrarMensaje("El Socio ha sido guardada con exito");
		    		  vsoc.blanquearCampos();
		    	  
					} else
						vsoc.mostrarMensaje("El Socio ya existe");
		    	  }
		    //  }
	//catch (Exception e) {
	//	vsoc.mostrarMensaje("No se pudo guardar el Socio, verifique que los datos sean correctos");
	//	vsoc.blanquearCampos();
	//	}
}

/////************* Boton  Buscar Cooperativa ***************************///
public void BuscarCooperativa(){
	
	Cooperativa coop = new Cooperativa();
	coop = term.BuscarCoop(vsoc.getRifCoop());
	vsoc.getCoop().setText(coop.getNombre());
}

///**************** Validar que el Socio exista ***********************///

public boolean ValidarSocio(){
	boolean v = false;
	Cooperativa coop = new Cooperativa();//term.BuscarCoop(vsoc.getRifCoop());
	
	for(int i=0; i<coop.getlChofer().size(); i++)
		if(vsoc.getCiS() == coop.getlSocio().get(i).getCi());{
			v = true;    // lo encontro
		}
	return v; //no lo encontro
}
}
