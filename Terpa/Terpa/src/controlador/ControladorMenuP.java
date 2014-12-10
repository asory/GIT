package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Chofer;
import model.Cooperativa;
import model.Feriado;
import model.Ruta;
import model.Socio;
import model.Terminal;
import model.Unidad;
import model.Viaje;
import modelo.*;
import vista.*;

;

public class ControladorMenuP implements ActionListener {

	private VistaMenuP vistaMenuP;
	private Socio soc;
	private Unidad uni;
	private Ruta rut;
	private Cooperativa coop;
	private Feriado fer;
	private Terminal ter;
	private Viaje via;

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
		} 
		else if (actionC.equals("COOPERATIVA")) {
			VistaCoop vcoop = new VistaCoop();
			vcoop.setVisible(true);
			vcoop.setLocationRelativeTo(vistaMenuP);
		}
		else if (actionC.equals("VIAJES"))
			;
		// new ControladorVistaViaje();
	}
////////////////CARGAR //////////////////////
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
	//	javax.swing.JFileChooser j = new javax.swing.JFileChooser();
	//	j.showOpenDialog(j);
		String lectura = "";
		javax.swing.JFileChooser j = new javax.swing.JFileChooser();
		j.showOpenDialog(j);
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

			case "1": // chofer
				cho.setNombre(atributos[k + 1]);
				cho.setApellido(atributos[k + 2]);
				cho.setCi(atributos[k + 3]);
				cho.setTelefono(atributos[k + 4]);
				cho.setId_Chofer(atributos[k + 5]);  /////////////??
				coop.agregarChofer(cho);
				cho = new Chofer();
				k = k + 6;
				break;
				
			case "2": // socio
				soc.setNombre(atributos[k + 1]);
				soc.setCi(atributos[k + 2]);
				soc.setCargo(atributos[k + 3]);
				soc.setTelefono(atributos[k + 4]);
				soc.setId_socio(atributos[k + 5]); ////////?? 
				coop.agregarSocio(soc);
				soc = new Socio();
				k = k + 6;
				break;
				
			case "3": // unidad
				uni.setId_Unida(atributos[k + 1]);
				uni.setId_Socio(atributos[k + 2]); ////Agregar .setSocio a Unidad
				uni.setTipo(atributos[k + 3]);
				uni.setPlaca(atributos[k + 4]);
				soc.agregarUnidad(uni);
				uni = new Unidad();
				k = k + 5;
				break;
				
			case"4": //ruta
				rut.setCodigo(atributos[k + 1]);
				rut.setDescripcion(atributos[k + 2]);
				rut.setTipo(atributos[k + 3]);
				coop.agregarRuta(rut);
				rut = new Ruta();
				k = k + 4;
				break;
				
			case "5": //cooperativa
				coop.setNombre(atributos[k+ 1]);
				coop.setRif(atributos[k +2]);
				ter.agregarCooperativa(coop);
				coop = new Cooperativa();
				k = k + 3;
				break;
				
			case "6": //feriado
				fer.setDia(atributos[k + 1]);
				fer.setMes(atributos[k+2]);
				fer.setDescripcion(atributos[k + 3]);
				via.agregarFeriado(fer);
				fer = new Feriado();
				k = k + 4;
				break;// / k+5 es el ultimo dato , k+6 es n

			}
			k = k + 1;// este nos lleva al siguiente dato
			if (k > atributos.length)// al finalizar el k+1 va a exceder el
										// tamaño por eso verificamos y
				k = k - 1; // reducimos

		} while (k < atributos.length);
		
	}
}
