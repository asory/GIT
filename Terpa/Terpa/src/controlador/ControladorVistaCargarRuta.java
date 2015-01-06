package controlador;

import modelo.Ruta;
import modelo.Terminal;
import modelo.Cooperativa;
import vista.VistaCargarRuta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVistaCargarRuta implements ActionListener {

	private VistaCargarRuta vistaCargarRuta;
	private Terminal terminal;

	public ControladorVistaCargarRuta(Terminal terminal) {
		
		vistaCargarRuta = new VistaCargarRuta();
		vistaCargarRuta.setLocation(480, 210);
		vistaCargarRuta.setVisible(true);
		vistaCargarRuta.activarListener(this);
		this.terminal = terminal;

	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource().equals(vistaCargarRuta.getBtnGuardar())) {
			agregarRuta(terminal);
		} else if (e.getSource().equals(vistaCargarRuta.getBtnSalir())) {
			vistaCargarRuta.dispose();

		} else if (e.getSource().equals(vistaCargarRuta.getBtnBuscar())){
			BuscarCoop(terminal );	
		}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private void agregarRuta(Terminal terminal) {
		try {
			if (vistaCargarRuta.getRIF().equals("")
					|| vistaCargarRuta.getNombreCoop().equals("")
					|| vistaCargarRuta.getCod().equals("")
					|| vistaCargarRuta.getDesc().equals("")
					|| vistaCargarRuta.getIndiceCombo()==0){

				// Deben estar todos los campos llenos para poder incluir la
				// ruta
				vistaCargarRuta.mostrarMensaje("Debe llenar todos los datos para guardar una nueva ruta");			}
			else {
				
				String cod=vistaCargarRuta.getCod();
				String des=vistaCargarRuta.getDesc();
				int tipo= vistaCargarRuta.getIndiceCombo();
				Ruta ruta = new Ruta(cod,des,tipo);
				
				if (!terminal.getlRutat().contains(ruta)) {
					terminal.agregarRuta(ruta);
					Cooperativa	coop = terminal.BuscarCoop(vistaCargarRuta.getRIF());
					if (!coop.getlRuta().contains(ruta)) {
						coop.agregarRuta(ruta);

						vistaCargarRuta.mostrarMensaje("La Ruta ha sido guardada con éxito");
						vistaCargarRuta.blanquearCampos();
					} else
						vistaCargarRuta.mostrarMensaje("La Ruta ya existe");
				} else
					vistaCargarRuta.mostrarMensaje("La Ruta ya existe");
			}
		} catch (Exception e) {
			vistaCargarRuta.mostrarMensaje("No se pudo guardar la ruta, verifique que los datos sean correctos");
			vistaCargarRuta.blanquearCampos();
		}
	}
	
	public void BuscarCoop(Terminal terminal ){
		
		Cooperativa coop = new Cooperativa();
		
		coop = terminal.BuscarCoop(vistaCargarRuta.getRIF());
		
		if (!terminal.getlCoop().contains(coop)){
			
			vistaCargarRuta.mostrarMensaje("La Cooperativa no existe");
		
		} else
		
			vistaCargarRuta.getTextNombreCoop().setText(coop.getNombre());
        
	}
}

