package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import vista.*;
import modelo.*;

;

public class ControladorMenuP implements ActionListener {

	private VistaMenuP vistaMenuP;

	public ControladorMenuP() {

		vistaMenuP = VistaMenuP.getInstancia();
		vistaMenuP.setLocationRelativeTo(null);
		vistaMenuP.setVisible(true);
		vistaMenuP.activarListener(this);

	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionC = e.getActionCommand();

		try {

			if (actionC.equals("COOPERATIVA")) {
				ControladorVistaCoop cvc = ControladorVistaCoop.getInstancia();
				cvc.iniciar();
			}

			else if (e.getSource().equals(vistaMenuP.getMpRuta())) {
				ControladorVistaCargarRuta cvr = ControladorVistaCargarRuta
						.getInstancia();
				cvr.iniciar();
			} else if (e.getSource().equals(vistaMenuP.getMpSocio())) {
				ControladorVistaSocio cv = ControladorVistaSocio.getInstancia();
				cv.iniciar();
			}

			else if (e.getSource().equals(vistaMenuP.getMpUnidad())) {
				ControladorVistaUnidad cv = ControladorVistaUnidad
						.getInstancia();
				cv.iniciar();
			}

			else if (e.getSource().equals(vistaMenuP.getMpChofer())) {
				ControladorVistaChofer cv = ControladorVistaChofer
						.getInstancia();
				cv.iniciar();
			}

			else if (e.getSource().equals(vistaMenuP.getMpCalendario())) {
				ControladorVistaCalendario cv = ControladorVistaCalendario
						.getInstancia();
				cv.iniciar();
			} else if (e.getSource().equals(vistaMenuP.getMpFeriado())) {
				ControladorVistaCargarFeriado cv = ControladorVistaCargarFeriado
						.getInstancia();
				cv.iniciar();
			}

			else if (e.getSource().equals(vistaMenuP.getMpViajes())) {
				ControladorReporte cv = ControladorReporte.getInstancia();
				cv.iniciar();

			} else if (e.getSource().equals(vistaMenuP.getBtnAsignar())) {
				ControladorVistaViaje cv = ControladorVistaViaje.getInstancia();
				cv.iniciar();

			} else if (actionC.equals("SALIR")) {
				System.exit(0);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

/*
 * Integrantes: Rosa Piña C.I. 24.166.902 Edwin Lucena C.I. 21.256.626 Norielsy
 * Freitez C.I. 20.668.899 Ana Ruiz C.I. 21.296.217
 */

