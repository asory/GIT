package modeloDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Usuario;
import bean.Conexion;

public class UsuarioDAO extends ConexionDAO {
	public UsuarioDAO() {
		super();
	}

	public void registrarUsuario(Usuario usu) {

		String tiraSQL = "INSERT INTO usuario " + "(nombre,password,tipo,statusdb) "
				+ "VALUES (' " + usu.getNombre() + "'," + "'" + usu.getPassword()+ "',"
						+ "'" + usu.getTipo() + "','A')";

		Conexion.ejecutar(tiraSQL);
	}

	public void eliminarUsuario(Usuario usu) {
		String tiraSQL = "update usuario set status='E' where nombre='"+ usu.getNombre() + "' and password='"+ usu.getPassword() +"'";

		Conexion.ejecutar(tiraSQL);

	}

	public void actualizarUsuario(Usuario usu) {

		String tiraSQL = "update usuario set " + "password='"
				+ usu.getPassword() + "' " + "where nombre='" + usu.getNombre()
				+ "' and status!='E'";

		Conexion.ejecutar(tiraSQL);

	}

	public Usuario buscarUsuario(String nombredado,String passdada) {

		String tiraSQL = "select * from usuario where nombre = '" + nombredado
				+ "' and password = '" + passdada + "' and status='A'";
		ResultSet rsUsuario = Conexion.consultar(tiraSQL);
		try {
			while (rsUsuario.next()) {
				String nombre = rsUsuario.getString("nombre");
				String password = rsUsuario.getString("password");
				int tipo = rsUsuario.getInt("tipo");

				Usuario usu = new Usuario(nombre,password,tipo);
				return usu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean consultarUsuario(Usuario usu) {

		boolean seEncuentra = false;

		String tiraSQL = "select nombre,password,tipo,statusdb" + " from usuario where nombre ='"
				+ usu.getNombre() + "' and password ='" + usu.getPassword() + "' and status='A'";

		ResultSet rsUsuario = Conexion.consultar(tiraSQL);

		try {
			if (rsUsuario.next()) {
				seEncuentra = true;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return seEncuentra;
	}
}	