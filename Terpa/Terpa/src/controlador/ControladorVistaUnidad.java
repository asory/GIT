package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.*;
import modelo.*;
import modeloDAO.CooperativaDAO;
import modeloDAO.SocioDAO;
import modeloDAO.UnidadDAO;

public class ControladorVistaUnidad implements ActionListener {

	private VistaUnidad vuni;
	private Socio soc;
	private Terminal ter;
	private Cooperativa coop;
	private UnidadDAO uniDAO;
	private CooperativaDAO copDAO;
	private SocioDAO socDAO;

	public ControladorVistaUnidad(Terminal terminal) {
		
		uniDAO = new UnidadDAO();
		copDAO = new CooperativaDAO();
		vuni = new VistaUnidad();
		vuni.setVisible(true);
		vuni.setLocationRelativeTo(null);
		vuni.activarListener(this);
		ter = terminal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {

			vuni.getTextCapacidad().setText((capacidad()));

			if (e.getSource().equals(vuni.getbtnAgregar()))
				agregarUni();

			else if (e.getSource().equals(vuni.getbtnBuscar())) {
				//Buscar();
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
		
		Unidad uni = new Unidad(vuni.getTextPlaca(), vuni.getIndiceComboTipo(), false, vuni.getTextSocio(), Integer.parseInt(vuni.getTextNumero()));

			if (vuni.getTextRif().isEmpty()
					|| vuni.getTextNumero() == "0 " 
					|| vuni.getTextSocio().equals("")
					|| vuni.getTextPlaca().equals("")
					|| vuni.getIndiceComboTipo() == 0) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
			} else {
				String rifdado = vuni.getTextRif();
				Cooperativa cop = copDAO.buscarCooperativa(rifdado);
						
				if (copDAO.consultarCooperativa(cop)); {
				
				String iddado = vuni.getTextSocio();	
				Socio soc = socDAO.buscarSocio(iddado);
				
				 if (socDAO.consultarSocio(soc)) {
					 
					if (!uniDAO.consultarUnidad(uni)){
						//if (!uniDAO.ValidarNumero(uni)){
						uniDAO.registrarUnidad(uni);
						vuni.mostrarMensaje("La unidad ha sido guardada con exito");
						vuni.Limpiar();
						} else
							vuni.mostrarMensaje("El numero ya existe");
					} else
						vuni.mostrarMensaje("La Unidad ya existe");
				//} else
					vuni.mostrarMensaje("El Socio no existe");
				} 
					vuni.mostrarMensaje("Cooperativa no existe");					
		}
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