package controlador;

import modelo.Feriado;
import modelo.Terminal;
import vista.VistaCargarFeriado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ControladorVistaCargarFeriado implements ActionListener {
	
	private VistaCargarFeriado vistaCargarFeriado;
	private Terminal terminal;
	
	//SINGLETON
	private static ControladorVistaCargarFeriado instancia;
	
	
	public static  ControladorVistaCargarFeriado getInstancia(Terminal terminal){
			if (instancia == null){
				instancia = new ControladorVistaCargarFeriado(terminal) ;
			}
			return instancia;
		}
		
		
	public ControladorVistaCargarFeriado(Terminal terminal) {
		
		vistaCargarFeriado= VistaCargarFeriado.getInstancia();
		vistaCargarFeriado.setLocation(480,210);
		vistaCargarFeriado.setVisible(true);
		vistaCargarFeriado.activarListener(this);
		this.terminal = terminal;
		
	}
	
	public void iniciar(){
		vistaCargarFeriado.blanquearCampos();
		vistaCargarFeriado.setVisible(true);
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		try {
			if (actionCommand.equals("Guardar")) {
				agregarFeriado(terminal);
			} else if (actionCommand.equals("Salir")) {
				vistaCargarFeriado.dispose();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void agregarFeriado(Terminal terminal) {
		try
		{
			if(vistaCargarFeriado.getFecha().equals(null) || 
					vistaCargarFeriado.getDesc().equals(""))
			    		
			    	//Deben estar todos los campos llenos para poder incluir el dia feriado
				vistaCargarFeriado.mostrarMensaje("Debe llenar todos los datos para guardar un nuevo día feriado");
			    	else
			    	{
			    		Calendar calendar = Calendar.getInstance();
			    		calendar.setTime(vistaCargarFeriado.getFecha());
			    		int dia = calendar.get(Calendar.DAY_OF_MONTH);
			    		int mes = calendar.get(Calendar.MONTH);
			    		String desc = vistaCargarFeriado.getDesc();
	
			    		Feriado feriado = new Feriado(dia,mes,desc);
			    		
			    		if (!terminal.getlFeriado().contains(feriado)) {
			    			terminal.agregarFeriado(feriado);
			    	
			    		vistaCargarFeriado.mostrarMensaje("El día feriado ha sido guardado con éxito");
			    		vistaCargarFeriado.blanquearCampos();
			    		}else 
			    			vistaCargarFeriado.mostrarMensaje("El día feriado ya existe");
			    	}
		}catch(Exception e)
		{
			vistaCargarFeriado.mostrarMensaje("No se pudo guardar el día feriado, verifique que los datos sean correctos");
			vistaCargarFeriado.blanquearCampos();
		}
			 
		
	}
	


}
