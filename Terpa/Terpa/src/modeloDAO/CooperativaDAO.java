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

	public void registrarCooperativa(Cooperativa cop) {

		String tiraSQL = "INSERT INTO cooperativa " + "(rif,nombre,statusdb) "
				+ "VALUES (' " + cop.getRif() + "','" + cop.getNombre() + "','" + "'A')";

		Conexion.ejecutar(tiraSQL);
	}

	public void eliminarCooperativa(Cooperativa cop) {
		String tiraSQL = "update cooperativa set status='E' where rif='"
				+ cop.getRif() + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public void actualizarCooperativa(Cooperativa cop) {

		String tiraSQL = "update cooperativa set " + "nombre='"
				+ cop.getNombre() + "' " + "where rif='" + cop.getRif()
				+ "' and status!='E'";

		Conexion.ejecutar(tiraSQL);

	}

	public Cooperativa buscarCooperativa(String rifdado) {

		String tiraSQL = "select * from cooperativa where rif = '" + rifdado
				+ "' and status='A'";
		ResultSet rsCooperativa = Conexion.consultar(tiraSQL);
		try {
			while (rsCooperativa.next()) {
				String rif = rsCooperativa.getString("rif");
				String nombre = rsCooperativa.getString("nombre");

				Cooperativa cop = new Cooperativa(rif, nombre);
				return cop;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean consultarCooperativa(Cooperativa cop) {

		boolean seEncuentra = false;

		String tiraSQL = "select rif,nombre,statusdb" + " from cooperativa where rif ='"
				+ cop.getNombre() + "' and status='A'";

		ResultSet rsCooperativa = Conexion.consultar(tiraSQL);

		try {
			if (rsCooperativa.next()) {
				seEncuentra = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seEncuentra;
	}

	public List<Cooperativa> Llenarlistcoop()
	 {
	 ArrayList<Cooperativa> lcoop= new ArrayList<Cooperativa>();
	
	 String tiraSQL= "select * from cooperativa where status='A'";
	
	 ResultSet rs= Conexion.consultar(tiraSQL);
	 String nombre="";
	 String rif="";

	
	 try {
		while(rs.next())
		 {
		  rif= rs.getString("rif");
		  nombre= rs.getString("nombre");
		
		 lcoop.add(new Cooperativa(rif,nombre));
		 }
	} catch (SQLException e) {
				e.printStackTrace();
	}
	
	 return lcoop;
	 }

}
