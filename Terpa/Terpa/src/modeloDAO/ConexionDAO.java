package modeloDAO;

import bean.Conexion;

public class ConexionDAO {
	
	public ConexionDAO() {
		super();	
		Conexion.establecerPropiedadesConexion("bdconfig", "jdbc.driver", "jdbc.url", "jdbc.nombrebd", "jdbc.usuario", "jdbc.password");
	}	
	
}
