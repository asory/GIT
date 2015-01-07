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
	private Terminal ter;
	private Cooperativa coop;

	public ControladorMenuP() {

		vistaMenuP = new VistaMenuP();
		vistaMenuP.setLocationRelativeTo(null);
		vistaMenuP.setVisible(true);
		vistaMenuP.activarListener(this);
		ter = new Terminal();
		cargar(ter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionC = e.getActionCommand();

		try {

			if (actionC.equals("COOPERATIVA")) {
				new ControladorVistaCoop(ter);
			}

			else if (e.getSource().equals(vistaMenuP.getMpRuta())) {
				new ControladorVistaCargarRuta(ter);

			} else if (e.getSource().equals(vistaMenuP.getMpSocio())) {
				new ControladorVistaSocio(ter);

			}

			else if (e.getSource().equals(vistaMenuP.getMpUnidad())) {
				new ControladorVistaUnidad(ter);
			}

			else if (e.getSource().equals(vistaMenuP.getMpChofer())) {
				new ControladorVistaChofer(ter);
			}

			else if (e.getSource().equals(vistaMenuP.getMpCalendario())) {
				new ControladorVistaCalendario(ter);
			}
			else if (e.getSource().equals(vistaMenuP.getMpFeriado())) {
				new ControladorVistaCargarFeriado(ter);
			}

			else if (e.getSource().equals(vistaMenuP.getMpViajes())) {
				new ControladorReporte(ter);

			} else if (e.getSource().equals(vistaMenuP.getBtnAsignar())) {
				new ControladorVistaViaje(ter);

			} else if (actionC.equals("SALIR")) {
				System.exit(0);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	// **********************/////////////LEER TXT //
	// ////////////////////***************//
	public String leer() {
		File f;

		/*
		 * //*********************En caso de querer seleccionar el archivo
		 * /////////////// { // javax.swing.JFileChooser j = new
		 * javax.swing.JFileChooser(); // j.showOpenDialog(j);}
		 */

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

		}

		return lectura;
	}

	// ********/// //////CARGAR///////////////***************//
	public void cargar(Terminal ter) {

		String lectura = leer();
		String[] atributos;
		atributos = lectura.split("-");
		int k = 0;

		do {
			switch (atributos[k]) { // ///*********** NECESITA JAVA 1.7+
									// **********/////////

			case "1": // cooperativa
				Cooperativa coop = new Cooperativa();
				coop.setNombre(atributos[k + 1]);
				coop.setRif(atributos[k + 2]);
				ter.agregarCooperativa(coop);
				k = k + 3;
				break;

			case "2": // ruta
				Ruta rut = new Ruta();
				rut.setCodigo(atributos[k + 1]);
				rut.setDestino(atributos[k + 2]);
				rut.setTipo(Integer.parseInt(atributos[k + 3]));
				coop = ter.BuscarCoop(atributos[k + 4]);
				coop.agregarRuta(rut);
				if (!ter.getlRutat().equals(rut))
					ter.agregarRuta(rut);
				k = k + 5;
				break;

			case "3": // socio
				Socio soc = new Socio();
				soc.setNombre(atributos[k + 1]);
				soc.setCi(atributos[k + 2]);
				soc.setCargo(Integer.parseInt(atributos[k + 3]));
				soc.setTelefono(atributos[k + 4]);
				soc.setId_socio(atributos[k + 5]); // //////??
				coop = ter.BuscarCoop(atributos[k + 6]);
				coop.agregarSocio(soc);
				k = k + 7;
				break;

			case "4": // chofer
				Chofer cho = new Chofer();
				cho.setNombre(atributos[k + 1]);
				cho.setApellido(atributos[k + 2]);
				cho.setTelefono(atributos[k + 4]);
				cho.setCi(atributos[k + 3]);
				cho.setId_chofer(atributos[k + 5]);
				cho.setId_Jefe(atributos[k + 6]);
				cho.setStatus("0");
				coop = ter.BuscarCoop(atributos[k + 7]);
				coop.agregarChofer(cho);
				k = k + 8;
				break;

			case "5": // unidad
				Unidad uni = new Unidad();
				uni.setId(Integer.parseInt(atributos[k + 1]));
				uni.setId_socio(atributos[k + 2]);
				uni.setTipo(Integer.parseInt(atributos[k + 3]));
				uni.setPlaca(atributos[k + 4]);
				uni.setStatus("0");
				coop = ter.BuscarCoop(atributos[k + 5]);
				soc = coop.BuscarSocio(atributos[k + 2]);
				soc.agregarUnidad(uni);
				k = k + 5;
				break;

			case "6": // feriado
				Feriado fer = new Feriado();
				fer.setDia(Integer.parseInt(atributos[k + 1]));
				fer.setMes(Integer.parseInt(atributos[k + 2]));
				fer.setDescripcion(atributos[k + 3]);
				ter.agregarFeriado(fer);
				k = k + 4;
				break;// / k+3 es el ultimo dato , k+4 es n

			}
			k = k + 1;// este nos lleva al siguiente dato

		} while (k < atributos.length);

	}

}
