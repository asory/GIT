package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Chofer;
import modelo.Multa;
import modelo.Socio;
import modelo.Unidad;
import modelo.Viaje;
import modeloDAO.ChoferDAO;
import bean.Conexion;

public class ViajeDAO extends ConexionDAO {

	private ChoferDAO choDAO;
	private UnidadDAO uniDAO;

	public ViajeDAO() {
		super();
	}

	public void registrarViaje(Viaje via) {

		String tiraSQL = "INSERT INTO viaje"
				+ "(id_viaje,fecha_salida,fecha_retorno,ruta,vehiculo,chofer,costo,statusdb)"
				+ "VALUES ('" + via.getIdviaje() + "'," + "'"
				+ via.getFecha_salida() + "'," + "'" + via.getFecha_retorno()
				+ "'," + "'" + via.getRuta() + "'," + "'" + via.getVehiculo()
				+ "'," + "'" + via.getChofer() + "'," + "'" + via.getCosto()
				+ "'," +via.getStatus() + "',"+ "'A')";
		Conexion.ejecutar(tiraSQL);

	}

	public void eliminarViaje(Viaje via) {
		String tiraSQL = "update viaje set status='E' where id_viaje='"
				+ via.getIdviaje() + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public void actualizarViaje(Viaje via) {

		String tiraSQL = "update viaje set " + "vehiculo='" + via.getVehiculo()
				+ "'," + "chofer='" + via.getChofer() + "'"
				+ "where id_viaje='" + via.getIdviaje() + "' and status!='E'";

		Conexion.ejecutar(tiraSQL);

	}

	public Viaje buscarViaje(String iddado) {

		uniDAO = new UnidadDAO();
		choDAO = new ChoferDAO();

		String tiraSQL = "select * from viaje where id_viaje = '" + iddado
				+ "' and status='A'";
		ResultSet rsViaje = Conexion.consultar(tiraSQL);
		try {
			while (rsViaje.next()) {
				String id = rsViaje.getString("id_viaje");
				Date fechasalida = rsViaje.getDate("fecha_salida");
				Date fecharetorno = rsViaje.getDate("fecha_retorno");
				String ruta = rsViaje.getString("ruta");
				String idunidad = rsViaje.getString("vehiculo");
				String idchofer = rsViaje.getString("chofer");
				String status = rsViaje.getString("status");

				Unidad vehiculo = uniDAO.buscarUnidad(idunidad);
				Chofer chofer = choDAO.buscarChofer(idchofer);

				Viaje via = new Viaje(id, fechasalida, fecharetorno, ruta,
						vehiculo, chofer, status); // ARREGLAR CONSTRUCTOR VIAJE
				return via;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean consultarViaje(Viaje via) {

		boolean seEncuentra = false;

		String tiraSQL = "select id_viaje,fecha_salida,fecha_retorno,ruta,vehiculo,chofer,costo,statusdb"
				+ " from viaje where id_viaje ='"
				+ via.getIdviaje()
				+ "' and status='A'";

		ResultSet rsViaje = Conexion.consultar(tiraSQL);

		try {
			if (rsViaje.next()) {
				seEncuentra = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seEncuentra;
	}

	public List<Viaje> Llenarlistviajes() {

		uniDAO = new UnidadDAO();
		choDAO = new ChoferDAO();

		ArrayList<Viaje> lviaj = new ArrayList<Viaje>();

		String tiraSQL = "select * from viaje where status='A'";

		ResultSet rs = Conexion.consultar(tiraSQL);

		try {
			while (rs.next()) {
				String id = rs.getString("id");
				Date fechasalida = rs.getDate("fecha_salida");
				Date fecharetorno = rs.getDate("fecha_retorno");
				String ruta = rs.getString("ruta");
				String idunidad = rs.getString("vehiculo");
				String idchofer = rs.getString("chofer");
				String status = rs.getString("status");

				Unidad vehiculo = uniDAO.buscarUnidad(idunidad);
				Chofer chofer = choDAO.buscarChofer(idchofer);

				lviaj.add(new Viaje(id, fechasalida, fecharetorno, ruta,
						vehiculo, chofer, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lviaj;
	}

}
