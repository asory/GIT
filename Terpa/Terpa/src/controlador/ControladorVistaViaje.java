package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import vista.VistaViaje;
import modelo.*;
import modeloDAO.*;

public class ControladorVistaViaje implements ActionListener {

	private VistaViaje vviaje;
	private Cooperativa coop;
	private CooperativaDAO copDao;
	private ViajeDAO vDao;
	private MultaDAO mDao;
	

	
	
	Viaje viaje = new Viaje();
	String[] columna = { "ID Viaje", "Destino", "Unidad", "Chofer", "Salida",
			"Retorno", "Pasaje", "Seguro", "Status" };
	DefaultTableModel model = new DefaultTableModel(null, columna);
	ArrayList<Viaje> lViaje ;
	
	// SINGLETON
	private static ControladorVistaViaje instancia;

	public void iniciar() {
		vviaje.setVisible(true);
	}

	public static ControladorVistaViaje getInstancia() {
		if (instancia == null) {
			instancia = new ControladorVistaViaje();
		}
		return instancia;
	}
	public ControladorVistaViaje() {
		

		vviaje = new VistaViaje();
		vviaje.setVisible(true);
		vviaje.activarListener(this);
		vviaje.getTable().setModel(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getSource().equals(vviaje.getBtnGenerar()))

				asignarViajes();

			else if (e.getActionCommand().equals("Nuevo")) {

				vviaje.Limpiar();
				vviaje.getBtnGenerar().setEnabled(true);
				vviaje.getTable().setModel(new DefaultTableModel(null, columna));
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

	private void asignarViajes() {

		try {
			if (vviaje.getRif() == "" || vviaje.getTextDias().getText()=="" || vviaje.getTextCantidad().getText()=="")
				JOptionPane.showMessageDialog(null,
						"Debe llenar todos los campos");
			else {

				String rif = vviaje.getRif();
				if (copDao.buscarCooperativa(rif)==null ) {
					JOptionPane.showMessageDialog(null,
							"La Cooperativa no esta registrada");
					vviaje.Limpiar();

				} else if (vviaje.getFechaI().before(new Date())) {
					JOptionPane.showMessageDialog(null, "fecha invalida  ");

				} else {
					int i = 0;
					int nroViajes= Integer.parseInt(vviaje.getTextCantidad().getText());
					do {
						// obtenemos condiciones del viaje

						coop =copDao.buscarCooperativa(rif);

						Date fs = randomSalida(vviaje.getFechaI());
						Ruta ruta = randomRuta();
						Date fr = asignarRetorno(ruta, fs);
						Unidad uni = ramdomSocio().randomUnidad();// asigna
																		// unidad
																		// aleatoria

						// / verifica la unidad y retorna una q este disponible
						uni = VerificarUnidad(uni, fs);
						Chofer cho = randomChofer();
						cho = VerificarChofer(cho, fs);
						float costo = asignarCosto();//
						// decide si el viaje salio o no
						int Stats = randomStatusVi();

						// ********** se asignan las variables al viaje*********
						String codv = "v" + "" + i + ""
								+ rif.substring(rif.length() - 3, rif.length());
						// codigo esta compuesto por el numero de viaje y los 3
						// ultimos digitos del rif de la cooperativa a la q
						// pertenece

						Viaje viaje = new Viaje();
						viaje.setIdviaje(codv);
						viaje.setFecha_salida(fs);
						viaje.setFecha_retorno(fr);
						viaje.setVehiculo(uni);
						viaje.setChofer(cho);
						viaje.setCosto(costo);
						viaje.setRuta(ruta);
						viaje.setStatus(Stats);

						vDao.registrarViaje(viaje);
						multar(fs, viaje, coop);

						i++;
					} while (i < nroViajes);
					
                   Ordenar();
					quitarmulta();
					cancelarViaje();
					llenarTabla();
					vviaje.getBtnGenerar().setEnabled(false);

				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void llenarTabla() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			lViaje= vDao.Llenarlistviajes(vviaje.getRif());
			
			model.setNumRows(lViaje.size());

			for (int i = 0; i < lViaje.size(); i++) {
				Viaje viaje = lViaje.get(i);

				model.setValueAt(viaje.getIdviaje(), i, 0);
				String Destino = viaje.getRuta().getDestino();
				model.setValueAt(Destino, i, 1);
				model.setValueAt(viaje.getVehiculo().getId(), i, 2);
				model.setValueAt(viaje.getChofer().getId_chofer(), i, 3);
				model.setValueAt(sdf.format(viaje.getFecha_salida()), i, 4);
				model.setValueAt(sdf.format(viaje.getFecha_retorno()), i, 5);
				model.setValueAt(viaje.getCosto(), i, 6);
				model.setValueAt(viaje.CalSeguro(viaje.getCosto()), i, 7);
				model.setValueAt(Status(viaje.getStatus()), i, 8);

			}

			vviaje.getTable().setModel(model);
			vviaje.getTable().setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ****************** Suma/resta los días/horas recibidos a la
	// fecha***********
	public Date modificarDias(Date fecha, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o
		// restar en caso de días<0

		return calendar.getTime();
		// Devuelve el objeto Date con los nuevos días añadidos
	}

	public Date modificarHoras(Date fecha, int hora) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		calendar.add(Calendar.HOUR, hora); //
		return calendar.getTime(); // Devuelve el objeto Date con la nueva hora

	}

	// **********************Random Salida***************

	public Date randomSalida(Date fecha) {

		int random = 0;
		int max= Integer.parseInt(vviaje.getTextDias().getText());
		
		

		random = (int) Math.floor(Math.random() * max + 0);

		Date salida = modificarDias(fecha, random);

		random = (int) Math.floor(Math.random() * 23 + 0);

		salida = modificarHoras(salida, random);

		return salida;
	}

	// ******************Asignar Retorno ****************//
	public Date asignarRetorno(Ruta ruta, Date f_salida) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(f_salida);
		Date f_retorno;
		if (ruta.getTipo() == 1) // 1 nacional
			f_retorno = modificarHoras(f_salida, 42);
		else
			// 2 regional
			f_retorno = modificarHoras(f_salida, 2); // en 2 horas return
														// f_retorno;
		return f_retorno;
	}

	// *******************************Asignar Costo********************** //
	public float asignarCosto() {
		float max = 500;
		float min = 50;

		float costo = min + new Random().nextFloat() * (max - min);// // genera
		// minimo
		BigDecimal precio = new BigDecimal(costo).setScale(2,
				BigDecimal.ROUND_HALF_UP);// / redondea el valor a 2 decimales
		costo = precio.floatValue();// / convierte el el bigdecimal (costo
									// redondeado ) en float
		return costo;
	}

	// *********************Verificar ********************************

	// **************Verifican si ya han retornado*********************
	public Unidad VerificarUnidad(Unidad uni, Date fs) {
		lViaje= vDao.Llenarlistviajes(vviaje.getRif());
		boolean v;
		do {
			for (int i = 0; i <lViaje.size(); i++) {
				Viaje viaje = lViaje.get(i);

				if ((viaje.getVehiculo().equals(uni))
						&& (viaje.getFecha_retorno().after(fs))) {
					uni = ramdomSocio().randomUnidad();
					v = false;
				}
			}
			v = true;
		} while (v = false);
		return uni;
	}

	public Chofer VerificarChofer(Chofer cho, Date fs) {
		lViaje= vDao.Llenarlistviajes(vviaje.getRif());
		boolean v = false;
		do {
			for (int i = 0; i < lViaje.size(); i++) {
				Viaje viaje = lViaje.get(i);

				if ((viaje.getChofer().getId_chofer()
						.equals(cho.getId_chofer()))
						&& (viaje.getFecha_retorno().after(fs))) {
					cho = randomChofer();
					v = false;
				}
			}
			v = true;

		} while (v = false);
		return cho;

		// ************************************
	}

	// ///**********cambia el estatus del chofer y la unidad a multado y agrega
	// la multa al listado
	public void multar(Date pferiado, Viaje viaje, Cooperativa coop) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pferiado);
		 FeriadoDAO fDao= new FeriadoDAO();
		List<Feriado> lFeriado = fDao.Llenarlistfer();
		int cm = calendar.get(Calendar.MONTH) + 1;// calendar maneja los meses
													// desd 0
		for (int i = 0; i < lFeriado.size(); i++) {
			Feriado feriado = lFeriado.get(i);
			int df = feriado.getDia();
			int mf = feriado.getMes();

			if ((df == calendar.get(Calendar.DAY_OF_MONTH)) && (mf == cm)) {
				if (viaje.getStatus()==2) {
					viaje.getChofer().setStatus(true);
					viaje.getVehiculo().setStatus(true);

					// id compuesta por: M + id del chofer + la id de la unidad multada
					String idmulta = "M" + viaje.getChofer().getId_chofer()
							+ viaje.getVehiculo().getId() + "";
					// Crea una multa y la agrega a la lista de coop
					Date iniciom=  modificarDias(viaje.getFecha_salida(),1);
					Date finm= modificarDias(iniciom,3);
					Multa multa = new Multa( iniciom,finm,idmulta,
							viaje.getVehiculo(), viaje.getChofer());
					
					mDao.registrarMulta(multa, vviaje.getRif());

					i = lFeriado.size();

				} else
					i = lFeriado.size();
			}
		}

	}

	public String Status(int i) {
		String sts = "";
		switch (i) {
		case 1:
			sts = "SALIO";
			break;
		case 2:
			sts = "NO SALIO";
			break;
		case 3:
			sts = "Cancelado ";
			break;
		}
		return sts;
	}



// *****************

// ** METODOS PARA Valores de VIAJE ***///
// *******************RANDOM **************************
// / retorna un objecto aleatorio
public Socio ramdomSocio() {
	int random = 0;
SocioDAO sdao= new SocioDAO();
lSocio= sdao.
	random = (int) Math.floor(Math.random() * getlSocio().size());
	Socio socio = getlSocio().get(random);
	return socio;

}

public int randomStatusVi() {
	int random = 0;

	random = (int) Math.floor(Math.random() * 2 + 1);
	
	return random;

}

public Chofer randomChofer() {
ChoferDAO cdao=new ChoferDAO();

	int random = 0;

	random = (int) Math.floor(Math.random() * getlChofer.size());
	Chofer cho = lChofer.get(random);
	return cho;
}

public Ruta randomRuta() {
RutaDAO rDao= new RutaDAO();
List<Ruta> lRuta = rDao.Llenarlistrut();
	int random = 0;

	random = (int) Math.floor(Math.random() * lRuta.size());
	Ruta ruta = lRuta.get(random);
	return ruta;
}

// ****************Ordenar
public void Ordenar() {

	Collections.sort(lViaje, new Comparator<Viaje>() {

		@Override
		public int compare(Viaje o1, Viaje o2) {
			return o1.getFecha_salida().compareTo(o2.getFecha_salida());
		}

	});
}

// **********************Cancelar viaje por Multa ************************
public void cancelarViaje() {

	Viaje viaje = new Viaje();
	for (int j = 0; j < lViaje.size(); j++) {
		viaje = lViaje.get(j);
		if (viaje.getChofer().getStatus()
				|| viaje.getVehiculo().getstatus()) {
			viaje.setStatus(3);
		}
	}

}

// *******************Quitar Multa *************
public void quitarmulta() {
	MultaDAO mDao=new MultaDAO();
	
	ArrayList<Multa> lMulta = mDao.Llenarlistmult(vviaje.getRif()) ;
	
	Viaje viaje = new Viaje();
	Multa multa = new Multa();
	int i = 0;
	if (!lMulta.isEmpty()) {
		for (int j = 0; j < lViaje.size(); j++) {
			viaje = lViaje.get(j);
			while (i < lMulta.size()) {

				multa = lMulta.get(i);

				if (viaje.getFecha_salida().before(multa.getFecha_in())
						|| viaje.getFecha_salida().after(
								multa.getFecha_fin())) {
					viaje.getChofer().setStatus(false);
					viaje.getVehiculo().setStatus(false);
				}
				i++;
			}

		}
	}
}
}



/*Integrantes:
 * Rosa Piña C.I. 24.166.902
 * Edwin Lucena C.I. 21.256.626
 * Norielsy Freitez C.I. 20.668.899
 * Ana Ruiz  C.I. 21.296.217
 */