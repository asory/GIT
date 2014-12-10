package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.Date;

import vista.VistaViaje;
import modelo.*;

public class ControladorVistaViaje implements ActionListener {

	private VistaViaje vviaje;
	private Chofer ch;
	private Unidad uni;
	private Cooperativa coop;

	public ControladorVistaViaje() {
		super();
		this.vviaje = new VistaViaje();
		this.vviaje.setLocation(480, 210);
		this.vviaje.setVisible(true);
		this.vviaje.addComponentListener((ComponentListener) this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public void CargarViajes() {
		String Rif = vviaje.getRif();
		int Fila;
		Viaje viaje = new Viaje();

		for (Fila = 0; Fila < coop.getlViaje().size(); Fila++)

		{
			paciente = coop.getlChofer().get(Fila);

			ConsultaPaciente.getjTablePacientes().setValueAt(
					paciente.getCedula(), Fila, 0);
			ConsultaPaciente.getjTablePacientes().setValueAt(
					paciente.getNombre(), Fila, 1);
		}

	}
//*****************Verificar **********************
	public boolean VerificarUnidad(Unidad uni) {
		for (int i = 0; i < coop.getlViaje().size(); i++) {
			Viaje viaje = coop.getlViaje().get(i);
			Date fechai = vviaje.getFechaI();

			if ((viaje.getVehiculo().equals(uni))
					&& (viaje.getFecha_retorno().after(fechai))) {
				if (uni.getstatus() == "2")
					return false;

			}
			
		}
		return true;
	}


public boolean VerificarChofer(Chofer cho)  {
	for (int i = 0; i < coop.getlViaje().size(); i++) {
		Viaje viaje = coop.getlViaje().get(i);
		Date fechai = vviaje.getFechaI();

		if ((viaje.getChofer().equals(cho))
				&& (viaje.getFecha_retorno().after(fechai))) {
			if (cho.getStatus() == "2")
				return false;

		}
		
	}
	return true;
}
}
