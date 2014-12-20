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
		this.vistaMenuP = new VistaMenuP();
		this.vistaMenuP.setLocationRelativeTo(vistaMenuP);
		this.vistaMenuP.setVisible(true);
		// cargar();

		this.vistaMenuP.agregarListener(null);;
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionC = e.getActionCommand();

		try {

			if (e.getSource().equals(vistaMenuP.getMpCoop())) {
				new ControladorVistaViaje();

			}
			if (actionC.equals("Salir")) {
				System.exit(0);
				/*
				 * } else if (actionC.equals("COOPERATIVA")) { new
				 * ControladorVistaCoop(); VistaCoop vcoop2 = new VistaCoop();
				 * vcoop2.setVisible(true); System.out.println("Cooperativa");
				 * 
				 * // cvcoop.iniciar();
				 */
			} else if (actionC.equals("VIAJES")) {

				new ControladorVistaViaje();

			}

			if (actionC.equals("REPORTE")) {
				VistaReporte frame = new VistaReporte();
				frame.setVisible(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// //////////////CARGAR //////////////////////
	public void cargar() {
		Chofer cho = new Chofer();
		Socio soc = new Socio();
		Ruta rut = new Ruta();
		Unidad uni = new Unidad();
		Cooperativa coop = new Cooperativa();
		Feriado fer = new Feriado();
		Terminal ter = new Terminal();
		Viaje via = new Viaje();
		File f;
		// javax.swing.JFileChooser j = new javax.swing.JFileChooser();
		// j.showOpenDialog(j);
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

		String[] atributos;
		atributos = lectura.split("|");
		int k = 0;

		do {
			switch (atributos[k]) {

			case "1": // chofer
				cho.setNombre(atributos[k + 1]);
				cho.setApellido(atributos[k + 2]);
				cho.setCi(atributos[k + 3]);
				cho.setTelefono(atributos[k + 4]);
				cho.setId_Jefe(atributos[k + 5]); // ///jefe////////??
				coop.agregarChofer(cho);
				cho = new Chofer();
				k = k + 6;
				break;

			case "2": // socio
				soc.setNombre(atributos[k + 1]);
				soc.setCi(atributos[k + 2]);
				soc.setCargo(Integer.parseInt(atributos[k + 3]));
				soc.setTelefono(atributos[k + 4]);
				soc.setId_socio(atributos[k + 5]); // //////??
				coop.agregarSocio(soc);
				soc = new Socio();
				k = k + 6;
				break;

			case "3": // unidad
				uni.setId(Integer.parseInt(atributos[k + 1]));
				uni.setId_socio(atributos[k + 2]);
				uni.setTipo(Integer.parseInt(atributos[k + 3]));
				uni.setPlaca(atributos[k + 4]);
				soc.agregarUnidad(uni);
				uni = new Unidad();
				k = k + 5;
				break;

			case "4": // ruta
				rut.setCodigo(atributos[k + 1]);
				rut.setDestino(atributos[k + 2]);
				rut.setTipo(Integer.parseInt(atributos[k + 3]));
				coop.agregarRuta(rut);
				if (!ter.getlRutat().equals(rut))
					ter.agregarRuta(rut);
				rut = new Ruta();
				k = k + 4;
				break;

			case "5": // cooperativa
				coop.setNombre(atributos[k + 1]);
				coop.setRif(atributos[k + 2]);
				ter.agregarCooperativa(coop);
				coop = new Cooperativa();
				k = k + 3;
				break;

			case "6": // feriado
				fer.setDia(Integer.parseInt(atributos[k + 1]));
				fer.setMes(Integer.parseInt(atributos[k + 2]));
				fer.setDescripcion(atributos[k + 3]);
				via.agregarFeriado(fer);
				fer = new Feriado();
				k = k + 4;
				break;// / k+5 es el ultimo dato , k+6 es n

			}
			k = k + 1;// este nos lleva al siguiente dato
			/*
			 * if (k > atributos.length)// al finalizar el k+1 va a exceder el
			 * // tamaño por eso verificamos y k = k - 1; // reducimos
			 */

		} while (k < atributos.length);

	}

}
