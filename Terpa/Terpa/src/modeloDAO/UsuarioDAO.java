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

		char a='A';
		
		String tiraSQL = "INSERT INTO usuario (nombre,password,tipo,statusdb) "
				+ "VALUES (' " + usu.getNombre() + "',"
				+ "'" + usu.getPassword()+ "',"
				+ "'" + usu.getTipo() + "',"
				+ "'" + a + "')";

		Conexion.ejecutar(tiraSQL);
	}

	public void eliminarUsuario(Usuario usu) {
		String tiraSQL = "update usuario set statusdb='E' where nombre='"+ usu.getNombre() + "' and password='"+ usu.getPassword() +"'";

		Conexion.ejecutar(tiraSQL);

	}

	public void actualizarUsuario(Usuario usu) {

		char a='A';
		
		String tiraSQL = "update usuario set password='" + usu.getPassword() + "' "
				+ "where nombre='" + usu.getNombre() + "' and statusdb='" + a + "'";

		Conexion.ejecutar(tiraSQL);

	}

	public Usuario buscarUsuario(String nombredado,String passdada) {

		char a='A';
		Usuario usu = new Usuario();
		String tiraSQL = "select * from usuario where nombre = '" + nombredado + "' and password = '" + passdada + "' and statusdb='" + a + "'";
		ResultSet rsUsuario = Conexion.consultar(tiraSQL);
		try {
			while (rsUsuario.next()) {
				String nombre = rsUsuario.getString("nombre");
				String password = rsUsuario.getString("password");
				int tipo = rsUsuario.getInt("tipo");

				usu.setNombre(nombre);
				usu.setPassword(password);
				usu.setTipo(tipo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usu;
	}

	public boolean consultarUsuario(Usuario usu) {

		char a='A';
		
		boolean seEncuentra = false;

		String tiraSQL = "select * from usuario where nombre ='" + usu.getNombre() + "' and password ='" + usu.getPassword() + "' and statusdb='" + a + "'";

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