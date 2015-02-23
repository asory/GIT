package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.*;
import modelo.*;

public class ControladorVistaUnidad implements ActionListener {

	private VistaUnidad vuni;
	private Socio soc;
	private Terminal ter;
	private Cooperativa coop;

	public ControladorVistaUnidad(Terminal terminal) {

		vuni = VistaUnidad.getInstancia();
		vuni.setVisible(true);
		vuni.setLocationRelativeTo(null);
		vuni.activarListener(this);
		ter = terminal;
	}
	//SINGLETON
	private static ControladorVistaUnidad instancia;
	
	
	public static  ControladorVistaUnidad getInstancia(Terminal ter){
			if (instancia == null){
				instancia = new ControladorVistaUnidad(ter) ;
			}
			return instancia;
		}
	public void iniciar(){
		vuni.Limpiar();
		vuni.setVisible(true);
	}
		
		
	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			vuni.getTextCapacidad().setText((capacidad()));

			if (e.getSource().equals(vuni.getbtnAgregar()))
				agregarUni();

			else if (e.getSource().equals(vuni.getbtnBuscar())) {
				BuscarCooperativa(ter);
			}

			else if (e.getSource().equals(vuni.getbtnSalir())) {
				vuni.Limpiar();
				vuni.dispose();

			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	// ///////////////////// AGREGAR UNIDAD /////////////////////////

	public void agregarUni() {
		try {
			if (vuni.getTextRif().isEmpty()
					|| vuni.getTextNombre().equals("")// .isEmpty()
					|| vuni.getTextNumero() == "0 " // ////////error eno
													// reconoce
													// el tipo de dato int
					|| vuni.getTextSocio().equals("")
					|| vuni.getTextPlaca().equals("")
					|| vuni.getIndiceComboTipo() == 0)

				JOptionPane
						.showMessageDialog(null,
								"Debe llenar todos los campos para guardar una nueva unidad");

			else {

				Cooperativa coop = ter.BuscarCoop(vuni.getTextRif());

				if (!ter.VerificarCoop(vuni.getTextRif()))
					vuni.mostrarMensaje("Cooperativa no existe");

				int numeroid = Integer.parseInt(vuni.getTextNumero());
				String id_socio = vuni.getTextSocio();
				int tipo = vuni.getIndiceComboTipo();
				String placa = vuni.getTextPlaca();

				Unidad uni = new Unidad(placa, tipo, false, id_socio, numeroid);
				if (ValidarSocio(coop) && !ValidarNumero(numeroid, coop)) {
					soc.agregarUnidad(uni);
					vuni.mostrarMensaje("La Unidad ha sido guardada con exito");
				} else
					vuni.mostrarMensaje("La Unidad ya existe");
				vuni.Limpiar();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ///////////////////////////BUSCAR COOPERATIVA
	// ///////////////////////////////////////////
	public void BuscarCooperativa(Terminal term) {

		coop = ter.BuscarCoop(vuni.getTextRif());

		if (!ter.getlCoop().contains(coop)) {

			vuni.mostrarMensaje("La Cooperativa no existe");

		} else

			vuni.getTextNombre().setText(coop.getNombre());
	}

	// //////////// VALIDAR NUMERO//////////////////////////////////////
	public boolean ValidarNumero(int idu, Cooperativa coop) {
		boolean v = false;

		soc = coop.BuscarSocio(vuni.getTextSocio());

		if (soc.getlUnidad() == null || soc.getlUnidad().isEmpty())
			v = false;
		else
			for (int i = 0; i < soc.getlUnidad().size(); i++) {

				if (idu == soc.getlUnidad().get(i).getId())

					v = true; // lo encontro
			}
		return v; // no lo encontro
	}

	// //////////VALIDAR SOCIO////////////////
	public boolean ValidarSocio(Cooperativa coop) {
		boolean v = false;

		if (coop.getlSocio() == null || coop.getlSocio().isEmpty())
			v = false;
		else
			for (int i = 0; i < coop.getlSocio().size(); i++) {
				if (vuni.getTextSocio() == coop.getlSocio().get(i)
						.getId_socio())
					;
				v = true; // lo encontro
			}
		return v; // no lo encontro
	}

	// ///////////////////////////SET TIPO-CAPACIDAD//////////
	public String capacidad() {
		int capacidad = 0;
		int tipo = vuni.getIndiceComboTipo();

		switch (tipo) {
		case 1:
			capacidad = 5;
			break;
		case 2:
			capacidad = 7;
			break;
		case 3:
			capacidad = 10;
			break;
		case 4:
			capacidad = 25;
			break;
		case 5:
			capacidad = 32;
			break;
		case 6:
			capacidad = 60;
			break;
		case 7:
			capacidad = 80;
			break;
		}
		
		return Integer.toString(capacidad);

	}

}