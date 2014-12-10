package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.*;
import vista.*;

;

public class ControladorMenuP implements ActionListener {

	private VistaMenuP vistaMenuP;
	private Cooperativa coop;

	public ControladorMenuP() {
		this.coop = new Cooperativa();
		this.vistaMenuP = new VistaMenuP();
		this.vistaMenuP.setLocationRelativeTo(null);
		this.vistaMenuP.setVisible(true);
		this.vistaMenuP.leer();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionC = e.getActionCommand();
		if (actionC.equals("Salir")) {
			// System.exit(0);
		} else if (actionC.equals("COOPERATIVA")) {
			VistaCoop vcoop = new VistaCoop();
			vcoop.setVisible(true);
			vcoop.setLocationRelativeTo(vistaMenuP);

		}

		else if (actionC.equals("VIAJES"))
			;
		// new ControladorVistaViaje();
	}

	public void cargar() {
		Chofer cho = new Chofer();
		File f;
	//	javax.swing.JFileChooser j = new javax.swing.JFileChooser();
	//	j.showOpenDialog(j);
		String lectura = "";
		try {
			String path = System.getProperty("user.dir") + "/src/z.txt";// j.getSelectedFile().getAbsolutePath();

			f = new File(path);
			try {
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String aux;
				while ((aux = br.readLine()) != null)
					lectura = lectura + aux + "n";
				br.close();
			} catch (IOException e) {
			}

		} catch (NullPointerException e) {
			// javax.swing.JOptionPane.showMessageDialog(j,
			// "Has seleccionado cerrar programa, saliendo...");

		}

		// String asd= miVentana.leer();
		String[] atributos;
		atributos = lectura.split("|");
		int k = 0;
		// for (int k = 0; k < atributos.length; k++) {

		do {
			switch (atributos[k]) {

			case "01":
				cho.setNombre(atributos[k + 1]);
				cho.setApellido(atributos[k + 2]);
				cho.setCi(atributos[k + 3]);
				cho.setTelefono(atributos[k + 4]);
				cho.setId_Chofer(atributos[k + 5]);
				coop.agregarChofer(cho);
				cho = new Chofer();
				k = k + 6;
				break;// / k+5 es el ultimo dato , k+6 es n

			}
			k = k + 1;// este nos lleva al siguiente dato
			if (k > atributos.length)// al finalizar el k+1 va a exceder el
										// tamaño por eso verificamos y
				k = k - 1; // reducimos

		} while (k < atributos.length);
	};
}
