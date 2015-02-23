package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Chofer;
import modelo.Cooperativa;
import modelo.Multa;
import modelo.Unidad;
import modeloDAO.ChoferDAO;
import modeloDAO.UnidadDAO;
import bean.Conexion;

public class MultaDAO extends ConexionDAO {

	private UnidadDAO uniDAO;
	private ChoferDAO choDAO;

	public MultaDAO() {
		super();
	}

	public void registrarMulta(Multa mul) {

		String tiraSQL = "INSERT INTO multa"
				+ "(nro,fecha_in,fecha_fin,unidad,c_asignado,statusdb)"
				+ "VALUES ('" + mul.getNro() + "'," + "'" + mul.getFecha_in()
				+ "'," + "'" + mul.getFecha_fin() + "'," + "'"
				+ mul.getUnidad() + "'," + "'" + mul.getC_Asignado() + "',"
				+ "'A')";
		Conexion.ejecutar(tiraSQL);

	}

	public void eliminarMulta(Multa mul) {
		String tiraSQL = "update multa set status='E' where nro='"
				+ mul.getNro() + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public void actualizarMulta(Multa mul) {

		String tiraSQL = "update multa set " + "unidad='" + mul.getUnidad()
				+ "'," + "c_asignado='" + mul.getC_Asignado() + "'"
				+ "where nro='" + mul.getNro() + "' and status!='E'";

		Conexion.ejecutar(tiraSQL);

	}

	public Multa buscarMulta(String nrodado) {

		uniDAO = new UnidadDAO();
		choDAO = new ChoferDAO();

		String tiraSQL = "select * from multa where nro = '" + nrodado
				+ "' and status='A'";
		ResultSet rsMulta = Conexion.consultar(tiraSQL);
		try {
			while (rsMulta.next()) {
				String nro = rsMulta.getString("nro");
				Date fechainic = rsMulta.getDate("fecha_in");
				Date fechafin = rsMulta.getDate("fecha_fin");
				String idunidad = rsMulta.getString("unidad");
				String idchofer = rsMulta.getString("c_asignado");

				Unidad unidad = uniDAO.buscarUnidad(idunidad);
				Chofer chofer = choDAO.buscarChofer(idchofer);

				Multa mul = new Multa(fechainic, fechafin, nro, unidad, chofer);
				return mul;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Multa> Llenarlistmult() {

		uniDAO = new UnidadDAO();
		choDAO = new ChoferDAO();

		ArrayList<Multa> lmult = new ArrayList<Multa>();

		String tiraSQL = "select * from multa where status='A'";

		ResultSet rs = Conexion.consultar(tiraSQL);

		try {
			while (rs.next()) {
				Date fecha_in = rs.getDate("fecha_in");
				Date fecha_fin = rs.getDate("fecha_fin");
				String nro = rs.getString("nro");
				String idunidad = rs.getString("unidad");
				String idchofer = rs.getString("c_asignado");

				Unidad unidad = uniDAO.buscarUnidad(idunidad);
				Chofer chofer = choDAO.buscarChofer(idchofer);

				lmult.add(new Multa(fecha_in, fecha_fin, nro, unidad, chofer));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lmult;
	}

}
