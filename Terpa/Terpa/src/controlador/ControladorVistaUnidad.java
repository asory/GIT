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

	public ControladorVistaUnidad() {

		vuni = VistaUnidad.getInstancia();
		vuni.setVisible(true);
		vuni.setLocationRelativeTo(null);
		vuni.activarListener(this);
		
	}
	//SINGLETON
		private static ControladorVistaUnidad instancia;
		
		
		public static  ControladorVistaUnidad getInstancia(){
				if (instancia == null){
					instancia = new ControladorVistaUnidad() ;
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
			else if (e.getSource().equals(vuni.getBtnEliminar())) {
				eliminar();
			} else if (e.getSource().equals(vuni.getBtnModificar())) {
			 	modificar();
			} else if (e.getSource().equals(vuni.getbtnBuscar())) {
				Buscar();
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
		
		Unidad uni = new Unidad(vuni.getPlaca(), vuni.getIndiceComboTipo(), false, vuni.getSocio(), Integer.parseInt(vuni.getNumero()));

			if (vuni.getRif().isEmpty()
					|| vuni.getNumero() == "0 " 
					|| vuni.getSocio().equals("")
					|| vuni.getPlaca().equals("")
					|| vuni.getIndiceComboTipo() == 0) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
			} else {
				String rifdado = vuni.getRif();
				Cooperativa cop = copDAO.buscarCooperativa(rifdado);
						
				if (copDAO.consultarCooperativa(cop)); {
				
				String iddado = vuni.getSocio();
				String rifcoop= vuni.getRif();
				Socio soc = socDAO.buscarSocio(iddado,rifcoop);
				
				 if (socDAO.consultarSocio(soc,rifcoop)) {
					 
					if (!uniDAO.consultarUnidad(uni)){
						if (!uniDAO.ValidarNumero(uni)){
						uniDAO.registrarUnidad(uni);
						vuni.mostrarMensaje("La unidad ha sido guardada con exito");
						vuni.Limpiar();
						} else
							vuni.mostrarMensaje("El numero ya existe");
					} else
						vuni.mostrarMensaje("La Unidad ya existe");
				} else
					vuni.mostrarMensaje("El Socio no existe");
				} 
					vuni.mostrarMensaje("Cooperativa no existe");					
		}
}

	public void eliminar(){
		
		Unidad uni = new Unidad(vuni.getPlaca(), vuni.getIndiceComboTipo(), false, vuni.getSocio(), Integer.parseInt(vuni.getNumero()));

		if (uniDAO.consultarUnidad(uni)){
			uniDAO.eliminarUnidad(uni);
			vuni.mostrarMensaje("La unidad ha sido eliminada");
			vuni.Limpiar();
		} else
			vuni.mostrarMensaje("La Unidad no existe");
	}
	
	public void modificar(){
		
		Unidad uni = new Unidad(vuni.getPlaca(), vuni.getIndiceComboTipo(), false, vuni.getSocio(), Integer.parseInt(vuni.getNumero()));

		if (vuni.getRif().isEmpty()
				|| vuni.getNumero() == "0 " 
				|| vuni.getSocio().equals("")
				|| vuni.getPlaca().equals("")
				|| vuni.getIndiceComboTipo() == 0) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
		} else {
			if (uniDAO.consultarUnidad(uni)){
				uniDAO.actualizarUnidad(uni);
				vuni.mostrarMensaje("La unidad ha sido actualizada");
				vuni.Limpiar();
			} else
				vuni.mostrarMensaje("La Unidad no existe");
		}
		
	
}

	private void Buscar() {
	
		Unidad uni = uniDAO.buscarUnidad(vuni.getNumero());
		
		String placa = uni.getPlaca();
		String idsocio = uni.getId_socio();
		int tipo = uni.getTipo();
		
		vuni.getTextPlaca().setText(placa);
		vuni.getTextSocio().setText(idsocio);
		vuni.getcomboTipo().setSelectedIndex(tipo);
		
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