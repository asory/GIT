package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cooperativa;
import bean.Conexion;

public class CooperativaDAO extends ConexionDAO {
	public CooperativaDAO() {
		super();
	}

	public boolean registrarCooperativa(Cooperativa cop) {
		char a = 'A';
		String tiraSQL = "INSERT INTO cooperativa " + "VALUES (' "
				+ cop.getRif() + "','" + cop.getNombre() + "','" + a + "'  )";

		boolean r = Conexion.ejecutar(tiraSQL);
		return r;
	}

	public void eliminarCooperativa(Cooperativa cop) {
		String tiraSQL = "update cooperativa set status='E' where rif='"
				+ cop.getRif() + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public boolean actualizarCooperativa(Cooperativa cop) {

		String tiraSQL = "update cooperativa set " + "nombre='"
				+ cop.getNombre() + "' " + "where rif='" + cop.getRif()
				+ "' and statusdb='A'";

		boolean r = Conexion.ejecutar(tiraSQL);
		return r;

	}

	public Cooperativa buscarCooperativa(String rifdado) {
			char a='A';
			
			String tiraSQL = "select * from cooperativa where rif = '" + rifdado + "' and statusdb='" + a + "'";
			ResultSet rsCooperativa = Conexion.consultar(tiraSQL);
			try {
				while (rsCooperativa.next()) {
					String rif = rsCooperativa.getString("rif");
					String nombre = rsCooperativa.getString("nombre");

					Cooperativa cop = new Cooperativa(rif,nombre);
					return cop;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	
//		Cooperativa cop = new Cooperativa();
//		String tiraSQL = "select * from cooperativa where rif = '" + rifdado
//				+ "' and statusdb='A'" + "";
//		ResultSet rsCooperativa = Conexion.consultar(tiraSQL);
//		try {
//			while (rsCooperativa.next()) {
//				String rif = rsCooperativa.getString("rif");
//				String nombre = rsCooperativa.getString("nombre");
//
//				cop.setRif(rif);
//				cop.setNombre(nombre);
//
//			} 
//				
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return cop;
//
//	}

	public boolean consultarCooperativa(Cooperativa cop) {

		boolean seEncuentra = false;

		String tiraSQL = "select rif,nombre from cooperativa where rif ='"+cop.getRif()+"' and statusdb='A' " ;

		ResultSet rsCooperativa = Conexion.consultar(tiraSQL);

		try {
			if (rsCooperativa.getRow()>0) {
				seEncuentra = true;

			}
		} catch (SQLException e) {

		}

		return seEncuentra;
	}

	public List<Cooperativa> Llenarlistcoop() {
		ArrayList<Cooperativa> lcoop = new ArrayList<Cooperativa>();

		String tiraSQL = "select * from cooperativa where statusdb='A'";

		ResultSet rs = Conexion.consultar(tiraSQL);
		String nombre = "";
		String rif = "";

		try {
			while (rs.next()) {
				rif = rs.getString("rif");
				nombre = rs.getString("nombre");

				lcoop.add(new Cooperativa(rif, nombre));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lcoop;
	}

}
