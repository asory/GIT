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

		char a='A';
		
		String tiraSQL = "INSERT INTO cooperativa "
				+ "(rif,nombre,statusdb) "
				+ "VALUES (' " + cop.getRif() + "','" + cop.getNombre() + "','" + a + "')";

		Conexion.ejecutar(tiraSQL);
	}

	public void eliminarCooperativa(Cooperativa cop) {
		String tiraSQL = "update cooperativa set statusdb='E' where rif='" + cop.getRif() + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public void actualizarCooperativa(Cooperativa cop) {

		char a='A';
		
		String tiraSQL = "update cooperativa set "
				+ "nombre='" + cop.getNombre() + "' where rif='" + cop.getRif() + "' and statusdb='" + a + "'";

		Conexion.ejecutar(tiraSQL);

	}

	
	public Cooperativa buscarCooperativa(String rifdado) {
		
		char a='A';
		Cooperativa cop = new Cooperativa();
		String tiraSQL = "select * from cooperativa where rif = '"+rifdado+"' and statusdb='" +a+ "'";
		ResultSet rsCooperativa = Conexion.consultar(tiraSQL);
		try {
			while (rsCooperativa.next()) {
				String rif = rsCooperativa.getString("rif");
				String nombre = rsCooperativa.getString("nombre");
				cop.setRif(rif);
				cop.setNombre(nombre);
			} 
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cop;

	}

	public boolean consultarCooperativa(Cooperativa cop) {

		char a='A';
		
		boolean seEncuentra = false;

		String tiraSQL ="select * from cooperativa where rif='"+cop.getNombre()+"'and statusdb='"+ a +"'";

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

	public ArrayList<Cooperativa> Llenarlistcoop()
	 {
		char a='A';
		
	 ArrayList<Cooperativa> lcoop= new ArrayList<Cooperativa>();
	
	 String tiraSQL= "select * from cooperativa where statusdb='" + a + "'";
	
	 ResultSet rs= Conexion.consultar(tiraSQL);
	 String nombre="";
	 String rif="";

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
